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
    //turnCounter and turnCounterDisplay should probably be private and be replaced in the other parts of the code with the get methods.
    static int turnCounter = 0;
    static int turnCounterDisplay = 1;
    public static ArrayList<Integer> turnOrder = new ArrayList();
    static ArrayList<Character> characterList = new ArrayList();
    static ArrayList<Integer> initiativeOrder = new ArrayList();
    
    int getTurnCounter() {
        return turnCounter;
    }
    
    int getTurnCounterDisplay() {
        return turnCounterDisplay;
    }
    
    private void addCharacterList(Character target) {
        characterList.add(target);   
    }
    
    private void addInitiativeOrder() {
        for (int i = 0 ; i < characterList.size() ; i++) {
            initiativeOrder.add((characterList.get(i)).getInitiative());
            // If characterList.get(i).getInitiative() doesn't work, use this:
            //  target = characterList.get(i);
            //  initiativeOrder.add(target.getInitiative());
        }
    }
    
    private void sortInitiativeOrder() {
        for (int i = 1 ; i < initiativeOrder.size() ; i++) {
            for (int j = i ; initiativeOrder.get(j) > initiativeOrder.get(j-1) ; j--) {
                Collections.swap(initiativeOrder, j, j-1);
                Collections.swap(characterList, j, j-1);
            }
        }
    }
    // I need some way of testing for identical initiative values so that there's not a slight bias toward the first Character added to the list.
    
    private void addTurnOrder() {
        //When the Initiative ArrayList is sorted greatest to least, this should iterate through it and add the ID Numbers of its elements
        // to the turnOrder ArrayList.
        //turnOrder.add(target.getIdNumber());
        for (int i = 0 ; i < characterList.size() ; i++) {
            turnOrder.add((characterList.get(i)).getIdNumber());
        }
    }
    
    void establishInitiative(Character... target) {
        addCharacterList(target);
        addInitiativeOrder;
        sortInitiativeOrder();
        addTurnOrder();
    }
    
    void displayTurnOrder() {
        System.out.println("The current turn order is: ");
        for (i = 0 ; i < characterList.size() ; i++) {
            if ((i+1) == characterList.size) {
                System.out.println((characterList.get(i)).getName() + ".");
            }
            else {
                System.out.println((characterList.get(i)).getName() + ", ");
            }
        }
    }
    
    void displayTurnNumber() {
        System.out.println("It is currently turn " + getTurnCounterDisplay() + ".");
    }
}
