package Capa_de_Datos;

import java.sql.*;

public class FactoriaConexion {
	private String dbDriver="com.mysql.jdbc.Driver";
	private Connection conexion;
	private String host="localhost";
	//private String port="3306";
	private String user="Ramiro";
	private String pass="";
	private String db="ajedrezdb";
	private int cantCon;
	private static FactoriaConexion instancia;	
	
	private FactoriaConexion(){
		try {
			Class.forName(dbDriver);
			conexion=null;
			cantCon=0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FactoriaConexion getInstancia(){
		if (instancia==null){
			instancia = new FactoriaConexion();
		}
		return instancia;
	}
	
	
	
	public Connection getConexion(){
		try {
			if(conexion==null || conexion.isClosed()){
				conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+db, user, pass);
				cantCon++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	
	public void releaseConexion(){
		try {
			cantCon--;
			if(cantCon==0){
				conexion.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
