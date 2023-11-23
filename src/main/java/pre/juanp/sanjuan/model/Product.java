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
import pre.juanp.sanjuan.model.dto.ProductFilterDTO;
import pre.juanp.sanjuan.model.dto.administrator.ProductOptionDTO;

@NamedNativeQuery(name = "Product.findAllProductFilters", query = "SELECT p.id, p.name, p.description, p.categoryid AS [categoryfilterid] FROM Product p WHERE p.id > :Id", resultSetMapping = "Mapping.ProductFilterDTO")
@SqlResultSetMapping(name = "Mapping.ProductFilterDTO", classes = @ConstructorResult(targetClass = ProductFilterDTO.class, columns = {
		@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "description"),
		@ColumnResult(name = "categoryfilterid") }))

@NamedNativeQuery(name = "Product.getProductOptionList", query = "SELECT pr.[Id], pr.[Name], pr.[Description] FROM [Product] pr", resultSetMapping = "Mapping.ProductOptionDTO")
@SqlResultSetMapping(name = "Mapping.ProductOptionDTO", classes = @ConstructorResult(targetClass = ProductOptionDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description") }))

@Entity
@Table(name = "Product")
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

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "CategoryId", referencedColumnName = "Id") private
	 * Category category;
	 */
	@Column(name = "CategoryId")
	private Integer categoryId;
}
