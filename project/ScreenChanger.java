import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class ScreenChanger {
     private GameManager gm;

     public ScreenChanger(GameManager gm){
         this.gm = gm;
     }

     public void showTitleScreen() {
         gm.ui.bgPanel[1].setVisible(true);
         gm.ui.bgPanel[2].setVisible(false);
         gm.ui.bgPanel[3].setVisible(false);
         gm.ui.bgPanel[4].setVisible(false);
         gm.ui.bgPanel[5].setVisible(false);
         gm.ui.bgPanel[6].setVisible(false);
         gm.ui.bgPanel[7].setVisible(false);
         gm.ui.bgPanel[8].setVisible(false);
         gm.ui.bgPanel[9].setVisible(false);
         gm.ui.bgPanel[10].setVisible(false);
         gm.ui.bgPanel[11].setVisible(false);
         gm.ui.bgPanel[12].setVisible(false);
         gm.ui.healPanel.setVisible(false);
         gm.ui.inventoryPanel.setVisible(false);
         gm.ui.lifePanel.setVisible(false);
         gm.ui.textArea.setText("");
         gm.ui.playButton.setVisible(true);
         gm.ui.leaderBoardButton.setVisible(true);
     }

     public void showGetName() {
      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(true);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.inventoryPanel.setVisible(false);
      gm.ui.healPanel.setVisible(false);
      gm.ui.lifePanel.setVisible(false);
      gm.ui.textField1.setVisible(true);
      gm.ui.textField1.setText("Enter your name");
      gm.ui.submitButton1.setVisible(true);
      gm.ui.submitButton1.setText("Submit");
      gm.ui.textArea.setText("");
     }

     public void showIntroScreen() {
      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(true);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(false);
      gm.ui.textArea.setText(" Ahoy Captain " + gm.player.getName() + "! Welcome to the Isle of Lost Souls. You will be leading the hunt for the long lost treasure buried on this island.The over 100 year old chest filled with coins was hidden away by captain Black Beard before he died. The starting point is East Cove, Good luck Captain!");
  }

     public void showEastCove() {
      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(true);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(true);
      gm.ui.textArea.setText("");
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
     }

     public void showThreePeaks() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(true);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(true);
      gm.ui.textArea.setText("");
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
     }

     public void showDeadlySwamp() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(true);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(true);
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
     }

     public void showWestSands() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(true);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(true);
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
     }

     public void showSkullRocks() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(true);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(true);
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
     }

     public void showCave() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(true);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.healPanel.setVisible(true);
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
     }

     public void showRiddle() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(true);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(false);
      gm.ui.textField2.setVisible(true);
      gm.ui.textField2.setText("Enter your guess");
      gm.ui.submitButton2.setVisible(true);
      gm.ui.textArea.setText("This is Captain Black Beard's Ghost. Answer the riddle correctly and his treasure is all yours.");
      gm.ui.inventoryPanel.setVisible(true);
      gm.ui.lifePanel.setVisible(true);
      gm.ui.healPanel.setVisible(false);
     }

     public void showPalmCoast() {

      gm.ui.bgPanel[1].setVisible(false);
      gm.ui.bgPanel[2].setVisible(false);
      gm.ui.bgPanel[3].setVisible(false);
      gm.ui.bgPanel[4].setVisible(false);
      gm.ui.bgPanel[5].setVisible(false);
      gm.ui.bgPanel[6].setVisible(false);
      gm.ui.bgPanel[7].setVisible(false);
      gm.ui.bgPanel[8].setVisible(false);
      gm.ui.bgPanel[9].setVisible(false);
      gm.ui.bgPanel[10].setVisible(false);
      gm.ui.bgPanel[11].setVisible(false);
      gm.ui.bgPanel[12].setVisible(true);
      gm.ui.textArea.setText("Congratulations! You found the treasure.");
      gm.ui.inventoryPanel.setVisible(false);
      gm.ui.lifePanel.setVisible(false);
      gm.ui.healPanel.setVisible(false);
     }

     public void showWinningScreen() {
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(true);
        gm.ui.restartButton.setVisible(true);
        gm.ui.textArea.setText("Well done! You made it to the end of the adventure and found BlackBeard's treasure");
        gm.ui.inventoryPanel.setVisible(false);
        gm.ui.lifePanel.setVisible(false);
        gm.ui.healPanel.setVisible(false);
        try{
            gm.player.write_file();
         }
         catch(IOException e) {
            gm.ui.textArea.setText("An error occurred.");
         }
       }

     public void showGameOver(String message) {
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(true);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.textArea.setText(message);
        gm.ui.restartButton.setVisible(true);
        gm.ui.restartButton.setText("Click here to restart the game.");
        gm.ui.healPanel.setVisible(false);
        try{
            gm.player.write_file();
        }
        catch(IOException e) {
            gm.ui.textArea.setText("An error occurred.");
            System.out.println(e);
        }
     }

     public void exitGameOverScreen() {
        gm.player.removeItems();
        gm.player.setPlayerDefaultStatus();
        this.showTitleScreen();
     }


}