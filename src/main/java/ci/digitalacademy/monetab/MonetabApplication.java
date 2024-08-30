package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.*;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private FicheNoteService ficheNoteService;

	@Autowired
	private AdresseService adresseService;

	public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		User user = new User(null, "Bakus", "12345", Instant.now());
//		User user2 = new User(null, "Berthe", "12345", Instant.now());
//		userService.save(user);
//		userService.save(user2);
//
//		Student student = new Student(null, "12121");
//		studentService.save(student);
//
//
//
//		List<User> users = userService.findAll();
//		System.out.println(users);
//
//		Optional<User>optionalUser= userService.findOne(3L);
//		System.out.println(optionalUser);
//
//		user2.setPseudo("Bakus0007");
//		userService.save(user2);
//
//		Teacher teacher = new Teacher(null, "Mathematique");
//		teacherService.save(teacher);
//
//		FicheNote ficheNote = new FicheNote(null, "Premiére Note", "2024");
//		ficheNoteService.save(ficheNote);


//		Adresse adresse1 = new Adresse();
//		adresse1.setCountry("Côte d'Ivoire");
//		adresse1.setCity("Abidjan");
//		adresse1.setStreet("Rue 12");
//		adresseService.save(adresse1);
//
//
//		User user2 = new User(null, "Berthe", "12345", Instant.now(), adresse1);
//		userService.save(user2);
//
//		List<User> users = userService.findAll();
//		System.out.println(users);
//
//		Teacher teacher1 = new Teacher();
//		teacher1.setMatiere("Mathemetique");
//		teacherService.save(teacher1);
//
//		Teacher teacher = new Teacher();
//		teacher.setMatiere("Informatique");
//		teacherService.save(teacher);
//
//
//		FicheNote ficheNote1 = new FicheNote();
//		ficheNote1.setNote("12");
//		ficheNote1.setAnnee("2024");
//		ficheNote1.setTeacher(teacher);
//
//		FicheNote ficheNote2 = new FicheNote();
//		ficheNote2.setNote("17");
//		ficheNote2.setAnnee("2024");
//		ficheNote2.setTeacher(teacher);
//
//		ficheNoteService.save(ficheNote1);
//		ficheNoteService.save(ficheNote2);
//
//		Set<FicheNote> ficheNotes = new HashSet<>();
//		ficheNotes.add(ficheNote1);
//		ficheNotes.add(ficheNote2);
//
//		List<Teacher> teachers = teacherService.findAll();
//		System.out.println(teachers);
//
//		Set<FicheNote> ficheNotes1 = teachers.get(0).getFicheNote();
//		System.out.println(ficheNotes1);









		//userService.delete(user.getId());


//		StudentDTO student1 = new StudentDTO();
//		student1.setMatricule("AB-123");
//		student1.setLastName("Fatim");
//		student1.setFirstName("Traore");
//		student1.setEmail("fatyyy@gmail.com");
//		student1.setTelephone("0781258902");
//		student1.setVille("Abidjan");
//		student1.setClasse("1ére");
//		student1.setGenre("Femme");
//		student1.setDateNaissance(Date.from(Instant.now()));
//
//
//		studentService.save(student1);
//
//		StudentDTO student2 = new StudentDTO();
//		student2.setMatricule("FA-245");
//		student2.setLastName("Ibrahim");
//		student2.setFirstName("Cisse");
//		student2.setEmail("ib@gmail.com");
//		student2.setTelephone("0544043040");
//		student2.setVille("Bonoua");
//		student2.setClasse("Tle");
//		student2.setGenre("Homme");
//		student2.setDateNaissance(Date.from(Instant.now()));
//
//		studentService.save(student2);
//
//		StudentDTO student3 = new StudentDTO();
//		student3.setMatricule("CA-379");
//		student3.setLastName("Zehnab");
//		student3.setFirstName("Cisse");
//		student3.setEmail("kob@gmail.com");
//		student3.setTelephone("0505342678");
//		student3.setVille("Abidjan");
//		student3.setClasse("2nde");
//		student3.setGenre("Homme");
//		student3.setDateNaissance(Date.from(Instant.now()));
//
//		studentService.save(student3);
//
//
//		TeacherDTO teacher1 = new TeacherDTO();
//		teacher1.setFirstName("Koffi");
//		teacher1.setLastName("Jacques");
//		teacher1.setMatiere("Physique");
//		teacher1.setEmail("koffij@gmail.com");
//		teacher1.setVille("Abidjan");
//		teacher1.setTelephone("0142786453");
//		teacher1.setVaccant(false);
//		teacher1.setGenre("M");
//
//
//		teacherService.save(teacher1);
//
//		TeacherDTO teacher2 = new TeacherDTO();
//		teacher2.setFirstName("Camara");
//		teacher2.setLastName("Mohamed");
//		teacher2.setMatiere("Informatique");
//		teacher2.setEmail("cam@gmail.com");
//		teacher2.setVille("Adzopé");
//		teacher2.setTelephone("0505674323");
//		teacher2.setVaccant(true);
//		teacher2.setGenre("M");
//
//		teacherService.save(teacher2);
//
//		UserDTO user1 = new UserDTO();
//		user1.setPseudo("Admin");
//		user1.setPassword("12345");
//		user1.setCreationDate(Date.from(Instant.now()));
//
//		userService.save(user1);
//
//		UserDTO user2 = new UserDTO();
//		user2.setPseudo("User");
//		user2.setPassword("12345");
//		user2.setCreationDate(Date.from(Instant.now()));
//
//
//		userService.save(user2);



	}
}
