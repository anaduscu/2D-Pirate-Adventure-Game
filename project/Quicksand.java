public class Quicksand implements Enemy{

    public Quicksand() {}

    public void harmPlayer(Player player, GameManager gm, ScreenChanger sChanger){
        player.setHealth();
        gm.sChanger.showGameOver("You stepped directly into the quicksand and drowned.");
    }

    public boolean checkInventory(Player player, GameManager gm, UI ui) {
		boolean found = false;
        for (Item it: player.getInventory()){
            if (it.getName() == "rocks"){
                found = true;
            } 
            }
        return found;
    }
}