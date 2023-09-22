package studentDB;

import java.util.List;
import model.Student;
import model.StudentTable;

/*
 * @mmmaimankarae
 */
public class StudentDB {

    public static void main(String[] args) {
            /* INSERT */
        /*Student stu = new Student(64050027);
        stu.setName("Kitthanya");
        stu.setGpa(3.61);
        StudentTable.insertStudent(stu);
        
        Student stu1 = new Student(64050033);
        stu1.setName("AlphaGo");
        stu1.setGpa(3.44);
        StudentTable.insertStudent(stu1);*/
        
            /* UPDATE */
        /*Student stu = new Student(64050033);
        stu.setGpa(4.00);
        StudentTable.updateStudent(stu);*/
        
            /* DELETE */
        /*Student stu = new Student(64050033);
        StudentTable.removeStudent(stu);*/
        
        Student stu = new Student(64050050);
        stu.setName("Gikabate");
        stu.setGpa(2.53);
        StudentTable.insertStudent(stu);
        
        Student update = StudentTable.findStudentById(64050050);
        if (update != null) {
            update.setName("Theerarat");
            update.setGpa(3.99);
            StudentTable.updateStudent(update);
        }
        
        List<Student> delete = StudentTable.findStudentByName("Gikabate");
        if (delete != null) {
            for (Student student : delete){
                StudentTable.removeStudent(student);
            } 
        }
            /* SHOW DATA FROM ID */
        System.out.println("Show Data By ID");
        List<Student> stuList = StudentTable.findAllStudent();
        
        for (Student student : stuList){
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("GPA: " + student.getGpa());
        } 
    }   
}
