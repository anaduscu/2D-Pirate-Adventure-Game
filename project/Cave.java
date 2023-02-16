import java.util.NoSuchElementException;

public class Cave{

    public Cave(){};
    public boolean animalDefeated(Player player, Spider spider, GameManager gm, UI ui) throws NoSuchElementException {
        boolean defeated = false;
            if (spider.getDeath() == true){
                defeated = true;
            } 
        return defeated;
    }
}

