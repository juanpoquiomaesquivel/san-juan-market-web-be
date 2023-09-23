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

	public List<Commodity> getAllCommodities() {
		return repo.findAll();
	}

	public List<Commodity> getCommoditiesByName(String name) {
		return repo.getCommoditiesByName(name);
	}

	public List<Commodity> getCommoditiesByClassId(String classId) {
		return repo.getCommoditiesByClassId(classId);
	}
}
