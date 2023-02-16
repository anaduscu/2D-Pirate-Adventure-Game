import java.util.NoSuchElementException;
import java.util.Scanner;

public class Treasure{

    public Treasure(){};

    public boolean open(Player player, GameManager gm, UI ui) throws NoSuchElementException {
		boolean found = false;
        for (Item it: player.getInventory()){
            try{
                if (it.getName().equals("key")){
					found = true;
                } 
            }
            catch(NoSuchElementException e) {
                gm.ui.textArea.setText("You don't have the key to open the chest! \nGame over");
                //add frame change
            }
        }
		if(!found){
			gm.ui.textArea.setText("You have no key to open the chest! Game over");
        }
		else{
            gm.ui.textArea.setText("Congratulations! You won the game, the treasure is all yours.");
			//add frame change
		}
        return found;
    }
}