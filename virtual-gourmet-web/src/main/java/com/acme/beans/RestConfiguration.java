/**
 * 
 */
package com.acme.beans;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Defines the general configuration for the services
 * 
 * @author jhsuarez
 *
 */
@ApplicationPath("/virtual-gourmet-rest")
public class RestConfiguration extends Application
{

	/*
	 * (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(ServicioRest.class));
	}
}
