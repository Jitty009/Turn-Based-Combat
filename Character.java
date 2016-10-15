/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preliminary.turn.based.combat;
import preliminary.turn.based.combat.TurnOrder;
import java.util.ArrayList;

/**
 *
 * @author Jitty
 */
public class Character {
            private int health;
            private String name;
            private int idNumber;
            private static int numberOfCharacters = 0;
            
            Character() {
                health = 100;
                name = "Default";
                idNumber = ++numberOfCharacters;
            }        
            Character(int maxHP) {
                health = maxHP;
                name = "Default";
                idNumber = ++numberOfCharacters;
            }
            Character(String charName) {
                health = 100;
                name = charName;
                idNumber = ++numberOfCharacters;
                        }
            Character(String charName, int maxHP) {
                health = maxHP;
                name = charName;
                idNumber = ++numberOfCharacters;
            }
        
            private boolean alive = true;
            private int defense = 0;
            
            int getIdNumber() {
                return idNumber;
            }
            int getHealth() {
                return health;
            }            
            String getName() {
                return name;
            }           
            int getDefense() {
                return defense;
            }
            int getTurnCounter() {
                return TurnOrder.turnCounter;
            }
            boolean checkStatusAlive() {
                int charStatus = health;
                if (charStatus <= 0) {
                    return false;
                }
                else {
                    return true;
                }
            }
            void setStatusAlive() {
                if (health <= 0) {
                    alive = false;
                }
                else {
                    alive = true;
                }
            }
            void printStatus() {
                boolean charStatus = checkStatusAlive();
                if (charStatus == false) {
                    System.out.println(name + " is dead! The match is over!");
                }
                else {
                    System.out.println(name + " is still alive with " + health
                     + " health.");
                }
            }
            
            void minusHealthAffliction(int damage) {
                health -= damage;
            }            
            void minusHealthNormal(int damage) {
                health -= (damage - defense);
            }
            void addHealth(int heal) {
                health += heal;
            }
            void endTurn() {
                if (TurnOrder.turnCounter < (TurnOrder.turnOrder.size() - 1)) {
                    TurnOrder.turnCounter++;
                    TurnOrder.turnCounterDisplay++;
                }
                else {
                    TurnOrder.turnCounter = 0;
                    TurnOrder.turnCounterDisplay++;
                }
            }
            boolean checkCharTurn() {
                if (idNumber == TurnOrder.turnOrder.get(TurnOrder.turnCounter)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            
            void attack(Character target, int atkValue) {
                if (checkCharTurn() == true && checkStatusAlive() == true) {
                    System.out.println(name + " attacks " + target.getName() + "!");
                    target.minusHealthNormal(atkValue);
                    System.out.println((atkValue - target.getDefense()) + " damage dealt.");
                    target.setStatusAlive();
                    target.printStatus();
                    endTurn();
                }
                else {
                    System.out.println("You cannot perform that action right now.");
                }
                
                }            
            void defend() {
                if (checkCharTurn() == true && checkStatusAlive() == true) {
                    System.out.println(name + " is defending!");
                    defense += 10;
                    System.out.println("Defense has increased to " + defense + ".");
                    endTurn();
                }
                else {
                    System.out.println("You cannot perform that action right now.");
                }
                }               
            void heal(Character target, int healValue) {
                if (checkCharTurn() == true && checkStatusAlive() == true) {
                    System.out.println(name + " heals for " + healValue + ".");
                    target.addHealth(healValue);
                    target.setStatusAlive();
                    target.printStatus();
                    endTurn();
                }
                else {
                    System.out.println("You cannot perform that action right now.");
                }
                
                }
            
    }
