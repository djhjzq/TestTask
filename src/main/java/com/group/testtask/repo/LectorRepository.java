package com.group.testtask.repo;

import com.group.testtask.data.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("SELECT l FROM Lector l WHERE l.name LIKE %:keyword%")
    List<Lector> findByNameContaining(@Param("keyword") String keyword);


}