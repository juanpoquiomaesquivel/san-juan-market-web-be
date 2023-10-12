package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Segment;

public interface SegmentRepo extends JpaRepository<Segment, Integer> {

	@Query(value = "SELECT s FROM Segment s WHERE s.name LIKE %:Name%")
	public List<Segment> findSegmentsContainingName(@Param("Name") String name);

	@Query(value = "SELECT s FROM Segment s WHERE s.code = :Code")
	public Segment getSegmentByCode(@Param("Code") String code);
}
