import java.util.Scanner;

public class Ghost{
    private final String correctAnswer = "silver";
    private String guess;
    public Ghost(){
        this.guess = "";
    }

    public String getGuess(){
        return this.guess;
    }

    public void setGuess(String guess){
        this.guess = guess;
    }

    public void Talk(GameManager gm, UI ui){
        gm.ui.textArea.setText("Ahoy! I am Captain Black Beard. I see you've come looking for my treasure. You must first answer this riddle.");
    }

    public boolean solveRiddle(String guess){
        if(guess.equals(correctAnswer)){
            return true;
        }
        return false;
    }
}