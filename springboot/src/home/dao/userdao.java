package home.dao;

import java.util.List;

import home.entity.User;

public interface userdao extends BaseDao<User>{
		public List<User> users();
}
