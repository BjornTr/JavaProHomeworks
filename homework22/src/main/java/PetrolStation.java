import lombok.Data;

import java.util.concurrent.Semaphore;

@Data
public class PetrolStation {
    private int amount;
    private final Semaphore semaphore;

    public PetrolStation(int initialAmount) {
        amount = initialAmount;
        semaphore = new Semaphore(3);
    }

    public void doRefuel(int requestedAmount) {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " started refueling...");
            Thread.sleep((long) (Math.random() * 8000) + 3000);
            synchronized (this) {
                if (requestedAmount <= amount) {
                    amount -= requestedAmount;
                    System.out.println(Thread.currentThread().getName() + " refueled successfully.");
                } else {
                    System.out.println(Thread.currentThread().getName() + " cannot refuel. Insufficient fuel.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}