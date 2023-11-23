package pre.juanp.sanjuan.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pre.juanp.sanjuan.model.dto.ArticleCardDTO;

@NamedNativeQuery(name = "Article.findAllCardArticles", query = "SELECT a.id, a.name, a.description, a.price, a.stock, a.img, a.barcode, a.productid, p.categoryid FROM Article a INNER JOIN Product p ON a.productid = p.id WHERE a.id > :Id", resultSetMapping = "Mapping.ArticleCardDTO")
@SqlResultSetMapping(name = "Mapping.ArticleCardDTO", classes = @ConstructorResult(targetClass = ArticleCardDTO.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "description"),
		@ColumnResult(name = "price"), @ColumnResult(name = "stock"), @ColumnResult(name = "img"),
		@ColumnResult(name = "barcode"), @ColumnResult(name = "productid"), @ColumnResult(name = "categoryid") }))

@Entity
@Table(name = "Article")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
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

	@Column(name = "Stock")
	private Integer stock;

	@Column(name = "Img")
	private String img;

	@Column(name = "BarCode")
	private String barCode;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "ProductId", referencedColumnName = "Id") private Product
	 * product;
	 */
	@Column(name = "ProductId")
	private Integer productId;
}
