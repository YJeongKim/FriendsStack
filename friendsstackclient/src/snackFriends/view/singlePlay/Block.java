package snackFriends.view.singlePlay;

import javax.swing.Icon;

public class Block {
	
	/**
	 * Block 클래스 - 블록의 동물종류(animal)와 색상(relation)필드를 갖는다.
	 */
	private String animal;
	private String relation;
	
	/**
	 * 
	 * @param animal - 타입: String / 동물종류를 의미한다.
	 * @param relation - 타입: String / 동물의 색상을 나타낸다.
	 * 블록의 동물 종류와 색상을 전달인자인 동물종류(animal)와 색상(relation)으로 초기화한다.
	 * 
	 */
	
	public Block(String animal, String relation) {
		this.animal=  animal;
		this.relation = relation;
	}
	/**
	 * 
	 * @param blockIcon - 타입 : Icon / 블록의
	 */
	
	public Block(Icon blockIcon) {
		String iconString=blockIcon.toString();
		String iconSplit[]=iconString.split("/");
		iconString = iconSplit[iconSplit.length-1];
		String iconSum[]= iconString.split("Box_");
		this.animal=iconSum[0];
		this.relation=iconSum[iconSum.length-1].split(".png")[0];
	}
	
	/**
	 * 
	 * @param previousBlock
	 */
	public Block(BlockBean previousBlock) {
		this(previousBlock.getBlockIcon());
	}
	public void setBlock(BlockInfo blockInfo) {
		this.animal=blockInfo.getAnimal();
		this.relation=blockInfo.getRelation();
	}
	public String getAnimal() {
		return this.animal;
		}
	public String getRelation() {
		return this.relation;
		}
	public void setBlock(Icon blockIcon) {
	}
	public void setBlock(BlockBean previousBlock) {
		
	}
	
	
}
