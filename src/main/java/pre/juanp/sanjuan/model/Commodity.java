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
import pre.juanp.sanjuan.model.dto.administrator.CommodityOptionDTO;

@NamedNativeQuery(name = "Commodity.UpGetAvailableCommodityOptionList", query = "{call UpGetAvailableCommodityOptionList(:ClassIdArray)}", resultSetMapping = "Mapping.CommodityOptionDTO")
@SqlResultSetMapping(name = "Mapping.CommodityOptionDTO", classes = @ConstructorResult(targetClass = CommodityOptionDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name"), @ColumnResult(name = "ClassId") }))

@NamedNativeQuery(name = "Commodity.getCurrentCommodityTagOptionsForProduct", query = "SELECT Co.[Id], Co.[Name], Co.[ClassId] FROM [Commodity] Co WHERE Co.[ProductId] = :ProductId", resultSetMapping = "Mapping.CommodityOptionDTO")

@Entity
@Table(name = "Commodity")
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
