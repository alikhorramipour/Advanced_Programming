import java.util.ArrayList;

public class Rectangle extends Polygon {
    public Rectangle(Double... args) {
        super(args);
    }

    public double calculatePerimeter(){
        return ((this.sides.get(0)) + (this.sides.get(1)) + (this.sides.get(2)) + (this.sides.get(3)));
    }

    public double calculateArea(){
        return (this.sides.get(0)) * (this.sides.get(1));
    }

    public String toString(){
        return ("Rectangle:: side1: " + this.sides.get(0) + ", side2: " + this.sides.get(1) + ", side3: " +
                this.sides.get(2) + ", side4: " + this.sides.get(3));
    }

    public boolean isSquare(){
        if ((this.sides.get(0) == this.sides.get(1)) && (this.sides.get(1) == this.sides.get(2))
                && (this.sides.get(2) == this.sides.get(3)))
            return true;
        return false;
    }


}
