package com.university.system.repository;

import com.university.system.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {


    @Query("""
    SELECT l
    FROM Lecturer l
    WHERE LOWER(CONCAT(l.firstName, ' ', l.lastName)) LIKE LOWER(CONCAT('%', :query, '%'))
       OR LOWER(l.firstName) LIKE LOWER(CONCAT('%', :query, '%'))
       OR LOWER(l.lastName) LIKE LOWER(CONCAT('%', :query, '%'))
""")
    List<Lecturer> searchByFullName(String query);
}