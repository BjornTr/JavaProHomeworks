package phonebook;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PhoneBook {
    private List<Records> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    public void addRecord(Records record) {
        records.add(record);
    }

    public void removeRecord(int index) {
        records.remove(index);
    }

    public Records findByLastName(String lastName) {
        for (Records record : records) {
            if (record.getLastName().equals(lastName)) {
                return record;
            }
        }
        return null;
    }

    public List<Records> findByFirstName(String firstName) {
        List<Records> firstNameResults = new ArrayList<>();
        for (Records record : records) {
            if (record.getFirstName().equals(firstName)) {
                firstNameResults.add(record);
            }
        }
        return firstNameResults.isEmpty() ? null : firstNameResults;
    }

    public Records findByPhone(String phoneNumber) {
        for (Records record : records) {
            if (record.getPhoneNumber().equals(phoneNumber)) {
                return record;
            }
        }
        return null;
    }

    public Records getRecord(int index) {
        return records.get(index);
    }

    public List<Records> getAllRecords() {
        return new ArrayList<>(records);
    }

    public List<Records> findAll(String firstName) {
        List<Records> matchingRecords = new ArrayList<>();
        for (Records record : records) {
            if (record.getFirstName().equals(firstName)) {
                matchingRecords.add(record);
            }
        }
        if (matchingRecords.isEmpty()) {
            return null;
        } else {
            return matchingRecords;
        }
    }
}
