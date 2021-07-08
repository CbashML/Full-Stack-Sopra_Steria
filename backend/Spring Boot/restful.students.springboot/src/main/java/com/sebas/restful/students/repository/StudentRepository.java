package com.sebas.restful.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sebas.restful.students.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//	@Query("SELECT s FROM Student s WHERE s.name = ':name'")
//	@Query("SELECT s FROM Student s")
	@Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
	List<Student> findByNameLike(@Param("name") String name);

}
