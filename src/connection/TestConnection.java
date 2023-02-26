package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection connection = null;
		Statement stament = null;
		ResultSet rs = null;
			
		try {		
			connection = conexion.conectar();
			stament = connection.createStatement();
			rs = stament.executeQuery("SELECT * FROM usuario");
			
			while(rs.next()) {
				int idUsuario = rs.getInt(1);
				String usuario = rs.getString(2);
				String clave = rs.getString(3);			
				System.out.println("id-> " + idUsuario + " usuario-> " + usuario + " clave " + clave);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				
				if(stament!=null) {
					stament.close();
				}
				
				if(connection!=null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
}
