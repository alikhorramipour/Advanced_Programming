import java.util.ArrayList;
import java.util.Iterator;

public class Paint {
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Triangle> triangles = new ArrayList<>();
    private ArrayList<Circle> circles = new ArrayList<>();

    private Iterator it;

    public void addRectangle(Rectangle rectangle){
        this.rectangles.add(rectangle);
    }

    public void addTriangle(Triangle triangle){
        this.triangles.add(triangle);
    }

    public void addCircle(Circle circle){
        this.circles.add(circle);
    }

    public void drawAll(){
        it = rectangles.iterator();
        while(it.hasNext()){
            Rectangle recTmp = (Rectangle)it.next();
            recTmp.draw();
        }

        it = triangles.iterator();
        while(it.hasNext()){
            Triangle triTmp = (Triangle)it.next();
            triTmp.draw();
        }

        it = circles.iterator();
        while(it.hasNext()){
            Circle cirTmp = (Circle)it.next();
            cirTmp.draw();
        }
    }

    public void printAll(){
        it = rectangles.iterator();
        while(it.hasNext()){
            Rectangle recTmp = (Rectangle)it.next();
            System.out.println(recTmp.toString());
        }

        it = triangles.iterator();
        while(it.hasNext()){
            Triangle triTmp = (Triangle)it.next();
            System.out.println(triTmp.toString());
        }

        it = circles.iterator();
        while(it.hasNext()){
            Circle cirTmp = (Circle)it.next();
            System.out.println(cirTmp.toString());
        }
    }
}
