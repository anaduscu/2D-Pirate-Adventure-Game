public class Coconut extends Food{
    public Coconut(){
        super("coconut");
    }

    public void heal(Player player, GameManager gm, UI ui){
        if (player.getHealth() < 6 ) {
            player.increaseHealth(1,2);
            gm.player.updatePlayerStatus();
            gm.ui.textArea.setText("The coconut gave you a lot of energy, your health went up by 1.");
        }
        else {
            gm.ui.textArea.setText("You are at full health.");
		}
    }
}