package pre.juanp.sanjuan.model.dto.administrator;

import javax.persistence.Column;

import lombok.Value;

@Value
public class FamilyOptionGroupDTO {

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;
}
