package pre.juanp.sanjuan.model.dto;

import javax.persistence.Column;

import lombok.Value;

@Value
public class CategoryFilterDTO {

	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Image")
	private String image;
}
