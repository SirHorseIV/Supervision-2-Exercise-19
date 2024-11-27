import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class StudentMarks {
    private HashMap<Student, Double> studentMarksMap;

    public StudentMarks(HashMap<Student, Double> studentMarksMap) {
        this.studentMarksMap = studentMarksMap;
    }

    public List<Student> getAllStudents() {
        return studentMarksMap.keySet().stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .toList();
    }

    public List<String> getTopStudents(int p) {
        int size = studentMarksMap.size();
        return studentMarksMap.entrySet().stream()
                .sorted((entryA, entryB) ->
                        -entryA.getValue().compareTo(entryB.getValue()))
                .limit((int) ((float) (size * p) / 100f))
                .map(entry -> {
                    Student student = entry.getKey();
                    return student.getFirstName() + " " + student.getLastName();
                })
                .toList();
    }

    public double median() {
        int size = studentMarksMap.size();
        if (size == 0) throw new NoSuchElementException();
        Stream<Double> marks = studentMarksMap.values().stream()
                .sorted();
        if ((size & 1) == 0) {
            Double[] medianBounds = studentMarksMap.values().stream()
                    .skip(size / 2 - 1)
                    .limit(2)
                    .toArray(Double[]::new);
            return (medianBounds[0] + medianBounds[1]) / 2;
        }
        return marks
                .skip(size / 2)
                .findFirst().orElseThrow();
    }
}
