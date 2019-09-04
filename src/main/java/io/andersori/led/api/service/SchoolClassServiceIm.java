
package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import io.andersori.led.api.bean.SchoolClassBean;
import io.andersori.led.api.entity.SchoolClass;
import io.andersori.led.api.repository.SchoolClassRepositoryIn;

@Repository("SchoolClassServiceIm")
public class SchoolClassServiceIm implements SchoolClassServiceIn {

    @Autowired
    @Qualifier("SchoolClassRepositoryIm")
    private SchoolClassRepositoryIn schoolClassRepository;

    @Override
    public void register(SchoolClassBean schoolClass) {
        schoolClassRepository.save(schoolClass.toEntity());
    }

	@Override
	public List<SchoolClassBean> getSchoolClasses() {
        return schoolClassRepository.findAll()
        .stream()
        .map((SchoolClass s) -> {
            SchoolClassBean bean = new SchoolClassBean();
            bean.toBean(Optional.of(s));
            return bean;
        })
        .collect(Collectors.toList());
	}
    
}