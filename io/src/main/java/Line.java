import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.io.Serializable;

@SuppressWarnings("WeakerAccess")
@Log
public class Line implements Serializable {
    private Point point1;
    private Point point2;

    @Getter
    @Setter
    private int index;

    Line(Point p1, Point p2, int index) {
        log.info("Constructing line: " + index);
        this.point1 = p1;
        this.point2 = p2;
        this.index = index;
    }

    public void printInfo() {
        System.out.println("Line: " + index);
        System.out.println(" Object reference: " + super.toString());
        System.out.println(" from point " + point1);
        System.out.println(" to point " + point2);
    }
}