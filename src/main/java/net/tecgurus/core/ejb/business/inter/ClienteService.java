package net.tecgurus.core.ejb.business.inter;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.common.dto.ClienteDTO;

@Local
public interface ClienteService {

	List<ClienteDTO> findByName(String name);

	List<ClienteDTO> findAll();

	boolean addCliente(ClienteDTO dto);

	boolean editCte(ClienteDTO dto);

	ClienteDTO findById(Integer id);

}
