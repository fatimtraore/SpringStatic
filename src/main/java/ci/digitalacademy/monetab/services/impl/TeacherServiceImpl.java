package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mappers.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;


    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);

    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        return findOne(teacherDTO.getId()).map(existingTeacher -> {
            existingTeacher.setVaccant(teacherDTO.getVaccant());
            existingTeacher.setMatiere(teacherDTO.getMatiere());
            existingTeacher.setGenre(teacherDTO.getGenre());
            existingTeacher.setEmail(teacherDTO.getEmail());
            existingTeacher.setTelephone(teacherDTO.getTelephone());
            existingTeacher.setLastName(teacherDTO.getLastName());
            existingTeacher.setFirstName(teacherDTO.getFirstName());
            existingTeacher.setVille(teacherDTO.getVille());
            return save(existingTeacher);
        }).orElseThrow(()->new IllegalArgumentException());
    }

//        Optional<Teacher> optionalUser = findOne(teacher.getId());
//        if (optionalUser.isPresent()){
//            Teacher teacherToUpdate = optionalUser.get();
//            teacherToUpdate.setId(teacher.getId());
//            return save(teacherToUpdate);
//        }else {
//            throw new IllegalArgumentException();
//        }






    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            return teacherMapper.toDto(teacher);
        });

    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacher -> {
            return teacherMapper.toDto(teacher);
        }).toList();

    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);

    }
}
