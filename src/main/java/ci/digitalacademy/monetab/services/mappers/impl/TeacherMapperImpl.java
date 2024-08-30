package ci.digitalacademy.monetab.services.mappers.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mappers.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapperImpl implements TeacherMapper {
    private final ModelMapper modelMapper;

    @Override
    public TeacherDTO toDto(Teacher entity) {
        return modelMapper.map(entity, TeacherDTO.class);
    }

    @Override
    public Teacher toEntity(TeacherDTO dto) {
        return modelMapper.map(dto, Teacher.class);
    }
}
