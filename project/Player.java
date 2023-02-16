import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Player extends Characters{  //inheritance

    GameManager gm;

	private String name;
    private int score;
    private int playerMaxHealth;
    private int playerHealth;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    
    public Player(GameManager gm) {
		super(false);
        this.gm = gm;
    }

    public void setPlayerDefaultStatus() {

		this.name = "";
        this.playerMaxHealth = 6;
        this.playerHealth = 6;

		updatePlayerStatus();
    }

    public void updatePlayerStatus() {

        //REMOVE ALL LIFE ICONS
        int i = 1;
        while(i<7) {
            gm.ui.lifeLabel[i].setVisible(false);
            i++;
        }

        int lifeCount = playerHealth;
        while(lifeCount!=0) {
            gm.ui.lifeLabel[lifeCount].setVisible(true);
            lifeCount--;
        }

        // CHECK PLAYER ITEMS
		gm.ui.ropeLabel.setVisible(false);
		gm.ui.matchsticksLabel.setVisible(false);
		gm.ui.bottleLabel.setVisible(false);
		gm.ui.bananaLabel.setVisible(false);
		gm.ui.rocksLabel.setVisible(false);
		gm.ui.coconutLabel.setVisible(false);
		gm.ui.keyLabel.setVisible(false);
		gm.ui.necklaceLabel.setVisible(false);
		for(int j=0; j<this.inventory.size(); j++){
			if(this.inventory.get(j).getName().equals("rope")) {gm.ui.ropeLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("matches")) {gm.ui.matchsticksLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("bottle")) {gm.ui.bottleLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("banana")) {gm.ui.bananaLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("rocks")) {gm.ui.rocksLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("coconut")) {gm.ui.coconutLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("key")) {gm.ui.keyLabel.setVisible(true);}
			if(this.inventory.get(j).getName().equals("necklace")) {gm.ui.necklaceLabel.setVisible(true);}
		}
    }

	public void setName(String name) {
		this.name = name;
    }

	public String getName() {
		return this.name;
    }

	public void setHealth() {
        this.playerHealth = 0;
        this.setDeath(true);
    }

	public void decreaseHealth(int health, int x) {
        this.playerHealth -= health;
        this.decreaseScore(x);
    }

	public void increaseHealth(int health, int x) {
        this.playerHealth += health;
        this.increaseScore(x);
    }

	public void setInventory(Item item) {
        this.inventory.add(item);
    }

	public int getHealth() {
        return this.playerHealth;
    }

	public ArrayList<Item> getInventory() {
        return this.inventory;
    }

	public void removeItems() {
		this.inventory.clear();
	}

	public void eat(Food food){
        boolean found = false;
        Item toRemove = null;
        for (Item f: this.inventory){
            if (f.getName().equals(food.getName())) {
                found = true;
                toRemove = f;
                food.heal(this, gm, gm.ui);
            }
        }
        this.inventory.remove(toRemove);
        if(!found){
            gm.ui.textArea.setText("You do not have this food item in your inventory.");
        }
	}

    public void increaseScore(int x) {
        this.score += x;
    }

    public void decreaseScore(int x) {
        this.score -= x;
    }

    public int getScore() {
        return this.score;
    }


    public void write_file() throws IOException {       
        PrintWriter myWriter = new PrintWriter(new FileWriter("data.txt"));
        myWriter.println(this.getName() + ", " + this.getScore()+ "\n");
        myWriter.close();
    }

    public void read_file() throws IOException {
        BufferedReader load = new BufferedReader(new FileReader("data.txt"));
        String lastSaved = load.readLine();
        load.close();
        gm.ui.textArea.setText("This is the current leaderboad: \n" + lastSaved);
    }
}


