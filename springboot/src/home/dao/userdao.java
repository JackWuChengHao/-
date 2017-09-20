package home.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import home.entity.User;

public interface userdao extends JpaRepository<User, Long>{

}
