package phonebook;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public final class RecordGenerator {

    private static final String[] LAST_NAMES = {"Doe", "Smith", "Johnson", "Brown", "Garcia", "Miller", "Davis"};
    private static final String[] FIRST_NAMES = {"John", "Jane", "David", "Emily", "Michael", "Maria", "Robert"};
    private static final Random RANDOM = new Random();

    public static Records generateRecord() {
        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
        String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
        String phoneNumber = String.format("%09d", RANDOM.nextInt(1000000000));
        return new Records(lastName, firstName, phoneNumber);
    }
}
