package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.CommodityOptionDTO;
import pre.juanp.sanjuan.model.dto.CommodityOptionGroupDTO;
import pre.juanp.sanjuan.model.dto.util.Message;
import pre.juanp.sanjuan.service.CommodityServ;

@RestController
@RequestMapping("/commodity/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class CommodityCtrl {

	@Autowired
	private CommodityServ serv;

	@GetMapping("/get/commodity-option/of-classes/available/all")
	public ResponseEntity<List<CommodityOptionDTO>> getFindAvailableCommodityOptionList(
			@RequestParam("JsonClassTagIdArray") String jsonClassTagIdArray) throws Exception {
		Optional<List<CommodityOptionDTO>> list = Optional
				.ofNullable(serv.getFindAvailableCommodityOptionList(jsonClassTagIdArray));

		if (list.isEmpty()) {
			throw new Exception("getFindAvailableCommodityOptionList");
		}

		return ResponseEntity.ok(list.get());
	} // ok

	@GetMapping("/get/commodity-option/of-classes/unavailable/all")
	public ResponseEntity<List<CommodityOptionDTO>> getFindUnavailableCommodityOptionList(
			@RequestParam("JsonClassTagIdArray") String jsonClassTagIdArray) throws Exception {
		Optional<List<CommodityOptionDTO>> list = Optional
				.ofNullable(serv.getFindUnavailableCommodityOptionList(jsonClassTagIdArray));

		if (list.isEmpty()) {
			throw new Exception("getFindAvailableCommodityOptionList");
		}

		return ResponseEntity.ok(list.get());
	} // ok

	@GetMapping("/get/commodity-tag/of-product/{ProductId}/all")
	public ResponseEntity<List<Integer>> findCommodityTagListOfProduct(
			@PathVariable("ProductId") Integer productId) throws Exception {
		Optional<List<Integer>> list = Optional.ofNullable(serv.findCommodityTagListOfProduct(productId));

		if (list.isEmpty()) {
			throw new Exception("findCommodityTagListOfProduct");
		}

		return ResponseEntity.ok(list.get());
	} // ok

	@PutMapping("/put/commodity-tag/of-product/{ProductId}/add")
	public ResponseEntity<Message> putAddCommodityTagForProduct(@PathVariable("ProductId") Integer productId,
			@RequestBody String jsonCommodityTagIdArray) {
		serv.putAddCommodityTagForProduct(jsonCommodityTagIdArray, productId);

		return ResponseEntity.ok(new Message(101, "Tags de producto agregado."));
	} // ok

	@PutMapping("/put/commodity-tag/remove")
	public ResponseEntity<Message> putRemoveCommodityTagForProduct(@RequestBody String jsonCommodityTagIdArray) {
		serv.putRemoveCommodityTagForProduct(jsonCommodityTagIdArray);

		return ResponseEntity.ok(new Message(101, "Tags de producto eliminado."));
	} // ok

	@GetMapping("/get/optiongroup/ofproduct/{ProductId}/all")
	public ResponseEntity<List<CommodityOptionGroupDTO>> findCommodityOptionGroupListOfProduct(
			@PathVariable("ProductId") Integer productId) throws Exception {
		Optional<List<CommodityOptionGroupDTO>> list = Optional
				.ofNullable(serv.findCommodityOptionGroupListOfProduct(productId));

		if (list.isEmpty()) {
			throw new Exception("findCommodityOptionGroupListOfProduct");
		}

		return ResponseEntity.ok(list.get());
	}
}
