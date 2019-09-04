package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.StudentBean;
import io.andersori.led.api.entity.Student;
import io.andersori.led.api.repository.StudentRepositoryIn;

@Service("StudentServiceIm")
public class StudentServiceIm implements StudentServiceIn {

    @Autowired
    @Qualifier("StudentRepositoryIm")
    private StudentRepositoryIn studentRepository;

    @Override
    public void register(StudentBean student) {
        studentRepository.save(student.toEntity());
    }

	@Override
	public List<StudentBean> getStudents() {
        return studentRepository.findAll()
        .stream()
        .map((Student s) -> {
            StudentBean bean = new StudentBean();
            bean.toBean(Optional.of(s));
            return bean;
        })
        .collect(Collectors.toList());
	}

}