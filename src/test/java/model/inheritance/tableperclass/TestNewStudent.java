package model.inheritance.tableperclass;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.inheritance.singletable.ScholarshipStudent;
import model.manytomany.MovieRating;

public class TestNewStudent extends TestCase {

    private static boolean isSuccessInsertNewStudent = false;

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        System.out.println("TestNewStudent: BEGIN");
        try {
            DataAccessObject<Student> dataAccessStudent = new DataAccessObject<>();
            try {
                Student student = new Student(123L, "John");
                ScholarshipStudent scholarshipStudent = new ScholarshipStudent(456L, "Julie", 500L);

                dataAccessStudent.includeAtomicTransactionalDAO(student);
                dataAccessStudent.includeAtomicTransactionalDAO(scholarshipStudent);

                dataAccessStudent.closeTransactionalDAO();

                isSuccessInsertNewStudent = true;
            } catch (final Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessInsertNewStudent);
                dataAccessStudent.closeConnectionDatabase();
                System.out.println("TestNewStudent: END");
            }
        } catch (final Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }
}
