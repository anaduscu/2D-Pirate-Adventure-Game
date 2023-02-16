import java.util.NoSuchElementException;

public class Mountain implements Enemy{

    public Mountain() {}

    public void harmPlayer(Player player, GameManager gm, ScreenChanger sChanger){
        if (player.getHealth() > 2){
            player.decreaseHealth(2,5);
        } else {
            gm.sChanger.showGameOver("You tried to climb the mountain without a rope and fell. Your health went down by 2.");
        }
    }

    public boolean checkInventory(Player player, GameManager gm, UI ui) throws NoSuchElementException {
		boolean found = false;
        for (Item it: player.getInventory()){
            if (it.getName() == "rope"){
                found = true;
            } 
        }
        return found;
    }
}