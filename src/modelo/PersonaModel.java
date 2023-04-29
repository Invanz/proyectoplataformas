package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import dataBase.DataBase;

public class PersonaModel {
	// Se definen los atributos de clase. 
	private String id;
	private String nombre;
	private String domicilio;
	private String telefono;
	
	public PersonaModel(String nombre, String domicilio, String telefono) {
		// Se instancia y se definen los métodos de Get y Set de acuerdo a las necesidades. 
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}

	public String getId () {
		return this.id;
	}
	public String getNombre () {
		return this.nombre;
	}
	public void setNombre (String newNombre) {
		this.nombre = newNombre;
	}
	public String getDomicilio () {
		return this.domicilio;
	}
	public void setDomicilio (String newDomicilio) {
		this.domicilio = newDomicilio;
	}
	public String getTelefono () {
		return this.telefono;
	}
	public void setTelefono (String newTelefono) {
		this.telefono = newTelefono;
	}
	
	public void savePersona () {
		// Se define el método para guardar usuario, se ejecuta conexión con base de datos y se envían comandos a MySql
		DataBase db=new DataBase();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd= null;
		try {
			 stmt = conn.createStatement();
			 stmt.executeUpdate("INSERT INTO clientes.persona ( nombre, domicilio, telefono) VALUES ( '" + this.nombre + "', '" + this.domicilio + "', '"
			 + this.telefono + "');");		 
			 rs = stmt.executeQuery("SELECT LAST_INSERT_ID();");
			 rsmd = rs.getMetaData();
			 int columnsNumber = rsmd.getColumnCount();
			 while (rs.next()) {
			     for (int i = 1; i <= columnsNumber; i++) {
			         String columnValue = rs.getString(i);
			         this.id = columnValue;
			   
			     }
			 }
		}
		
		catch (SQLException ex){
		    // Se ocupa respuesta a posibles errores
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // Se cierran los procesos.
			

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { }

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { }

		        stmt = null;
		    }
		}
		

	
	}
	
	public void readPersona (String searchId) {
		// Se define el método que recupera los valores de la tabla a partir del ID 
		DataBase db=new DataBase();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd= null;
		try {
			 stmt = conn.createStatement();	 
			 rs = stmt.executeQuery("SELECT * FROM clientes.persona WHERE id= " + searchId + ";");
			 rsmd = rs.getMetaData();
			 int columnsNumber = rsmd.getColumnCount();
			 while (rs.next()) {
				 //el while itera y encuentra los valores que guarda en las variables
			     for (int i = 1; i <= columnsNumber; i++) {
			         String columnValue = rs.getString(i);
			         if (i == 2) {
			        	 this.nombre = columnValue;
			         } else if (i == 3) {
				         this.domicilio = columnValue;
			         } else if (i == 4) {
				         this.telefono = columnValue;
			         }		
			     }
			 }
		}
		
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {	

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { }

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { }

		        stmt = null;
		    }
		}
		

	
	}
	public void updatePersona (String searchId, String nombre, String domicilio, String telefono) {
		// se conecta y define la instrucción a MySQL
		DataBase db=new DataBase();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			 stmt = conn.createStatement();	 
			 stmt.executeUpdate("UPDATE  clientes.persona SET nombre = '" + nombre +"',"	+ "domicilio = '" + domicilio +"',"
			 		+ "    telefono = '" + telefono +"'"
			 		+ "    WHERE id = " + searchId + ";"); 
				
		}
		
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {	

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { }

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { }

		        stmt = null;
		    }
		}
		

	
	}
	
	public void deletePersona (String searchId) {
		//con el parámetro ID se envía la instrucción para eliminar dicha fila
		DataBase db=new DataBase();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			 stmt = conn.createStatement();	 
			 stmt.executeUpdate("DELETE FROM clientes.persona WHERE id = " + searchId + ";"); 
				
		}
		
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {	

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { }

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { }

		        stmt = null;
		    }
		}
		

	
	}
}
