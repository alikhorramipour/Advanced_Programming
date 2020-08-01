import java.util.ArrayList;

public class Rectangle extends Paint {
    private ArrayList<Double> sides  = new ArrayList();

    public Rectangle(double side1, double side2, double side3, double side4) {
        this.sides.add(side1);
        this.sides.add(side2);
        this.sides.add(side3);
        this.sides.add(side4);
    }

    public ArrayList<Double> getSides() {
        return sides;
    }

    public boolean isSquare(){
        if ((this.sides.get(0) == this.sides.get(1)) && (this.sides.get(1) == this.sides.get(2))
        && (this.sides.get(2) == this.sides.get(3)))
            return true;
        return false;
    }

    public double calculatePerimeter(){
        return ((this.sides.get(0)) + (this.sides.get(1)) + (this.sides.get(2)) + (this.sides.get(3)));
    }

    public double calculateArea(){
        return (this.sides.get(0)) * (this.sides.get(1));
    }

    public void draw(){
        System.out.println("Rectangle");
        System.out.println("The Perimeter = " + this.calculatePerimeter());
        System.out.println("The Area = " + this.calculateArea());
        System.out.println();
    }

    public boolean equals(Rectangle rectangle){
        if( (this.sides.get(0) == rectangle.sides.get(0)) && (this.sides.get(1) == rectangle.sides.get(1))
                && (this.sides.get(2) == rectangle.sides.get(2)) && (this.sides.get(3) == rectangle.sides.get(3)) )
            return true;
        return false;
    }

    public String toString(){
        return ("Rectangle and the side lengths of it are: " + this.sides.get(0) + ", " + this.sides.get(1) + ", " +
                this.sides.get(2) + ", " + this.sides.get(3));
    }
}
