import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
@AllArgsConstructor
public class Contact {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
}