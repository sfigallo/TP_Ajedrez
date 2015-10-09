package Capa_de_Datos;

import java.sql.*;

import Capa_de_Entidades.Jugador;

public class DataJugadores {

	public static void registrarJugador(Jugador j){
		Connection conexion;
		conexion = FactoriaConexion.getInstancia().getConexion();
		String sql = "insert into jugadores (dni, nombre, apellido)"+
			  "values ("+j.getDni()+", '"+j.getNombre()+"', '"+j.getApellido()+"');";
		try {
			Statement comando = conexion.createStatement();
			comando.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}
	public static Jugador buscarJugador(int dni){
		Jugador j = new Jugador();
		Connection conexion;
		conexion = FactoriaConexion.getInstancia().getConexion();
		String sql = "select * from jugadores where dni = ?";
		try {
			PreparedStatement comando = conexion.prepareStatement(sql);
			comando.setInt(1, dni);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				j.setDni(rs.getInt(1));
				j.setNombre(rs.getString(2));
				j.setApellido(rs.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return j;
	}

}
