package home.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import home.dao.userdao;
import home.entity.User;

@RestController
public class welcome {
	
	@Resource
	private userdao ud;
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/users")
	public String test(HttpServletRequest request, HttpServletResponse response ) {
		System.out.println(request.getHeader("Origin"));
		System.out.println(request.getHeader("Refer"));
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		return "123123";
	}
	
	@RequestMapping("/file")
	public JSONObject filein(@RequestParam("txt_file") MultipartFile[] multipartarray,HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		System.out.println(request.getHeader("Origin"));
//		System.out.println(request.getHeader("Refer"));
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		for (MultipartFile multipartFile : multipartarray) {
			System.out.println(multipartFile.getName());
			multipartFile.transferTo(new File("c:/"+multipartFile.getOriginalFilename()));
		}
		JSONObject result = new JSONObject();
		result.put("result","0");
		return result;
	}
	
	@RequestMapping("/show")
	public JSONObject show(HttpServletRequest request, HttpServletResponse response, @RequestBody String data){
//		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		System.out.println(data);
		List<User> userlist = JSON.parseArray(data,User.class);
		for (User user : userlist) {
			System.out.println(user.getName());
		}
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("result","success");
		JSONObject jsobject = new JSONObject();
		jsobject.put("code","0");
		return jsobject;
	}
	
	
	@RequestMapping("userlist")
	public List<User> userlist() {
		return ud.findAll();
	}
	
}
