package net.tecgurus.core.ejb.business;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.tecgurus.common.dto.ClienteDTO;
import net.tecgurus.common.exceptions.PersistenceException;
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
	
	@Override
	public List<ClienteDTO> findAll(){
		List<Cliente> list;
		try {
			list = daoCte.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			list = null;
		}
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
	
	@Override
	public ClienteDTO findById(Integer id){
		try {
			Cliente c = daoCte.find(Cliente.class, id);
			if(c == null){
				return null;
			}
			ClienteDTO dto = new ClienteDTO();
			dto.setApeMatCte(c.getApeMatCte());
			dto.setApePatCte(c.getApePatCte());
			dto.setDirCte(c.getDirCte());
			dto.setIdCte(c.getIdCte());
			dto.setIdEdoCte(c.getIdEdoCte());
			dto.setNomCte(c.getNomCte());
			dto.setTelCte(c.getTelCte());
			return dto;
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	@Override
	public boolean addCliente(ClienteDTO dto){
		Cliente c = new Cliente();
		c.setApeMatCte(dto.getApeMatCte());
		c.setApePatCte(dto.getApePatCte());
		c.setDirCte(dto.getDirCte());
		c.setIdEdoCte(dto.getIdEdoCte());
		c.setNomCte(dto.getNomCte());
		c.setTelCte(dto.getTelCte());
		try {
			daoCte.create(c);
			return true;
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean editCte(ClienteDTO dto){
		Cliente c = new Cliente();
		c.setApeMatCte(dto.getApeMatCte());
		c.setApePatCte(dto.getApePatCte());
		c.setDirCte(dto.getDirCte());
		c.setIdEdoCte(dto.getIdEdoCte());
		c.setNomCte(dto.getNomCte());
		c.setTelCte(dto.getTelCte());
		try {
			daoCte.update(c);
			return true;
		} catch (PersistenceException e) {
			return false;
		}
	}
	
}
