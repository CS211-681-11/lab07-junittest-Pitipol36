package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentList studentList;
    @BeforeEach
    void init() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        studentList = datasource.readData();
    }

    @Test
    @DisplayName("ทดสอบว่าสามารถหาสมาชิกเฉพาะตัวได้หรือเปล่า")
    void findHardCodeTest() {
        //Test if specific student can be found from datasource
        Student a = studentList.findStudentById("6710400004");
        assertEquals("Fourth", a.getName());
    }

    @Test
    @DisplayName("ทดสอบว่ามีจำนวนข้อมูลถูกต้องหรือเปล่า")
    void dataAmountTest() {
        //Test if datasource has the correct amount of data
        assertEquals(4, studentList.getStudents().size());
    }
}