package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DB;
import modelos.Contacto;

public class DAOContacto {

	
	public ResultadoCRUD crear(Contacto c){
		ResultadoCRUD r=ResultadoCRUD.ERROR;
				
		String sql="insert into contactos (nombre,telefono) values (?,?)";
		try(Connection con=DB.getConexion();
			PreparedStatement ps=con.prepareStatement(sql);){
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getTelefono());
			int nAfectados=ps.executeUpdate();
			r=ResultadoCRUD.OK;
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return r;
	}
	
	public ArrayList<Contacto> getListado(){
		ArrayList<Contacto> r=new ArrayList<Contacto>();
		
		String sql="select * from contactos";
		try(Connection con=DB.getConexion();
		    Statement stm=con.createStatement();){
			stm.executeQuery(sql);
			ResultSet rs=stm.getResultSet();
			
			while(rs.next()){
				Contacto c=new Contacto(rs.getString("nombre"),rs.getString("telefono"));
				System.out.println(c);
				r.add(c);
			}
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
				
		return r;
	}
	
	
	
}
