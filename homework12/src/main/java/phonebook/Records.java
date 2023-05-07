package phonebook;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Records {
    private final  String lastName;
    private final String firstName;
    private final  String phoneNumber;
}
