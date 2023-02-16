import java.io.IOException;

public class GameManager{

    ActionHandler ah = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);
    public ScreenChanger sChanger = new ScreenChanger(this);
    public Event event = new Event(this);
    public static void main(String [] args) throws Exception{
        new GameManager();
    }
    public GameManager() {

        player.setPlayerDefaultStatus();
        sChanger.showTitleScreen();
    }
}



