public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculatePerimeter(){
        return 2 * Math.PI * this.radius;
    }

    public double calculateArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    public String toString(){
        return ("Circle:: radius = " + this.radius);
    }
}
