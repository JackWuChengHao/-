package home.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import home.dao.userdao;
import home.entity.User;


@Repository("userdaoimpl")
public class userdaoimpl extends BaseDaoImpl<User> implements userdao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> users() {
		String hql = "select u from User u";
		return getSession().createQuery(hql).list();
	}
		
}
