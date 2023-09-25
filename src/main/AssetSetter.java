package src.main;

import src.object.OBJ_Chest;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Chest();
        gp.obj[0].worldX = 18 * gp.tileSize;
        gp.obj[0].worldY = 21 * gp.tileSize;
    }
}
