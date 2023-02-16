import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Event {

    private GameManager gm;

    public Event(GameManager gm) {
        this.gm = gm;
    }

    public void lookRope() {
        this.gm.ui.textArea.setText("This is a rope coil. Very versatile."); 
    }

    public void lookMatches() {
        this.gm.ui.textArea.setText("This is a matchbox. Ideal for creating a fire."); 
    }

    public void lookBottle() {
        this.gm.ui.textArea.setText("This is a broken glass bottle. Sharp. Very sharp."); 
    }

    public void lookMountain() {
        this.gm.ui.textArea.setText("You must climb this mountain in order to continue."); 
    }

    public void lookBridge() {
        this.gm.ui.textArea.setText("You must cross this bridge in order to continue."); 
    }

    public void lookQuickSand() {
        this.gm.ui.textArea.setText("You must cross the quicksand in order to continue."); 
    }

    public void lookBanana() {
        this.gm.ui.textArea.setText("These are bananas. Good source of energy."); 
    }

    public void lookCoconut() {
        this.gm.ui.textArea.setText("These are coconuts. Good source of energy."); 
    }

    public void lookRocks() {
        this.gm.ui.textArea.setText("These are some rocks. Can be used for numerous things."); 
    }
    
    public void lookKey() {
        this.gm.ui.textArea.setText("A key! Must be useful in some way.");
    }

    public void lookNecklace() {
        this.gm.ui.textArea.setText("This pearl necklace seems to be...misplaced."); 
    }

    public void lookChest() {
        this.gm.ui.textArea.setText("BLACK BEARD'S FORGOTTEN TREASURE!");
    }

    public void lookCrocodile() {
        this.gm.ui.textArea.setText("The crocodile swam towards you with it's mouth wide open! Be careful!"); 
    }

    public void lookSpider() {
        this.gm.ui.textArea.setText("The spider launched a web at you! Be careful!"); 
    }

    public void lookCave() {
        this.gm.ui.textArea.setText("There is something extremely valuable in this cave."); 
    }


    public void pickUpRope() {
        this.gm.ui.textArea.setText("You picked up a rope coil. You can now find it in your inventory.");
        Item rope = new Item("rope");
        rope.pickUp(gm.player,2);
        this.gm.player.updatePlayerStatus();
    }

    public void pickUpMatches() {
        this.gm.ui.textArea.setText("You picked up a matchbox. You can now find it in your inventory.");
        Item matches = new Item("matches");
        matches.pickUp(gm.player,1);
        this.gm.player.updatePlayerStatus();
    }

    public void pickUpBottle() {
        this.gm.ui.textArea.setText("You picked up a broken glass bottle. You can now find it in your inventory.");
        Item bottle = new Item("bottle");
        bottle.pickUp(gm.player,1);
        this.gm.player.updatePlayerStatus();
    }

    public Food pickUpBanana() {
        this.gm.ui.textArea.setText("You picked up a banana. You can now find it in your inventory.");
        Food banana = new Banana();
        banana.pickUp(gm.player,2);
        this.gm.player.updatePlayerStatus();
        return banana;
    }

    public void pickUpRocks() {
        this.gm.ui.textArea.setText("You picked up a pile of rocks. You can now find it in your inventory.");
        Item rocks = new Item("rocks");
        rocks.pickUp(gm.player,3);
        this.gm.player.updatePlayerStatus();
    }

    public Food pickUpCoconut() {
        this.gm.ui.textArea.setText("You picked up a coconut. You can now find it in your inventory.");
        Food coconut = new Coconut();
        coconut.pickUp(gm.player,2);
        this.gm.player.updatePlayerStatus();
        return coconut;
    }
    public void pickUpKey() {
        this.gm.ui.textArea.setText("You picked up a key. You can now find it in your inventory.");
        Item key = new Item("key");
        key.pickUp(gm.player,3);
        this.gm.player.updatePlayerStatus();
    }

    public void pickUpNecklace() {
        this.gm.ui.textArea.setText("You picked up a necklace. You can now find it in your inventory.");
        Item necklace = new Item("necklace");
        necklace.pickUp(gm.player,10);
        this.gm.player.updatePlayerStatus();
    }

    public void climbMountain() {
        Mountain mountain = new Mountain();
        boolean ropePresent= mountain.checkInventory(gm.player, gm, gm.ui);
        if(ropePresent){
			gm.ui.textArea.setText("You climbed the mountain successfully.");
		}
		else{
			mountain.harmPlayer(gm.player,gm,gm.sChanger);
            gm.player.updatePlayerStatus();
            gm.ui.textArea.setText("You tried to climb the mountain without a rope and fell. Your health went down by 2.");
		}
    }

    public void crossQuickSand() {
        Quicksand quicksand = new Quicksand();
        boolean rocksPresent = quicksand.checkInventory(gm.player, gm, gm.ui);
        if(rocksPresent){
			gm.ui.textArea.setText("You crossed the quicksand successfully.");
		}
		else{
			quicksand.harmPlayer(gm.player,gm,gm.sChanger);
            gm.player.updatePlayerStatus();
            gm.ui.textArea.setText("You walked directly into the quicksand and drowned.");
		}
    }

    public void enterCave(Spider spider) {
        Cave cave = new Cave();
        boolean spiderDead = cave.animalDefeated(gm.player, spider, gm, gm.ui);
        if(spiderDead){
			gm.ui.textArea.setText("You defeated the giant spider and entered the cave successfully.");
		}
		else{
			spider.harmPlayer(gm.player,gm, gm.sChanger);
            gm.player.updatePlayerStatus();
			gm.ui.textArea.setText("The giant spider bit you when you entered the cave! Your health went down by 1.");
		}
    }

    public void crossBridge(Crocodile crocodile) {
        Bridge bridge = new Bridge();  
        boolean crocodileDead = bridge.crossBridge(gm.player, crocodile, gm, gm.ui); 
        if(crocodileDead){
			gm.ui.textArea.setText("You defeated the crocodile and crossed the bridge successfully.");
		}
		else{
			crocodile.harmPlayer(gm.player,gm,gm.sChanger);
            gm.player.updatePlayerStatus();
			gm.ui.textArea.setText("The crocodile bit you when you tried to cross the bridge! Your health went down by 2.");
		}
    }

    public void showLeaderBoard(){
        try{
            gm.player.read_file();
         }
         catch(IOException e) {
            gm.ui.textArea.setText("An error occurred.");
         }
    }

    public void playerHeal(Food food) {
        gm.player.eat(food);
        gm.player.updatePlayerStatus();
    }

    public boolean attackCrocodile(Crocodile crocodile) {
        return crocodile.checkInventory(gm.player, gm, gm.ui);
    }

    public boolean attackSpider(Spider spider) {
        return spider.checkInventory(gm.player, gm, gm.ui);
    }

    public boolean answerRiddle() {
        Ghost ghost = new Ghost();
        ghost.setGuess(gm.ui.textField2.getText());
        return ghost.solveRiddle(ghost.getGuess());
    }

    public boolean openChest() {
        Treasure treasure = new Treasure();
        return treasure.open(gm.player, gm, gm.ui);
    }
}  
