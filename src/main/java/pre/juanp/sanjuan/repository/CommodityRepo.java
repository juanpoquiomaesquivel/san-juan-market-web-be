package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Commodity;

public interface CommodityRepo extends JpaRepository<Commodity, Integer> {

	@Query(value = "SELECT co FROM Commodity co WHERE co.name LIKE %:name%")
	public List<Commodity> findCommoditiesContainingName(@Param("name") String name);

	@Query(value = "SELECT co FROM Commodity co WHERE co.code = :Code")
	public Commodity getCommodityByCode(@Param("Code") String code);

	@Query(value = "SELECT co FROM Commodity co WHERE co.nclass.id = :ClassId")
	public List<Commodity> getCommoditiesByClass(@Param("ClassId") Integer classId);

	@Query(value = "SELECT co FROM Commodity co WHERE co.product.id = :ProductId")
	public List<Commodity> getCommodityTagsForProduct(@Param("ProductId") Integer productId);
	
	@Procedure(name = "UpAddCommodityTagForProduct")
	public void UpAddCommodityTagForProduct(@Param("Id") Integer id, @Param("ProductId") Integer productId);
	
	@Procedure(name = "UpRemoveCommodityTagForProduct")
	public void UpRemoveCommodityTagForProduct(@Param("Id") Integer id);
}
