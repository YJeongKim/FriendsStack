package snackFriends.view.singlePlay;

import java.awt.Graphics;

import javax.swing.ImageIcon;
public class BlockBean extends Thread{
	private int x;
	private int y;
	private ImageIcon blockIcon;
	private static final int BLOCKWIDTH=200;
	private static final int BLOCKHEIGHT=200;
	
	public BlockBean(ImageIcon blockIcon, int x, int y) {
		this.x = x;
		this.y= y;
		this.blockIcon = blockIcon;
	}
	public void drawBlock(Graphics g) {
		g.drawImage(blockIcon.getImage(), x, y, BLOCKWIDTH, BLOCKHEIGHT,null);
	}
	public void run() {
		
		try {
			while (y <= SinglePlayScreen.blockLimitHeight + 200) {
				drop();
				Thread.sleep(80);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void drop() {
		y += 40;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public ImageIcon getBlockIcon() {
		return blockIcon;
	}
	public void setBlockIcon(ImageIcon blockIcon) {
		this.blockIcon = blockIcon;
	}
	
}
