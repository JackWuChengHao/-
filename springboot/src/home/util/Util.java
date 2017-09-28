package home.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import home.entity.QueryParam;

public class Util {
	
	@Autowired
	private static QueryParam queryParam;
	
	public QueryParam getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(QueryParam queryParam) {
		Util.queryParam = queryParam;
	}

	public synchronized static QueryParam GetQueryParam(HttpServletRequest httpServletRequest) {
		queryParam.setLimit(Integer.valueOf(httpServletRequest.getParameter("limit")));
		queryParam.setOffset(Integer.valueOf(httpServletRequest.getParameter("offset")));
		queryParam.setOrder((String)httpServletRequest.getParameter("order"));
		queryParam.setSort((String)httpServletRequest.getParameter("sort"));
		return queryParam;
	} 
}
