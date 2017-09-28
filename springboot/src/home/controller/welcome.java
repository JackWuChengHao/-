package home.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
import home.entity.QueryParam;
import home.entity.User;
import home.iter.Season;
import home.util.Util;

@RestController
public class welcome {
	
	@Resource
	private userdao userdaoimpl;
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
//	@RequestMapping("/users")
//	public List<User> test(HttpServletRequest request, HttpServletResponse response ) {
//		System.out.println(request.getHeader("Origin"));
//		System.out.println(request.getHeader("Refer"));
//		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//		return userdaoimpl.users();
//	}
	
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
	
	@RequestMapping("type")
	public List<type> typeselect() {
		List<type> tt = new LinkedList<type>();
		type t = new type();
		t.setValue(Season.SPRING.getVal());
		t.setText(Season.SPRING.getText());
		tt.add(t);
		type tto = new type();
		tto.setValue(Season.SUMMER.getVal());
		tto.setText(Season.SUMMER.getText());
		tt.add(tto);
		type ttt = new type();
		ttt.setValue(Season.AUTOMN.getVal());
		ttt.setText(Season.AUTOMN.getText());
		tt.add(ttt);
		type ttttt = new type();
		ttttt.setValue(Season.WINTOR.getVal());
		ttttt.setText(Season.WINTOR.getText());
		tt.add(ttttt);
		return tt;
	}
	
	@RequestMapping("login")
	public HashMap<String,String> login(ServletRequest request,@RequestBody User user, ServletResponse response) throws ServletException, IOException{
		HashMap<String,String> result =  new HashMap<>();
		List<User> userlist = userdaoimpl.users();
		for (User user2 : userlist) {
			if(user2.getName().equals(user.getName()) && user2.getPassword().equals(user.getPassword()) ) {
				result.put("code","0");
//				HttpServletRequest httprequest =	(HttpServletRequest)request;
//				HttpServletResponse httpresponse = (HttpServletResponse)response;
//				Enumeration<String> test =  httprequest.getHeaderNames();
//				httpresponse.sendRedirect("http://localhost:8080/spring/homepage");
				return result;
			}else {
				continue;
			}
		}
		result.put("code","-1");
		result.put("message","用户名或者密码错误");
		return result;
	}
	
	@RequestMapping("users")
	public  Map<String,Object> userlist(HttpServletRequest httpServletRequest) {
//		QueryParam queryParam = Util.GetQueryParam(httpServletRequest);
		 Map<String, String[]> httpparam = httpServletRequest.getParameterMap();
		Map<String,Object> result  = new HashMap<>();
		List<User> rows = userdaoimpl.users();
		result.put("total", 7);
		result.put("rows", rows);
		return result;
	}
}


class type{
	
	private int value;
	
	private String text;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}