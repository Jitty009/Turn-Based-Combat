/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preliminary.turn.based.combat;
import java.util.ArrayList;
/*interface characterInterface {
    void attack(Character target, int atkValue);
    void defend(int defValue);
    void heal(Character target, int healValue); 
    boolean checkStatusAlive();
}*/
/**
 *
 * @author Jitty
 */
public class PreliminaryTurnBasedCombat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here   
    Character Player1 = new Character("Hoolio", 150);
    Character Player2 = new Character("Jackson");
    TurnOrder TurnOrder = new TurnOrder();
    
    TurnOrder.addTurnOrder(Player1);
    TurnOrder.addTurnOrder(Player2);
    
    Player1.attack(Player2, 25);
    Player1.heal(Player1, 50);
    Player2.attack(Player1, 40);
    Player2.attack(Player1, 40);
    Player1.heal(Player1, 20);
    Player1.heal(Player1, 20);
    Player2.heal(Player2, 30);
    Player1.defend();
    Player2.attack(Player1, 50);
    Player1.defend();
    Player2.attack(Player1, 50);
    Player1.attack(Player2, 105);
    Player2.attack(Player1, 50000);
    }
    
}
