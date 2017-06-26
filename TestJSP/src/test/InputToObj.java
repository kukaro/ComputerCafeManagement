package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputToObj
 */
@WebServlet("/InputToObj")
public class InputToObj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputToObj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		ArrayList<Integer> indx = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		ArrayList<Integer> obj_indx = new ArrayList<>();
		ArrayList<Integer> obj_count = new ArrayList<>();
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
			pstmt = conn.prepareStatement("select * from m_input");
			rs=pstmt.executeQuery();
			while(rs.next()){
				indx.add(Integer.parseInt(rs.getString("input_obj_indx")));
				count.add(Integer.parseInt(rs.getString("input_count")));
			}
			rs.close();
			pstmt.close();
			pstmt = conn.prepareStatement("select * from obj");
			rs=pstmt.executeQuery();
			while(rs.next()){
				for(int i=0;i<indx.size();i++)
					if(Integer.parseInt(rs.getString("obj_indx"))==indx.get(i)){
						obj_indx.add(indx.get(i));
						obj_count.add(Integer.parseInt(rs.getString("obj_amount")));
					}
			}
			pstmt.close();
			pstmt = conn.prepareStatement("delete from m_input");
			rs = pstmt.executeQuery();
			pstmt.close();
			for(int i=0;i<indx.size();i++){
				//System.out.println("update obj set obj_amount = "+count.get(i) +" where obj_indx = " + indx.get(i));
				pstmt = conn.prepareStatement("update obj set obj_amount = "+(obj_count.get(obj_indx.indexOf(indx.get(i)))+count.get(i)) +" where obj_indx = " + indx.get(i));
				rs=pstmt.executeQuery();
				pstmt.close();
			}
			out.write("모두 재고품으로 이전했습니다.");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
