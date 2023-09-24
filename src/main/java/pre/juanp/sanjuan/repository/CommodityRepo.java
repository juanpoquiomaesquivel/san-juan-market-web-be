package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Commodity;

public interface CommodityRepo extends JpaRepository<Commodity, String> {

	@Query(value = "SELECT co FROM Commodity co WHERE co.name LIKE %:name%")
	public List<Commodity> findCommoditiesContainingName(@Param("name") String name);

	@Query(value = "SELECT co FROM Commodity co WHERE co.nclass.id = :classId")
	public List<Commodity> getCommoditiesByClass(@Param("classId") String classId);

	@Query(value = "SELECT co FROM Commodity co WHERE co.product.id = :productId")
	public List<Commodity> getCommodityTagsForProduct(@Param("productId") String productId);
	
	@Procedure(name = "UpAddCommodityTagForProduct")
	public void UpAddCommodityTagForProduct(@Param("id") String id, @Param("productId") String productId);
	
	@Procedure(name = "UpRemoveCommodityTagForProduct")
	public void UpRemoveCommodityTagForProduct(@Param("id") String id);
}
