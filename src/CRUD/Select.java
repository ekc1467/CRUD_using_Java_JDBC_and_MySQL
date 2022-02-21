package CRUD;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	// public static void main(String[] args) {

	static public void select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. �����ϱ�
			//String url = "jdbc:mysql://localhost:3306/kes_table?useSSL=false";
			String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Seoul&useSSL=false";
			conn = DriverManager.getConnection(url, "root", "1234");

			// 3. ���� ������ ���� Statement ��ü ����
			stmt = conn.createStatement();
			System.out.println("����");
			// 4. SQL ���� �ۼ�
			// ���ǻ���
			// 1) JDBC���� ������ �ۼ��� ���� �����ݷ�(;)�� ���� �ۼ��Ѵ�.
			// 2) SELECT �� �� * ���� ��� Į���� �������� �ͺ���
			// �����;� �� Į���� ���� �������ִ� ���� ����.
			// 3) ���ϴ� ����� �����ν� ������ ����, java �ڵ�� ���۾� �ϴ� ���� ������ ����
			// 4) ������ �� �ٷ� ���� ����� ��� �鿩���⸦ ����ص� ������ ���⿡ ���� !!
			String sql = "SELECT * FROM crudtest";
			
			// 5. ���� ����
			// ���ڵ���� ResultSet ��ü�� �߰��ȴ�.
			rs = stmt.executeQuery(sql);

			// 6. ������ ����ϱ�
			while (rs.next()) {
				// ���ڵ��� Į���� �迭�� �޸� 0���� �������� �ʰ� 1���� �����Ѵ�.
				// �����ͺ��̽����� �������� �������� Ÿ�Կ� �°� getString �Ǵ� getInt ���� ȣ���Ѵ�.
				String id = rs.getString(1);
				String Name = rs.getString(2);
	
				
				
				System.out.println(id + " " + Name );
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("���� " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}




}
// }