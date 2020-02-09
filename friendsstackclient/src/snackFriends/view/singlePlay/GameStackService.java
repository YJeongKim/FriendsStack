package snackFriends.view.singlePlay;

public class GameStackService {
	private Block currentBlock;
	private static GameStackService instance;
	public static GameStackService getinstance() {
		if(instance ==null) {
			instance = new GameStackService();
		}
		return instance;
	}
	private GameStackService() {}
	public Block stackBlock() {
		BlockInfo blockInfo=new BlockInfo(currentBlock.getAnimal(),currentBlock.getRelation());
		BlockInfo nextBlock= BlockAdmin.getInstance().popBlock(blockInfo);
		return new Block(nextBlock.getAnimal(),nextBlock.getRelation());
	}
	public void setBlocks(Block currentBlock) {
		this.currentBlock = currentBlock;
	}
}
