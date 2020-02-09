package snackFriends.view.singlePlay;

import javax.swing.Icon;

public class Block {
	
	/**
	 * Block Ŭ���� - ����� ��������(animal)�� ����(relation)�ʵ带 ���´�.
	 */
	private String animal;
	private String relation;
	
	/**
	 * 
	 * @param animal - Ÿ��: String / ���������� �ǹ��Ѵ�.
	 * @param relation - Ÿ��: String / ������ ������ ��Ÿ����.
	 * ����� ���� ������ ������ ���������� ��������(animal)�� ����(relation)���� �ʱ�ȭ�Ѵ�.
	 * 
	 */
	
	public Block(String animal, String relation) {
		this.animal=  animal;
		this.relation = relation;
	}
	/**
	 * 
	 * @param blockIcon - Ÿ�� : Icon / �����
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
