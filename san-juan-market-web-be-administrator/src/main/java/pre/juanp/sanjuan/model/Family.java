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
import pre.juanp.sanjuan.model.dto.FamilyOptionGroupDTO;

@NamedNativeQuery(name = "Family.UpAdmGetFindFamilyOptionGroupList", query = "{CALL UpAdmGetFindFamilyOptionGroupList}", resultSetMapping = "Mapping.FamilyOptionGroupDTO")
@SqlResultSetMapping(name = "Mapping.FamilyOptionGroupDTO", classes = @ConstructorResult(targetClass = FamilyOptionGroupDTO.class, columns = {
		@ColumnResult(name = "Id"), @ColumnResult(name = "Name") }))
@Entity
@Table(name = "[Family]")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Family implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Code")
	private String code;

	@Column(name = "Name")
	private String name;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "SegmentId", referencedColumnName = "Id") private Segment
	 * segment;
	 */
	@Column(name = "SegmentId")
	private Integer segmentId;
}
