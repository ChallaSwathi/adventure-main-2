package game;

import java.awt.Color;
//import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	//Container con;
	JPanel titlepanel, buttonpanel, maintextpanel,choicebuttonpanel, playerpanel;
	JLabel titleLabel, hp, hpnumber, weapon, weaponnumber;
	Font titlefont = new Font("Times New Roman", Font.PLAIN,80);
	Font buttonfont = new Font("Times New Roman", Font.ITALIC, 30);
	Font textfont = new Font("Times New Roman", Font.PLAIN,30);
	JButton button, C1, C2, C3, C4;
	JTextArea maintextarea;
	
	TitleScreenHandler tshandler = new TitleScreenHandler();
	ChoiceHandler chandler = new ChoiceHandler();
	
	int hpnum, monsterhp, silverRing;
	String weaponnum, position;
	
	public static void main(String[] args) {
		
		new Game();
	}
	public Game()
	{
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		//con = window.getContentPane();
		
		titlepanel = new JPanel();
		titlepanel.setBounds(100, 100, 600, 150);
		titlepanel.setBackground(Color.black);
		
		titleLabel = new JLabel("ADVENTURE");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titlefont);
		
		buttonpanel = new JPanel();
		buttonpanel.setBounds(300,400, 200, 150);
		buttonpanel.setBackground(Color.black);
		
		button = new JButton("START");
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(buttonfont);
		button.addActionListener(tshandler);
		button.setFocusPainted(false);
		
		titlepanel.add(titleLabel);
		buttonpanel.add(button);
		window.add(titlepanel);
		window.add(buttonpanel);
		window.setVisible(true);
		
	}
	public void CreateGameScreen(){
		
		titlepanel.setVisible(false);
		buttonpanel.setVisible(false);
		
		maintextpanel = new JPanel();
		maintextpanel.setBounds(100, 100, 600, 250);
		maintextpanel.setBackground(Color.black);
		
		
		maintextarea = new JTextArea("This is a text area.");
		maintextarea.setBounds(100, 100, 600, 200);
		maintextarea.setBackground(Color.black);
		maintextarea.setForeground(Color.white);
		maintextarea.setFont(textfont);
		maintextarea.setLineWrap(true);
		
		maintextpanel.add(maintextarea);
		
		choicebuttonpanel = new JPanel();
		choicebuttonpanel.setBounds(250	, 350, 300, 150);
		choicebuttonpanel.setBackground(Color.black);
		choicebuttonpanel.setLayout(new GridLayout(4,1));
		
		C1 = new JButton("Choice 1");
		C1.setBackground(Color.black);
		C1.setForeground(Color.white);
		C1.setFont(buttonfont);
		C1.setFocusPainted(false);
		choicebuttonpanel.add(C1);
		C1.addActionListener(chandler);
		C1.setActionCommand("c1");
		
		C2 = new JButton("Choice 2");
		C2.setBackground(Color.black);
		C2.setForeground(Color.white);
		C2.setFont(buttonfont);
		C2.setFocusPainted(false);
		choicebuttonpanel.add(C2);
		C2.addActionListener(chandler);
		C2.setActionCommand("c2");
		
		C3 = new JButton("Choice 3");
		C3.setBackground(Color.black);
		C3.setForeground(Color.white);
		C3.setFont(buttonfont);
		C3.setFocusPainted(false);
		choicebuttonpanel.add(C3);
		C3.addActionListener(chandler);
		C3.setActionCommand("c3");
		
		C4 = new JButton("Choice 4");
		C4.setBackground(Color.black);
		C4.setForeground(Color.white);
		C4.setFont(buttonfont);
		C4.setFocusPainted(false);
		choicebuttonpanel.add(C4);
		C4.addActionListener(chandler);
		C4.setActionCommand("c4");
		
		window.add(maintextpanel);
		window.add(choicebuttonpanel);
		
		
		playerpanel = new JPanel();
		playerpanel.setBounds(100, 15, 600, 50);
		playerpanel.setBackground(Color.black);
		playerpanel.setLayout(new GridLayout(1,4));
		
		hp = new JLabel("HP :");
		hp.setFont(textfont);
		hp.setForeground(Color.white);
		playerpanel.add(hp);
		
		hpnumber = new JLabel();
		hpnumber.setFont(textfont);
		hpnumber.setForeground(Color.white);
		playerpanel.add(hpnumber);
		
		weapon = new JLabel("Weapon :");
		weapon.setFont(textfont);
		weapon.setForeground(Color.white);
		playerpanel.add(weapon);
		
		weaponnumber = new JLabel();
		weaponnumber.setFont(textfont);
		weaponnumber.setForeground(Color.white);
		playerpanel.add(weaponnumber);
		
		window.add(playerpanel);
		playersetup();
		
	}
	
	public void playersetup()
	{
		hpnum = 15;
		monsterhp = 20;
		silverRing = 0;
		weaponnum = "Knife";
		weaponnumber.setText(weaponnum);
		hpnumber.setText(""+hpnum);
		
		townGate();
	}
	
	public void townGate() {
		position = "towngate";
		
		maintextarea.setText("You are at the town gate.\n A guard is standing infront of you.\n\nWhat do you do?");
		
		C1.setText("Talk to the Guard");
		C2.setText("Attack the Guard");
		C3.setText("Leave");
		//C4.setText("");
		C1.setVisible(true);
		C2.setVisible(true);
		C3.setVisible(true);
		C4.setVisible(false);
	}
	
	public void talkGuard() {
		position = "talkguard";
		
		maintextarea.setText("Guard:Hello Stranger. I have never seen your face. I am sorry but we can't let a stranger enter our town.");
		
		C1.setText(">");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
	}
	
	public void attackGuard() {
		position = "attackguard";
		
		maintextarea.setText("Guard:Hey don't be stupid!\n\nThe Guard fought back and hit you hard.\n(You receive 3 damage)");
		
		hpnum = hpnum - 3;
		hpnumber.setText(""+hpnum);
		C1.setText(">");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
		
	}
	
	public void crossRoad() {
		position = "crossroad";
		maintextarea.setText("You are at crossroad.\nIf you go south, you will go back to town.");
		
		C1.setText("Go North");
		C2.setText("Go East");
		C3.setText("Go South");
		C4.setText("Go West");
		C1.setVisible(true);
		C2.setVisible(true);
		C3.setVisible(true);
		C4.setVisible(true);
	}
	
	public void north() {
		position = "north";
		maintextarea.setText("There is a river.\n\nYou drink the water and rest at the river side.\n\n(Your HP is recovered by 2)");
		
		hpnum = hpnum + 2;
		hpnumber.setText(""+hpnum);
		
		C1.setText("Go South");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
	}
	public void east() {
		position = "east";
		maintextarea.setText("You walked into the forest.\n You found a long sword.\n(You obtain a Long Sword)");
		weaponnum = "Long Sword";
		weaponnumber.setText(weaponnum);
		
		C1.setText("Go West");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
		
		
	}
	public void west() {
		position = "west";
		maintextarea.setText("You encounter a Goblin.");
		C1.setText("Fight");
		C2.setText("Run");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(true);
		C3.setVisible(false);
		C4.setVisible(false);
		
	}
	
	public void fight() {
		position = "fight";
		maintextarea.setText("Monster Hp:" + monsterhp +"\nWhat do you do?");
		
		C1.setText("Attack");
		C2.setText("Run");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(true);
		C3.setVisible(false);
		C4.setVisible(false);
	}
	
	public void playerAttack() {
		position = "attack";
		
		int playerdamage = 0;
		
		if(weaponnum.equals("Knife"))
		{
			playerdamage = new java.util.Random().nextInt(4);
		}
		else if(weaponnum.equals("Long Sword")){
			playerdamage = new java.util.Random().nextInt(8);
		}
		maintextarea.setText("You attacked the Monster and gave "+playerdamage+" damage!");
		
		monsterhp = monsterhp-playerdamage;
		C1.setText(">");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
	}
	
	public void monsterAttack() {
		position = "monattack";
		
		int monsterdamage = 0;
		monsterdamage = new java.util.Random().nextInt(5);
		
		maintextarea.setText("Monster attacked you and gave "+monsterdamage+" damage.");
		hpnum = hpnum - monsterdamage;
		hpnumber.setText(""+hpnum);
		C1.setText(">");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
		
	}
	public void win() {
		position = "win";
		
		maintextarea.setText("You defeated the Monster!\nThe Monster dropped a ring!\n\n(You obtained a Silver ring)");
		
		silverRing = 1;
		C1.setText("Go East");
		//C2.setText("");
		//C3.setText("");
		C1.setVisible(true);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
		
	}
	public void lose() {
		position = "lose";
		
		maintextarea.setText("You are dead!\n\n<Game Over>");
		
		C1.setVisible(false);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
	}
	
	public void ending() {
		position = "ending";
		
		maintextarea.setText("Guard:Oh You killed the Goblin?\nThank you so much. You are a true hero!\nWelcome to our town.\n\n<THE END>");
		
		C1.setVisible(false);
		C2.setVisible(false);
		C3.setVisible(false);
		C4.setVisible(false);
	}
	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			CreateGameScreen();
		}

		
	}
