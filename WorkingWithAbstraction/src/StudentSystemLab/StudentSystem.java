package StudentSystemLab;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> university;

    public StudentSystem() {
        this.university = new HashMap<>();
    }

    public Map<String, Student> getUniversity() {
        return this.university;
    }

    public void studentInfo(String[] args) {

        if (args[0].equals("Create")) {
            makeAStudent(args);
        } else if (args[0].equals("Show")) {
            getStudentInformation(args[1]);
        }
    }

    private void getStudentInformation(String studentName) {
        if (!university.containsKey(studentName)) { return; }

        Student student = university.get(studentName);
        String view = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }

        System.out.println(view);
    }

    private void makeAStudent(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        Student student = new Student(name, age, grade);
        university.putIfAbsent(name, student);
    }
}
