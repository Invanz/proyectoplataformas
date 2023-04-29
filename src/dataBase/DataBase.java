package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import java.sql.ResultSet;

public class DataBase {
	
	private static String drivers="com.mysql.cj.jdbc.Driver";
	private static String usuario="root";
	private static String password="Alejos12!";
	private static String url="jdbc:mysql://localhost:3306/clientes";
	
	static {
		try {
			Class.forName(drivers);
			System.out.println("conexion con mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("error en el driver");
		}
	}
	
	
		Connection con=null;
		
		
		public Connection getConnection() {
			
			try {
				
				con=DriverManager.getConnection(url, usuario, password);
				System.out.println("conectado a mysql");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("error de conexion");
				
			}
			return con;
			
		}
		
		Connection conn = null;

		public static void main (String[] args) {
			DataBase db=new DataBase();
			Connection conn = db.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			ResultSetMetaData rsmd= null;
			try {
				
				 stmt = conn.createStatement();
				 stmt.executeUpdate("INSERT INTO clientes.persona ( nombre, domicilio, telefono) VALUES ('Ale','Sur 270','3430848374');");
				 rs = stmt.executeQuery("SELECT LAST_INSERT_ID();");
				 rsmd = rs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();
				 while (rs.next()) {
				     for (int i = 1; i <= columnsNumber; i++) {
				         if (i > 1) System.out.print(",  ");
				         String columnValue = rs.getString(i);
				         System.out.print(columnValue);
				     }
				     System.out.println("");
				 }
				
			}
			
			
			catch (SQLException ex){
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			finally {
			    // it is a good idea to release
			    // resources in a finally{} block
			    // in reverse-order of their creation
			    // if they are no-longer needed

			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }
			}
			
	
		}

}
