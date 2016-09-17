import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Point implements java.io.Serializable {
    private double x;
    private double y;
}