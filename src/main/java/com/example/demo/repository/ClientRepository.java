package com.example.demo.repository;

import com.example.demo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "FROM Client c WHERE c.dob <= :date")
    List<Client> olderThan(@Param("date") LocalDate date);
}
