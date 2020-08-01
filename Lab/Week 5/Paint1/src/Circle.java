public class Circle extends Paint{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public double calculatePerimeter(){
        return 2 * Math.PI * this.radius;
    }

    public double calculateArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    public void draw(){
        System.out.println("Circle");
        System.out.println("The Perimeter = " + this.calculatePerimeter());
        System.out.println("The Area = " + this.calculateArea());
        System.out.println();

    }

    public boolean equals(Circle circle){
        if(this.radius == circle.radius)
            return true;
        return false;
    }

    public String toString(){
        return ("Circle and the radius of it is: " + this.radius);
    }
}
