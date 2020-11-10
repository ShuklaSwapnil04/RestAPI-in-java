package com.springrest.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDAO;
import com.springrest.springrest.entity.Course;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDao;
	//List<Course> list;
	public CourseServiceImpl() {
	
		// TODO Auto-generated constructor stub
		/*
		 * list=new ArrayList<>(); list.add(new
		 * Course(145,"java core","this conatins basic of java")); list.add(new
		 * Course(146,"java advace","this conatins advance of java"));
		 */
	 }

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		/*
		 * Course c=null; for(Course course:list) { if(course.getId()==courseId) {
		 * c=course; break; } } return c;
		 */
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		/*
		 * list.forEach(e ->{ if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * });
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		/*
		 * list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.
		 * toList());
		 */
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
