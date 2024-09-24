package com.project.CrudOperationsTask.RepositoryLayer;

import com.project.CrudOperationsTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByManager_Id(UUID managerId);

    Optional<User> findById(int userId);

    void deleteById(int userId);
}