public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Circle c1 = new Circle(2, p1);
        p1.setX(3);
        p1.setY(4);
        //System.out.println(c1.center.getX());
        //System.out.println(c1.center.getY());
        System.out.println();

        Point p2 = new Point(0, 0);
        Square s1 = new Square(p2, 4);
        //System.out.println(s1.startingPoint.getX());
        //System.out.println(s1.startingPoint.getY());
        s1.setStartingPoint(p1);
        //System.out.println(s1.startingPoint.getX());
        //System.out.println(s1.startingPoint.getY());

        Rectangle r1 = new Rectangle(5, 3);
        Rectangle r2 = new Rectangle(7, 6);
        //r2.set

        // Calculating all circumferences and areas

        // circle c1
        //System.out.print("Circle circumference: ");
        System.out.println(c1.circumference());
        //System.out.print("Circle area: ");
        System.out.println(c1.area());
        System.out.println();

        // square s1
        //System.out.print("Square circumference: ");
        System.out.println(s1.circumference());
        //System.out.print("Square area: ");
        System.out.println(s1.area());
        System.out.println();

        // rectangle r1
        //System.out.print("Rectangle r1 circumference: ");
        System.out.println(r1.circumference());
        //System.out.print("Rectangle r1 area: ");
        System.out.println(r1.area());
        // rectangle r2
        //System.out.print("Rectangle r2 circumference: ");
        System.out.println(r2.circumference());
        //System.out.print("Rectangle r2 area: ");
        System.out.println(r2.area());

    }
}
