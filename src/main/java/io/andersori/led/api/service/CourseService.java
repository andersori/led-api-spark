package io.andersori.led.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.dto.CourseDTO;
import io.andersori.led.api.entity.Course;
import io.andersori.led.api.repository.ICourseRepository;

@Service("CourseService")
public class CourseService implements ICourseService {

    @Autowired
    @Qualifier("CourseRepository")
    private ICourseRepository courseReposiroty;

    @Override
    public void register(CourseDTO course) {
        courseReposiroty.save(course.toEntity(course));
    }

	@Override
	public List<CourseDTO> getCouses() {
        return courseReposiroty.findAll()
        .stream()
        .map((Course c) -> {
            CourseDTO dto = new CourseDTO();
            return dto.toDto(c);
        })
        .collect(Collectors.toList());
	}
    
}