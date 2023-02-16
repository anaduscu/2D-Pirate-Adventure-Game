public class Item{
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
		return this.name;
    }

    public void pickUp(Player player,int x){
        player.setInventory(this);
        player.increaseScore(x);
    }
}