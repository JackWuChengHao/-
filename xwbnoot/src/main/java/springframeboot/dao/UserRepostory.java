package springframeboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springframeboot.entity.User;

public interface UserRepostory extends JpaRepository<User,Integer> {

}

