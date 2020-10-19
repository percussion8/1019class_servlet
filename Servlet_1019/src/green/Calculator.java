package green;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
/* @WebServlet({ "/Calculator", "/calcu" }) */
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a;
		int b;
		a = Integer.parseInt(request.getParameter("a"));
		b = Integer.parseInt(request.getParameter("b"));
		response.setContentType("text/plain;");
		response.setCharacterEncoding("UTF-8");
		//이미지나 동영상같은 바이너리데이터를 출력할때는 getOutputStream() 사용
		PrintWriter writer = response.getWriter();
		
		writer.println("a="+a+", b="+b);
		writer.println("a+b="+(a+b));
		writer.println("a-b="+(a-b));
		writer.println("a*b="+(a*b));
		writer.println("a/b="+((float)a/b));
		writer.println("a%b="+(a%b));
		
		
		
	}

}
