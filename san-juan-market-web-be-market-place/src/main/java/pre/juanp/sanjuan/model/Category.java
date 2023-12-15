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

@NamedNativeQuery(name = "Category.findCategoryFilterListExcept", query = "SELECT [Id], [Name], [Description], [Image] FROM [Category] WHERE [Id] > :CategoryId", resultSetMapping = "Mapping.CategoryFilterDTO")
@SqlResultSetMapping(name = "Mapping.CategoryFilterDTO", classes = @ConstructorResult(targetClass = CategoryFilterDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "Description"), @ColumnResult(name = "Image") }))

@Entity
@Table(name = "[Category]")
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
	
	@Column(name = "Image")
	private String image;
}
