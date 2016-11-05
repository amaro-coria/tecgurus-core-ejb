package net.tecgurus.core.ejb.business.interf;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.common.dto.CatalogoGeneralDTO;
import net.tecgurus.entities.CatalogoGeneral;

@Local
public interface CatalogoGeneralService {

	List<CatalogoGeneralDTO> findAll();

}
