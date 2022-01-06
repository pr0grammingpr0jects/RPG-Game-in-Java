import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, healthBarPanel, inventoryPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, continueButton, choice1, choice2, choice3, choice4, inventoryButton, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String weapon, position, inventoryStatus;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	JProgressBar healthBar;
	
	ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");
	
	InventoryHandler iHandler = new InventoryHandler();

	String [] playerItem = new String[5];

	KeyHandler kHandler = new KeyHandler();
	int buttonPosition = 1;

	ImageIcon titleImage;
	JPanel titleImagePanel;
	JLabel titleImageLabel;

	public static void main(String[] args) {

		new Game();
	}
	
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setIconImage(logo.getImage());
		window.addKeyListener(kHandler);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("TATIUM");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		startButton.setBorder(null);
		startButton.setActionCommand("start");

		continueButton = new JButton("COUNTINUE");
		continueButton.setBackground(Color.black);
		continueButton.setForeground(Color.white);
		continueButton.setFont(normalFont);
		continueButton.addActionListener(tsHandler);
		continueButton.setFocusPainted(false);
		continueButton.setBorder(null);
		continueButton.setActionCommand("continue");

		titleImage = new ImageIcon(getClass().getClassLoader().getResource("cyber.jpg"));

		titleImagePanel = new JPanel();
		titleImagePanel.setBounds(0, 0, 800, 800);

		titleImageLabel = new JLabel();
		titleImageLabel.setIcon(titleImage);
		titleImagePanel.add(titleImageLabel);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		startButtonPanel.add(continueButton);
		titleImagePanel.add(titleImageLabel);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(titleImagePanel);
		
		window.setVisible(true);

		window.getRootPane().setDefaultButton(startButton);

		

		
	}
	
	public void createGameScreen(String startorcontinue){
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		titleImagePanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);		
		mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true); 
		mainTextArea.setEditable(false); 	
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 200);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(5,1));
		con.add(choiceButtonPanel);		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); 
		choice1.setActionCommand("c1"); 
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

		inventoryButton = new JButton("[ Inventory ]");
		inventoryButton.setBackground(Color.white);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(iHandler);
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(550, 350, 200, 200);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(5,1));
		con.add(inventoryPanel);

		itemButton1 = new JButton();
		itemButton1.setBackground(Color.black);
		itemButton1.setForeground(Color.white);
		itemButton1.setFont(normalFont);
		itemButton1.addActionListener(iHandler);
		itemButton1.setActionCommand("item1");
		itemButton1.setFocusPainted(false);

		itemButton2 = new JButton();
		itemButton2.setBackground(Color.black);
		itemButton2.setForeground(Color.white);
		itemButton2.setFont(normalFont);
		itemButton2.addActionListener(iHandler);
		itemButton2.setActionCommand("item2");
		itemButton2.setFocusPainted(false);

		itemButton3 = new JButton();
		itemButton3.setBackground(Color.black);
		itemButton3.setForeground(Color.white);
		itemButton3.setFont(normalFont);
		itemButton3.addActionListener(iHandler);
		itemButton3.setActionCommand("item3");
		itemButton3.setFocusPainted(false);

		itemButton4 = new JButton();
		itemButton4.setBackground(Color.black);
		itemButton4.setForeground(Color.white);
		itemButton4.setFont(normalFont);
		itemButton4.addActionListener(iHandler);
		itemButton4.setActionCommand("item4");
		itemButton4.setFocusPainted(false);

		itemButton5 = new JButton();
		itemButton5.setBackground(Color.black);
		itemButton5.setForeground(Color.white);
		itemButton5.setFont(normalFont);
		itemButton5.addActionListener(iHandler);
		itemButton5.setActionCommand("item5");
		itemButton5.setFocusPainted(false);

		inventoryPanel.add(itemButton1);
		inventoryPanel.add(itemButton2);
		inventoryPanel.add(itemButton3);
		inventoryPanel.add(itemButton4);
		inventoryPanel.add(itemButton5);

		inventoryPanel.setVisible(false);
		
