package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.StudentDTO;
import io.andersori.led.api.entity.Student;
import io.andersori.led.api.repository.StudentRepositoryIn;

@Service("StudentService")
public class StudentService implements IStudentService {

    @Autowired
    @Qualifier("StudentRepositoryIm")
    private StudentRepositoryIn studentRepository;

    @Override
    public void register(StudentDTO student) {
        studentRepository.save(student.toEntity(student));
    }

	@Override
	public List<StudentDTO> getStudents() {
        return studentRepository.findAll()
        .stream()
        .map((Student s) -> {
            StudentDTO bean = new StudentDTO();
            return bean.toDto(s);
        })
        .collect(Collectors.toList());
	}

}