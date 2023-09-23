package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Commodity;

public interface CommodityRepo extends JpaRepository<Commodity, String> {

	@Query(value = "SELECT co FROM Commodity co WHERE co.name LIKE '%' + :name + '%'")
	public List<Commodity> getCommoditiesByName(@Param("name") String name);

	@Query(value = "SELECT co FROM Commodity co WHERE co.nclass.id = :classId")
	public List<Commodity> getCommoditiesByClassId(@Param("classId") String classId);
}
