package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.CategoryFilterDTO;
import pre.juanp.sanjuan.repository.CategoryRepo;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo repo;

	public List<CategoryFilterDTO> findCategoryFilterListExcept(Integer categoryId) {
		return repo.findCategoryFilterListExcept(categoryId);
	}
}