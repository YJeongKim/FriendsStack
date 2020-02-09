package snackFriends.view.singlePlay;

import java.util.ArrayList;

import snackFriends.view.bean.Music;

public class GameRuleService {
	private Block currentBlock;
	private Block previousBlock;
	private static GameRuleService instance;
	
	public static GameRuleService getinstance() {
		if(instance ==null) {
			instance = new GameRuleService();
		}
		return instance;
	}
	private GameRuleService() {}
	public boolean checkGameRule() {
		if(previousBlock==null)
			return true;

		if(currentBlock.getRelation().equals("joker")||previousBlock.getRelation().equals("joker")) 			
			return true;				
		if(previousBlock.getRelation().equals("public"))
		{
			if(currentBlock.getRelation().equals("public")||previousBlock.getAnimal().equals(currentBlock.getAnimal()))
				return true;
			else
				return false;
		}
		if(previousBlock.getRelation().equals("friendly")) {
			ArrayList<String> relationCheck = RelationshipDAO.getInstance().search(previousBlock.getAnimal());
			System.out.println(relationCheck);
			for(String check:relationCheck) {
				if(currentBlock.getAnimal().equals(check))
					return true;
			}
			return false;
		}
		if(previousBlock.getRelation().equals("private")) {
			if(previousBlock.getAnimal().equals(currentBlock.getAnimal()))
				return true;
		}
		return false;
	}
	public void setBlocks(Block currentBlock,Block previousBlock) {
		System.out.println(currentBlock.getRelation());
		System.out.println(currentBlock.getAnimal());
		switch(currentBlock.getAnimal()) {
		case "lion":
			new Music("lion.mp3", false).start();
			break;
		case "dog":
			new Music("dog.mp3", false).start();
			break;
		case "cat":
			new Music("cat.mp3", false).start();
			break;
		case "bear":
			new Music("bear.mp3", false).start();
			break;
		case "bee":
			new Music("bee.mp3", false).start();
			break;
		}						
		this.currentBlock = currentBlock;
		this.previousBlock = previousBlock;
	}
	
}
