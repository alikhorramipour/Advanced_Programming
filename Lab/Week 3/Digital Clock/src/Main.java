import java.io.IOException;
import java.lang.Thread;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ClockDisplay clock = new ClockDisplay(12, 24, 53);
        for(int i=0; i < 10000; i++){
            clock.timeTick();
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(clock.getTime());
            sleep(1000);
        }
    }
}
