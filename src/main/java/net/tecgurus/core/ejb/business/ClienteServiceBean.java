package net.tecgurus.core.ejb.business;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.tecgurus.common.dto.ClienteDTO;
import net.tecgurus.core.ejb.business.inter.ClienteService;
import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.dao.ClienteDAO;

/**
 * Session Bean implementation class ClienteServiceBean
 */
@Stateless
public class ClienteServiceBean implements ClienteService {

	@EJB
   private ClienteDAO daoCte;

	@Override
	public List<ClienteDTO> findByName(String name){
		List<Cliente> list = daoCte.findByName(name);
		if(list == null){
			return new LinkedList<>();
		}
		List<ClienteDTO> listDTO = new LinkedList<>();
		for(Cliente c : list){
			ClienteDTO dto = new ClienteDTO();
			dto.setApeMatCte(c.getApeMatCte());
			dto.setApePatCte(c.getApePatCte());
			dto.setDirCte(c.getDirCte());
			dto.setIdCte(c.getIdCte());
			dto.setIdEdoCte(c.getIdEdoCte());
			dto.setNomCte(c.getNomCte());
			dto.setTelCte(c.getTelCte());
			listDTO.add(dto);
		}
		return listDTO;
	}
	
}
