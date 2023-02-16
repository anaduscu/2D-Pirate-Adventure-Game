import java.util.NoSuchElementException;

public class Spider extends Animal{
    public Spider(){
        super("matches", false);
    }

    public void harmPlayer(Player player, GameManager gm, ScreenChanger sChanger){
        if (player.getHealth() > 1){
            player.decreaseHealth(1,2);
        } 
        else{
            gm.sChanger.showGameOver("The giant spider bit you when you entered the cave! Your health went down by 1.");
        }
    }

    public boolean checkInventory(Player player, GameManager gm, UI ui) {
		boolean found = false;
        for (Item it: player.getInventory()){
            if (it.getName() == this.getWeapon()){
                found = true;
            } 
        }
		if(found){
            this.takeDamage();
			gm.ui.textArea.setText("You defeated the spider! The cave is safe.");
		}
		else{
            gm.ui.textArea.setText("You have no item that could help you defeat the spider.");
		}
        return this.getDeath();
    }
}