package prototypepattern;

public class Main {
    public static void main(String[] args) {
        Student obj = new Student(30, 10001, "Raam");
        Student cloneObj = (Student) obj.clone();
        System.out.println(obj);
        System.out.println(cloneObj);
    }
}
