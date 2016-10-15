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
    static ArrayList<Character> characterList = new ArrayList();
    static ArrayList<Integer> initiativeOrder = new ArrayList();
    
    private void addCharacterList(Character target) {
        characterList.add(target);   
    }
    
    private void addInitiativeOrder() {
        for (int i = 0 ; i < characterList.size() ; i++) {
            initiativeOrder.add(characterList[i].getInitiative());
        }
    }
    
    private void sortInitiativeOrder() {
        for (int i = 1 ; i < initiativeOrder.size() ; i++) {
            for (int j = i ; initiativeOrder[j] > initiativeOrder[(j - 1)] ; j--) {
                Collections.swap(initiativeOrder, j, j-1);
            }
        }
    }
    
    void establishInitiative(Character... target) {
        addCharacterList(target);
        addInitiativeOrder;
        sortInitiativeOrder();
    }
    
    void addTurnOrder(Character target) {
        //When the Initiative ArrayList is sorted greatest to least, this should iterate through it and add the ID Numbers of its elements
        // to the turnOrder ArrayList.
        turnOrder.add(target.getIdNumber());
    }
}
