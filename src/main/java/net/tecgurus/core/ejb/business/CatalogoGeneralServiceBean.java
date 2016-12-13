package net.tecgurus.core.ejb.business;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.tecgurus.common.dto.CatalogoGeneralDTO;
import net.tecgurus.core.ejb.business.interf.CatalogoGeneralService;
import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.dao.CatalogoGeneralDAO;

/**
 * Session Bean implementation class CatalogoGeneralServiceBean
 */
@Stateless
public class CatalogoGeneralServiceBean implements CatalogoGeneralService {

	@EJB
	private CatalogoGeneralDAO daoCat;
	
	@Override
    public List<CatalogoGeneralDTO> findAll(){
    	List<CatalogoGeneral> list = daoCat.findAll();
    	if(list == null){
    		return new LinkedList<>();
    	}
    	List<CatalogoGeneralDTO> listDTO = new LinkedList<>();
    	for(CatalogoGeneral c : list){
    		CatalogoGeneralDTO dto = new CatalogoGeneralDTO();
    		dto.setDscComCat(c.getDscComCat());
    		dto.setDscCorCat(c.getDscCorCat());
    		dto.setFchCre(c.getFchCre());
    		dto.setFchMod(c.getFchMod());
    		dto.setIdCat(c.getIdCat());
    		dto.setIdEstCat(c.getIdEstCat());
    		listDTO.add(dto);
    	}
    	return listDTO;
    }

}
