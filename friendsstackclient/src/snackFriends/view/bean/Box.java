package snackFriends.view.bean;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import snackFriends.view.multiPlay.MultiPlayScreen;

public class Box extends Thread {
	private ImageIcon[] animalBox = new ImageIcon[16];
	private String boxType;
	private int boxHeight;
	private int boxWidth;
	private String play;
	private String animal;
	private String modifier;

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Box(String boxType, int boxHeight, String play) {
		this.boxHeight = boxHeight;
		this.boxType = boxType;
		this.play = play;
		int oldIndex = boxType.indexOf("Box");
		animal = boxType.substring(0, oldIndex);
		modifier = boxType.substring(oldIndex + 4);
		this.boxWidth = 340 - new Random().nextInt(60);

		animalBox[0] = new ImageIcon("image/box/bearBox_friendly.png");
		animalBox[1] = new ImageIcon("image/box/bearBox_private.png");
		animalBox[2] = new ImageIcon("image/box/bearBox_public.png");
		animalBox[3] = new ImageIcon("image/box/beeBox_friendly.png");
		animalBox[4] = new ImageIcon("image/box/beeBox_private.png");
		animalBox[5] = new ImageIcon("image/box/beeBox_public.png");
		animalBox[6] = new ImageIcon("image/box/catBox_friendly.png");
		animalBox[7] = new ImageIcon("image/box/catBox_private.png");
		animalBox[8] = new ImageIcon("image/box/catBox_public.png");
		animalBox[9] = new ImageIcon("image/box/dogBox_friendly.png");
		animalBox[10] = new ImageIcon("image/box/dogBox_private.png");
		animalBox[11] = new ImageIcon("image/box/dogBox_public.png");
		animalBox[12] = new ImageIcon("image/box/rabbitBox_friendly.png");
		animalBox[13] = new ImageIcon("image/box/rabbitBox_private.png");
		animalBox[14] = new ImageIcon("image/box/rabbitBox_public.png");
		animalBox[15] = new ImageIcon("image/box/lionBox_joker.png");
	}

	public void drawBox(Graphics g) {
		switch (boxType) {
		case "bearBox_friendly":
			g.drawImage(animalBox[0].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "bearBox_private":
			g.drawImage(animalBox[1].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "bearBox_public":
			g.drawImage(animalBox[2].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "beeBox_friendly":
			g.drawImage(animalBox[3].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "beeBox_private":
			g.drawImage(animalBox[4].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "beeBox_public":
			g.drawImage(animalBox[5].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "catBox_friendly":
			g.drawImage(animalBox[6].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "catBox_private":
			g.drawImage(animalBox[7].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "catBox_public":
			g.drawImage(animalBox[8].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "dogBox_friendly":
			g.drawImage(animalBox[9].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "dogBox_private":
			g.drawImage(animalBox[10].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "dogBox_public":
			g.drawImage(animalBox[11].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "rabbitBox_friendly":
			g.drawImage(animalBox[12].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "rabbitBox_private":
			g.drawImage(animalBox[13].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "rabbitBox_public":
			g.drawImage(animalBox[14].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		case "lionBox_joker":
			g.drawImage(animalBox[15].getImage(), boxWidth, boxHeight, 200, 200, null);
			break;
		}
	}

	public void drop() {
		boxHeight += 40;
	}

	public void run() {
		int height;
		try {
			if (play.equals("single"))
				System.out.println("ik");
			else
				height = MultiPlayScreen.boxHeight;

			while (boxHeight <= 200) {
				drop();
				// System.out.println("박스 : " + boxHeight + "한계 : " + (height));
				// Thread.sleep(30);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getBoxHeight() {
		return boxHeight;
	}

	public void setBoxHeight(int boxHeight) {
		this.boxHeight = boxHeight;
	}

	public String getBoxType() {
		return boxType;
	}

	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}

}
