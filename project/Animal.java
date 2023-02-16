public class Animal extends Characters implements Enemy {  //Abstraction and Inheritence
    private String weapon;
    public Animal (String weapon, boolean death){
        super(death);
        this.weapon = weapon;
    }

    public void harmPlayer(Player player, GameManager gm, ScreenChanger sChanger){  //Polymorphism
        System.out.println("The animal bit you! Your health decreased.");
    }
    
    public boolean checkInventory(Player player, GameManager gm, UI ui) {  //Polymorphism
		boolean found = false;
        for (Item it: player.getInventory()){
                if (it.getName() == this.getWeapon()){
					found = true;
            }
        }
		if(found){
            this.takeDamage();
			gm.ui.textArea.setText("You defeated the animal!");
		}
		else{
            gm.ui.textArea.setText("You have no item that could help you with this action.");
		}
        return found;
    }

    public void takeDamage() {
        this.setDeath(true);
    }

    public String getWeapon(){
        return this.weapon;
    }
}
