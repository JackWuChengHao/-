package com.spring;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;

@Controller
public class Test {
	
	@RequestMapping("toregisterpage")
	public String toregisterpage() {
		return "register";
	}
	
	@RequestMapping("/homepage")
	public String homepage() {
		return "homepage";
	}
	
	@RequestMapping("register")
	public String register() {
		return "index";
	}
	
	
	@RequestMapping("/file")
	public void filein(MultipartFile multipart) {
		System.out.println(multipart.getName());
	}
//	public String register(@Valid User user,BindingResult result){
////		System.out.println("password====="+result.getFieldValue("username")+"=");
////		System.out.println("password====="+result.getFieldValue("password")+"=");
//		if(result.hasErrors()) {s
//			return "register";
//		}
//		return "hello";
//	}
	
	@org.junit.Test
	public  void hh() {
		User s = new User();
		s.setName("123");
		s.setPassword("123123123");
		System.out.println(new GsonBuilder().create().toJson(s)
     );
		
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public JSONObject show(@RequestBody String data){
		System.out.println(data);
//		try {
//			System.out.println(URLDecoder.decode(data, "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		User user  = JSONObject.toJavaObject(User.class);
//		System.out.println(data);
//		System.out.println(user.getName());\
		User user = new GsonBuilder().create().fromJson(data, User.class);
		System.out.println(user.getName());
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("result","success");
		JSONObject jsobject = new JSONObject();
		jsobject.put("result","ok");
		return jsobject;
	}
}
