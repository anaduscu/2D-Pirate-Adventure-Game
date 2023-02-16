import java.util.NoSuchElementException;

public class Crocodile extends Animal {
    public Crocodile(){
        super("bottle", false);
    }

    public void harmPlayer(Player player, GameManager gm, ScreenChanger sChanger){
        if (player.getHealth() > 2){
            player.decreaseHealth(2,5);
        } else {
            gm.sChanger.showGameOver("The crocodile bit you when you tried to cross the bridge! Your health went down by 2.");
        }
    }

    public boolean checkInventory(Player player, GameManager gm, UI ui) throws NoSuchElementException {
		boolean found = false;
        for (Item it: player.getInventory()){
                if (it.getName() == this.getWeapon()){
					found = true;
                } 
            }

		if(found){
            this.takeDamage();
			gm.ui.textArea.setText("You defeated the crocodile! The bridge is safe.");
		}
		else{
            gm.ui.textArea.setText("You have no item that could help you defeat the crocodile.");
		}
        return this.getDeath();
    }

}