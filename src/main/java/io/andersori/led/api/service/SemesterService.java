package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.SemesterDto;
import io.andersori.led.api.entity.Semester;
import io.andersori.led.api.repository.SemesterRepositoryIn;

@Service("SemesterService")
public class SemesterService implements ISemesterService {

    @Autowired
    @Qualifier("SemesterRepositoryIm")
    private SemesterRepositoryIn semesterRepository;

    @Override
    public void register(SemesterDto semester) {
        semesterRepository.save(semester.toEntity(semester));
    }

	@Override
	public List<SemesterDto> getSemesters() {
        return semesterRepository.findAll()
        .stream()
        .map((Semester s) -> {
            SemesterDto bean = new SemesterDto();
            return bean.toDto(s);
        })
        .collect(Collectors.toList());
	}
    
}