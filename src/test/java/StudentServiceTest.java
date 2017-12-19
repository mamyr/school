import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.school.model.Student;
import com.mycompany.school.service.StudentService;

@Test
@ContextConfiguration(locations = "classpath*:spring-test-config.xml")
public class StudentServiceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private StudentService studentService;
	
	@Test()
	public void test() {
		Student student = new Student();
		student.setUserName("userName");
		student.setDateOfBirth(new Date());
		student.setPassword("password");
		student.setConfirmPassword("password");
		student.setEmailAddress("emailAddress");
		student.setFirstName("firstName");
		student.setLastName("lastName");
		Student studentInserted = studentService.insertStudent(student);
		
		Assert.assertNotNull(studentInserted);
		Assert.assertTrue(studentInserted.getId().intValue() != 0);
		
		List<Student> students = studentService.getStudentList();
		
		Assert.assertTrue(students.size() == 1);
		
		Assert.assertTrue(studentService.getStudentByUserName("userName"));
		
		studentService.deleteStudent(studentInserted.getId().intValue());
		students = studentService.getStudentList();
		
		Assert.assertTrue(students.size() == 0);
		Assert.assertFalse(studentService.getStudentByUserName("userName"));
		System.out.println("Hello!");
	}
}
