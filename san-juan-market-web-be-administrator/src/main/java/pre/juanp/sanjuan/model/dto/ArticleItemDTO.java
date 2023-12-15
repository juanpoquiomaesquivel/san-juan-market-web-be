package pre.juanp.sanjuan.model.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.Value;

@Value
public class ArticleItemDTO {

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Code")
	private String code;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "Price")
	private BigDecimal price;

	@Column(name = "Image")
	private String image;

	@Column(name = "BarCode")
	private String barCode;

	@Column(name = "Product")
	private String product;
}
