package by.bsu.lab4.entity;


import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.bsu.lab4.constants.NumMarks.NUM_MARKS;

/**
 * Class to describe Abiturients
 * @author Alexandr Goncharov
 * @version 1.0
 */
public class Abiturient {
    //private static final Logger logger = LogManager.getRootLogger();//корневой регистратор
    private static final Logger log = LogManager.getLogger(Abiturient.class.getName());
    //private static final Logger x = LogManager.getLogger("file");
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String phone;
    private int[] marks;

    /**
     * Abiturient constructor
     * @param id
     * @param firstName
     * @param middleName
     * @param lastName
     * @param phone
     * @param address
     * @param marks
     */
    public Abiturient(int id, String firstName, String middleName, String lastName,String phone, String address,int[] marks) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone=phone;
        this.address = address;
        this.marks= Arrays.copyOf(marks,NUM_MARKS);
        log.info("Created Abiturient object "+this.id+" "+this.firstName+" "+this.middleName+" "+this.lastName+" "+this.address+" "+Arrays.toString(marks));
    }

    /**
     * Constructor without arguments
     */
    public Abiturient()
    {
        this.id=0;
        this.firstName=null;
        this.middleName=null;
        this.lastName=null;
        this.phone=null;
        this.address=null;
        this.marks=null;
    }

    /**
     * Copy constructor
     * @param given Abiturient to copy from
     */
    public Abiturient(Abiturient given)
    {
        this.id=given.getId();
        this.firstName=given.getFirstName();
        this.middleName=given.getMiddleName();
        this.lastName=given.getLastName();
        this.phone=given.getPhone();
        this.address=given.getAddress();
        this.marks=Arrays.copyOf(given.getMarks(),NUM_MARKS);
    }

    /**
     * Get id
     * @return id
     */
    public int getId() {

        return id;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(int id) {
        if(id<1)throw new IllegalArgumentException("id must be positive");
        this.id = id;
    }

    /**
     * get phone
     * @return return phone
     */
    public String getPhone()
    {
        return this.phone;
    }

    /**
     * set phone
     * @param phone
     */
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    /**
     * get first name
     * @return first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * set first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if(firstName.matches(".*\\d+.*"))
            throw new IllegalArgumentException("Name can't contain digits");
        this.firstName = firstName;
    }

    /**
     * get middle name
     * @return middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * set middle name
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        if(middleName.matches(".*\\d+.*"))
            throw new IllegalArgumentException("Name can't contain digits");
        this.middleName = middleName;
    }

    /**
     * get last name
     * @return last name
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * set last name
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        if(lastName.matches(".*\\d+.*"))
            throw new IllegalArgumentException("Name can't contain digits");

        this.lastName=lastName;
    }

    /**
     * get Address
     * @return address
     */
    public String getAddress()
    {

        return address;
    }

    /**
     * set address
     * @param address
     */
    public void setAddress(String address)
    {

        this.address=address;
    }

    /**
     * get all marks
     * @return array of marks
     */
    public int[] getMarks()
    {

        return marks;
    }

    /**
     * set all marks
     * @param marks array of marks
     */
    public void setMarks(int[] marks)
    {

        for(int i=0;i<NUM_MARKS;i++)
        {
            if (marks[i] < 1 || marks[i] > 10) {
                throw new IllegalArgumentException("Mark should be between 1 and 10");
        }
        }
        this.marks= Arrays.copyOf(marks,5);
    }

    /**
     * get mark of given index
     * @param i index
     * @return mark
     */
    public int getMark(int i)
    {
        return marks[i];
    }

    /**
     * set mark on given index
     * @param i index
     * @param mark mark to set
     */
    public void setMark(int i,int mark)
    {
        if(i<0||i>(NUM_MARKS-1))
        {
            throw new IllegalArgumentException("Index should be in range of number of marks");
        }
        if (mark < 1 || mark > 10) {
            throw new IllegalArgumentException("Mark should be between 1 and 10");
        }
        marks[i]=mark;
    }

    /**
     * Override toString() for Abiturient
     * @return string after toString()
     */
    @Override
    public String toString()
    {
        String marks=Arrays.toString(this.marks);
        String result ="id: "+this.id+ " name: "+this.firstName+" middle name: "+this.middleName+" last name: "+this.lastName+" phone: "+this.phone+" address: "+this.address+" marks: "+marks;
        return result;
    }
    /**
     * Override equals for Abiturients
     * @param obj given object
     * @return true if equal false if not equal
     */
  @Override
    public boolean equals(Object obj)
    {
        if(obj==this )return true;
        if(obj==null||obj.getClass()!=this.getClass())
        {
            return false;
        }
        Abiturient second=(Abiturient)obj;
        if (Arrays.compare(this.marks,second.marks)==0&&this.id==second.id&&this.firstName.equals(second.firstName)
                &&this.middleName.equals(second.middleName)&&this.lastName.equals(second.lastName)
                &&this.phone.equals(second.phone)&&this.address.equals(second.address))return true;
        else return false;
    }

    /**
     * Overrided equals, so have to override hashCode() too
     * @return hashCode
     */
    @Override
    public int hashCode()
    {
        final int prime=31;
        int result=1;
        result=prime*result+((firstName==null)?0:firstName.hashCode());
        result=prime*result+id;
        result=prime*result+((phone==null)?0:phone.hashCode());
        result=prime*result+((lastName==null)?0:lastName.hashCode());
        result=prime*result+((middleName==null)?0:middleName.hashCode());
        result=prime*result+((address==null)?0:address.hashCode());
        result=prime*result+((marks==null)?0:marks.hashCode());
        return result;
    }
}
