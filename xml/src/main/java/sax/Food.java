package sax;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "")
public class Food {

    public Food(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private String price;
    private String description;
    private int calories;
}
