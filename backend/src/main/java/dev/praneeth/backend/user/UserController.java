package dev.praneeth.backend.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
	public List<User> GetUsers() {
    	return userService.GetUsers();
    }

    @PostMapping
    public void AddUser(@RequestBody User user) {
    	userService.AddUser(user);
    }

    @DeleteMapping(path = "/{userId}")
    public void DeleteUser(@PathVariable("userId") Integer userId) {
    	userService.DeleteUser(userId);
    }

    @PutMapping(path = "/{userId}")
    public void UpdateUser(@PathVariable("userId") Integer userId, @RequestBody UserUpdateRequest updateRequest) {
    	userService.updateUser(userId, updateRequest);
    }
}
