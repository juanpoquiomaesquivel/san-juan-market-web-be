package pre.juanp.sanjuan.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "art_code")
	private String code;

	@Column(name = "art_name")
	private String name;

	@Column(name = "art_description")
	private String description;

	@Column(name = "art_price")
	private BigDecimal price;

	@Column(name = "art_stock")
	private Integer stock;

	@Column(name = "art_img")
	private String img;

	@Column(name = "bar_code")
	private String barCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code")
	private Product product;
}