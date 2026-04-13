package com.university.system.repository;

import com.university.system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
    SELECT s
    FROM Student s
    WHERE LOWER(CONCAT(s.firstName, ' ', s.lastName)) LIKE LOWER(CONCAT('%', :query, '%'))
       OR LOWER(s.firstName) LIKE LOWER(CONCAT('%', :query, '%'))
       OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :query, '%'))
""")
    List<Student> searchByFullName(String query);
}