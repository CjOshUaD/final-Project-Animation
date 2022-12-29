package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.AnimationPanel;
import main.KeyHandler;

public class Player extends Entity{

	AnimationPanel ap;
	KeyHandler KeyH;
	
	
	public Player(AnimationPanel ap, KeyHandler KeyH) {
		this.ap = ap;
		this.KeyH = KeyH;
		setDefaultValues();
		getLuffy();
		
	}
	
	

	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction= "down";
	}
	
	
	
	public void getLuffy() {
		
		try {
			
			
			up1 = ImageIO.read(getClass().getResource("/player/LUFFY_UP1.png"));
			up2 = ImageIO.read(getClass().getResource("/player/LUFFY_UP2.png"));
			up3 = ImageIO.read(getClass().getResource("/player/LUFFY_UP3.png"));
			down1 = ImageIO.read(getClass().getResource("/player/LUFFY_DOWN1.png"));
			down2 = ImageIO.read(getClass().getResource("/player/LUFFY_DOWN2.png"));
			down3 = ImageIO.read(getClass().getResource("/player/LUFFY_DOWN3.png"));
			right1 = ImageIO.read(getClass().getResource("/player/LUFFY_RIGHT1.png"));
			right2 = ImageIO.read(getClass().getResource("/player/LUFFY_RIGHT2.png"));
			right3 = ImageIO.read(getClass().getResource("/player/LUFFY_RIGHT3.png"));
			left1 = ImageIO.read(getClass().getResource("/player/LUFFY_LEFT1.png"));
			left2 = ImageIO.read(getClass().getResource("/player/LUFFY_LEFT2.png"));
			left3 = ImageIO.read(getClass().getResource("/player/LUFFY_LEFT3.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(KeyH.upPressed == true || KeyH.downPressed == true 
				|| KeyH.rightPressed == true || KeyH.leftPressed == true)
		{
			if(KeyH.upPressed == true) {
			direction= "up";
			y -= speed;
		}
		else if(KeyH.downPressed == true) {
			direction= "down";
			y += speed;
		}
		else if(KeyH.leftPressed == true) {
			direction= "left";
			x -= speed;
		}
		
		else if(KeyH.rightPressed == true) {
			direction= "right";
			x += speed;
		}
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}
			else if(spriteNum == 3) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		}
		
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			
			break;
		}
		g2.drawImage(image, x, y, ap.tileSize, ap.tileSize, null);
		
	}
	
	
}
