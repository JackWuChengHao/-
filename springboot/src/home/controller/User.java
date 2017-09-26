package home.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import home.dao.userdao;

@RestController
public class User {
	
	@Resource
	private userdao ud;
	
	public userdao getUd() {
		return ud;
	}

	public void setUd(userdao ud) {
		this.ud = ud;
	}

//	@RequestMapping("users")
//	public List<home.entity.User> users(){
//		return ud.users();
//	}
	
}
