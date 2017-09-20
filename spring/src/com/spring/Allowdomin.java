package com.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Allowdomin implements HandlerInterceptor {

    private List<String> excludedUrls;

    public List<String> getExcludedUrls() {
        return excludedUrls;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    /**
     * 
     * ��ҵ��������������֮ǰ������ �������false 
     * �ӵ�ǰ������������ִ��������������afterCompletion(),
     * ���˳���������, �������true ִ����һ��������,
     * ֱ�����е���������ִ����� ��ִ�б����ص�Controller
     * Ȼ�������������,
     * �����һ������������ִ�����е�postHandle()
     * �����ٴ����һ������������ִ�����е�afterCompletion()
     * 
     * @param  request
     * 
     * @param  response
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
    	System.out.println("setting okokok");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
        return true;
    }

    // ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    /**
     * 
     * ��DispatcherServlet��ȫ����������󱻵���
     * �����������׳��쳣ʱ,
     * ��ӵ�ǰ����������ִ�����е���������afterCompletion()
     * 
     * @param request
     * 
     * @param response
     * 
     * @param handler
     * 
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {

    }
}

