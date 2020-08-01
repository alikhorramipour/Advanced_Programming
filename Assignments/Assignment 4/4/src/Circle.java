public class Circle {
    public int radius;
    Point center;

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double circumference() {
        return ( 2 * Math.PI * this.radius );
    }

    public double area() {
        return ( Math.PI * this.radius * this.radius );
    }
}
