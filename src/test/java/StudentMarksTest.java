import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentMarksTest {
    private static StudentMarks generateStudentMarks() {
        HashMap<Student, Double> studentMarksMap = new HashMap<>();
        studentMarksMap.put(new Student("F", "F"), 0.6);
        studentMarksMap.put(new Student("G", "G"), 0.7);
        studentMarksMap.put(new Student("H", "H"), 0.8);
        studentMarksMap.put(new Student("I", "I"), 0.9);
        studentMarksMap.put(new Student("J", "J"), 1.0);
        studentMarksMap.put(new Student("A", "A"), 0.1);
        studentMarksMap.put(new Student("B", "B"), 0.2);
        studentMarksMap.put(new Student("C", "C"), 0.3);
        studentMarksMap.put(new Student("D", "D"), 0.4);
        studentMarksMap.put(new Student("E", "E"), 0.5);
        return new StudentMarks(studentMarksMap);
    }

    private static StudentMarks generateOddStudentMarks() {
        HashMap<Student, Double> studentMarksMap = new HashMap<>();
        studentMarksMap.put(new Student("F", "F"), 0.6);
        studentMarksMap.put(new Student("G", "G"), 0.7);
        studentMarksMap.put(new Student("H", "H"), 0.8);
        studentMarksMap.put(new Student("I", "I"), 0.9);
        studentMarksMap.put(new Student("J", "J"), 1.0);
        studentMarksMap.put(new Student("A", "A"), 0.1);
        studentMarksMap.put(new Student("B", "B"), 0.2);
        studentMarksMap.put(new Student("C", "C"), 0.3);
        studentMarksMap.put(new Student("D", "D"), 0.4);
        studentMarksMap.put(new Student("E", "E"), 0.5);
        studentMarksMap.put(new Student("K", "K"), 0.0);
        return new StudentMarks(studentMarksMap);
    }

    @Test
    public void getAllStudents() {
        StudentMarks studentMarks = generateStudentMarks();
        List<Student> students = studentMarks.getAllStudents();
        assertEquals(List.of(
                new Student("A", "A"),
                new Student("B", "B"),
                new Student("C", "C"),
                new Student("D", "D"),
                new Student("E", "E"),
                new Student("F", "F"),
                new Student("G", "G"),
                new Student("H", "H"),
                new Student("I", "I"),
                new Student("J", "J")
        ), students);
    }

    @Test
    public void getTopStudents() {
        StudentMarks studentMarks = generateStudentMarks();
        List<String> students = studentMarks.getTopStudents(20);
        assertEquals(List.of(
                "J J",
                "I I"
        ), students);
    }

    @Test
    public void median_odd() {
        StudentMarks studentMarks = generateOddStudentMarks();
        double median = studentMarks.median();
        assertEquals(0.5, median, 1E-7);
    }

    @Test
    public void median_even() {
        StudentMarks studentMarks = generateStudentMarks();
        double median = studentMarks.median();
        assertEquals(0.55, median, 1E-7);
    }
}
