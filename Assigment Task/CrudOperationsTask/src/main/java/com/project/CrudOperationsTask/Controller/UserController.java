package com.project.CrudOperationsTask.Controller;

import com.project.CrudOperationsTask.ServiceLayer.UserService;
import com.project.CrudOperationsTask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public String createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return "User created successfully";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }


    @GetMapping("/get_users")
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        List<UserResponse> userResponses = users.stream()
                .map(user -> new UserResponse(user.getUserId(), user.getFullName(), user.getMobNum(), user.getPanNum(), user.getCreatedAt(), user.getUpdatedAt(), user.isActive()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userResponses);
    }




    @GetMapping("/get_user/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete_user/{userId}")
    public String deleteUser(@PathVariable UUID userId) {
        try {
            userService.deleteUser(userId);
            return "User deleted successfully";
        } catch (Exception e) {
            return "Error deleting user";
        }
    }
}
