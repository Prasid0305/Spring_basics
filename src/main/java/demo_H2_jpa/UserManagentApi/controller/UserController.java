package demo_H2_jpa.UserManagentApi.controller;

import demo_H2_jpa.UserManagentApi.exception.UserNotFoundException;
import demo_H2_jpa.UserManagentApi.model.UserModel;
import demo_H2_jpa.UserManagentApi.services.UserServices;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * REST controller for managing User entities.
 * Provides endpoints for creating, retrieving, updating, and deleting users.
 */
@RestController
@RequestMapping("/api")
public class UserController {




    @Autowired
    UserServices userServices;
    /**
     * Create a new user.
     *
     * @param userModel The user model object containing user data from the request body.
     * @return The saved UserModel instance.
     */
    @PostMapping("/user")
    public UserModel addUser(@Valid @RequestBody UserModel userModel){

        return userServices.saveUser(userModel);
    }
    /**
     * Retrieve all users.
     *
     * @return A list of all UserModel objects.
     */
    @GetMapping("/user")
    public List<UserModel> getAllUsers() {
        return userServices.getAllUsers();
    }
    /**
     * Retrieve a user by ID.
     *
     * @param id The ID of the user to retrieve.
     * @return An Optional containing the UserModel if found, or empty if not.
     */
    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable int id) throws UserNotFoundException {

        if (id <= 0) {

            throw new IllegalArgumentException("ID must be positive");
        }

        return userServices.getUserById(id);
    }
    /**
     * Update an existing user.
     *
     * @param id The ID of the user to update.
     * @param userModel The user data from the request body to update the user with.
     * @return The updated UserModel object.
     */
    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable int id,@Valid  @RequestBody UserModel userModel) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        return userServices.updateUser(id, userModel);
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userServices.deleteUserById(id);

    }
}
