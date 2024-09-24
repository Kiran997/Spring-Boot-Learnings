package com.project.CrudOperationsTask.ServiceLayer;



import com.project.CrudOperationsTask.RepositoryLayer.ManagerRepository;
import com.project.CrudOperationsTask.RepositoryLayer.UserRepository;
import com.project.CrudOperationsTask.model.Manager;
import com.project.CrudOperationsTask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public User createUser(User user) {

        // Set created_at
        user.setCreatedAt(LocalDateTime.now());

        // Validate and format mobile number
        user.setMobNum(formatMobileNumber(user.getMobNum()));

        // Ensure PAN is in uppercase
        user.setPanNum(user.getPanNum().toUpperCase());

        // Validate manager, if provided
        if (user.getManager() != null) {
            Optional<Manager> manager = managerRepository.findByIdAndIsActiveTrue(user.getManager().getId());
            if (manager.isEmpty()) {
                throw new IllegalArgumentException("Invalid manager ID.");
            }
        }

        // Save user
        return userRepository.save(user);
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public List<User> getUsersByManagerId(UUID managerId) {
        return userRepository.findByManager_Id(managerId);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    // Utility function to format mobile number
    private String formatMobileNumber(String mobileNumber) {
        if (mobileNumber.startsWith("+91") || mobileNumber.startsWith("0")) {
            return mobileNumber.substring(mobileNumber.length() - 10);
        }
        return mobileNumber;
    }
}
