package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Commodity;
import pre.juanp.sanjuan.model.dto.CommodityOptionDTO;
import pre.juanp.sanjuan.model.dto.CommodityOptionGroupDTO;

public interface CommodityRepo extends JpaRepository<Commodity, Integer> {

	@Query(nativeQuery = true)
	public List<CommodityOptionDTO> UpAdmGetFindAvailableCommodityOptionList(@Param("JsonClassTagIdArray") String jsonClassTagIdArray);

	@Query(nativeQuery = true)
	public List<CommodityOptionDTO> UpAdmGetFindUnavailableCommodityOptionList(@Param("JsonClassTagIdArray") String jsonClassTagIdArray);
	
	@Query(value = "SELECT co.id FROM Commodity co WHERE co.productId = :ProductId")
	public List<Integer> findCommodityTagListOfProduct(@Param("ProductId") Integer productId);
	
	@Procedure(name = "UpAdmPutAddCommodityTagForProduct")
	public void UpAdmPutAddCommodityTagForProduct(@Param("JsonCommodityTagIdArray") String jsonCommodityTagIdArray, @Param("ProductId") Integer productId);
	
	@Procedure(name = "UpAdmPutRemoveCommodityTagForProduct")
	public void UpAdmPutRemoveCommodityTagForProduct(@Param("JsonCommodityTagIdArray") String jsonCommodityTagIdArray);
	
	@Query(nativeQuery = true)
	public List<CommodityOptionGroupDTO> findCommodityOptionGroupListOfProduct(@Param("ProductId") Integer productId);
}
