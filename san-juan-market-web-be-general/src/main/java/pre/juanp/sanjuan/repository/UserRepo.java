package pre.juanp.sanjuan.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Procedure(procedureName = "UpGnPostCreateNewUser", outputParameterName = "Message")
	public String UpGnPostCreateNewUser(@Param("Username") String username, @Param("Password") byte[] password,
			@Param("Salt") byte[] salt, @Param("Email") String email, @Param("FirstName") String firstName,
			@Param("LastName") String lastName, @Param("BirthDate") Date birthDate, @Param("Gender") String gender);

	@Procedure(value = "UpGnGetLoginUser", outputParameterName = "Message")
	public String UpGnGetLoginUser(@Param("Username") String username, @Param("Password") byte[] password);

	@Query(value = "SELECT [Salt] FROM [User] WHERE [Username] = :Username", nativeQuery = true)
	public byte[] getUserSalt(@Param("Username") String username);
}
