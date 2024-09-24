package com.project.CrudOperationsTask.RepositoryLayer;

import com.project.CrudOperationsTask.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findByIdAndIsActiveTrue(UUID id);
}
