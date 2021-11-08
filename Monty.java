import java.util.ArrayList;
import java.util.Random;

 /* I'm new to software development, and I have always been interested in the Monty Hall problem. 
  * This is my attempt at testing it in Java 
  * 
  * As a quick overview, the flow of the problem goes as follows. A contestant enters a game-show.
  * During the show, the player is presented with three closed doors. Behind two doors are
  * goats, behind the 3rd is a car.
  * 
  * The player is urged to choose a door. Once he has done so, the host, who knows what lies behind
  * all doors opens one of the doors (not the contestants choice) revealing a goat. At this 
  * point the contestent is left with his choice and the remaining door, one has a goat, the other a car. 
  * 
  * The crux of the problem is whether the contestant, now knowing which door contains the first 
  * goat, should change their guess.
  * 
  * Answer: They should since the original guess had a one in three chance of being correct, 
  * however the new guess would have one in two.
  * 
  *  */

public class Monty {
	public static void main(String[] args) {
	
	/* Initialize two variables to hold wins and losses - did the contestant win the car? */
		
	int won = 0;
	int lost = 0;
	
	/* A for loop so that we can run the experiment many times and compare the outcomes over x iterations */
	
	for(int i = 0; i < 2000; i++) {
	
	/* Create the three doors */
		
	String door1 = null;
	String door2 = null;
	String door3 = null; 
	
	
	/* Use Java's Random function to choose which door to put the car behind. Random accepts an upperbound number (exclusive) which I set to 3 since there are 3 doors  */
	
	Random r = new Random();
	int winningDoor = r.nextInt(3);


    /* An ArrayList to house the result of inserting the car and goats behind the doors */
	ArrayList<String> array = new ArrayList();
	
   /* If statements based on the outcome of winningDoor, the door corresponding to random int 'winningDoor' receives the value of Car, the remainder are assigned the String 'goat' */
	
 if(winningDoor==1){
	 door1 = "car";
	 door2 = "goat";
	 door3 = "goat";
	 	 
	}
 
 if(winningDoor==2) {
	 door2 = "car";
	 door1 = "goat";
	 door3 = "goat";
	 }

 if(winningDoor==3) {
	 door3 ="car";
	 door1 = "goat";
	 door2 = "goat";
	 }
 
  array.add(door1);
  array.add(door2);
  array.add(door3);
  

  int contestantFirstChoice = r.nextInt(3); // The initial contestant choice
  int doorCheck = r.nextInt(3); // The door the host opens revealing a goat
	
	
	/* The following is used to open the door containing the goat. The door cannot contain the car, and it cannot be the door the contestant picked */
	while(doorCheck == (contestantFirstChoice) || array.get(doorCheck) == "car") {
		  doorCheck = r.nextInt(3);		
	}
	
	int newChoice =  r.nextInt(3); // The contestants new choice now that a door has been opened
	
	/* The contestants new choice cannot be the door that was opened by the host, it it cannot be their current choice. Using a random number followed by a while loop is inefficient here. 
	 * I should just get the correct choice be removing the two invalid ones. I struggled to do this with ArrayList since removing the corresponding index changes the index of the 
	 * remaining items making the second one harder to find and remove */
	
	while(newChoice == doorCheck || newChoice == contestantFirstChoice){
		newChoice =  r.nextInt(3);
	}
	
	/* Win if new choice is car */
	
	if(array.get(newChoice) == "car") {
		won = won + 1;
	}
	
	/* Lose if original choice is car */
	
	if(array.get(contestantFirstChoice) == "car") {
		lost = lost + 1;
	}
	
	/* print out results */
	
	System.out.println("Iterations: " + i + " New choice won: " + won + " First choice won: " + lost);
	

  }
 }
}
