import java.util.ArrayList;

public class Polygon extends Shape{
    ArrayList<Double> sides;

    public ArrayList<Double> getSides() {
        return sides;
    }

    public Polygon(Double... args) {
        this.sides = new ArrayList<Double>();
        for(Double arg : args){
            sides.add(arg.doubleValue());
        }
    }

    @Override
    public String toString() {
        return ("Side1: " + sides.get(0) + ", Side2: " + sides.get(1) + ", Side3: " + sides.get(2));
    }
}
