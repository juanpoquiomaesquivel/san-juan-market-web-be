package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Commodity;
import pre.juanp.sanjuan.repository.CommodityRepo;

@Service
public class CommodityServ {

	@Autowired
	private CommodityRepo repo;

	public List<Commodity> findAllCommodities() {
		return repo.findAll();
	}

	public List<Commodity> findCommoditiesContainingName(String name) {
		return repo.findCommoditiesContainingName(name);
	}

	public Commodity getCommodityByCode(String code) {
		return repo.getCommodityByCode(code);
	}
	
	public List<Commodity> getCommoditiesByClass(Integer classId) {
		return repo.getCommoditiesByClass(classId);
	}
	
	public List<Commodity> getCommodityTagsForProduct(Integer productId) {
		return repo.getCommodityTagsForProduct(productId);
	}
	
	public void addCommodityTagForProduct(Integer id, Integer productId) {
		repo.UpAddCommodityTagForProduct(id, productId);
	}
	
	public void removeCommodityTagForProduct(Integer id) {
		repo.UpRemoveCommodityTagForProduct(id);
	}
}
