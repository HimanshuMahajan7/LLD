package builderpattern.src;

public class Director {
    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        }
        if (studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    public Student createEngineeringStudent() {
        return studentBuilder
                .setRollNumber(1)
                .setAge(30)
                .setName("Himanshu")
                .setSubjects()
                .build();
    }

    public Student createMBAStudent() {
        return studentBuilder
                .setRollNumber(2)
                .setAge(30)
                .setName("Mahajan")
                .setSubjects()
                .build();
    }
}
