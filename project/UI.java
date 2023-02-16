
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;



public class UI {
     private GameManager gm;
     private JFrame window;
     public JTextArea textArea;
     public JPanel bgPanel[] = new JPanel[13];
     public JLabel bgLabel[] = new JLabel[13];

     //PLAYER UI
     JPanel lifePanel;
     JLabel lifeLabel[] = new JLabel[7];
     JPanel healPanel;
     JPanel inventoryPanel;
     public JLabel ropeLabel, matchsticksLabel, bottleLabel, rocksLabel, 
                    bananaLabel, coconutLabel, keyLabel, necklaceLabel;

     // GAME OVER UI
     public JLabel titleLabel;
     public JButton restartButton;

     // OTHER UI
     public JTextField textField1;
     public JTextField textField2;
     public JButton submitButton1;
     public JButton submitButton2;
     public JButton playButton;
     public JLabel gameName;
     public JButton healButton1;
     public JButton healButton2;
     public JButton leaderBoardButton;


     public UI(GameManager gm) {
         this.gm = gm;
         createMainField();
         createPlayerField();
         generateScreen();
         this.window.setVisible(true);
     }

     public void createMainField() {
         this.window = new JFrame();
         this.window.setSize(1500,900);
         this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.window.getContentPane().setBackground(Color.black);
         this.window.setLayout(null);

         this.textArea = new JTextArea();
         this.textArea.setBounds(170,700,1000,80);
         this.textArea.setBackground(Color.black);
         this.textArea.setForeground(Color.white);
         this.textArea.setEditable(false);
         this.textArea.setLineWrap(true);
         this.textArea.setWrapStyleWord(true);
         this.textArea.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
         this.window.add(textArea);
     }

