/**
 * This class represents a college.
 * @author Ali
 * @version 1.0
 */
public class College {
    //array of labs
    private Lab[] labs;

    //number of labs
    private int currentNumber;

    /**
     * @param num is the number of laboratories
     */
    public College(int num) {
        labs = new Lab[num];
    }
}
