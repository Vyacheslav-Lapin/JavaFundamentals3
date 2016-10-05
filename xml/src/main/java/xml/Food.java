package xml;

import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@ToString(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "price", "description", "calories" })
public class Food {

    @XmlAttribute(required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String price;

    @XmlElement(required = true)
    private String description;

    @XmlElement(required = true)
    private int calories;
}