//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!
		
		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(100, 15, 200, 30);
		healthBarPanel.setBackground(Color.black);
		con.add(healthBarPanel);
		healthBar = new JProgressBar(0,15);
		healthBar.setPreferredSize(new Dimension(200,30));
		healthBar.setBackground(Color.red);
		healthBar.setForeground(Color.green);
		healthBarPanel.add(healthBar);

		playerPanel = new JPanel();
		playerPanel.setBounds(400, 15, 300, 30);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,2));
		con.add(playerPanel);
		// hpLabel = new JLabel("HP:");
		// hpLabel.setFont(normalFont);
		// hpLabel.setForeground(Color.white);
		// playerPanel.add(hpLabel);
		// hpLabelNumber = new JLabel();
		// hpLabelNumber.setFont(normalFont);
		// hpLabelNumber.setForeground(Color.white);
		// playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		weaponLabel.setBackground(Color.red);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		if(startorcontinue.equals("start")){
			playerSetup();
		}

		if(startorcontinue.equals("continue")){
			loadData();
		}
		

	}
	public void playerSetup(){
		
		playerHP = 15;
		monsterHP = 20;
		weapon = "None";
		weaponLabelName.setText(weapon);
		//hpLabelNumber.setText("" + playerHP);
		healthBar.setValue(playerHP);
		inventoryStatus = "close";

		playerItem[0] = "Medicine";
		playerItem[1] = "Wallet";
		playerItem[2] = "";
		playerItem[3] = "";
		playerItem[4] = "";

		
		wake();
	}

	
	
	public void loadData(){

		try {
			BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));

			playerHP = Integer.parseInt(br.readLine());
			monsterHP = Integer.parseInt(br.readLine());
			weapon = br.readLine();
			

			br.close();
		}	

		catch(Exception e){

		}

		weaponLabelName.setText(weapon);
		playerHP = 150;
		healthBar.setValue(playerHP);

		


		wake();

	}

	public void wake(){
		position = "wake";
		mainTextArea.setText("Karlie wakes up in her room the sound of her cell phone Blaring throughout your house\n What should Karlie do?");		
		choice1.setText("Answer it");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void answer(){
		position = "answer";
		mainTextArea.setText("Karlie get up and answers the phone the person on the other line says.\n Hey this is Adam Karlie we need you to build a Robot for us we will send the fax of what we want later but go to the store and get the materials\n What should Karlie do?");
		choice1.setText("Go to store");
		choice2.setText("Get dressed");
		choice3.setText("Bathroom");
		choice4.setText("");
	}

	public void store(){
		position = "store";
		mainTextArea.setText("Karlie: I can't go to the store I need my clothes.");
		//playerHP = playerHP -3;
		//playerHP -=3;
		//hpLabelNumber.setText(""+playerHP);
		//healthBar.setValue(playerHP);
		choice1.setText("Get dressed");
		choice2.setText("Bathroom");
		choice3.setText("");
		choice4.setText("");
	}

	public void dressed(){
		position = "dressed";
		// weapon = "Arm Canon";
		// weaponLabelName.setText(weapon);
		//playerHP = playerHP -3;
		//playerHP -=3;
		//hpLabelNumber.setText(""+playerHP);
		//healthBar.setValue(playerHP);
		int slotNumber = 0;

		while(playerItem[slotNumber] != "" && slotNumber <4){
			slotNumber++;
		}

		if(playerItem[slotNumber]==""){
			mainTextArea.setText("Karlie put on her clothes.\n She then heads over to the printer and gets the fax for the Robot design.\nNow Karlie was ready to head out.");
			playerItem[slotNumber] = "Fax";
		}

		choice1.setText("Go to store");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void bathroom(){
		position = "bathroom";
		mainTextArea.setText("Karlie freshens up and brushes her teeth");
		choice1.setText("Go to store");
		choice2.setText("Get dressed");
		choice3.setText("");
		choice4.setText("");
	}

	public void storereal(){
		position = "storereal";
		mainTextArea.setText("After Karlie got everything she go ready to go to the store.\n She got on the bus that headed to the store.\n What should Karlie do?");
		choice1.setText("Get Tech");
		choice2.setText("Chips");
		choice3.setText("Beverages");
		choice4.setText("Grappes");
	}

	public void chips(){
		position = "chips";
		mainTextArea.setText("Karlie got some Chips which are her favirite kind Lays\n What should Karlie do now?");
		choice1.setText("Get Tech");
		choice2.setText("Beverages");
		choice3.setText("Grappes");
		choice4.setText("Leave");
	}

	public void beverages(){
		position = "beverages";
		mainTextArea.setText("Karlie got some beverages like water and V8 Splash\n");
		choice1.setText("Get Tech");
		choice2.setText("Chips");
		choice3.setText("Grappes");
		choice4.setText("Leave");
	}

	public void grappes(){
		position = "grappes";
		mainTextArea.setText("Karlie got some grappes which are her favorite fruit\n");
		choice1.setText("Get Tech");
		choice2.setText("Chips");
		choice3.setText("Beverages");
		choice4.setText("Leave");
	}

	public void leavebad(){
		position = "leavebad";
		mainTextArea.setText("Karlie: I can't leave I have to get the Tech first.\n");
		choice1.setText("Get Tech");
		choice2.setText("Chips");
		choice3.setText("Beverages");
		choice4.setText("Grappes");
	}

	public void tech(){
		position = "tech";
		mainTextArea.setText("Karlie: Alright time to look at the fax to see what I should get\n");
		choice1.setText("Get Plants");
		choice2.setText("Get Iron");
		choice3.setText("Get Blades");
		choice4.setText("Flame");
	}

	public void plants(){
		position = "plants";
		mainTextArea.setText("Karlie: This is the wrong item\n");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void iron(){
		position = "iron";
		mainTextArea.setText("Karlie: This is the correct item\n");
		choice1.setText("Get Plants");
		choice2.setText("Get Blades");
		choice3.setText("Flame");
		choice4.setText("Leave");
	}

	public void blades(){
		position = "blades";
		mainTextArea.setText("Karlie: This is the correct item\n");
		choice1.setText("Get Plants");
		choice2.setText("Get Blades");
		choice3.setText("Flame");
		choice4.setText("Leave");
	}

	public void flame(){
		position = "flame";
		mainTextArea.setText("Karlie: This is the correct item\n");
		choice1.setText("Get Plants");
		choice2.setText("Iron");
		choice3.setText("Get Blades");
		choice4.setText("Leave");
	}

	public void leavebad2(){
		position = "leavebad2";
		mainTextArea.setText("Karlie: I can't leave before I get all the Items\n");
		choice1.setText("Get Plants");
		choice2.setText("Iron");
		choice3.setText("Get Blades");
		choice4.setText("Flame");
	}

	public void leavegood(){
		position = "leavegood";
		mainTextArea.setText("Karlie got all the items paid for them and left the store and went home.\n What should Karlie do now?");
		choice1.setText("Work");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void work(){
		position = "work";
		mainTextArea.setText("Karlie went to her book shelf and pulled one book which open up a passage to her lab.\n What should Karlie do?");
		choice1.setText("Work on Robot");
		choice2.setText("Side Project");
		choice3.setText("");
		choice4.setText("");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);
	}

	public void robot(){
		position = "robot";
		mainTextArea.setText("Karlie gets out the items she got from the store and starts constructing the robot out of spar Roba parts with the Blades Flamethrougher and everything else attached.\n What should Karlie do?");
		choice1.setText("Make more");
		choice2.setText("Add AI");
		choice3.setText("Side Project");
		choice4.setText("Leave");
	}

	public void more(){
		position = "more";
		mainTextArea.setText("Karlie constructed 5 Robots total.\n What should Karlie do?");
		choice1.setText("Add AI");
		choice2.setText("Side Project");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void ai(){
		position = "ai";
		mainTextArea.setText("Karlie adds an AI to the Robots which attacks people that match a similar body type to a dealer\n What should Karlie do?");
		choice1.setText("Side Project");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}

	public void side(){
		position = "side";
		mainTextArea.setText("Karlie takes off her watch and starts tinkering with it when she does this it turns into a Arm Canon.\n What should Karlie do?");
		choice1.setText("Add Barrier");
		choice2.setText("Make ammo");
		choice3.setText("");
		choice4.setText("");
	}

	public void barrier(){
		position = "barrier";
		mainTextArea.setText("Karlie adds a barrier between the ammo and her hand because before hand when she would shoot something her hand would get caught because the hand was inside of the Arm Canon but now Karlie has fixed the issue.\n What should Karlie do?");
		choice1.setText("Make ammo");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}

	public void ammo(){
		position = "ammo";
		mainTextArea.setText("Karlie adds some ammo to the arm Canon the ammo is a traqulizer dart that is coved in soft ball substance\n What should Karlie do?");
		choice1.setText("Add Barrier");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}

	public void leavebad3(){
		position = "leavebad3";
		mainTextArea.setText("Karlie: I can't leave yet I still have stuff to work on");
		choice1.setText("Make more");
		choice2.setText("Add AI");
		choice3.setText("Side Project");
		choice4.setText("");
	}

	public void leavegood2(){
		position = "leavegood2";
		mainTextArea.setText("Karlie got a cellphone call what should she do?");
		choice1.setText("Answer it");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void answer2(){
		position = "answer2";
		mainTextArea.setText("Karlie: Hello Adam I finished the Robot.\n Adam: GREAT now all I need you to do is deliver it to 5670 Ports Street.\n What should Karlie do?");
		choice1.setText("Ask");
		choice2.setText("Go to location");
		choice3.setText("");
		choice4.setText("");
	}

	public void ask(){
		position = "ask";
		mainTextArea.setText("Karlie: Hey Adam when can I get some Tatium I need it for a Project I have been working on.\n Adam: You will get it when you get it now hurry up\n What should Karlie do?");
		choice1.setText("Go to location");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void location(){
		position = "location";
		mainTextArea.setText("Karlie went out and got on the bus headed to the location.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void location2(){
		position = "location2";
		mainTextArea.setText("Karlie arrived at the location and his partner Steve was with him.\n");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void location3(){
		position = "location3";
		mainTextArea.setText("Adam: Alright Karlie you have the Robots please hand them over.\n What should Karlie do?");
		choice1.setText("Hand them over");
		choice2.setText("Ask");
		choice3.setText("Steve");
		choice4.setText("");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);
	}

	public void hand(){
		position = "hand";
		mainTextArea.setText("Karlie: Here are the Robots I fixed them up with something special that wasn't in the blueprints.\n Adam: Ok thank you see ya.\n What should Karlie do?");
		choice1.setText("Ask");
		choice2.setText("Steve");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void ask2(){
		position = "ask2";
		mainTextArea.setText("Karlie: Hey I know I asked this earlier but um when can I- \nAdam: We already talked about this Karlie and the answer is wait.\n What should Karlie do?");
		choice1.setText("Hand them over");
		choice2.setText("Steve");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void steve(){
		position = "steve";
		mainTextArea.setText("Karlie: Hey Steve how is it going.\n Steve.........\n Karlie: Alright\n What should Karlie do?");
		choice1.setText("Hand them over");
		choice2.setText("Ask");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void leavebad4(){
		position = "leavebad4";
		mainTextArea.setText("Adam: Hand over the Robots before you leave Karlie!!!\n What should Karlie do?");
		choice1.setText("Hand them over");
		choice2.setText("Ask");
		choice3.setText("Steve");
		choice4.setText("");
	}

	public void leavegood3(){
		position = "leavegood3";
		mainTextArea.setText("Karlie: Alright Guys can't wait until our next meeting bye.\n Adam: Bye\n");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);
	}

	public void back(){
		position = "back";
		mainTextArea.setText("Karlie got on the bus to go back home and when she got home it was pretty late at night.\n What should Karlie do?");
		choice1.setText("Lab");
		choice2.setText("Eat");
		choice3.setText("Journal");
		choice4.setText("Sleep");
	}

	public void lab2(){
		position = "lab2";
		mainTextArea.setText("Karlie went into her Lab.\n What should she work on?");
		choice1.setText("Arm Canon");
		choice2.setText("Secret Project");
		choice3.setText("");
		choice4.setText("");
	}

	public void secret(){
		position = "secret";
		mainTextArea.setText("Karlie: I can't work on THAT until I get some Tatium\n What should Karlie  work on?");
		choice1.setText("Arm Canon");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}

	public void armcanon(){
		position = "armcanon";
		mainTextArea.setText("Karlie then work on the Arm Canon she added some more quality of life inprovements but she needed one more thing to finish it which was a scouter maybe she could get it tomorrow and then the Arm Canon could be complete\n What should Karlie work on?");
		choice1.setText("Secret Project");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}

	public void leavegood4(){
		position = "leavegood4";
		mainTextArea.setText("Karlie leaves the lab and closes it.\n What should Karlie do now?");
		choice1.setText("Eat");
		choice2.setText("Journal");
		choice3.setText("Sleep");
		choice4.setText("");
	}	

	public void eat(){
		position = "eat";
		mainTextArea.setText("Karlie made a HotDog with some Fries it was tasty\n What should Karlie do?");
		choice1.setText("Lab");
		choice2.setText("Journal");
		choice3.setText("Sleep");
		choice4.setText("");
	}

	public void journal(){
		position = "journal";
		mainTextArea.setText("Karlie went into her bedroom and opened a holographic pad which open a virtual journal Karlie got the Pencil she used to write in the journal\n What should Karlie write about?");
		choice1.setText("Today");
		choice2.setText("Adam");
		choice3.setText("Steve");
		choice4.setText("Secret Project");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);
	}

	public void today(){
		position = "today";
		mainTextArea.setText("Karlie: Today was pretty alright all things considered I am getting close to finsihing the Arm Canon all I need is a Scouter but man imagine if I had Tatium my Arm Canon would be so powerful.");
		choice1.setText("Today Con");
		choice2.setText("Adam");
		choice3.setText("Steve");
		choice4.setText("Secret Project");
	}

	public void today2(){
		position = "today2";
		mainTextArea.setText("Karlie: Its so weird the reason I worked for the Organization is so I can get Tatium Legally but no because I don't go on the front lines I get nothing which hurts because I can't work on my secret project.");
		choice1.setText("Organization");
		choice2.setText("Adam");
		choice3.setText("Steve");
		choice4.setText("Secret Project");
	}

	public void organization(){
		position = "organization";
		mainTextArea.setText("Karlie: The organization is kinda annoying because in order to get Tatium you have to go through them and do all this stuff but you only GET the tatium if they like you.");
		choice1.setText("Org Con");
		choice2.setText("Adam");
		choice3.setText("Steve");
		choice4.setText("Secret Project");
	}

	public void organization2(){
		position = "organization2";
		mainTextArea.setText("Karlie: The reason I was able to get into the Organization is because of my Robot making but because I am not like Adam and Steve who are on the front lines I get no Tatium it sucks.");
		choice1.setText("Adam");
		choice2.setText("Steve");
		choice3.setText("Secret Project");
		choice4.setText("Sleep");
	}

	public void adam(){
		position = "adam";
		mainTextArea.setText("Karlie: Adam is the super visor of me because hes the main deal in the Organization since his family are High Soldiers in the Organization so he has special privlages.");
		choice1.setText("Adam Con");
		choice2.setText("Today");
		choice3.setText("Steve");
		choice4.setText("Secret Project");
	}

	public void adam2(){
		position = "adam2";
		mainTextArea.setText("Karlie: I HATE Adam he always acts better then everyone he won't give me Tatium and he doesn't even do anything its Steve and my Robots that does all the work when he goes on missions");
		choice1.setText("Today");
		choice2.setText("Steve");
		choice3.setText("Secret Project");
		choice4.setText("Sleep");
	}

	public void steve2(){
		position = "steve2";
		mainTextArea.setText("Karlie: Steve is alright he is always quiet because he is basically the body guard of Adam so he doesn't talk much but his scarf is SO COOL");
		choice1.setText("Steve Con");
		choice2.setText("Today");
		choice3.setText("Adam");
		choice4.setText("Secret Project");
	}
	
	public void steve3(){
		position = "steve3";
		mainTextArea.setText("Karlie: Steves scarf is completely robotic but the fabric desgues its robotic center the whole scarf is FULL of Tatium which makes it so Steve can control his Scarf at will like an extra apendic its SO COOL.");
		choice1.setText("Today");
		choice2.setText("Adam");
		choice3.setText("Secret Project");
		choice4.setText("Sleep");
	}

	//Make a seperate path for this
	public void secret2(){
		position = "secret2";
		mainTextArea.setText("Karlie: The project I am working is my Magnum Opas a robot named um......\n What should Karlie name the Robot?");
		choice1.setText("Engine");
		choice2.setText("Markus");
		choice3.setText("Setruy");
		choice4.setText("Shipent");
	}

	public void engine(){
		position = "engine";
		mainTextArea.setText("Karlie: The Robots name is Engine and he is going to be a powerful Robot who can transform into an Engine and go into any ship and Control the ship no matter what shape the ship is in.");
		choice1.setText("Secret Con");
		choice2.setText("Today");
		choice3.setText("Adam");
		choice4.setText("Steve");
	}

	public void engine2(){
		position = "engine2";
		mainTextArea.setText("Karlie: If I am able to do this it would be a game changer for Travel in general yeah sure we have flying cars but if Engine gets made it would make it so we wouldn never have to repair Cars get Gas it would be a game changed I just need Tatum to do it.");
		choice1.setText("Today");
		choice2.setText("Adam");
		choice3.setText("Steve");
		choice4.setText("Sleep");
	}

	public void sleep(){
		position = "sleep";
		mainTextArea.setText("Karlie goes to sleep");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void awake2(){
		position = "awake2";
		mainTextArea.setText("Karlie got up in the morning she checked her phone no missed calls seems like today she not going to be on a mission\n What should Karlie do?");
		choice1.setText("Eat");
		choice2.setText("Arm Canon");
		choice3.setText("Store");
		choice4.setText("Adam");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);
	}

	public void eat2(){
		position = "eat2";
		mainTextArea.setText("Karlie got dressed and ate some ceral which was alright.\n What should Karlie do?");
		choice1.setText("Arm Canon");
		choice2.setText("Store");
		choice3.setText("Adam");
		choice4.setText("");
	}

	public void adam3(){
		position = "adam3";
		mainTextArea.setText("Karlie: Why would I call Adam I don't have a mission today\n What should karlie do?");
		choice1.setText("Arm Canon");
		choice2.setText("Store");
		choice3.setText("Eat");
		choice4.setText("");
	}

	public void armcanon2(){
		position = "armcanon2";
		mainTextArea.setText("Karlie: I should get some more materials like a scouter before I can finish the Arm Canon\n What should Karlie do?");
		choice1.setText("Adam");
		choice2.setText("Store");
		choice3.setText("Eat");
		choice4.setText("");
	}

	public void store2(){
		position = "store2";
		mainTextArea.setText("Karlie got on the bus and went to the store after entering Karlie looked around\n What should Karlie do?");
		choice1.setText("Tech");
		choice2.setText("Food");
		choice3.setText("Beverages");
		choice4.setText("");
	}

	public void food(){
		position = "food";
		mainTextArea.setText("Karlie got some chips and some chicken wings and some hotdogs\n What should Karlie do?");
		choice1.setText("Tech");
		choice2.setText("Beverages");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void beverages2(){
		position = "beverages2";
		mainTextArea.setText("Karlie got some water and some lemonade\n What should Karlie do?");
		choice1.setText("Tech");
		choice2.setText("Food");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void tech2(){
		position = "tech2";
		mainTextArea.setText("Karlie went to the Tech Section of the store she got the materials to make the scouter and some material to make a net\n What should Karlie do?");
		choice1.setText("Food");
		choice2.setText("Beverages");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void leavebad5(){
		position = "leavebad5";
		mainTextArea.setText("Karlie: I have to get the stuff for my Arm Canon first\n What should Karlie do?");
		choice1.setText("Tech");
		choice2.setText("Food");
		choice3.setText("Beverages");
		choice4.setText("");
	}

	public void leavegood5(){
		position = "leavegood5";
		mainTextArea.setText("Karlie left the store and went home when she entered her house she looked around contimplating on what to do.\n What should Karlie do?");
		choice1.setText("Eat Lunch");
		choice2.setText("Arm Canon");
		choice3.setText("");
		choice4.setText("");
	}

	public void eat3(){
		position = "eat3";
		mainTextArea.setText("Karlie ate some grappes for lucnch it was alright\n What should Karlie do?");
		choice1.setText("Arm Canon");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void armcanon3(){
		position = "armcanon3";
		mainTextArea.setText("Karlie open up her Lab and took off her Watch which activated the Arm Canon.\n What should Karlie do?");
		choice1.setText("Scouter");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void scouter(){
		position = "scouter";
		mainTextArea.setText("Karlie used the materials she got at the store to make a Scouter for the Arm Canon it seems like with this the Arm Canaon is finally Complete\n What should Karlie do?");
		weapon = "Arm Canon";
		weaponLabelName.setText(weapon);
		choice1.setText("Add");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);
	}

	public void add(){
		position = "add";
		mainTextArea.setText("Karlie used the materials that she got from the store to make a net she then added a section of the Arm Canon for the net compartment.\n What should Karlie do?");
		choice1.setText("Leave");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void leavegood6(){
		position = "leavegood6";
		mainTextArea.setText("Karlie left the lab.\n What should Karlie do?");
		choice1.setText("Journal");
		choice2.setText("Eat Snack");
		choice3.setText("");
		choice4.setText("");
	}

	public void eat4(){
		position = "eat4";
		mainTextArea.setText("Karlie got up and eats some chips they were pretty good\n What should Karlie do?");
		choice1.setText("Journal");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void journal2(){
		position = "journal2";
		mainTextArea.setText("Karlie: Today was a good day I finshed the Arm Canon and it looks and functions really well so well in fact I could.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	//Do more for this later add an extra path
	public void journal3(){
		position = "journal3";
		mainTextArea.setText("Karlie: go on the front lines like Adam which can get me Taium maybe I should call Adam and tell him\n What should Karlie do?");
		choice1.setText("Call Adam");
		choice2.setText("Don't Call");
		choice3.setText("");
		choice4.setText("");
	}

	public void call(){
		position = "call";
		mainTextArea.setText("Karlie: Hey Adam whats up I finished my Arm Canon so can I fight on the front lines\n Adam: Karlie you have no field experience so you not fighting on the front lines would be better\n What should Karlie do?");
		choice1.setText("Argue");
		choice2.setText("Give Up");
		choice3.setText("");
		choice4.setText("");
	}

	public void argue(){
		position = "argue";
		mainTextArea.setText("Karlie: Yeah Adam I have not been on the front lines but how can you say I am bad if you don't give me a chance.\n Yeah fine you will have a mission tomorrow do NOT miss my call.\n Karlie: Alright\n What should Karlie do now?");
		choice1.setText("Eat Dinner");
		choice2.setText("Arm Canon");
		choice3.setText("Sleep");
		choice4.setText("");
	}

	public void eat5(){
		position = "eat5";
		mainTextArea.setText("Karlie ate Dinner which was some Cheese Stakes and fries it was really good\n What should Karlie do now?");
		choice1.setText("Arm Canon");
		choice2.setText("Sleep");
		choice3.setText("");
		choice4.setText("");
	}

	public void armcanon4(){
		position = "armcanon4";
		mainTextArea.setText("Karlie opened her Lab and ativated her Arm Canon\n What should Karlie do?");
		choice1.setText("Grappler");
		choice2.setText("Ammo");
		choice3.setText("");
		choice4.setText("");
	}

	public void grappler(){
		position = "grappler";
		mainTextArea.setText("Karlie got some metal wire, and then she made a compartment of the Arm Canon to the metal wire and made a grappleing function.");
		choice1.setText("Ammo");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}

	public void ammo2(){
		position = "ammo2";
		mainTextArea.setText("Karlie made some more traqualizer darts and some stun bullets.\n What should Karlie do?");
		choice1.setText("Eat Dinner");
		choice2.setText("Sleep");
		choice3.setText("");
		choice4.setText("");
	}

	public void sleep2(){
		position = "sleep2";
		mainTextArea.setText("Karlie went to sleep");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void leavegood7(){
		position = "leavegood7";
		mainTextArea.setText("Karlie left the lab.\n What should Karlie do?");
		choice1.setText("Eat Dinner");
		choice2.setText("Sleep");
		choice3.setText("");
		choice4.setText("");
	}

	public void awake3(){
		position = "awake3";
		mainTextArea.setText("Karlie didn't sleep long she woke up at 5am so she wouldn't miss Adam's call\n What should Karlie do?");

		choice1.setText("Eat");
		choice2.setText("Call Adam");
		choice3.setText("Lab");
		choice4.setText("Wait");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

			bw.write(""+playerHP);
			bw.newLine();
			bw.write(""+monsterHP);
			bw.newLine();
			bw.write(weapon);

			bw.close();
		}

		catch(Exception e){



		}

		playerHP = 25;
		healthBar.setValue(playerHP);
		weaponLabelName.setText(weapon);

	}

	public void eat6(){
		position = "eat6";
		mainTextArea.setText("Karlie ate some Waffles and Bacon it was really good\n What should Karlie do?");
		choice1.setText("Call Adam");
		choice2.setText("Lab");
		choice3.setText("Wait");
		choice4.setText("");
	}

	public void call2(){
		position = "call2";
		mainTextArea.setText("Karlie called Adam but there was no response\n What should Karlie do?");
		choice1.setText("Eat");
		choice2.setText("Lab");
		choice3.setText("Wait");
		choice4.setText("");
	}

	public void wait2(){
		position = "wait2";
		mainTextArea.setText("Karlie waited for Adam or someone from the Organization to contact her\n What should Karlie do?");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void lab3(){
		position = "lab3";
		mainTextArea.setText("Karlie went into the Lab what should she do\n What should Karlie do?");
		choice1.setText("Robot");
		choice2.setText("Arm Canon");
		choice3.setText("Secret Project");
		choice4.setText("Leave");
	}

	public void robot2(){
		position = "robot2";
		mainTextArea.setText("Karlie had some materials left over from her last mission so she made a secrutiy Robot to Protect her lab it attacsk anyone that isn't her\n What should Karlie do?");
		choice1.setText("Arm Canon");
		choice2.setText("Secret Project");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void armcanon5(){
		position = "armcanon5";
		mainTextArea.setText("Karlie didn't know what to do with the Arm canon since she added anything maybe she could add a unique feature.\n What should Karlie add?");
		choice1.setText("Trackpad");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void trackpad(){
		position = "trackpad";
		mainTextArea.setText("Karlie got a small screen from her storage in her lab she connected it to the Arm Canon the only thing it can do right now is type simple messages like a phone maybe it can be advanced later.\n What should Karlie do?");
		choice1.setText("Robot");
		choice2.setText("Secret Project");
		choice3.setText("Leave");
		choice4.setText("");
	}

	//Put new path here
	public void secret3(){
		position = "secret3";
		mainTextArea.setText("Karlie: I do have some ideas for Engine but I don't know it may be stupid with him turning into an Engine and going into ships and all so maybe I should change the idea.\n Should Karlie change the idea?");
		choice1.setText("Keep Idea");
		choice2.setText("New Idea");
		choice3.setText("");
		choice4.setText("");
	}

	public void keep(){
		position = "secret3";
		mainTextArea.setText("Karlie: I guess I should keep my idea\n What should karlie do?");
		choice1.setText("Robot");
		choice2.setText("Arm Canon");
		choice3.setText("Leave");
		choice4.setText("");
	}

	public void leavegood8(){
		position = "leavegood8";
		mainTextArea.setText("Karlie left the Lab.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void call4(){
		position = "call4";
		mainTextArea.setText("Karlie got a phone call but it wasn't from Adam it was from an unknown number.\n Hey Karlie your intiation will begin tomorrow today you can get whatever items you want from the store to help you in any way you can.\n What should Karlie do?");
		choice1.setText("Store");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void store3(){
		position = "store3";
		mainTextArea.setText("Karlie goes to the store and gets some Tech equipment that can be used to Control Robots.\n She then goes home but is confused on what to do with the Tech.\n What should Karlie do?");
		choice1.setText("Make Robots");
		choice2.setText("Arm Canon");
		choice3.setText("");
		choice4.setText("");
	}

	public void armcanon6(){
		position = "armcanon6";
		mainTextArea.setText("Karlie using the Trackpad added a feature that allowed her to type coordinates on her Trackpad that made her able to control her Robots to attack or send them to a different location\n What should Karlie do?");
		choice1.setText("Make Robots");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void robot3(){
		position = "robot3";
		mainTextArea.setText("Karlie goes in the lab and tries to make Robots but she is confused on what to make.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void robot4(){
		position = "robot4";
		int slotNumber = 0;
		while(playerItem[slotNumber] != "" && slotNumber <4){
			slotNumber++;
		}

		if(playerItem[slotNumber]==""){
			mainTextArea.setText("Karlie writes down her items on a piece of paper and she can make 4 different robot types with them but can only pick one.\n What should Karlie do?");
			playerItem[slotNumber] = "Orange";
		}

		else if(playerItem[slotNumber]!= ""){
			mainTextArea.setText("Karlie: I can't hold the items paper.");
		}

		choice1.setText("Fire Wood Rob");
		choice2.setText("Fire Metal Rob");
		choice3.setText("Blade Rob");
		choice4.setText("Whip Robot");
	}

	public void firewood(){
		position = "firewood";
		mainTextArea.setText("Karlie goes in the lab and tries to make Robots but she is confused on what to make.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void talkWoman(){
		position = "talkWoman";

		int slotNumber = 0;
		while(playerItem[slotNumber] != "" && slotNumber <4){
			slotNumber++;
		}

		if(playerItem[slotNumber]==""){
			mainTextArea.setText("Woman: You look hungry. Here, take this \n(You recived an Orange");
			playerItem[slotNumber] = "Orange";
		}

		else if(playerItem[slotNumber]!= ""){
			mainTextArea.setText("Woman: It seems you cannot carry anymore");
		}

		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void fight(){
		position = "fight";
		mainTextArea.setText("Monter HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}

	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("None")){
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Arm Canon")){
			playerDamage = new java.util.Random().nextInt(12); 
		}
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void monsterAttack(){
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		
		playerHP = playerHP - monsterDamage;
		//hpLabelNumber.setText(""+playerHP);
		healthBar.setValue(playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
		
		silverRing = 1;
		
		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You got the wrong item and wasted your time!\n\nGAME OVER");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\nTHE END");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void buttonHighlight(){

		switch(buttonPosition){
		case 1:
			window.getRootPane().setDefaultButton(choice1);
			choice1.setForeground(Color.green);
			choice2.setForeground(Color.white);
			choice3.setForeground(Color.white);
			choice4.setForeground(Color.white);
			break;
		
		case 2:
			window.getRootPane().setDefaultButton(choice2);
			choice1.setForeground(Color.white);
			choice2.setForeground(Color.green);
			choice3.setForeground(Color.white);
			choice4.setForeground(Color.white);
			break;
		
		case 3:
			window.getRootPane().setDefaultButton(choice3);
			choice1.setForeground(Color.white);
			choice2.setForeground(Color.white);
			choice3.setForeground(Color.green);
			choice4.setForeground(Color.white);
			break;
		
		case 4:
			window.getRootPane().setDefaultButton(choice4);
			choice1.setForeground(Color.white);
			choice2.setForeground(Color.white);
			choice3.setForeground(Color.white);
			choice4.setForeground(Color.green);
			break;
		}
	}

	public void itemUsed(int slotNumber){

		switch(playerItem[slotNumber]){
		case "Fax":
			mainTextArea.setText("The Fax details a small Romba robot made out of Iron with Saw Blades on top with a Giant Flamethrougher\n");
			break;
		case "Items List":
			mainTextArea.setText("Karlie: I have some a little bit of Iron a lot of Wood materials a Giant wire one Blade a Light Flame Darts Paint Bullets and thats about it\n");
			break;
		case "None2":
			break;
		}
	}




	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();

			switch(yourChoice){
			case "start":
				window.requestFocus();
				createGameScreen("start");
				break;
			case "continue":
				window.requestFocus();
				createGameScreen("continue");
				break;	
			}
		}
	}
	

	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "wake":
				switch(yourChoice){
				case "c1": answer(); break;
				}
				break;
			case "answer":
				switch(yourChoice){
				case "c1": store(); break;
				case "c2": dressed(); break;
				case "c3": bathroom(); break;
				}
				break;
			case "store":
				switch(yourChoice){
				case "c1": dressed(); break;
				case "c2": bathroom(); break;
				}
				break;
			case "bathroom":
				switch(yourChoice){
				case "c1": store(); break;
				case "c2": dressed(); break;
				}
				break;
			case "talkWoman":
				switch(yourChoice){
					case "c1": wake(); break;
				}
			break;
			case "talkLady":
				switch(yourChoice){
					case "c1": wake(); break;
				}
			break;
			case "dressed":
				switch(yourChoice){
				case "c1": storereal(); break;
				}
			break;
			case "storereal":
				switch(yourChoice){
				case "c1": tech(); break;
				case "c2": chips(); break;
				case "c3": beverages(); break;
				case "c4": grappes(); break;
				}
			break;
			case "leavebad":
				switch(yourChoice){
				case "c1": tech(); break;
				case "c2": chips(); break;
				case "c3": beverages(); break;
				case "c4": grappes(); break;
				}
			break;
			case "chips":
				switch(yourChoice){
				case "c1": tech(); break;
				case "c2": beverages(); break;
				case "c3": grappes(); break;
				case "c4": beverages(); break;
				}
			break;
			case "beverages":
				switch(yourChoice){
				case "c1": tech(); break;
				case "c2": chips(); break;
				case "c3": grappes(); break;
				case "c4": leavebad(); break;
				}
			break;
			case "grappes":
				switch(yourChoice){
				case "c1": tech(); break;
				case "c2": chips(); break;
				case "c3": beverages(); break;
				case "c4": leavebad(); break;
				}
			break;
			case "tech":
				switch(yourChoice){
				case "c1": plants(); break;
				case "c2": iron(); break;
				case "c3": blades(); break;
				case "c4": flame(); break;
				}
			break;
			case "lose":
				switch(yourChoice){
				case "c1": tech(); break;
				}
			break;
			case "plants":
				switch(yourChoice){
				case "c1": lose(); break;
				}
			break;
			case "iron":
				switch(yourChoice){
				case "c1": plants(); break;
				case "c2": blades(); break;
				case "c3": flame(); break;
				case "c4": leavebad2(); break;
				}
			break;
			case "blades":
				switch(yourChoice){
				case "c1": plants(); break;
				case "c2": iron(); break;
				case "c3": flame(); break;
				case "c4": leavebad2(); break;
				}
			break;
			case "flame":
				switch(yourChoice){
				case "c1": plants(); break;
				case "c2": iron(); break;
				case "c3": blades(); break;
				case "c4": leavegood(); break;
				}
			break;
			case "leavebad2":
				switch(yourChoice){
				case "c1": plants(); break;
				case "c2": iron(); break;
				case "c3": blades(); break;
				case "c4": flame(); break;
				}
			break;
			case "leavegood":
				switch(yourChoice){
				case "c1": work(); break;
				}
				break;
			case "work":
				switch(yourChoice){
				case "c1": robot(); break;
				case "c2": side(); break;
				}
				break;
			case "robot":
				switch(yourChoice){
				case "c1": more(); break;
				case "c2": ai(); break;
				case "c3": side(); break;
				case "c4": leavebad3(); break;
				}
				break;
			case "more":
				switch(yourChoice){
				case "c1": ai(); break;
				case "c2": side(); break;
				case "c3": leavegood2(); break;
				}
				break;
			case "ai":
				switch(yourChoice){
				case "c1": side(); break;
				case "c2": leavegood2(); break;
				}
				break;
			case "side":
				switch(yourChoice){
				case "c1": barrier(); break;
				case "c2": ammo(); break;
				}
				break;
			case "barrier":
				switch(yourChoice){
				case "c1": ammo(); break;
				case "c2": work(); break;
				}
				break;
			case "ammo":
				switch(yourChoice){
				case "c1": barrier(); break;
				case "c2": work(); break;
				}
				break;
			case "leavebad3":
				switch(yourChoice){
				case "c1": more(); break;
				case "c2": ai(); break;
				case "c3": side(); break;
				}
				break;
			case "leavegood2":
				switch(yourChoice){
				case "c1": answer2(); break;
				}
				break;
			case "answer2":
				switch(yourChoice){
				case "c1": ask(); break;
				case "c2": location(); break;
				}
				break;
			case "ask":
				switch(yourChoice){
				case "c1": location(); break;
				}
				break;
			case "location":
				switch(yourChoice){
				case "c1": location2(); break;
				}
				break;
			case "location2":
				switch(yourChoice){
				case "c1": location3(); break;
				}
				break;
			case "location3":
				switch(yourChoice){
				case "c1": hand(); break;
				case "c2": ask2(); break;
				case "c3": steve(); break;
				}
				break;
			case "hand":
				switch(yourChoice){
				case "c1": ask2(); break;
				case "c2": steve(); break;
				case "c3": leavegood3(); break;
				}
				break;
			case "ask2":
				switch(yourChoice){
				case "c1": hand(); break;
				case "c2": steve(); break;
				case "c3": leavebad4(); break;
				}
				break;
			case "steve":
				switch(yourChoice){
				case "c1": hand(); break;
				case "c2": ask(); break;
				case "c3": leavebad4(); break;
				}
				break;
			case "leavebad4":
				switch(yourChoice){
				case "c1": hand(); break;
				case "c2": ask(); break;
				case "c3": steve(); break;
				}
				break;
			case "leavegood3":
				switch(yourChoice){
				case "c1": back(); break;
				}
				break;
			case "back":
				switch(yourChoice){
				case "c1": lab2(); break;
				case "c2": eat(); break;
				case "c3": journal(); break;
				case "c4": sleep(); break;
				}
				break;
			case "lab2":
				switch(yourChoice){
				case "c1": armcanon(); break;
				case "c2": secret(); break;
				}
				break;
			case "secret":
				switch(yourChoice){
				case "c1": armcanon(); break;
				case "c2": leavegood4(); break;
				}
				break;
			case "armcanon":
				switch(yourChoice){
				case "c1": secret(); break;
				case "c2": leavegood4(); break;
				}
				break;
			case "leavegood4":
				switch(yourChoice){
				case "c1": eat(); break;
				case "c2": journal(); break;
				case "c3": sleep(); break;
				}
				break;
			case "eat":
				switch(yourChoice){
				case "c1": lab2(); break;
				case "c2": journal(); break;
				case "c3": sleep(); break;
				}
				break;
			case "journal":
				switch(yourChoice){
				case "c1": today(); break;
				case "c2": adam(); break;
				case "c3": steve2(); break;
				case "c4": secret2(); break;
				}
				break;
			case "today":
				switch(yourChoice){
				case "c1": today2(); break;
				case "c2": adam(); break;
				case "c3": steve2(); break;
				case "c4": secret2(); break;
				}
				break;
			case "today2":
				switch(yourChoice){
				case "c1": organization(); break;
				case "c2": adam(); break;
				case "c3": steve2(); break;
				case "c4": secret2(); break;
				}
				break;
			case "organization":
				switch(yourChoice){
				case "c1": organization2(); break;
				case "c2": adam(); break;
				case "c3": steve2(); break;
				case "c4": secret2(); break;
				}
				break;
			case "organization2":
				switch(yourChoice){
				case "c1": adam(); break;
				case "c2": steve2(); break;
				case "c3": secret2(); break;
				case "c4": sleep(); break;
				}
				break;
			case "adam":
				switch(yourChoice){
				case "c1": adam2(); break;
				case "c2": today(); break;
				case "c3": steve2(); break;
				case "c4": secret2(); break;
				}
				break;
			case "adam2":
				switch(yourChoice){
				case "c1": today(); break;
				case "c2": steve2(); break;
				case "c3": secret2(); break;
				case "c4": sleep(); break;
				}
				break;
			case "steve2":
				switch(yourChoice){
				case "c1": steve3(); break;
				case "c2": today(); break;
				case "c3": adam(); break;
				case "c4": secret2(); break;
				}
				break;
			case "steve3":
				switch(yourChoice){
				case "c1": today(); break;
				case "c2": adam(); break;
				case "c3": secret2(); break;
				case "c4": sleep(); break;
				}
				break;
			case "secret2":
				switch(yourChoice){
				case "c1": engine(); break;
				}
				break;
			case "engine":
				switch(yourChoice){
				case "c1": engine2(); break;
				case "c2": today(); break;
				case "c3": adam(); break;
				case "c4": steve(); break;
				}
				break;
			case "engine2":
				switch(yourChoice){
				case "c1": today(); break;
				case "c2": adam(); break;
				case "c3": steve(); break;
				case "c4": sleep(); break;
				}
				break;
			case "sleep":
				switch(yourChoice){
				case "c1": awake2(); break;
				}
				break;
			case "awake2":
				switch(yourChoice){
				case "c1": eat2(); break;
				case "c2": armcanon2(); break;
				case "c3": store2(); break;
				case "c4": adam3(); break;
				}
				break;
			case "eat2":
				switch(yourChoice){
				case "c1": armcanon2(); break;
				case "c2": store2(); break;
				case "c3": adam3(); break;
				}
				break;
			case "adam3":
				switch(yourChoice){
				case "c1": armcanon2(); break;
				case "c2": store2(); break;
				case "c3": eat2(); break;
				}
				break;
			case "armcanon2":
				switch(yourChoice){
				case "c1": adam3(); break;
				case "c2": store2(); break;
				case "c3": eat2(); break;
				}
				break;
			case "store2":
				switch(yourChoice){
				case "c1": tech2(); break;
				case "c2": food(); break;
				case "c3": beverages2(); break;
				}
				break;
			case "food":
				switch(yourChoice){
				case "c1": tech2(); break;
				case "c2": beverages2(); break;
				case "c3": leavebad5(); break;
				}
				break;
			case "beverages2":
				switch(yourChoice){
				case "c1": tech2(); break;
				case "c2": food(); break;
				case "c3": leavebad5(); break;
				}
				break;
			case "tech2":
				switch(yourChoice){
				case "c1": food(); break;
				case "c2": beverages2(); break;
				case "c3": leavegood5(); break;
				}
				break;
			case "leavebad5":
				switch(yourChoice){
				case "c1": tech2(); break;
				case "c2": food(); break;
				case "c3": beverages2(); break;
				}
				break;
			case "leavegood5":
				switch(yourChoice){
				case "c1": eat3(); break;
				case "c2": armcanon3(); break;
				}
				break;
			case "eat3":
				switch(yourChoice){
				case "c1": armcanon3(); break;
				}
				break;
			case "armcanon3":
				switch(yourChoice){
				case "c1": scouter(); break;
				}
				break;
			case "scouter":
				switch(yourChoice){
				case "c1": add(); break;
				case "c2": leavegood6();
				}
				break;
			case "add":
				switch(yourChoice){
				case "c1": leavegood6();
				}
				break;
			case "leavegood6":
				switch(yourChoice){
				case "c1": journal2();
				case "c2": eat4();
				}
				break;
			case "eat4":
				switch(yourChoice){
				case "c1": journal2();
				}
				break;
			case "journal2":
				switch(yourChoice){
				case "c1": journal3();
				}
				break;
			case "journal3":
				switch(yourChoice){
				case "c1": call();
				}
				break;
			case "call":
				switch(yourChoice){
				case "c1": argue();
				}
				break;
			case "argue":
				switch(yourChoice){
				case "c1": eat5();
				case "c2": armcanon4();
				case "c3": sleep2();
				}
				break;
			case "eat5":
				switch(yourChoice){
				case "c1": armcanon4();
				case "c2": sleep2();
				}
				break;
			case "armcanon4":
				switch(yourChoice){
				case "c1": grappler();
				case "c2": ammo2();
				}
				break;
			case "grappler":
				switch(yourChoice){
				case "c1": ammo2();
				case "c2": leavegood7();
				}
				break;
			case "ammo2":
				switch(yourChoice){
				case "c1": eat5();
				case "c2": sleep2();
				}
				break;
			case "leavegood7":
				switch(yourChoice){
				case "c1": eat5();
				case "c2": sleep2();
				}
				break;
			case "awake3":
				switch(yourChoice){
				case "c1": eat6();
				case "c2": call2();
				case "c3": lab3();
				case "c4": wait2();
				}
				break;
			case "eat6":
				switch(yourChoice){
				case "c1": call2();
				case "c2": lab3();
				case "c3": wait2();
				}
				break;
			case "call2":
				switch(yourChoice){
				case "c1": eat6();
				case "c2": lab3();
				case "c3": wait2();
				}
				break;
			case "wait2":
				switch(yourChoice){
				case "c1": eat6();
				}
				break;
			case "lab3":
				switch(yourChoice){
				case "c1": robot2();
				case "c2": armcanon5();
				case "c3": secret3();
				case "c4": leavegood8();
				}
				break;
	
			case "robot2":
				switch(yourChoice){
				case "c1": armcanon5();
				case "c2": secret3();
				case "c3": leavegood8();
				}
				break;
			case "armcanon5":
				switch(yourChoice){
				case "c1": trackpad();
				}
				break;
			case "trackpad":
				switch(yourChoice){
				case "c1": robot2();
				case "c2": secret3();
				case "c3": leavegood8();
				}
				break;
			case "secret3":
				switch(yourChoice){
				case "c1": keep();
				}
				break;
			case "keep":
				switch(yourChoice){
				case "c1": robot2();
				case "c2": armcanon5();
				case "c3": leavegood8();
				}
				break;
			case "leavegood8":
				switch(yourChoice){
				case "c1": robot2();
				case "c2": armcanon5();
				case "c3": leavegood8();
				}
				break;
			case "call4":
				switch(yourChoice){
				case "c1": store3();
				}
				break;
			case "store3":
				switch(yourChoice){
				case "c1": robot3();
				}
				break;
			case "robot3":
				switch(yourChoice){
				case "c1": robot4();
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP <1 ){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP <1 ){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": wake();
				}
				break;
				
			}
			
			
		}
	}

	public class InventoryHandler implements ActionListener{

		public void actionPerformed(ActionEvent event){

			String yourChoice = event.getActionCommand();

			switch(yourChoice){
				case "inventoryButton":
				if(inventoryStatus.equals("close")){
					choice1.setVisible(false);
					choice2.setVisible(false);
					choice3.setVisible(false);
					choice4.setVisible(false);
					inventoryPanel.setVisible(true);
					itemButton1.setText(playerItem[0]);
					itemButton2.setText(playerItem[1]);
					itemButton3.setText(playerItem[2]);
					itemButton4.setText(playerItem[3]);
					itemButton5.setText(playerItem[4]);
					inventoryStatus = "open";
				}
				else if(inventoryStatus.equals("open")){
					choice1.setVisible(true);
					choice2.setVisible(true);
					choice3.setVisible(true);
					choice4.setVisible(true);
					inventoryPanel.setVisible(false);
					inventoryStatus = "close";
				}	
				break;
			case "item1":
				itemButton1.setText("");
				itemUsed(0);
				break;
			case "item2":
				itemButton2.setText("");
				itemUsed(1);
				break;
			case "item3":
				itemButton3.setText("");
				itemUsed(2);
				break;
			case "item4":
				itemButton4.setText("");
				itemUsed(3);
				break;
			case "item5":
				itemButton5.setText("");
				itemUsed(4);
				break;
			}
		}
	}

	public class KeyHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e){

			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				switch(buttonPosition){
				case 1: buttonPosition = 1; break;
				case 2: buttonPosition = 1; break;
				case 3: buttonPosition = 2; break;
				case 4: buttonPosition = 3; break;
				}
				break;
			case KeyEvent.VK_DOWN:
				switch(buttonPosition){
				case 1: buttonPosition = 2; break;
				case 2: buttonPosition = 3; break;
				case 3: buttonPosition = 4; break;
				case 4: buttonPosition = 4; break;
				}
				break;
			}
			buttonHighlight();
		}

		@Override
		public void keyReleased(KeyEvent e){
			
		}

		@Override
		public void keyTyped(KeyEvent e){
			
		}

	}

}
