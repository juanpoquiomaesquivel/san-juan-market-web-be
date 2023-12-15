package pre.juanp.sanjuan.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.User;
import pre.juanp.sanjuan.service.UserServ;

@RestController
@RequestMapping("/user/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class UserController {

	@Autowired
	private UserServ serv;

	@GetMapping("/get/user/all")
	public ResponseEntity<List<User>> getAll() {
		Optional<List<User>> list = Optional.of(serv.getAll());
		
		if (list.isEmpty()) {
			System.out.println("Is empty!");
		}
		
		return ResponseEntity.ok(list.get());
	}

	@PostMapping("/post/new")
	public ResponseEntity<String> postCreateNewUser(@RequestParam("Username") String username,
			@RequestParam("Password") String password, @RequestParam("Email") String email,
			@RequestParam("FirstName") String firstName, @RequestParam("LastName") String lastName,
			@RequestParam("BirthDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
			@RequestParam("Gender") String gender) {
		String msg = serv.postCreateNewUser(username, password, email, firstName, lastName, birthDate, gender);

		return ResponseEntity.ok(msg);
	}

	@GetMapping("/get/login")
	public ResponseEntity<String> getLoginUser(@RequestParam("Username") String username,
			@RequestParam("Password") String password) {
		String msg = serv.getLoginUser(username, password);

		return ResponseEntity.ok(msg);
	}
}
