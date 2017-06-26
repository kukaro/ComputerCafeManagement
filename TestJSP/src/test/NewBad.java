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
 * Servlet implementation class NewBad
 */
@WebServlet("/NewBad")
public class NewBad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBad() {
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
		String name = request.getParameter("newBad_name");
		String count = request.getParameter("newBad_count");
		Integer num = null;
		Integer i_count = null;
		Integer o_count = null;
		PrintWriter out = response.getWriter();
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
				o_count = Integer.parseInt(rs.getString("obj_amount"));
				if(Integer.parseInt(rs.getString("obj_amount"))<Integer.parseInt(count)){
					out.println("그 만큼의 재고량이 없습니다.");
					return;
				}
			}
			rs.close();
			pstmt.close();
			pstmt = conn.prepareStatement("select * from bad where bad_obj_idx = " + num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				i_count = Integer.parseInt(rs.getString("bad_count"));
			}
			rs.close();
			pstmt.close();
			
			if(i_count==null) {
				//System.out.println("none");
				pstmt = conn.prepareStatement("insert into bad(bad_indx,bad_obj_idx,bad_count) values(bad_id.nextval,"+
						num+","+count+")");
				rs = pstmt.executeQuery();
				pstmt.close();
				pstmt = conn.prepareStatement("update obj set obj_amount = "+
						(o_count-Integer.parseInt(count)) +" where obj_indx = " + num);
				rs = pstmt.executeQuery();
				
			}
			else{
				pstmt = conn.prepareStatement("update bad set bad_count = "+
						(i_count+Integer.parseInt(count)) +" where bad_obj_idx = " + num);
				rs = pstmt.executeQuery();
				pstmt.close();
				pstmt = conn.prepareStatement("update obj set obj_amount = "+
						(o_count-Integer.parseInt(count)) +" where obj_indx = " + num);
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
		out.println("처리완료");
	}

}
