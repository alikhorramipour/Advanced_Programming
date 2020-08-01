import java.util.ArrayList;

public class Triangle extends Paint {
    private ArrayList<Double> sides  = new ArrayList();

    public Triangle(double side1, double side2, double side3) {
        this.sides.add(side1);
        this.sides.add(side2);
        this.sides.add(side3);
    }

    public ArrayList getSides() {
        return sides;
    }

    public boolean isEquilateral(){
        if ((this.sides.get(0) == this.sides.get(1)) && (this.sides.get(1) == this.sides.get(2)))
            return true;
        return false;
    }

    public double calculatePerimeter(){
        return ((this.sides.get(0)) + (this.sides.get(1)) + (this.sides.get(2)));
    }

    public double calculateArea(){
        double per = this.calculatePerimeter()/2;
        return Math.sqrt(per * (per - this.sides.get(0)) * (per - this.sides.get(1)) * (per - this.sides.get(2)));
    }

    public void draw(){
        System.out.println("Triangle");
        System.out.println("The Perimeter = " + this.calculatePerimeter());
        System.out.println("The Area = " + this.calculateArea());
        System.out.println();
    }

    public boolean equals(Triangle triangle){
        if( (this.sides.get(0) == triangle.sides.get(0)) && (this.sides.get(1) == triangle.sides.get(1))
                && (this.sides.get(2) == triangle.sides.get(2)) )
            return true;
        return false;
    }

    public String toString(){
        return ("Triangle and the side lengths of it are: " + this.sides.get(0) + ", " + this.sides.get(1) + ", " +
                this.sides.get(2));
    }
}
