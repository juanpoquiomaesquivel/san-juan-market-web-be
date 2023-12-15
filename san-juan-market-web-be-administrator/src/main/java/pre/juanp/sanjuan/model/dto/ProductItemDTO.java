package pre.juanp.sanjuan.model.dto;

import javax.persistence.Column;

import lombok.Value;

@Value
public class ProductItemDTO {

	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Image")
	private String image;
	
	@Column(name = "Category")
	private String category;
}
