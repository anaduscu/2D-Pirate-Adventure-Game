import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
    
    private GameManager gm;
    private Crocodile c;
    private Spider s;
    private Food co;
    private Food b;


    public ActionHandler(GameManager gm) {
        this.gm = gm;
        this.c = new Crocodile();
        this.s = new Spider();
    }

    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch(yourChoice) {
            // LOOK AT OBJECTS
            case "lookRope": gm.event.lookRope(); break;
            case "lookMatches": gm.event.lookMatches(); break;
            case "lookBottle": gm.event.lookBottle(); break;
            case "lookMountain": gm.event.lookMountain(); break;
            case "lookBridge": gm.event.lookBridge(); break;
            case "lookCrocodile": gm.event.lookCrocodile(); break;
            case "lookRocks": gm.event.lookRocks(); break;
            case "lookQuickSand": gm.event.lookQuickSand(); break;
            case "lookSpider": gm.event.lookSpider(); break;
            case "lookKey": gm.event.lookKey(); break;
            case "lookNecklace": gm.event.lookNecklace(); break;
            case "lookChest": gm.event.lookChest(); break;
            case "lookCoconut": gm.event.lookCoconut(); break;
            case "lookBanana": gm.event.lookBanana(); break;
            case "lookCave": gm.event.lookCave(); break;
            // PICKUP ITEMS
            case "pickUpRope": gm.event.pickUpRope(); break;
            case "pickUpMatches": gm.event.pickUpMatches(); break;
            case "pickUpBottle": gm.event.pickUpBottle(); break;
            case "pickUpBanana": this.b = gm.event.pickUpBanana(); break;
            case "pickUpRocks": gm.event.pickUpRocks(); break;
            case "pickUpCoconut": this.co = gm.event.pickUpCoconut(); break;
            case "pickUpKey": gm.event.pickUpKey(); break;
            case "pickUpNecklace": gm.event.pickUpNecklace(); break;
            // SCREEN CHANGES
            case "goGetName": gm.sChanger.showGetName(); break;
            case "goEastCove": gm.sChanger.showEastCove(); break;
            case "goThreePeaks": gm.sChanger.showThreePeaks(); break;
            case "goDeadlySwamp": gm.sChanger.showDeadlySwamp(); break;
            case "goWestSands": gm.sChanger.showWestSands(); break;
            case "goSkullRocks": gm.sChanger.showSkullRocks(); break;
            case "goCave": gm.sChanger.showCave(); break;
            case "goRiddle": gm.sChanger.showRiddle(); break;
            case "goPalmCoast": gm.sChanger.showPalmCoast(); break;
            // OTHER
            case "showLeaderBoard": gm.event.showLeaderBoard(); break;
            case "attackCrocodile": this.c.setDeath(gm.event.attackCrocodile(this.c)); break;
            case "attackSpider": this.s.setDeath(gm.event.attackSpider(this.s)); break;
            case "climbMountain": gm.event.climbMountain(); gm.sChanger.showDeadlySwamp(); break;
            case "crossQuickSand": gm.sChanger.showSkullRocks(); gm.event.crossQuickSand(); break;
            case "crossBridge": gm.event.crossBridge(this.c); gm.sChanger.showWestSands(); break;
            case "enterCave": gm.event.enterCave(this.s); gm.sChanger.showCave(); break;
            case "play": gm.sChanger.showGetName(); break;
            case "eatBanana": gm.event.playerHeal(this.b); break;
            case "eatCoconut": gm.event.playerHeal(this.co); break;
            case "restart": gm.sChanger.exitGameOverScreen(); this.c.setDeath(false); this.s.setDeath(false); break;
            case "submitName": gm.player.setName(gm.ui.textField1.getText()); gm.sChanger.showIntroScreen(); break;
            case "submitRiddleGuess": 
                if (gm.event.answerRiddle()) {gm.sChanger.showPalmCoast();
                } else{gm.sChanger.showGameOver("You answered the riddle incorrectly. Balck Beard will not allow you to take the treasure."); }; break;
            case "open": 
                if (gm.event.openChest()) {gm.sChanger.showWinningScreen();;
                } else {gm.sChanger.showGameOver("Oh no! It seems that you have no key to open the chest. Sorry but your adventure ends here.");}
        }
    }
}