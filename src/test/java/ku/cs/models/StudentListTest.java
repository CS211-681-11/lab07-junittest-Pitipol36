package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList list;
    @BeforeEach
    void init(){
        list = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มสมาชิกเข้าไปในลิสต์และทดสอบการหาสมาชิกด้วยไอดี")
    void testFindStudent(){
        String id = "6xxxxxxxx";
        String name = "StudentTest";
        list.addNewStudent(id, name);
        assertEquals(name, list.findStudentById(id).getName());
        assertEquals(id, list.findStudentById(id).getId());
    }

    @Test
    @DisplayName("ทดสอบการฟิลเตอร์ให้เหลือลิสต์ตามสตริงที่ใส่")
    void testFilterByName(){
        list.addNewStudent("6xxxxxxx1", "StudentTest1");
        list.addNewStudent("6xxxxxxx2", "StudentTest2");
        list.addNewStudent("6xxxxxxx3", "StudentTest3");
        list.addNewStudent("6xxxxxxx4", "StudentTest4");
        list.addNewStudent("6xxxxxxx5", "StudentTest5");
        StudentList filteredList = list.filterByName("Student");
        assertEquals(5,filteredList.getStudents().size());
        filteredList = list.filterByName("1");
        assertEquals(1,filteredList.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนและการขอดูเกรดของสมาชิกลิสต์")
    void testScoreAndGrade(){
        list.addNewStudent("6xxxxxxx1", "StudentTest1");
        list.addNewStudent("6xxxxxxx2", "StudentTest2");
        list.addNewStudent("6xxxxxxx3", "StudentTest3");
        list.addNewStudent("6xxxxxxx4", "StudentTest4");
        list.addNewStudent("6xxxxxxx5", "StudentTest5");
        list.giveScoreToId("6xxxxxxx1", 25);
        list.giveScoreToId("6xxxxxxx2", 60);
        assertEquals(25,list.findStudentById("6xxxxxxx1").getScore());
        assertEquals("C",list.findStudentById("6xxxxxxx2").grade());
    }

}