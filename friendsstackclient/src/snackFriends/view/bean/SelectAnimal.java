package snackFriends.view.bean;


import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectAnimal extends JDialog {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, ImageIcon> pop = new HashMap<String, ImageIcon>();
	private static SelectAnimal instance;
	private static JPanel panel;
	private static JButton[] friends;
	private static HashMap<String, ArrayList<String>> relation = new HashMap<String, ArrayList<String>>();

	private static HashMap<String, ImageIcon> select;
	private static String selected;

	private String selectedAnimal;

	private SelectAnimal(JFrame frame) {
		super(frame, "Select Animal", true);

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(pop.get(selected).getImage(), 0, 0, 550, 358, null);
			}
		};
		this.setContentPane(panel);
		ArrayList<String> dog = new ArrayList<>();
		dog.add("cat");
		dog.add("rabbit");
		ArrayList<String> cat = new ArrayList<>();
		cat.add("dog");
		cat.add("bear");
		ArrayList<String> bear = new ArrayList<>();
		bear.add("cat");
		bear.add("bee");
		ArrayList<String> rabbit = new ArrayList<>();
		rabbit.add("dog");
		rabbit.add("bee");
		ArrayList<String> bee = new ArrayList<>();
		bee.add("rabbit");
		bee.add("bear");

		relation.put("dog", dog);
		relation.put("cat", cat);
		relation.put("bear", bear);
		relation.put("rabbit", rabbit);
		relation.put("bee", bee);

		pop.put("bear", new ImageIcon("image\\multi\\friendly\\select\\popup\\bearPop.png"));
		pop.put("bee", new ImageIcon("image\\multi\\friendly\\select\\popup\\beePopup.png"));
		pop.put("cat", new ImageIcon("image\\multi\\friendly\\select\\popup\\catPopup.png"));
		pop.put("dog", new ImageIcon("image\\multi\\friendly\\select\\popup\\dogPopup.png"));
		pop.put("rabbit", new ImageIcon("image\\multi\\friendly\\select\\popup\\rabbitPopup.png"));

		select = new HashMap<String, ImageIcon>();
		select.put("bear", new ImageIcon("image\\multi\\friendly\\select\\selectbutton\\bearSelect.png"));
		select.put("bee", new ImageIcon("image\\multi\\friendly\\select\\selectbutton\\beeSelect.png"));
		select.put("cat", new ImageIcon("image\\multi\\friendly\\select\\selectbutton\\catSelect.png"));
		select.put("dog", new ImageIcon("image\\multi\\friendly\\select\\selectbutton\\dogSelect.png"));
		select.put("rabbit", new ImageIcon("image\\multi\\friendly\\select\\selectbutton\\rabbitSelect.png"));

		this.setLayout(null);
		setBounds(100, 100, 560, 388);
		setLocationRelativeTo(null);

		friends = new JButton[2];
		for (int i = 0; i < friends.length; i++) {
			friends[i] = new JButton();
			friends[i].setBounds(222 + i * 143, 170, 100, 100);
			friends[i].setBorderPainted(false);
			friends[i].setContentAreaFilled(false);
			friends[i].setFocusPainted(false);
			friends[i].addMouseListener(new friendsHandler());
			this.add(friends[i]);
		}
	}

	class friendsHandler extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			instance.setVisible(false);
		}
	}

	public String getSelectedAnimal() {
		return selectedAnimal;
	}

	public static SelectAnimal getInstance(JFrame frame, Box box) {
		if (instance == null)
			instance = new SelectAnimal(frame);
		selected = box.getAnimal();
		for (int i = 0; i < friends.length; i++) {
			friends[i].setVisible(false);
			friends[i].setIcon(select.get(relation.get(selected).get(i)));
			friends[i].setVisible(true);
		}
		instance.repaint();
		instance.setVisible(true);
		return instance;
	}
}
