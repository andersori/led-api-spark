
package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import io.andersori.led.api.dto.SchoolClassDto;
import io.andersori.led.api.entity.SchoolClass;
import io.andersori.led.api.repository.SchoolClassRepositoryIn;

@Repository("SchoolClassService")
public class SchoolClassService implements ISchoolClassService {

    @Autowired
    @Qualifier("SchoolClassRepositoryIm")
    private SchoolClassRepositoryIn schoolClassRepository;

    @Override
    public void register(SchoolClassDto schoolClass) {
        schoolClassRepository.save(schoolClass.toEntity(schoolClass));
    }

	@Override
	public List<SchoolClassDto> getSchoolClasses() {
        return schoolClassRepository.findAll()
        .stream()
        .map((SchoolClass s) -> {
            SchoolClassDto bean = new SchoolClassDto();
            return bean.toDto(s);
        })
        .collect(Collectors.toList());
	}
    
}