/**
 * This class represents a college.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class College {
    //array of labs
    private Lab[] labs;

    //number of labs
    private int currentLabs;

    //average of college's labs.
    private int avg;

    //college capacity
    private int collegeCapacity;

    //the number of current students
    private int currentSize;

    /**
     * constructor for the class College
     * @param labs = array of the labs
     * @param currentLabs = number of labs in the college
     * @param avg = average of students grades
     * @param collegeCapacity = capacity of the college
     * @param currentSize = the number of students currently registered
     */
    public College(Lab[] labs, int currentLabs, int avg, int collegeCapacity, int currentSize) {
        this.labs = labs;
        this.currentLabs = currentLabs;
        avg = 0;
        this.collegeCapacity = collegeCapacity;
        currentSize = 0;
    }

    /**
     * method for adding a new lab in college
     * @param lab new lab finna register
     */
    public void registerLab(Lab lab){
        if(currentSize < collegeCapacity){
            this.labs[currentSize] = lab;
            currentSize++;
        }
        else{
            System.out.println("College is full!");
        }
    }

    /**
     * method for calculating the average of the college's labs.
     */
    public void calculateAvg() {
        int temp = 0;
        for(int i = 0 ; i < currentSize ; i++){
            temp = temp +  labs[i].getAvg();
        }
        avg = temp / currentSize;
    }

    /**
     * setter for labs
     * @param labs list of labs
     */
    public void setLabs(Lab[] labs) {
        for(int i = 0 ; i <= collegeCapacity; i++){
            this.labs[i] = labs[i];
        }
    }

    /**
     * the method for printing out college's information
     */
    public void print() {
        System.out.println("Number of labs: " + currentLabs);
        System.out.println("Average: " + avg);
        System.out.println("Capacity: " + collegeCapacity);
        System.out.println("Current size: " + currentSize);
    }

    /**
     * method for returning the array of labs
     * @return array of labs
     */
    public Lab[] getLabs() {
        return labs;
    }

    /**
     * getter for current number of labs
     * @return current number of labs
     */
    public int getcurrentLabs() {
        return currentLabs;
    }

    /**
     * getter for avg
     * @return the average of student's grades
     */
    public int getAvg() {
        return avg;
    }

    /**
     * getter for college's capacity
     * @return college's capacity
     */
    public int getCollegeCapacity() {
        return collegeCapacity;
    }

    /**
     * current number of students
     * @return current size
     */
    public int getCurrentSize() {
        return currentSize;
    }
}
