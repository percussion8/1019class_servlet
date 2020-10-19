package green;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet{
	
	ServletConfig config; //서블릿환경에 대한부분을 관리

	@Override
	public void destroy() {
		System.out.println("destory() 실행");
		
	}

	public ServletConfig getServletConfig() {
		System.out.println("getServiceConfig() called");
	     return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServiceInfo() 실행");
		return "version=1.0; author=Monica; copyright=Monica2020";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
		this.config = config; //init하면 자동으로 정보 채워짐
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//service에서 do-get, do-post로 전달
		System.out.println("service() 실행");
		
	}
	

}
