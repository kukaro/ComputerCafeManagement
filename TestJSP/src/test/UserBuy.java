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
 * Servlet implementation class UserBuy
 */
@WebServlet("/UserBuy")
public class UserBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserBuy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
		String uname = request.getParameter("userBuy_userName");
		String oname = request.getParameter("userBuy_objName");
		PrintWriter out = response.getWriter();
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "qwerty";
		String pass = "qwerty";
		Integer uid = null;
		Integer oid = null;
		Integer count = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		boolean check = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement("select * from obj where OBJ_NAME = '" + oname + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				check = true;
				count = Integer.parseInt(rs.getString("obj_amount"));
				oid = Integer.parseInt(rs.getString("obj_indx"));
				if (count == 0) {
					out.println("재고가 없습니다.");
					return;
				}
			}
			pstmt.close();
			if (check == false) {
				out.println("처리 실패");
				return;
			}
			check = false;

			pstmt = conn.prepareStatement("select * from m_user where user_name = '" + uname + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				check = true;
				uid = Integer.parseInt(rs.getString("user_indx"));
			}
			if (check == false) {
				out.println("처리 실패");
				return;
			}

			pstmt.close();
			pstmt = conn.prepareStatement(
					"insert into sell(SELL_INDX,BUY_USER_INDX,sell_obj_indx) values (sell_id.nextval,'" + uid + "','"
							+ oid + "')");
			rs = pstmt.executeQuery();

			pstmt.close();
			pstmt = conn
					.prepareStatement("update obj set obj_amount = " + (count - 1) + " where obj_indx = " + oid);
			rs = pstmt.executeQuery();
			out.println("처리 완료");
			return;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.println("처리실패");
	}
}
