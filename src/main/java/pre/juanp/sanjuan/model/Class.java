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
import pre.juanp.sanjuan.model.dto.administrator.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.administrator.ClassOptionGroupDTO;

@NamedNativeQuery(name = "Class.UpGetAvailableClassOptionList", query = "{call UpGetAvailableClassOptionList}", resultSetMapping = "Mapping.ClassOptionDTO")
@SqlResultSetMapping(name = "Mapping.ClassOptionDTO", classes = @ConstructorResult(targetClass = ClassOptionDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "FamilyId") }))

@NamedNativeQuery(name = "Class.getCurrentClassTagOptionsForCategory", query = "SELECT c.id, c.name, c.familyId FROM Class c WHERE c.categoryId = :CategoryId", resultSetMapping = "Mapping.ClassOptionDTO")

@NamedNativeQuery(name = "Class.getClassOptionGroupList", query = "SELECT cl.[Id], cl.[Name] FROM [Class] cl WHERE cl.[CategoryId] = :CategoryId", resultSetMapping = "Mapping.ClassOptionGroupDTO")
@SqlResultSetMapping(name = "Mapping.ClassOptionGroupDTO", classes = @ConstructorResult(targetClass = ClassOptionGroupDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name") }))

@Entity
@Table(name = "[Class]")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Class implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Code")
	private String code;

	@Column(name = "Name")
	private String name;

	@Column(name = "FamilyId")
	private Integer familyId;

	@Column(name = "CategoryId")
	private Integer categoryId;
}
