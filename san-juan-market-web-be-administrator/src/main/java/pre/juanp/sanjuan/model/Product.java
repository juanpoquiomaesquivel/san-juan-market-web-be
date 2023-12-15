package pre.juanp.sanjuan.model;

import java.io.Serializable;

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
import pre.juanp.sanjuan.model.dto.ProductItemDTO;
import pre.juanp.sanjuan.model.dto.ProductOptionDTO;

@NamedNativeQuery(name = "Product.findProductItemList", query = "SELECT p.[Id], p.[Code], p.[Name], p.[Description], p.[Image], c.[Name] as [Category] FROM [Product] p INNER JOIN [Category] c ON p.[CategoryId] = c.[Id]", resultSetMapping = "Mapping.ProductItemDTO")
@SqlResultSetMapping(name = "Mapping.ProductItemDTO", classes = @ConstructorResult(targetClass = ProductItemDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Code"), @ColumnResult(name = "Name"),
		@ColumnResult(name = "Description"), @ColumnResult(name = "Image"), @ColumnResult(name = "Category") }))

@NamedNativeQuery(name = "Product.findProductOptionList", query = "SELECT [Id], [Name], [Description] FROM [Product]", resultSetMapping = "Mapping.ProductOptionDTO")
@SqlResultSetMapping(name = "Mapping.ProductOptionDTO", classes = @ConstructorResult(targetClass = ProductOptionDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description") }))

@Entity
@Table(name = "[Product]")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product implements Serializable {

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

	@Column(name = "Image")
	private String image;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "CategoryId", referencedColumnName = "Id") private
	 * Category category;
	 */
	@Column(name = "CategoryId")
	private Integer categoryId;
}
