/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preliminary.turn.based.combat;

import java.util.ArrayList;

/**
 *
 * @author Jitty
 */
public class TurnOrder {
    static int turnCounter = 0;
    static int turnCounterDisplay = 1;
    public static ArrayList<Integer> turnOrder = new ArrayList();
    
    void addTurnOrder(Character target) {
        turnOrder.add(target.getIdNumber());
    }
}
