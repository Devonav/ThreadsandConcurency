import java.util.Random;

/**
 * Objective: Implement the behavior of the animals racing and possibly eating during the race.
 * This class defines animals that will race and possibly eat during the race.
 */

public class Animal implements Runnable {

    // Instance variables
    private String name;           // Name of the animal
    private int position;          // Current position in the race
    private int distanceTraveled;  // Distance the animal travels in one move
    private int restMax;           // Maximum time the animal can rest for
    private Food food;             // Shared food source for animals
    private static boolean winner = false; // Static variable to check if there's already a race winner

    // Constructor
    public Animal(String name, int distanceTraveled, int restMax, Food food) {
        this.name = name;
        this.distanceTraveled = distanceTraveled;
        this.restMax = restMax;
        this.food = food;
        this.position = 0;
    }

    /**
     * The run method represents the life of the thread (animal's participation in the race).
     * As long as there's no winner, the animal will rest, eat, and move forward.
     */
    @Override
    public void run() {
        try {
            while (!winner) {
                rest();
                eat();
                moveForward();
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }

    /**
     * The animal rests for a random time not exceeding restMax.
     */
    private void rest() throws InterruptedException {
        System.out.println(name + " is resting."); // Notify user that the animal is resting
        Random random = new Random();
        Thread.sleep(random.nextInt(restMax));  // Resting duration is random
    }

    /**
     * The animal eats from the shared food source.
     */
    private void eat() throws InterruptedException {
        food.eat(name);
    }

    /**
     * Move the animal forward by its specified distanceTraveled value.
     * Check if this move makes the animal the winner.
     */
    private synchronized void moveForward() {
        if (winner) return;  // If race already has a winner, don't proceed

        position += distanceTraveled;
        System.out.println(name + " has reached position " + position);

        // Check if current position is 120 or beyond, which means the animal wins the race
        if (position >= 120) {
            winner = true;
            System.out.println(name + " wins the race!");
        }
    }
}


