package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newInput
 */
@WebServlet("/NewInput")
public class NewInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("newInput_name");
		String count = request.getParameter("newInput_count");
		Integer num = null;
		Integer i_count = null;
		PrintWriter out = response.getWriter();
		out.println("처리완료");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "qwerty";
		String pass = "qwerty";
		Connection conn = null;
		Statement  stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement("select * from obj where obj_name = '" + name+ "'");
			rs=pstmt.executeQuery();
			while(rs.next()){
		        //System.out.println(num = Integer.parseInt(rs.getString("obj_indx")));
				num = Integer.parseInt(rs.getString("obj_indx"));
			}
			rs.close();
			pstmt.close();
			pstmt = conn.prepareStatement("select * from m_input where input_obj_indx = " + num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				i_count = Integer.parseInt(rs.getString("input_count"));
			}
			rs.close();
			pstmt.close();
			
			if(i_count==null) {
				//System.out.println("none");
				pstmt = conn.prepareStatement("insert into m_input(input_indx,input_obj_indx,input_count) values(input_id.nextval,"+
						num+","+count+")");
				rs = pstmt.executeQuery();
				
			}
			else{
				pstmt = conn.prepareStatement("update m_input set input_count = "+
						(i_count+Integer.parseInt(count)) +" where input_obj_indx = " + num);
				rs = pstmt.executeQuery();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
