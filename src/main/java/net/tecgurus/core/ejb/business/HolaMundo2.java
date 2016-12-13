package net.tecgurus.core.ejb.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HolaMundo2
 */
@Stateless
@LocalBean
public class HolaMundo2 {

    public String saludaTambien(){
    	return "Hola mundo 2";
    }

}
