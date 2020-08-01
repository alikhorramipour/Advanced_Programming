public class Triangle extends Polygon {
    public Triangle(Double... args) {
        super(args);
    }

    public boolean isEquilateral(){
        if ((this.sides.get(0) == this.sides.get(1)) && (this.sides.get(1) == this.sides.get(2)))
            return true;
        return false;
    }

    public String toString(){
        return ("Triangle:: side1: " + this.sides.get(0) + ", side2: " + this.sides.get(1) + ", side3: " +
                this.sides.get(2));
    }
}