public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String ch = event.getActionCommand();
			
			switch(position)
			{
			case "towngate":
				switch(ch) {
				case "c1": 
					if(silverRing == 1) {
						ending();
					}
					else {
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
			case "talkguard":
				switch(ch) {
				case "c1": townGate();break;
				}
				break;
			case "attackguard":
				switch(ch) {
				case "c1":townGate();break;
				}
				break;
			case "crossroad":
				switch(ch) {
				case "c1": north();break;
				case "c2":east();break;
				case "c3":townGate();break;
				case "c4":west();break;
				}
				break;
			case "north":
				switch(ch) {
				case "c1":crossRoad();break;
				}
				break;
			case "east":
				switch(ch) {
				case "c1": crossRoad();break;
				}
				break;
			case "west":
				switch(ch) {
				case "c1": fight();break;
				case "c2": crossRoad();break;
				}
				break;
			case "fight":
				switch(ch) {
				case "c1": playerAttack();break;
				case "c2" : crossRoad();break;
				}
				break;
			case "attack":
				switch(ch) {
				case "c1":
					if(monsterhp<1) {
						win();
					}
					else {
						monsterAttack();
					}
					break;
				}
				break;
			case "monattack":
				switch(ch) {
				case "c1":
					if(hpnum<1) {
						lose();
					}
					else {
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(ch) {
				case "c1":crossRoad();break;
				}
				break;
			}
		}

		
	}

}

