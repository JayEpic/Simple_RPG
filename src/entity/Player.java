package src.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;
import src.main.KeyHandler;
import src.main.UtilityTool;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler KeyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler KeyH) {

        this.gp = gp;
        this.KeyH = KeyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 18;
        worldY = gp.tileSize * 22;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        down1 = setup("char_walk_down1");
        down2 = setup("char_normal");
        down3 = setup("char_walk_down2");
        up1 = setup("char_walk_up1");
        up2 = setup("char_normal_up");
        up3 = setup("char_walk_up2");
        left1 = setup("char_walk_left1");
        left2 = setup("char_normal_left");
        left3 = setup("char_walk_left2");
        right1 = setup("char_walk_right1");
        right2 = setup("char_normal_right");
        right3 = setup("char_walk_right2");
    }

    public BufferedImage setup(String ImageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(new FileInputStream("res/player/" + ImageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return image;
    }

    public void update() {
        if (KeyH.upPressed == true || KeyH.downPressed == true ||
                KeyH.leftPressed == true || KeyH.rightPressed == true) {
            if (KeyH.upPressed == true) {
                direction = "up";
            }

            else if (KeyH.downPressed == true) {
                direction = "down";
            }

            else if (KeyH.leftPressed == true) {
                direction = "left";
            } else if (KeyH.rightPressed == true) {
                direction = "right";
            }

            // Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            // pickUpObject(objIndex);

            // If collision is false, player can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int i) {
        if (i != 999) {

            String objectName = gp.obj[i].name;

            switch (objectName) {
                // case "Chest":
                // if (KeyH.enterPressed == true) {
                // try {
                // gp.obj[i].image = ImageIO
                // .read(getClass().getResourceAsStream("/res/objects/chestOpened.png"));
                // } catch (IOException e) {
                // e.printStackTrace();
                // }
                // }
                // KeyH.enterPressed = false;
                // break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);

        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

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
        g2.drawImage(image, screenX, screenY, null);
    }
}
