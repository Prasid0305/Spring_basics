package demo_H2_jpa.UserManagentApi.services;

import demo_H2_jpa.UserManagentApi.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo_H2_jpa.UserManagentApi.controller.UserController;
import demo_H2_jpa.UserManagentApi.model.UserModel;
import demo_H2_jpa.UserManagentApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic related to UserModel entities.
 * Provides methods to save, retrieve, update, and delete users.
 */
@Service
public class UserServices {
    private static final Logger logger = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    UserRepository userRepository;
    /**
     * Save a new user to the repository.
     *
     * @param userModel the user model to save
     * @return the saved UserModel instance
     */
    public UserModel saveUser(UserModel userModel) {
        logger.info("Saving new user: {}", userModel.getName());
        return userRepository.save(userModel);
    }
    /**
     * Retrieve all users from the repository.
     *
     * @return a list of all UserModel objects
     */
    public List<UserModel> getAllUsers() {
        System.out.println("getting all the users");
        return userRepository.findAll();
    }

    //Optional is new
    /**
     * Retrieve a user by their ID.
     *
     * @param id the user ID
     * @return an Optional containing the UserModel if found, otherwise empty
     */
    public Optional<UserModel> getUserById(int id) throws UserNotFoundException {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("user with this id is not present!!!");
        }
        return user;
    }

    /**
     * Delete a user by their ID.
     *
     * @param id the ID of the user to delete
     */
    public void deleteUserById(int id) {
        logger.warn("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }
    /**
     * Update an existing user by their ID.
     *
     * @param id the ID of the user to update
     * @param updatedUser the UserModel object containing updated data
     * @return the updated UserModel instance
     * @throws RuntimeException if the user with the given ID is not found
     */
    public UserModel updateUser(int id, UserModel updatedUser) {
        Optional<UserModel> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserModel user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
