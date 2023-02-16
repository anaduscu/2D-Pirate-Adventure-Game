import java.util.NoSuchElementException;

public class Bridge{

    public Bridge(){};
    public boolean crossBridge(Player player, Crocodile crocodile, GameManager gm, UI ui) {
        boolean defeated = false;
            if (crocodile.getDeath() == true){
                defeated = true;
            } 
		return defeated;
        }
}

