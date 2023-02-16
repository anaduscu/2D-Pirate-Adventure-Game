public class Banana extends Food{

    public Banana(){
        super("banana");
    }
    
    public void heal(Player player, GameManager gm, UI ui){
        if (player.getHealth() < 5) {
            player.increaseHealth(2,2);
            gm.ui.textArea.setText("The banana gave you a lot of energy, your health went up by 2.");
        }
        else if (player.getHealth() == 5) {
            player.increaseHealth(1,2);
            gm.ui.textArea.setText("The banana gave you a lot of energy, your health went up by 1.");
        }
        else {
            gm.ui.textArea.setText("You are at full health.");
		}
        gm.player.updatePlayerStatus();
    }
}
    
