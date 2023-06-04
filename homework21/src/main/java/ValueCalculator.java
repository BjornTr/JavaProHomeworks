import lombok.Data;

import java.util.Arrays;

@Data
public class ValueCalculator {
    private float[] vals;
    private final Object lock = new Object();

    public ValueCalculator(int size) {
        vals = new float[size];
    }

    public int getHalfArraySize() {
        return vals.length / 2;
    }

    public void processArray() {
        long start = System.currentTimeMillis();
        float value = 1;
        Arrays.fill(vals, value);

        float[] array1 = new float[getHalfArraySize()];
        float[] array2 = new float[getHalfArraySize()];

        System.arraycopy(vals, 0, array1, 0, array1.length);
        System.arraycopy(vals, array1.length, array2, 0, array2.length);

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = array1[i] * (float) (Math.sin(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < array1.length; i++) {
                    array2[i] = array2[i] * (float) (Math.sin(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array1, 0, vals, 0, array1.length);
        System.arraycopy(array2, 0, vals, array2.length, array2.length);

        long end = System.currentTimeMillis();
        long executionTime = end - start;

        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    public static void main(String[] args) {
        ValueCalculator calculator = new ValueCalculator(1_000_000);
        calculator.processArray();
    }
}