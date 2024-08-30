package ci.digitalacademy.monetab.controller;


import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/add")
    public String showAddTeacherForms(Model model){
        log.debug("Request to show add teachers forms");
        model.addAttribute("teacher", new Teacher());
        return "teachers/form";
    }

    @PostMapping
    public String saveTeacher(TeacherDTO teacher){
        log.debug("Request to save teacher :{}", teacher);
        teacherService.save(teacher);
        return "redirect:/teachers";
    }



    @GetMapping
    public String showTeacherPages(Model model){
        log.debug("Request teacher show to teacher");
       final List<TeacherDTO> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers/add";
    }


    @GetMapping("/{id}")
    public String showUpdateTeacherForm(Model model , @PathVariable Long id){
        log.debug("Request to show update teacher forms");
        Optional<TeacherDTO> teacher= teacherService.findOne(id);
        if (teacher.isPresent()){
            model.addAttribute("teacher", teacher.get());
            return "teachers/form";
        }else {
            return "redirect:/teachers";
        }



    }

    @PostMapping("/{id}")
    public String showDeleteTeacher( @PathVariable Long id){
        log.debug("Request delete student");
        teacherService.delete(id);
        return "redirect:/teachers";
    }
    //<input hidden type="text" th:field="*{id}">
}
