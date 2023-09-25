package com.dev.marcos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.marcos.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
