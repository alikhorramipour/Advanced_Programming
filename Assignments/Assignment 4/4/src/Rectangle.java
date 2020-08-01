public class Rectangle {
    public int longitude;
    public int latitude;
    static Point p3 = new Point(1, 1);
    static Point startingPoint = p3;

    public Rectangle(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getlongitude() {
        return longitude;
    }

    public void setlongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public static Point getStartingPoint() {
        return startingPoint;
    }

    public static void setStartingPoint(Point startingPoint) {
        Rectangle.startingPoint = startingPoint;
    }

    public float circumference() {
        return ( 2 * ( this.longitude + this.latitude ) );
    }

    public float area() {
        return ( this.longitude * this.latitude );
    }
}
