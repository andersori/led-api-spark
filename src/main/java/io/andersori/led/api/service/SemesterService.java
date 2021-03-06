package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.SemesterDTO;
import io.andersori.led.api.entity.Semester;
import io.andersori.led.api.repository.ISemesterRepository;

@Service("SemesterService")
public class SemesterService implements ISemesterService {

    @Autowired
    @Qualifier("SemesterRepository")
    private ISemesterRepository semesterRepository;

    @Override
    public void register(SemesterDTO semester) {
        semesterRepository.save(semester.toEntity(semester));
    }

	@Override
	public List<SemesterDTO> getSemesters() {
        return semesterRepository.findAll()
        .stream()
        .map((Semester s) -> {
            SemesterDTO dto = new SemesterDTO();
            return dto.toDto(s);
        })
        .collect(Collectors.toList());
	}
    
}