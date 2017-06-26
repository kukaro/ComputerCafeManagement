package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		String uid = request.getParameter("v_m_user_id");
		String upass = request.getParameter("v_m_user_pass");
		String uname = request.getParameter("v_m_user_name");
		String uphone = request.getParameter("v_m_user_phone");
		String ubirth = request.getParameter("v_m_user_birth");
		PrintWriter out = response.getWriter();
		out.println(uid+"<br>"+upass+"<br>"+uname+"<br>"+uphone+"<br>"+ubirth);
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
			pstmt = conn.prepareStatement("insert into m_user(user_indx,user_id,user_pwd,user_name,user_birth,user_phone_num,user_service,user_time,user_total_time,user_coast,user_total_coast) values "+
					"(user_seq_id.nextval,'"+
					uid+"','"+
					upass+"','"+
					uname+"',to_date('"+
					ubirth+"','mm-dd-yyyy'),'"+
					uphone+"',0,0,0,0,0)");
			rs=pstmt.executeQuery();
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
