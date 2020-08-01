/**
 * This class represents a lab.
 * @author Ali
 * @version 1.0
 */
public class Lab {
    //array of students
    private Student[] students;

    //average
    private int avg;

    //day
    private String day;

    //capacity
    private int capacity;

    //number of students in class
    private int currentSize;

    /**
     * constructor for a new lab
     * @param cap = capacity
     * @param d = day
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
        avg = 0;
        currentSize = 0;
        students = new Student[capacity];
    }

    /**
     *
     * @param std = a new student
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        }
        else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * this method prints out a lab's information
     */
    public void print() {
        System.out.println("Average is: " + avg);
        System.out.println("Current size is: " + currentSize);
        System.out.println("Day is:" + day);
    }

    /**
     *
     * @return this method returns the array of students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     *
     * @param stdents: students to be enrolled
     */
    public void setStudents(Student[] stdents) {
        for(int i=0; i<capacity; i++) {
            students[i] = stdents[i];
        }
    }

    /**
     *
     * @return average of students
     */
    public int getAvg() {
        return avg;
    }

    /**
     * this method calculates the average of the students
     */
    public void calculateAvg() {
        int sum=0;
        for(int i=0; i<currentSize; i++){
            sum += students[i].getGrade();
        }
        avg = sum/currentSize;
    }

    /**
     *
     * @return the of the lab
     */
    public String getDay() {
        return day;
    }

    /**
     * sets the day
     * @param day: the entry for day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the capacity of the lab
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @param capacity: the capacity for the lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}