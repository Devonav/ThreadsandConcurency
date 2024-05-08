/**
 * Objective: Demonstrate the behavior of threads that share data, using synchronized methods.
 * This class represents shared data that will be accessed by multiple threads.
 * Animals will "eat" using this class, which means threads will sleep for a while.
 */

class Food {

    public synchronized void eat(String animalName) throws InterruptedException {
        // Indicate which animal started eating
        System.out.println(animalName + " started eating.");

        // If the hare is eating, it sleeps (eats) longer, giving the tortoise a chance to get ahead.
        if ("hare".equalsIgnoreCase(animalName)) {
            Thread.sleep(5000); // Hare sleeps longer (e.g., 5000ms or 5 seconds)
        } else {
            Thread.sleep(2000); // Tortoise sleeps for a shorter duration (e.g., 2000ms or 2 seconds)
        }

        // Indicate which animal finished eating
        System.out.println(animalName + " finished eating.");
    }
}


