package pre.juanp.sanjuan.model.dto.administrator;

import javax.persistence.Column;

import lombok.Value;

@Value
public class CommodityOptionDTO {

	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "ClassId")
	private Integer classId;
}
