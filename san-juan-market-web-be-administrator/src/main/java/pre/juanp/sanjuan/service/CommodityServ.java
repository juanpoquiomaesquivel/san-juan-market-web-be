package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.CommodityOptionDTO;
import pre.juanp.sanjuan.model.dto.CommodityOptionGroupDTO;
import pre.juanp.sanjuan.repository.CommodityRepo;

@Service
public class CommodityServ {

	@Autowired
	private CommodityRepo repo;

	public List<CommodityOptionDTO> getFindAvailableCommodityOptionList(String jsonClassTagIdArray) {
		return repo.UpAdmGetFindAvailableCommodityOptionList(jsonClassTagIdArray);
	}

	public List<CommodityOptionDTO> getFindUnavailableCommodityOptionList(String jsonClassTagIdArray) {
		return repo.UpAdmGetFindUnavailableCommodityOptionList(jsonClassTagIdArray);
	}

	public List<Integer> findCommodityTagListOfProduct(Integer productId) {
		return repo.findCommodityTagListOfProduct(productId);
	}

	public void putAddCommodityTagForProduct(String jsonCommodityTagIdArray, Integer productId) {
		repo.UpAdmPutAddCommodityTagForProduct(jsonCommodityTagIdArray, productId);
	}

	public void putRemoveCommodityTagForProduct(String jsonCommodityTagIdArray) {
		repo.UpAdmPutRemoveCommodityTagForProduct(jsonCommodityTagIdArray);
	}
	
	public List<CommodityOptionGroupDTO> findCommodityOptionGroupListOfProduct(Integer productId) {
		return repo.findCommodityOptionGroupListOfProduct(productId);
	}
}
