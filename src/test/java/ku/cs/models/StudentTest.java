package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StudentTest {
    Student s;
    @BeforeEach
    void init(){
        s = new Student("6xxxxxxxx", "StudentTest");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName(){
        assertEquals("StudentTest", s.getName());
        s.changeName("TestStudent");
        assertEquals("TestStudent", s.getName());
    }

    @Test
    void testIsId(){
        boolean b = s.isId("12345");
        assertEquals(false, b);
    }

    @Test
    void testIsNameContains(){
        boolean b = s.isNameContains("tuden");
        assertEquals(true, b);
    }

}