package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Commodity;
import pre.juanp.sanjuan.model.dto.administrator.CommodityOptionDTO;

public interface CommodityRepo extends JpaRepository<Commodity, Integer> {

	@Query(value = "SELECT co FROM Commodity co WHERE co.name LIKE %:name%")
	public List<Commodity> findCommoditiesContainingName(@Param("name") String name);

	@Query(value = "SELECT co FROM Commodity co WHERE co.code = :Code")
	public Commodity getCommodityByCode(@Param("Code") String code);

	@Query(value = "SELECT co FROM Commodity co WHERE co.classId = :ClassId")
	public List<Commodity> getCommoditiesByClass(@Param("ClassId") Integer classId);

	@Query(value = "SELECT co.id FROM Commodity co WHERE co.productId = :ProductId")
	public List<Integer> getCommodityTagsForProduct(@Param("ProductId") Integer productId);
	
	@Procedure(name = "UpAddCommodityTagForProduct")
	public void UpAddCommodityTagForProduct(@Param("ProductId") Integer productId, @Param("CommodityIdArray") String commodityIdArray);
	
	@Procedure(name = "UpRemoveCommodityTagForProduct")
	public void UpRemoveCommodityTagForProduct(@Param("CommodityIdArray") String commodityIdArray);
	
	@Query(nativeQuery = true) // ok
	public List<CommodityOptionDTO> UpGetAvailableCommodityOptionList(@Param("ClassIdArray") String classIdArray);
	
	@Query(nativeQuery = true)
	public List<CommodityOptionDTO> getCurrentCommodityTagOptionsForProduct(@Param("ProductId") Integer productId);
}
