package main;   

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class AnimationPanel extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Screen Settings
	final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; //768 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	//FPS
	int FPS = 60;
	
	KeyHandler KeyH = new KeyHandler();
	Thread animationThread;
	Player player = new Player(this, KeyH);
	
	//set player default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	
	public AnimationPanel() {
		this.setPreferredSize(new Dimension (screenWidth, screenHeight));
		this.setBackground(Color.BLUE);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
	}


	public void startAnimationThread() {
		animationThread = new Thread(this);
		animationThread.start();
		
	}
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(animationThread != null ){
			
			long currentTime = System.nanoTime();
			System.out.println("Current Time : " + currentTime);
			//Update
			update();
			
			//Draw
			repaint();
			
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if(remainingTime <0 ) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		public  void update() {
			player.update();
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			player.draw(g2);
			g2.dispose();
			
		}
		
		

}
