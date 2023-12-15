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
import pre.juanp.sanjuan.model.dto.CommodityOptionDTO;
import pre.juanp.sanjuan.model.dto.CommodityOptionGroupDTO;

@NamedNativeQuery(name = "Commodity.UpAdmGetFindAvailableCommodityOptionList", query = "{call UpAdmGetFindAvailableCommodityOptionList(:JsonClassTagIdArray)}", resultSetMapping = "Mapping.CommodityOptionDTO")
@NamedNativeQuery(name = "Commodity.UpAdmGetFindUnavailableCommodityOptionList", query = "{call UpAdmGetFindUnavailableCommodityOptionList(:JsonClassTagIdArray)}", resultSetMapping = "Mapping.CommodityOptionDTO")
@SqlResultSetMapping(name = "Mapping.CommodityOptionDTO", classes = @ConstructorResult(targetClass = CommodityOptionDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "ClassId") }))

@NamedNativeQuery(name = "Commodity.findCommodityOptionGroupListOfProduct", query = "SELECT [Id], [Name] FROM [Commodity] WHERE [ProductId] = :ProductId", resultSetMapping = "Mapping.CommodityOptionGroupDTO")
@SqlResultSetMapping(name = "Mapping.CommodityOptionGroupDTO", classes = @ConstructorResult(targetClass = CommodityOptionGroupDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name") }))
@Entity
@Table(name = "[Commodity]")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Commodity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Code")
	private String code;

	@Column(name = "Name")
	private String name;

	@Column(name = "ClassId")
	private Integer classId;

	@Column(name = "ProductId")
	private Integer productId;
}
