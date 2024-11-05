package connectdb;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnectDB {
		 // URL của database, bao gồm: protocol, địa chỉ, cổng, tên database
	    private static final String URL = "jdbc:mysql://localhost:3306/login";
	    private static final String USER = "root";  // Tài khoản MySQL
	    private static final String PASSWORD = "251105";  // Mật khẩu MySQL

	   public static Connection getConnection() throws ClassNotFoundException {
	        Connection connection = null;
	        String dbDriver = "com.mysql.jdbc.Driver";
	        Class.forName(dbDriver); 
	        try {
	            // Kết nối tới MySQL
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	            if (connection != null) {
	                System.out.println("Kết nối thành công!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	           
	        
			return connection;
	    }

		
	}