     public void createBackground(int bgNum, String bgFileName){
        this.bgPanel[bgNum] = new JPanel();
        this.bgPanel[bgNum].setBounds(150,50,1137,640);
        this.bgPanel[bgNum].setLayout(null);
        this.window.add(bgPanel[bgNum]);

        this.bgLabel[bgNum] = new JLabel();
        this.bgLabel[bgNum].setBounds(0,0,1137,640);

        ImageIcon bgIcon = new ImageIcon(new ImageIcon(bgFileName).getImage().getScaledInstance(1137, 640, Image.SCALE_SMOOTH));
        this.bgLabel[bgNum].setIcon(bgIcon);
     }

    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName, String choice1Name, String choice2Name, String choice1Command, String choice2Command) {

        //CREATE POP MENU
        JPopupMenu popMenu = new JPopupMenu();
        //CREATE POP MENU ITEMS
        JMenuItem menuItem[] = new JMenuItem[3];
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.ah);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);
                   
        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.ah);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);

        //CREATE OBJECTS
        JLabel objectJLabel = new JLabel();
        objectJLabel.setBounds(objx,objy,objWidth,objHeight);

        ImageIcon objIcon = new ImageIcon(new ImageIcon(objFileName).getImage().getScaledInstance(objWidth, objHeight, Image.SCALE_SMOOTH));
        objectJLabel.setIcon(objIcon);

        objectJLabel.addMouseListener(new MouseListener() {
            
            public void mouseClicked(MouseEvent e){}
            public void mousePressed(MouseEvent e){

                if(SwingUtilities.isLeftMouseButton(e)) {
                    popMenu.show(objectJLabel, e.getX(), e.getY());
                }

            }
            public void mouseReleased(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
        });

        this.bgPanel[bgNum].add(objectJLabel);
    }

    public void createArrowButton(int bgNum, int arrX, int arrY, String arrowFileName, String arrowCommand) {
        JButton arrowButton = new JButton();
        ImageIcon arrowIcon = new ImageIcon(new ImageIcon(arrowFileName).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        arrowButton = new JButton();
        arrowButton.setBounds(arrX, arrY,50,50);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.ah);
        arrowButton.setActionCommand(arrowCommand);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);
    }

    public void createPlayerField() {
        lifePanel = new JPanel();
        lifePanel.setBounds(150,0,230,50);
        lifePanel.setBackground(Color.black);
        lifePanel.setLayout(new GridLayout(1,6));
        this.window.add(lifePanel);

        ImageIcon lifeIcon = new ImageIcon(new ImageIcon("heart.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        for(int i=1; i<7; i++ ){
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
        }

        healPanel = new JPanel();
        healPanel.setBounds(600,0,200,50);
        healPanel.setBackground(Color.black);
        healPanel.setLayout(new GridLayout(1,2));
        this.window.add(healPanel);

        healButton1= new JButton();
        healButton1.setBounds(0,0,40,30);
        healButton1.setBackground(null);
        healButton1.setForeground(Color.white);
        healButton1.setContentAreaFilled(false);
        healButton1.setFocusPainted(false);
        healButton1.setBorder(new LineBorder(Color.green));
        healButton1.setText("EAT BANANA");
        healButton1.setFocusPainted(false);
        healButton1.addActionListener(gm.ah);
        healButton1.setActionCommand("eatBanana");
        healPanel.add(healButton1);

        healButton2= new JButton();
        healButton2.setBounds(50,0,40,30);
        healButton2.setBackground(null);
        healButton2.setForeground(Color.white);
        healButton2.setContentAreaFilled(false);
        healButton2.setFocusPainted(false);
        healButton2.setBorder(new LineBorder(Color.green));
        healButton2.setText("EAT COCONUT");
        healButton2.setFocusPainted(false);
        healButton2.addActionListener(gm.ah);
        healButton2.setActionCommand("eatBanana");
        healPanel.add(healButton2);

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(980,0,300,50);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(1,8));
        this.window.add(inventoryPanel);

        // CREATE ITEMS
        ropeLabel = new JLabel();
        ImageIcon ropeIcon = new ImageIcon(new ImageIcon("rope-coil.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ropeLabel.setIcon(ropeIcon);
        inventoryPanel.add(ropeLabel);

        matchsticksLabel = new JLabel();
        ImageIcon matchsticksIcon = new ImageIcon(new ImageIcon("matchbox.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        matchsticksLabel.setIcon(matchsticksIcon);
        inventoryPanel.add(matchsticksLabel);

        bottleLabel = new JLabel();
        ImageIcon bottleIcon = new ImageIcon(new ImageIcon("broken-bottle.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        bottleLabel.setIcon(bottleIcon);
        inventoryPanel.add(bottleLabel);

        rocksLabel = new JLabel();
        ImageIcon rocksIcon = new ImageIcon(new ImageIcon("stone-pile.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        rocksLabel.setIcon(rocksIcon);
        inventoryPanel.add(rocksLabel);

        bananaLabel = new JLabel();
        ImageIcon bananaIcon = new ImageIcon(new ImageIcon("banana.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        bananaLabel.setIcon(bananaIcon);
        inventoryPanel.add(bananaLabel);

        coconutLabel = new JLabel();
        ImageIcon coconutIcon = new ImageIcon(new ImageIcon("coconuts.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        coconutLabel.setIcon(coconutIcon);
        inventoryPanel.add(coconutLabel);

        keyLabel = new JLabel();
        ImageIcon keyIcon = new ImageIcon(new ImageIcon("key.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        keyLabel.setIcon(keyIcon);
        inventoryPanel.add(keyLabel);

        necklaceLabel = new JLabel();
        ImageIcon necklaceIcon = new ImageIcon(new ImageIcon("pearl-necklace.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        necklaceLabel.setIcon(necklaceIcon);
        inventoryPanel.add(necklaceLabel);

    }

    public void createPlayButton(int bgNum) {
        ImageIcon playIcon = new ImageIcon(new ImageIcon("play icon.png").getImage().getScaledInstance(250, 105, Image.SCALE_SMOOTH));
        playButton = new JButton();
        playButton.setBounds(250,500,250,105);
        playButton.setBackground(null);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        playButton.setIcon(playIcon);
        playButton.addActionListener(gm.ah);
        playButton.setActionCommand("play");
        playButton.setBorderPainted(false);

        bgPanel[bgNum].add(playButton);
    }

    public void createGameNameLabel() {
        gameName = new JLabel();
        gameName.setBounds(200,150,400,200);
        gameName.setIcon(new ImageIcon(new ImageIcon("name.png").getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH)));
        gameName.setVisible(false);
        this.window.add(gameName);
    }

    public void createSubmitButton1(int bgNum) {
        submitButton1 = new JButton();
        submitButton1.setBounds(620,360,40,40);
        submitButton1.setBackground(null);
        submitButton1.setContentAreaFilled(false);
        submitButton1.setFocusPainted(false);
        submitButton1.setIcon(new ImageIcon(new ImageIcon("enter icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        submitButton1.addActionListener(gm.ah);
        submitButton1.setActionCommand("submitName");
        submitButton1.setBorderPainted(false);

        this.bgPanel[bgNum].add(submitButton1);
    }

    public void createSubmitButton2(int bgNum) {
        submitButton2 = new JButton();
        submitButton2.setBounds(945,450,40,40);
        submitButton2.setBackground(null);
        submitButton2.setContentAreaFilled(false);
        submitButton2.setFocusPainted(false);
        submitButton2.setIcon(new ImageIcon(new ImageIcon("enter icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        submitButton2.addActionListener(gm.ah);
        submitButton2.setActionCommand("submitRiddleGuess");
        submitButton2.setBorderPainted(false);

        this.bgPanel[bgNum].add(submitButton2);
    }

    public void createTextField1(int bgNum) {
        textField1 = new JTextField();
        textField1.setBounds(420,360,200,40);
        textField1.setForeground(Color.black);
        textField1.setBackground(Color.white);
        textField1.setFont(new Font("Times New Roman", Font.PLAIN,20));
        textField1.setVisible(false);
        this.bgPanel[bgNum].add(textField1);
    }

    public void createTextField2(int bgNum) {
        textField2 = new JTextField();
        textField2.setBounds(750,450,200,40);
        textField2.setForeground(Color.black);
        textField2.setBackground(Color.white);
        textField2.setFont(new Font("Times New Roman", Font.PLAIN,20));
        textField2.setVisible(false);
        this.bgPanel[bgNum].add(textField2);
    }

    public void createLeaderboard(int bgNum){
        leaderBoardButton= new JButton();
        leaderBoardButton.setBounds(100,900,70,50);
        leaderBoardButton.setBackground(Color.black);
        leaderBoardButton.setForeground(Color.white);
        leaderBoardButton.setContentAreaFilled(false);
        leaderBoardButton.setFocusPainted(false);
        leaderBoardButton.setBorder(new LineBorder(Color.red));
        leaderBoardButton.setText("VIEW LEADERBOARD");
        leaderBoardButton.setFocusPainted(false);
        leaderBoardButton.addActionListener(gm.ah);
        leaderBoardButton.setActionCommand("showLeaderBoard");
        this.bgPanel[bgNum].add(leaderBoardButton);
    }

    public void createGameOverButton(int bgNum, int x, int y) {
        restartButton = new JButton();
        restartButton.setBounds(x,y,100,50);
        restartButton.setBorder(null);
        restartButton.setBackground(Color.green);
        restartButton.setForeground(Color.green);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.ah);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        this.window.add(restartButton);

        this.bgLabel[bgNum].add(restartButton);
    }

    public void generateScreen() {

        // SCREEN 1 "TITLE SCREEN"
        createBackground(1,"titlescreen.png");
        createPlayButton(1);
        createLeaderboard(1);
        this.bgPanel[1].add(bgLabel[1]);

        //SCREEN 2 "GET NAME"
        createBackground(2,"enter name.jpg");
        createTextField1(2);
        createSubmitButton1(2);
        this.bgPanel[2].add(bgLabel[2]);

        // SCREEN 3 "INTRO SCREEN"
        createBackground(3,"intro.png");
        createArrowButton(3,1080, 350,"right arrow.png","goEastCove");
        this.bgPanel[3].add(bgLabel[3]);

        //SCREEN 4 "EAST COVE"
        createBackground(4,"east cove.jpg");
        createObject(4,640,400,130,95,"rope object.png","Look","Pick Up","lookRope","pickUpRope");
        createObject(4,710,570,60,60,"matches object.png","Look","Pick Up","lookMatches","pickUpMatches");
        createObject(4,880,520,120,90,"bottle object.png","Look","Pick Up","lookBottle","pickUpBottle");
        createArrowButton(4,1080, 350,"right arrow.png","goThreePeaks");
        this.bgPanel[4].add(bgLabel[4]);

        //SCREEN 5 "THREE PEAKS"
        createBackground(5,"3 peaks.png");
        createObject(5,145,180,120,95,"banana object.png","Look","Pick Up","lookBanana","pickUpBanana");
        createObject(5,600,250,200,150,"blank.png","Look","Climb","lookMountain","climbMountain");
        createArrowButton(5,10, 350,"left arrow.png","goEastCove");
        this.bgPanel[5].add(bgLabel[5]);

        // SCREEN 6 "DEADLY SWAMP"
        createBackground(6,"deadly swamp.png");
        createObject(6,480,300,200,150,"crocodile object.png","Look","Attack","lookCrocodile","attackCrocodile");
        createObject(6,0,500,1250,140,"bridge object.png","Look","Cross","lookBridge","crossBridge");
        createObject(6,70,275,150,100,"rocks object.png","Look","Pick Up","lookRocks","pickUpRocks");
        createArrowButton(6,10, 350,"left arrow.png","goThreePeaks");
        this.bgPanel[6].add(bgLabel[6]);

        // SCREEN 7 "WEST SANDS"
        createBackground(7,"west sands.png");
        createObject(7,170,100,170,95,"coconut object.png","Look","Pick Up","lookCoconut","pickUpCoconut");
        createObject(7,220,450,1000,300,"blank.png","Look","Cross","lookQuickSand","crossQuickSand");
        createArrowButton(7,10, 350,"left arrow.png","goDeadlySwamp");
        this.bgPanel[7].add(bgLabel[7]);

        // SCREEN 8 "SKULL ROCKS"
        createBackground(8,"skull rocks.png");
        createObject(8,600,30,300,200,"spider object.png","Look","Attack","lookSpider","attackSpider");
        createObject(8,400,300,300,300,"blank.png","Look","Enter","lookCave","enterCave");
        createArrowButton(8,10, 350,"left arrow.png","goWestSands");
        this.bgPanel[8].add(bgLabel[8]);

        // SCREEN 9 "CAVE"
        createBackground(9,"cave.png");
        createObject(9,200,435,50,50,"key object.png","Look","Pick Up","lookKey","pickUpKey");
        createArrowButton(9,10, 350,"left arrow.png","goSkullRocks");
        createArrowButton(9,1080, 350,"right arrow.png","goRiddle");
        this.bgPanel[9].add(bgLabel[9]);


        // SCREEN 10 "RIDDLE"
        createBackground(10,"riddle.png");
        createTextField2(10);
        createSubmitButton2(10);
        createArrowButton(10,10, 350,"left arrow.png","goCave");
        this.bgPanel[10].add(bgLabel[10]);

        // SCREEN 11 "GAME OVER"
        createBackground(11,"finish screen.png");
        createGameOverButton(11,400,100);
        this.bgPanel[11].add(bgLabel[11]);

        // SCREEN 12 "PALM COAST"
        createBackground(12,"palm coast.png");
        createObject(12, 400, 540, 60, 50, "necklace object.png", "Look", "Pick Up", "lookNecklace", "pickUpNecklace");
        createObject(12,400,300,300,300,"chest object.png","Look","Open","lookChest","open");
        createGameOverButton(12,300,100);
        this.bgPanel[12].add(bgLabel[12]);
    }
}