package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DB {

	
	public static Connection getConexion(){
		Connection con=null;
		try{
			Context contexto= new InitialContext();
			Context contextoSecundario=(Context)contexto.lookup("java:/comp/env");
			DataSource ds=(DataSource)contextoSecundario.lookup("jdbc/Agenda");
			con=ds.getConnection();
		}
		catch(NamingException ne){
			ne.printStackTrace();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return con;
	}
}
