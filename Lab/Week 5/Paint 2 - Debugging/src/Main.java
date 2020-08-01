public class Main {
    public static void main (String... args){
        //Circle circle1 = new Shape(19);
        Circle circle1 = new Circle(19);
        Shape circle2 = new Circle(3);
        //Rectangle rect1 = new Triangle(1,4,1);
        Rectangle rect1 = new Rectangle(1.0,4.0,1.0,4.0);
        Polygon rect2 = new Rectangle(8.0,5.0,8.0,5.0);
        //Rectangle rec3 = new Shape(6,6,6,6);
        Rectangle rect3 = new Rectangle(6.0,6.0,6.0,6.0);
        Polygon tri1 = new Triangle(2.0,2.0,2.0);
        Triangle tri2 = new Triangle(4.0,4.0,6.0);
        Shape tri3 = new Triangle(2.0,2.0,2.0);
        circle1 = (Circle)circle2;
        rect2 = rect3;
        tri1 = (Polygon) tri3;
        //cricle2 = tri3;
        tri3 = tri2;
        //rect3 = new Shape(2,3,2);
        rect3 = new Rectangle(2.0,3.0,2.0,3.0);
        System.out.println(rect3.toString());
    }
}
