package ci.digitalacademy.monetab.services.mappers.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.mappers.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentMapperImpl implements StudentMapper {

    private final ModelMapper modelMapper;

    @Override
    public StudentDTO toDto(Student entity) {
        return modelMapper.map(entity, StudentDTO.class);
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }
}
