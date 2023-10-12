package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.Commodity;
import pre.juanp.sanjuan.service.CommodityServ;

@RestController
@RequestMapping("/commodity/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CommodityCtrl {

	@Autowired
	private CommodityServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<Commodity>> findAllCommodities() throws Exception {
		Optional<List<Commodity>> coms = Optional.ofNullable(serv.findAllCommodities());

		if (coms.isEmpty()) {
			throw new Exception("There is no commodities.");
		}

		return ResponseEntity.ok(coms.get());
	}

	@GetMapping("/get/byname")
	public ResponseEntity<List<Commodity>> findCommoditiesContainingName(@RequestParam("Name") String name)
			throws Exception {
		Optional<List<Commodity>> coms = Optional.ofNullable(serv.findCommoditiesContainingName(name));

		if (coms.isEmpty()) {
			throw new Exception("There is no commodity with a name alike.");
		}

		return ResponseEntity.ok(coms.get());
	}

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<Commodity> getCommodityByCode(@PathVariable("Code") String code) throws Exception {
		Optional<Commodity> commodity = Optional.ofNullable(serv.getCommodityByCode(code));

		if (commodity.isEmpty()) {
			throw new Exception("There is no commodity associated with the provided code.");
		}

		return ResponseEntity.ok(commodity.get());
	}

	@GetMapping("/get/byclass/{ClassId}")
	public ResponseEntity<List<Commodity>> getCommoditiesByClass(@PathVariable("ClassId") Integer classId)
			throws Exception {
		Optional<List<Commodity>> coms = Optional.ofNullable(serv.getCommoditiesByClass(classId));

		if (coms.isEmpty()) {
			throw new Exception("There is no commodity associated with the provided family.");
		}

		return ResponseEntity.ok(coms.get());
	}

	@GetMapping("/get/forproduct/{ProductId}")
	public ResponseEntity<List<Commodity>> getCommodityTagsForProduct(@PathVariable("ProductId") Integer productId)
			throws Exception {
		Optional<List<Commodity>> coms = Optional.ofNullable(serv.getCommodityTagsForProduct(productId));

		if (coms.isEmpty()) {
			throw new Exception("There is no commodity associated with the provided product.");
		}

		return ResponseEntity.ok(coms.get());
	}

	@PutMapping("/put/commoditytag/add")
	public ResponseEntity<String> addCommodityTagForProduct(@RequestParam("Id") Integer id,
			@RequestParam("ProductId") Integer productId) {
		try {
			serv.addCommodityTagForProduct(id, productId);

			return ResponseEntity.ok("[Commodity Tag For Product Added] Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@PutMapping("/put/commoditytag/remove")
	public ResponseEntity<String> removeCommodityTagForProduct(@RequestParam("Id") Integer id) {
		try {
			serv.removeCommodityTagForProduct(id);

			return ResponseEntity.ok("[Commodity Tag For Product Removed] Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}
}
