package com.google.login.dao;

import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * Generic Service for SQL CRUD operations.
 *
 * @param <T> Type
 */
public interface GenericService <T>{

	/**
	 * Get the Type list based on query and class type.
	 * @param query String
	 * @param type Class<T>
	 * @return List<T> type<T> list
	 */
	public List<T> getTypes(String query, Class<T> type);

	/**
	 * Get Element based on Query,ResultSetHandler and Parameters.
	 * @param query String
	 * @param rsh ResultSetHandler
	 * @param params Object
	 * @return List<T>
	 */
	public List<T> getListTypes(String query, ResultSetHandler<List<T>> rsh,Object... params);
	
	/**
	 * Get Element based on Query,ResultSetHandler and Parameters.
	 * @author vijay
	 * @param query String
	 * @param rsh ResultSetHandler
	 * @param params Object
	 * @return T
	 */
	public T getTypes(String query, ResultSetHandler<T> rsh,Object... params);
	
	
	/**
	 * Get Element based on Query,ResultSetHandler.
	 * @param query String
	 * @param rsh ResultSetHandler
	 * @return T
	 */
	public T getTypes(String query, ResultSetHandler<T> rsh);
	
	
	/**
	 * Get Type list based on query, class type and params.
	 * @param query Query
	 * @param clazz Class<T>
	 * @param params Object
	 * @return List<T>
	 */
	public List<T> getTypes(String query, Class<T> clazz,Object... params) ;

	/**
	 *  Insert the values in database based on query, class type and params.
	 * @param query Query
	 * @param clazz Class<T>
	 * @param params
	 * @return T
	 */
	public T insertType(String query, Class<T> clazz, Object... params);
	
	/**
	 * Insert the values in database based on query, ResultSetHandler and params.
	 * @param query Query
	 * @param rsh ResultSetHandler<T>
	 * @param params Object
	 * @return T
	 */
	public  T insertType(String query,ResultSetHandler<T> rsh,Object... params);

	/**
	 * Update the database based on query and params.
	 * @param query Query
	 * @param params Object
	 * @return Integer
	 */
	public Integer updateType(String query,Object... params);
	
	/**
	 * Update the database based on query,ResultSetHandler and params.
	 * @param query Query
	 * @param rsh ResultSetHandler<T>
	 * @param params Object
	 * @return Integer
	 */
	public Integer updateType(String query,ResultSetHandler<T> rsh,Object... params);

	/**
	 * Delete the row based on query and params.
	 * @param query Query
	 * @param params Object
	 * @return Integer
	 */
	public Integer deleteType(String query,Object... params);
	
	
	/**
	 * 
	 * Moves from-value to postion of to-value, based on the tableId of the row which we want to move,
	 * Also specify tableColumn name, tableName and sequenceColumn name.
	 * updateWhere is the optional parameter which can be used for adding filter while updating sequence order
	 * 
	 * @param from
	 * @param to
	 * @param tableID
	 * @param tableColumnName
	 * @param tableName
	 * @param seqColumnName
	 * @param updateWhere
	 */
	public boolean reorderData(final int from, final int to, String tableID, String tableColumnName, String tableName, String seqColumnName, String updateWhere);
	
	
	/**
	 * 
	 * Moves from-value to postion of to-value, based on the tableId of the row which we want to move,
	 * Also specify tableColumn name, tableName and sequenceColumn name
	 * 
	 * 
	 * @param from
	 * @param to
	 * @param tableID
	 * @param tableColumnName
	 * @param tableName
	 * @param seqColumnName
	 * @return 
	 */
	public boolean reorderData(final int from, final int to, String tableID, String tableColumnName, String tableName, String seqColumnName);
}
