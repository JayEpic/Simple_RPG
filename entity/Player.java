package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler KeyH;

    public Player(GamePanel gp, KeyHandler KeyH) {

        this.gp = gp;
        this.KeyH = KeyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(new FileInputStream("res/player/char_walk_down1.png"));
            down2 = ImageIO.read(new FileInputStream("res/player/char_normal.png"));
            down3 = ImageIO.read(new FileInputStream("res/player/char_walk_down2.png"));
            up1 = ImageIO.read(new FileInputStream("res/player/char_walk_up1.png"));
            up2 = ImageIO.read(new FileInputStream("res/player/char_normal_up.png"));
            up3 = ImageIO.read(new FileInputStream("res/player/char_walk_up2.png"));
            left1 = ImageIO.read(new FileInputStream("res/player/char_walk_left1.png"));
            left2 = ImageIO.read(new FileInputStream("res/player/char_normal_left.png"));
            left3 = ImageIO.read(new FileInputStream("res/player/char_walk_left2.png"));
            right1 = ImageIO.read(new FileInputStream("res/player/char_walk_right1.png"));
            right2 = ImageIO.read(new FileInputStream("res/player/char_normal_right.png"));
            right3 = ImageIO.read(new FileInputStream("res/player/char_walk_right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (KeyH.upPressed == true || KeyH.downPressed == true ||
        KeyH.leftPressed == true || KeyH.rightPressed == true) {
            if (KeyH.upPressed == true) {
                direction = "up";
                y -= speed;
            }
    
            else if (KeyH.downPressed == true) {
                direction = "down";
                y += speed;
            }
    
            else if (KeyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            }
            else if (KeyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }
    
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum == 2) {
                    spriteNum = 3;
                }
                else if(spriteNum == 3) {
                    spriteNum = 4;
                }
                else if(spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);

        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up2;
                }
                if (spriteNum == 2) {
                    image = up3;
                }
                if (spriteNum == 3) {
                    image = up2;
                }
                if (spriteNum == 4) {
                    image = up1;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down2;
                }
                if (spriteNum == 2) {
                    image = down3;
                }
                if (spriteNum == 3) {
                    image = down2;
                }
                if (spriteNum == 4) {
                    image = down1;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left2;
                }
                if (spriteNum == 2) {
                    image = left3;
                }
                if (spriteNum == 3) {
                    image = left2;
                }
                if (spriteNum == 4) {
                    image = left1;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right2;
                }
                if (spriteNum == 2) {
                    image = right3;
                }
                if (spriteNum == 3) {
                    image = right2;
                }
                if (spriteNum == 4) {
                    image = right1;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
