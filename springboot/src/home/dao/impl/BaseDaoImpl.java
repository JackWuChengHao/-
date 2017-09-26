package home.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import home.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	
private Class<T> clazz;//创建一个Class对象来获取泛型的class
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
	@Autowired
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public Session getSession() {
		return getSessionfactory().openSession();
	}

	@Override
	public T get(Serializable id) {
		return getSession().get(clazz, id);
	}
	
	@Override
	public void merge(T t) {
		if(t!= null){
			getSession().merge(t);
		}
	}
	
	@Override
	public void clear() {
		getSession().clear();
	}
	
	@Override
	public void toDetached(T t) {
		getSession().evict(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getSession().delete(t);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		getSession().close();
	}

}
