package home.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;

@RestController
public class welcome {
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
	public String filein(@RequestParam("file") MultipartFile[] multipart,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getHeader("Origin"));
		System.out.println(request.getHeader("Refer"));
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		System.out.println(multipart[0].getName());
		return "ok";
	}
	
	@RequestMapping("/show")
	public JSONObject show(HttpServletRequest request, HttpServletResponse response, @RequestBody String data){
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		System.out.println(data);
//		try {
//			System.out.println(URLDecoder.decode(data, "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		User user  = JSONObject.toJavaObject(User.class);
//		System.out.println(data);
//		System.out.println(user.getName());\
		home.entity.User user = new GsonBuilder().create().fromJson(data, home.entity.User.class);
		System.out.println(user.getName());
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("result","success");
		JSONObject jsobject = new JSONObject();
		jsobject.put("result","ok");
		return jsobject;
	}
}
