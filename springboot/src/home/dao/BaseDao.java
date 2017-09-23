package home.dao;

import java.io.Serializable;

import org.hibernate.Session;

public interface BaseDao <T>{
	public Session getSession();
	
	public T get(Serializable id);

	public void merge(T t);

	public void clear();

	public void toDetached(T t);
	
	public void delete(T t);

	public void close();
}
