package pre.juanp.sanjuan.model.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.Value;

@Value
public class ArticleCardDTO {

	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "img")
	private String img;

	@Column(name = "barcode")
	private String barCode;

	@Column(name = "productid")
	private Integer productId;

	@Column(name = "categoryid")
	private Integer categoryId;
}
