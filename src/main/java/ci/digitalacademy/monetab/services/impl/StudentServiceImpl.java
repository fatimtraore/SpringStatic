package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.mappers.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        log.info("Request to save student {}", student);
        Student saveStudent = studentRepository.save(student);
        return studentMapper.toDto(saveStudent);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return findOne(studentDTO.getId()).map(existingStudent->{
            existingStudent.setEmail(studentDTO.getEmail());
            existingStudent.setClasse(studentDTO.getClasse());
            existingStudent.setVille(studentDTO.getVille());
            existingStudent.setGenre(studentDTO.getGenre());
            existingStudent.setDateNaissance(studentDTO.getDateNaissance());
            existingStudent.setFirstName(studentDTO.getFirstName());
            existingStudent.setLastName(studentDTO.getLastName());
            existingStudent.setMatricule(studentDTO.getMatricule());
            existingStudent.setTelephone(studentDTO.getTelephone());
            return save(existingStudent);
        }).orElseThrow(()->new IllegalArgumentException());


//        Optional<Student> optionalUser = findOne(student.getId());
//        if (optionalUser.isPresent()){
//            Student studentToUpdate = optionalUser.get();
//            studentToUpdate.setMatricule(student.getMatricule());
//            return save(studentToUpdate);
//        }else {
//            throw new IllegalArgumentException();
//        }

    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id).map(student -> {
            return studentMapper.toDto(student);
        });
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> {
        return studentMapper.toDto(student);
        }).toList();

    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
