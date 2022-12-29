package main;

import javax.swing.JFrame;


public class AnimationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Animation Of Luffy");
		
		AnimationPanel animationPanel = new AnimationPanel();
		window.add(animationPanel);
		window.pack();
		window.setLocationRelativeTo(animationPanel);
		window.setVisible(true);
		animationPanel.startAnimationThread();
		

	}
	

}
