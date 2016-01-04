package com.edia.tsearch.data.util;

import java.util.List;

import com.edia.tsearch.data.domain.Texture;

public interface IDbRepository <Customer> {

	public void saveOrUpdate(Texture texture) ;
	
	/**
	 * gets all objects as list
	 * @return
	 */
	public List<Texture> getAll() ;

	/**
	 * gets selected id object from database 
	 * 
	 * @param id
	 * @return
	 */
	public Texture getSelectedId(long id);
}
