package CRUD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	// public static void main(String[] args) {
	// // kes_table ���̺��� ID/Ÿ��Ʋ/����/������� Į���� �ֽ��ϴ�.
	// insert( 5,"BullySQL", "BULLT SQL is...", "2019-09-10
	// 01:36:33","Allen","developer");
	// }

	public static void update(String name, String inputName) {


		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. �����ϱ�
			//String url = "jdbc:mysql://localhost:3306/kes_table?useSSL=false";
			String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Seoul&useSSL=false";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			// 3. SQL ���� �غ�
			// �߰��Ϸ��� �������� ���� ���޵� ���ڸ� ���� �������� �Ҵ�Ǵ� ���̴�.
			// �� � ���� ���޵��� �𸣹Ƿ� Select �� ���� �޸�
			// stmt = conn.createStatement(); �� �ۼ����� �ʰ�
			// pstmt = conn.prepareStatement(sql); �� �ۼ��Ͽ� �����͸� �߰��� ������ �˸��ϴ�.
			// ���� sql ���� ������ + �����ڷ� �� �ٷ� �ۼ��� �� ������ �������� �ʹ� �������� �ǹǷ�
			// �� ����� ���մϴ�.
			String sql ="update crudtest set name=? where name = ?";
			pstmt = conn.prepareStatement(sql);
			//insert(id, Name, Age, Job, Hobby);
			// 4. ������ binding
			
			pstmt.setString(1, inputName);
			pstmt.setString(2, name);

			// 5. ���� ���� �� ��� ó��
			// SELECT�� �޸� INSERT�� ��ȯ�Ǵ� �����͵��� �����Ƿ�
			// ResultSet ��ü�� �ʿ� ����, �ٷ� pstmt.executeUpdate()�޼��带 ȣ���ϸ� �˴ϴ�.
			// INSERT, UPDATE, DELETE ������ �̿� ���� �޼��带 ȣ���ϸ�
			// SELECT������ stmt.executeQuery(sql); �޼��带 ����߾����ϴ�.
			// @return int - �� ���� row�� ������ ���ƴ����� ��ȯ
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("������ �Է� ����");
			} else {
				System.out.println("������ �Է� ����");
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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
