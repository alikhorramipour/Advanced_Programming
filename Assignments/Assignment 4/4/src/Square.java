public class Square {
    public int sideLength;
    Point startingPoint;

    public Square(Point startingPoint, int sideLength) {
        this.startingPoint = startingPoint;
        this.sideLength = sideLength;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public float circumference() {
        return ( 4 * this.sideLength );
    }

    public float area() {
        return ( this.sideLength * this.sideLength );
    }
}
