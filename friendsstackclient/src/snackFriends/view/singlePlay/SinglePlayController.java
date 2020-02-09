package snackFriends.view.singlePlay;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SinglePlayController {
   private GameServiceManager gameServiceManager;

   public SinglePlayController() {
      this.gameServiceManager = new GameServiceManager();
   }

   public Icon getNextButton() {
      Block block = gameServiceManager.getNextBlock();
      if (block == null)
         return null;
      Icon icon = new ImageIcon("image/boxIcon/" + block.getAnimal() + "Box_" + block.getRelation() + ".png");
      return icon;
   }

   public void setGameServiceManager(Icon blockIcon, BlockBean previousBlock) {
	   Block pb=null;
	   if(previousBlock!=null)
		  pb = new Block(previousBlock);
      Block cb = new Block(blockIcon);
      gameServiceManager.setService(cb, pb);
   }

}