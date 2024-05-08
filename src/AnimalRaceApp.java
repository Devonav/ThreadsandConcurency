/**
 * Author: [Devon Villalona]
 * Course: [COP3330.CRN12565]
 * Date: [9/23/2023]
 * Objective: Initialize and start the race between Hare and Tortoise.
 * Output: Race progress and winner announcement will be printed on the screen.
 */

public class AnimalRaceApp {

    public static void main(String[] args) {
        // Shared food instance for both animals. Only one animal can eat at a time.
        Food sharedFood = new Food();

        // Initialize the hare with specific characteristics. Hare moves 15 units at a time and rests for 3 seconds.
        Animal hare = new Animal("Hare", 15, 3000, sharedFood);

        // Initialize the tortoise with specific characteristics. Tortoise moves 10 units at a time and rests for 2 seconds.
        Animal tortoise = new Animal("Tortoise", 10, 2000, sharedFood);

        // Create threads for both animals.
        Thread hareThread = new Thread(hare);
        Thread tortoiseThread = new Thread(tortoise);

        // Start the race by starting both threads.
        hareThread.start();
        tortoiseThread.start();
    }
}