package net.tecgurus.core.ejb.business;

import javax.ejb.Stateless;
import net.tecgurus.core.ejb.business.interf.HolaMundo3;

/**
 * Session Bean implementation class HolaMundo3Bean
 */
@Stateless
public class HolaMundo3Bean implements HolaMundo3 {

	@Override
    public String saludaTambienTu(){
    	return "Hola mundo 3";
    }

}
