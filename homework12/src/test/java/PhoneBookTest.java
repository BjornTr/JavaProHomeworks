import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import phonebook.PhoneBook;
import phonebook.RecordGenerator;
import phonebook.Records;

import java.util.List;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
        for (int i = 0; i < 10; i++) {
            Records record = RecordGenerator.generateRecord();
            phoneBook.addRecord(record);
        }
    }

    @Test
    public void testAddRecord() {
        Records record = new Records("John", "Doe", "123-456-7890");
        phoneBook.addRecord(record);
        Assertions.assertEquals(11, phoneBook.getAllRecords().size());
        System.out.println("Added record: " + record);
        System.out.println("Test passed!");
    }

    @Test
    public void testRemoveRecord() {
        int initialSize = phoneBook.getAllRecords().size();
        phoneBook.removeRecord(0);
        Assertions.assertEquals(initialSize - 1, phoneBook.getAllRecords().size());
        System.out.println("Removed record at index 0");
        System.out.println("Test passed!");
    }

    @Test
    public void testFindByLastName() {
        Records record = phoneBook.getAllRecords().get(0);
        Records foundRecord = phoneBook.findByLastName(record.getLastName());
        Assertions.assertEquals(record, foundRecord);
        System.out.println("Found record by last name: " + foundRecord);
        System.out.println("Test passed!");
    }

    @Test
    public void testFindByFirstName() {
        Records record = phoneBook.getAllRecords().get(0);
        List<Records> foundRecords = phoneBook.findByFirstName(record.getFirstName());
        Assertions.assertTrue(foundRecords.contains(record));
        System.out.println("Records found by first name: " + foundRecords);
        System.out.println("Test passed!");
    }

    @Test
    public void testFindByPhone() {
        Records record = phoneBook.getAllRecords().get(0);
        Records foundRecord = phoneBook.findByPhone(record.getPhoneNumber());
        Assertions.assertEquals(record, foundRecord);
        System.out.println("Found record by phone number: " + foundRecord);
        System.out.println("Test passed!");
    }

    @Test
    public void testGetRecord() {
        Records record = phoneBook.getAllRecords().get(0);
        Records foundRecord = phoneBook.getRecord(0);
        Assertions.assertEquals(record, foundRecord);
        System.out.println("Found record at index 0: " + foundRecord);
        System.out.println("Test passed!");
    }

    @Test
    public void testGetAllRecords() {
        List<Records> allRecords = phoneBook.getAllRecords();
        Assertions.assertEquals(10, allRecords.size());
        System.out.println("All records:");
        for (Records record : allRecords) {
            System.out.println(record);
        }
        System.out.println("Test passed!");
    }

    @Test
    public void testFindAll() {
        Records record = phoneBook.getAllRecords().get(0);
        List<Records> foundRecords = phoneBook.findAll(record.getFirstName());
        Assertions.assertTrue(foundRecords.contains(record));
        System.out.println("All records by first name: ");
        for (Records record2 : foundRecords) {
            System.out.println(record2);
        }
        System.out.println("Test passed!");
    }
}

