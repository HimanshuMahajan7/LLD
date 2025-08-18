package prototypepattern;

public class Student implements Prototype {

    int age;
    String name;
    private int rollNumber;

    public Student() {
    }

    public Student(int age, int rollNumber, String name) {
        this.age = age;
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new Student(age, rollNumber, name);
    }

    @Override
    public String toString() {
        return "Student[age=" + age + ", rollNumber=" + rollNumber + ", name='" + name + "]";
    }
}
