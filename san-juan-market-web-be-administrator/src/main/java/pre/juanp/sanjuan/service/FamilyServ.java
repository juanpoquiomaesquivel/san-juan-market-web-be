package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.FamilyOptionGroupDTO;
import pre.juanp.sanjuan.repository.FamilyRepo;

@Service
public class FamilyServ {

	@Autowired
	private FamilyRepo repo;

	public List<FamilyOptionGroupDTO> getFindFamilyOptionGroupList() {
		return repo.UpAdmGetFindFamilyOptionGroupList();
	}
}
