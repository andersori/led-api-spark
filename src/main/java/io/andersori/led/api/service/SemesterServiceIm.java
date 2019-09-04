package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.SemesterBean;
import io.andersori.led.api.entity.Semester;
import io.andersori.led.api.repository.SemesterRepositoryIn;

@Service("SemesterServiceIm")
public class SemesterServiceIm implements SemesterServiceIn {

    @Autowired
    @Qualifier("SemesterRepositoryIm")
    private SemesterRepositoryIn semesterRepository;

    @Override
    public void register(SemesterBean semester) {
        semesterRepository.save(semester.toEntity());
    }

	@Override
	public List<SemesterBean> getSemesters() {
        return semesterRepository.findAll()
        .stream()
        .map((Semester s) -> {
            SemesterBean bean = new SemesterBean();
            bean.toBean(Optional.of(s));
            return bean;
        })
        .collect(Collectors.toList());
	}
    
}