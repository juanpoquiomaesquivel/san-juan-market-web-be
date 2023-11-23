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
import pre.juanp.sanjuan.model.dto.CategoryFilterDTO;
import pre.juanp.sanjuan.model.dto.administrator.CategoryOptionDTO;

@NamedNativeQuery(name = "Category.findAllCategoryFilters", query = "SELECT ca.id, ca.name, ca.description FROM Category ca WHERE ca.id > :Id", resultSetMapping = "Mapping.CategoryFilterDTO")
@SqlResultSetMapping(name = "Mapping.CategoryFilterDTO", classes = @ConstructorResult(targetClass = CategoryFilterDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description") }))

@NamedNativeQuery(name = "Category.getCategoryOptionList", query = "SELECT ca.id, ca.name, ca.description FROM Category ca", resultSetMapping = "Mapping.CategoryOptionDTO")
@SqlResultSetMapping(name = "Mapping.CategoryOptionDTO", classes = @ConstructorResult(targetClass = CategoryOptionDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description") }))

@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category implements Serializable {
	
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
}
