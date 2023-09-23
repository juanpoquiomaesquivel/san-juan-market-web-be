package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.Commodity;
import pre.juanp.sanjuan.service.CommodityServ;

@RestController
@RequestMapping("/commodity/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CommodityCtrl {

	@Autowired
	private CommodityServ serv;

	@GetMapping("/all")
	public ResponseEntity<List<Commodity>> getAllCommodities() {
		List<Commodity> commodities = serv.getAllCommodities();

		return ResponseEntity.ok(commodities);
	}

	@GetMapping("/byname/{name}")
	public ResponseEntity<List<Commodity>> getCommoditiesByName(@PathVariable("name") String name) throws Exception {
		Optional<List<Commodity>> commodities = Optional.ofNullable(serv.getCommoditiesByName(name));

		if (commodities.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(commodities.get());
	}

	@GetMapping("/byclassid/{classId}")
	public ResponseEntity<List<Commodity>> getCommoditiesByClassId(@PathVariable("classId") String classId)
			throws Exception {
		Optional<List<Commodity>> commodities = Optional.ofNullable(serv.getCommoditiesByClassId(classId));

		if (commodities.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(commodities.get());
	}
}
