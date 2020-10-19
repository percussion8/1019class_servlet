package green;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet({ "/MemberListServ", "/member/list" })
public class MemberListServ extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = null;
		   Statement stmt = null;
		   ResultSet rs = null;
		   String dbURL = "jdbc:mysql://localhost:3306/studydb?serverTimezone=Asia/Seoul";
		   String dbId = "root";
		   String dbPw = "1234";
		   
		   try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      conn = DriverManager.getConnection(dbURL,dbId,dbPw);
		      System.out.println("db 연결 성공" + conn);
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery("select mno, mname, email, cre_date from members order by mno asc");
		      response.setContentType("text/html; charset=utf-8");
		      PrintWriter out = response.getWriter();
		      out.println("<html><head><title>회원목록</title></head>");
		      out.println("<body><h1>회원목록</h1>");
		      out.println("<p><a href='add'>신규회원</a></p>");
		      while(rs.next()) {
		    	  out.println(rs.getInt("mno") + ", " + "<a href='update?no=" + rs.getInt("mno") + "'>"
		    			  + rs.getString("mname")+", " 
		    			  + rs.getString("email")+ ", " 
		    			  + rs.getDate("cre_date") + "</a><br>");
		      }
		      out.println("</body></html>");
		      
		      
		   }catch(Exception e){
			   throw new ServletException();//예외를 던짐   
		   } finally {
			   try {if(rs != null) {rs.close();}} catch(Exception e) {System.out.println(e.getMessage());}
			   try {if(stmt!= null) {stmt.close();}} catch(Exception e) {System.out.println(e.getMessage());}
			   try {if(conn != null) {conn.close();}} catch(Exception e) {System.out.println(e.getMessage());}
		   }
	}

}
