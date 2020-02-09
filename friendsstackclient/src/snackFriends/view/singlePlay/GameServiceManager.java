package snackFriends.view.singlePlay;

public class GameServiceManager {
   private GameRuleService gameRuleService;
   private GameStackService gameStackService;

   public GameServiceManager() {
      this.gameRuleService = GameRuleService.getinstance();
      this.gameStackService = GameStackService.getinstance();
   }

   public GameStackService getGameStackService() {
      return getGameStackService();
   }

   public GameRuleService getGameRuleService() {
      return gameRuleService;
   }

   public void setService(Block currentBlock, Block previousBlock) {
      gameRuleService.setBlocks(currentBlock, previousBlock);
      gameStackService.setBlocks(currentBlock);
   }

   public Block getNextBlock() {
      if (!gameRuleService.checkGameRule())
         return null;
      return gameStackService.stackBlock();
   }
}