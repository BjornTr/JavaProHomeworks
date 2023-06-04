public class PetrolStationUsage {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(500);

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            final int requestedAmount = (int) (Math.random() * 200) + 50;
            threads[i] = new Thread(() -> petrolStation.doRefuel(requestedAmount));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All refueling operations completed.");
    }
}