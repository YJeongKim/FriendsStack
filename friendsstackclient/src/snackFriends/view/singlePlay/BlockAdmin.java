package snackFriends.view.singlePlay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BlockAdmin {
	private static BlockAdmin instance;
	private ArrayList<BlockInfo> blockList;
	private int blockCount;
	private Random random;
	private static final String[] RELATIONS = { "public", "friendly", "private" };
	private static final String JOKER="joker";
	private static final Integer[] RELATIONCOUNT = { 2, 3, 2 };
	private static final String[] ANIMALS = { "dog", "cat", "bear", "bee", "rabbit", "lion" };
	private static final int PLAYERBLOCK = 6;

	   
	public static BlockAdmin getInstance() {
		if(instance ==null) {
			instance = new BlockAdmin();
		}
		return instance;
	}
	public int getBlockCount() {
		BlockAdmin.getInstance().clear();
		return blockCount;
	}
	private BlockAdmin() {
		random=new Random();
		initBlock();
	}
	public void initBlock() {
		blockList=new ArrayList<BlockInfo>();
		for (int i = 0; i < ANIMALS.length - 1; i++)
	         for (int j = 0; j < RELATIONS.length; j++)
	            for (int k = 0; k < RELATIONCOUNT[j]; k++)
	               blockList.add(new BlockInfo(ANIMALS[i], RELATIONS[j]));
	      blockList.add(new BlockInfo(ANIMALS[ANIMALS.length - 1], JOKER));
	}
	public ArrayList<BlockInfo> popBlocklist(){
		Collections.shuffle(blockList);
		ArrayList<BlockInfo> playerBlock =new ArrayList<BlockInfo>(blockList.subList(0, PLAYERBLOCK));
		blockList = new ArrayList<BlockInfo>(blockList.subList(PLAYERBLOCK,blockList.size()));
		return playerBlock;
		
	}
	public BlockInfo popBlock(BlockInfo block) {
		BlockInfo pop=blockList.get(random.nextInt(blockList.size()));
		blockCount++;
		blockList.add(block);
		return pop;
	}
	public static void clear() {
		instance = new BlockAdmin();
	}
}
