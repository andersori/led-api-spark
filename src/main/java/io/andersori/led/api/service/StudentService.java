package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.StudentDTO;
import io.andersori.led.api.entity.Student;
import io.andersori.led.api.repository.IStudentRepository;

@Service("StudentService")
public class StudentService implements IStudentService {

    @Autowired
    @Qualifier("StudentRepository")
    private IStudentRepository studentRepository;

    @Override
    public void register(StudentDTO student) {
        studentRepository.save(student.toEntity(student));
    }

	@Override
	public List<StudentDTO> getStudents() {
        return studentRepository.findAll()
        .stream()
        .map((Student s) -> {
            StudentDTO dto = new StudentDTO();
            return dto.toDto(s);
        })
        .collect(Collectors.toList());
	}

}