package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/add")
    public String addShowStudentForms(Model model){
        log.debug("Request to add show students forms");
        model.addAttribute("student", new Student());
        return "students/form";
    }

    @PostMapping
    public String saveStudent(StudentDTO student){
        log.debug("Request to save teacher :{}", student);
        studentService.save(student);
        return "redirect:/students";
    }


    @GetMapping
    public String showStudentPages(Model model){
        final List<StudentDTO> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/add";

    }

    @GetMapping("/{id}")
    public String showUpdateStudentForms(Model model, @PathVariable Long id){
        log.debug("Request to show update student forms");
        Optional<StudentDTO> student = studentService.findOne(id);
        if (student.isPresent()){
            model.addAttribute("student", student.get());
            return "students/form";
        }
        else {
            return "redirect:/students";
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        log.debug("Demande de suppression de l'étudiant avec l'ID : " + id);
        studentService.delete(id);
        return ResponseEntity.ok().build();  // Retourne 200 OK si la suppression est réussie
    }







}
