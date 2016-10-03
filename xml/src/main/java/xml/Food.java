package xml;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@ToString(exclude = "id")
@Builder
public class Food {
    private int id;
    private String name;
    private String price;
    private String description;
    private int calories;
}
