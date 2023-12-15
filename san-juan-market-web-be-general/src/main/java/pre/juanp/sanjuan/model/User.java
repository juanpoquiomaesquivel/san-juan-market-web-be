package pre.juanp.sanjuan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "[User]")
@Data
@NoArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password", columnDefinition = "VARBINARY(MAX)")
	private byte[] password;
	
	@Column(name = "Salt", columnDefinition = "VARBINARY(MAX)")
	private byte[] salt;
}
