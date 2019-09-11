
package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import io.andersori.led.api.dto.SchoolClassDTO;
import io.andersori.led.api.entity.SchoolClass;
import io.andersori.led.api.repository.ISchoolClassRepository;

@Repository("SchoolClassService")
public class SchoolClassService implements ISchoolClassService {

    @Autowired
    @Qualifier("SchoolClassRepository")
    private ISchoolClassRepository schoolClassRepository;

    @Override
    public void register(SchoolClassDTO schoolClass) {
        schoolClassRepository.save(schoolClass.toEntity(schoolClass));
    }

	@Override
	public List<SchoolClassDTO> getSchoolClasses() {
        return schoolClassRepository.findAll()
        .stream()
        .map((SchoolClass s) -> {
            SchoolClassDTO dto = new SchoolClassDTO();
            return dto.toDto(s);
        })
        .collect(Collectors.toList());
	}
    
}