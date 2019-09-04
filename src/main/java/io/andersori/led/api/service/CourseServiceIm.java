package io.andersori.led.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.andersori.led.api.bean.CourseBean;
import io.andersori.led.api.entity.Course;
import io.andersori.led.api.repository.CourseRepositoryIn;

@Service("CourseServiceIm")
public class CourseServiceIm implements CourseServiceIn {

    @Autowired
    @Qualifier("CourseRepositoryIm")
    private CourseRepositoryIn courseReposiroty;

    @Override
    public void register(CourseBean course) {
        courseReposiroty.save(course.toEntity());
    }

	@Override
	public List<CourseBean> getCouses() {
        return courseReposiroty.findAll()
        .stream()
        .map((Course c) -> {
            CourseBean bean = new CourseBean();
            bean.toBean(Optional.of(c));
            return bean;
        })
        .collect(Collectors.toList());
	}
    
}