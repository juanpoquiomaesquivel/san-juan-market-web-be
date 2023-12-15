package pre.juanp.sanjuan.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.User;
import pre.juanp.sanjuan.repository.UserRepo;

@Service
public class UserServ {

	@Autowired
	private UserRepo repo;

	public List<User> getAll() {
		return repo.findAll();
	}

	public String postCreateNewUser(String username, String password, String email, String firstName, String lastName,
			Date birthDate, String gender) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[12];
		random.nextBytes(salt);

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		SecretKeyFactory factory;
		byte[] hashedPassword = new byte[12];

		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hashedPassword = factory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		return repo.UpGnPostCreateNewUser(username, hashedPassword, salt, email, firstName, lastName, birthDate, gender);
	}

	public String getLoginUser(String username, String password) {
		byte[] salt = repo.getUserSalt(username);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		SecretKeyFactory factory;
		byte[] hashedPassword = new byte[12];
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hashedPassword = factory.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		return repo.UpGnGetLoginUser(username, hashedPassword);
	}
}
