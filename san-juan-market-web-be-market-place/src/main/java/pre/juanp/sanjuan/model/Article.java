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

@NamedNativeQuery(name = "Article.findArticleCardListExcept", query = "SELECT a.[Id], a.[Name], a.[Description], a.[Price], a.[Image], a.[BarCode], a.[ProductId], p.[CategoryId] FROM [Article] a INNER JOIN [Product] p ON a.[ProductId] = p.[Id] WHERE a.[Id] > :ArticleId", resultSetMapping = "Mapping.ArticleCardDTO")
@SqlResultSetMapping(name = "Mapping.ArticleCardDTO", classes = @ConstructorResult(targetClass = ArticleCardDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description"),
		@ColumnResult(name = "Price"), @ColumnResult(name = "Image"), @ColumnResult(name = "BarCode"),
		@ColumnResult(name = "ProductId"), @ColumnResult(name = "CategoryId") }))

@Entity
@Table(name = "[Article]")
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

	@Column(name = "Image")
	private String image;

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
