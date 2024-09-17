package dev.praneeth.backend.user;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // @Autowired is optional here, Spring will inject automatically
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetUsers() {
        return userRepository.findAll();
    }

    public void AddUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        userRepository.save(user);
    }

    public void DeleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Integer userId, UserUpdateRequest updateRequest) {
        // Retrieve the user or throw an exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));

        // Update firstName if it's valid
        if (updateRequest.getFirstName() != null && !updateRequest.getFirstName().trim().isEmpty()) {
            user.setFirstName(updateRequest.getFirstName());
        }

        // Update lastName if it's valid
        if (updateRequest.getLastName() != null && !updateRequest.getLastName().trim().isEmpty()) {
            user.setLastName(updateRequest.getLastName());
        }

        // Update dob if it's valid
        if (updateRequest.getDob() != null && !updateRequest.getDob().trim().isEmpty()) {
            try {
                LocalDate parsedDob = LocalDate.parse(updateRequest.getDob()); // Convert dob from String to LocalDate
                user.setDob(parsedDob);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for dob: " + updateRequest.getDob());
            }
        }

        // Update gender if it's not null
        if (updateRequest.getGender() != null) {
            user.setGender(updateRequest.getGender());
        }

        // Update address if it's valid
        if (updateRequest.getAddress() != null && !updateRequest.getAddress().trim().isEmpty()) {
            user.setAddress(updateRequest.getAddress());
        }

        // Update phone_number if it's valid
        if (updateRequest.getPhone_number() != null && !updateRequest.getPhone_number().trim().isEmpty()) {
            user.setPhone_number(updateRequest.getPhone_number());
        }

        // Check for duplicate email before updating
        if (updateRequest.getEmail() != null && !updateRequest.getEmail().trim().isEmpty()) {
            Optional<User> userWithEmail = userRepository.findByEmail(updateRequest.getEmail());
            if (userWithEmail.isPresent() && !userWithEmail.get().getPatientID().equals(userId)) {
                throw new IllegalStateException("Email already taken");
            }
            user.setEmail(updateRequest.getEmail());
        }

        // Save the updated user entity
        userRepository.save(user);
    }
}
