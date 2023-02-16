public class Food extends Item {
	public Food(String name){
		super(name);
	}

    
	public void heal(Player player, GameManager gm, UI ui){
        if (player.getHealth() < 3 ) {
            player.increaseHealth(0,1);
            gm.player.updatePlayerStatus();
            gm.ui.textArea.setText("The fruit gave you a lot of energy, your health went up.");
        }
        else {
            gm.ui.textArea.setText("You are at full health.");
		}
    }
}