package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.ProductFilterDTO;
import pre.juanp.sanjuan.repository.ProductRepo;

@Service
public class ProductServ {

	@Autowired
	private ProductRepo repo;

	public List<ProductFilterDTO> findProductFilterListExcept(Integer productId) {
		return repo.findProductFilterListExcept(productId);
	}
}