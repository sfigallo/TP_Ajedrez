package Capa_de_Datos;

import java.sql.*;
import java.util.ArrayList;

import Capa_de_Entidades.Alfil;
import Capa_de_Entidades.Caballo;
import Capa_de_Entidades.Dama;
import Capa_de_Entidades.Partida;
import Capa_de_Entidades.Peon;
import Capa_de_Entidades.Pieza;
import Capa_de_Entidades.Posicion;
import Capa_de_Entidades.Rey;
import Capa_de_Entidades.Torre;

public class DataPartidas {

	
	public static Pieza[] getPiezas(){
		Pieza[] piezas= new Pieza[32];
		ResultSet rs;
		Connection conexion;
		conexion = FactoriaConexion.getInstancia().getConexion();
		String sql="select * from piezas;";
		try {
			Statement comando = conexion.createStatement();
			rs = comando.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				Pieza p = null;
				String tipoPieza = rs.getString(2);
				if(tipoPieza.equals("p")) p = new Peon();
				if(tipoPieza.equals("r")) p = new Rey();
				if(tipoPieza.equals("d")) p = new Dama();
				if(tipoPieza.equals("a")) p = new Alfil();
				if(tipoPieza.equals("c")) p = new Caballo();
				if(tipoPieza.equals("t")) p = new Torre();
				
				p.setIdPieza(rs.getInt(1));
				p.setColor(rs.getString(3));
				piezas[i]=p;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return piezas;
		
	}
	public static ArrayList<Partida> buscarPartidas(int dni1, int dni2){
		Connection conexion;
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		String sql = "select idPartida, turno from partidas where (dniJugador1 = ? and dniJugador2 = ? ) or (dniJugador2 = ? and dniJugador1 = ? );";

		try {
			conexion = FactoriaConexion.getInstancia().getConexion(); 
			PreparedStatement com = conexion.prepareStatement(sql);
			com.setInt(1, dni1);
			com.setInt(2, dni2);
			com.setInt(3, dni1);
			com.setInt(4, dni2);
			ResultSet rs= com.executeQuery();
			while(rs.next()){
				Partida p = new Partida();
				p.setIdPartida(rs.getInt("idPartida"));
				p.setTurno(rs.getString("turno").toCharArray()[0]);
				partidas.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FactoriaConexion.getInstancia().releaseConexion();
		return partidas;
	}
	public static Partida buscarPartida(int id){
		Connection conexion;
		Partida partida = new Partida();
		conexion = FactoriaConexion.getInstancia().getConexion();
		String sql1="select * from partidas where idPartida = ?";
		String sql2="select idPieza, estado, letra, numero from piezas_partidas where idPartida = ?";
		try {
			PreparedStatement comando = conexion.prepareStatement(sql1);
			comando.setInt(1, id);
			ResultSet rs = comando.executeQuery();
			if(rs.next()){
				int idPartida = rs.getInt(1);
				int dniJugador1 = rs.getInt(2);
				int dniJugador2 = rs.getInt(3);
				char turno = rs.getString(4).toCharArray()[0];
				
				partida.setIdPartida(idPartida);
				partida.setJ1(DataJugadores.buscarJugador(dniJugador1));
				partida.setJ2(DataJugadores.buscarJugador(dniJugador2));
				partida.setTurno(turno);
				Pieza[] piezas = new Pieza[32];
				piezas = DataPartidas.getPiezas();
				partida.setPiezas(piezas);
					Connection conexion2 = FactoriaConexion.getInstancia().getConexion();
					PreparedStatement comando2 = conexion2.prepareStatement(sql2);
					comando2.setInt(1, id);
					ResultSet rs2= comando2.executeQuery();
					while(rs2.next())
					{
						int idPieza = rs2.getInt(1);
						boolean estado = rs2.getInt(2)==1;
						char letra = rs2.getString(3).toCharArray()[0];
						int numero = rs2.getInt(4);
						Pieza pieza = partida.buscarPieza(idPieza);
						Posicion pos = new Posicion();
						pos.setLetra(letra);
						pos.setNumero(numero);
						pieza.setPosicion(pos);
						pieza.setEstado(estado);
						partida.updatePieza(pieza);
					}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FactoriaConexion.getInstancia().releaseConexion();
		FactoriaConexion.getInstancia().releaseConexion();
		return partida;
	}
	public static void setTurno(int idPartida, char turno) {
		Connection conexion = FactoriaConexion.getInstancia().getConexion();
		String sql="update partidas set turno=? where idPartida=?";
		try {
			PreparedStatement comando = conexion.prepareStatement(sql);
			comando.setString(1, Character.toString(turno));
			comando.setInt(2, idPartida);
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();		
	}
	public static Partida nuevaPartida(Partida partidaActual) {
		Connection conexion = FactoriaConexion.getInstancia().getConexion();
		String sql = "insert into partidas (dniJugador1, dniJugador2) values (?,?);";
		String insert = "insert into piezas_partidas (idPieza, idPartida, letra, numero) values (?,?,?,?);";
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setInt(1, partidaActual.getJ1().getDni());
			comando.setInt(2, partidaActual.getJ2().getDni());
			comando.executeUpdate();
			ResultSet rs = comando.getGeneratedKeys();
			rs.next();
			partidaActual.setIdPartida(rs.getInt(1));
			partidaActual.setTurno('b');
			for (Pieza pieza : partidaActual.getPiezas()) {
				comando = conexion.prepareStatement(insert);
				comando.setInt(1, pieza.getIdPieza());
				comando.setInt(2, partidaActual.getIdPartida());
				comando.setString(3, Character.toString(pieza.getPosicion().getLetra()));
				comando.setInt(4, pieza.getPosicion().getNumero());
				comando.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return partidaActual;	
	}
	public static Posicion getPosicion(int idPieza, int idPartida) {
		Posicion p = new Posicion();
		String sql = "select letra, numero from piezas_partidas where (idPieza = ? and idPartida = ?); ";
		Connection conexion = FactoriaConexion.getInstancia().getConexion();
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setInt(1, idPieza);
			comando.setInt(2, idPartida);
			ResultSet rs = comando.executeQuery();
			rs.next();
			p.setLetra(rs.getString("letra").toCharArray()[0]);
			p.setNumero(rs.getInt("numero"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		return p;
	}
	public static void moverPieza(int idPartida, int idPieza, Posicion p) {
		String sql = "update piezas_partidas set letra = ?, numero = ? where idPieza = ? and idPartida = ?";
		Connection conexion = FactoriaConexion.getInstancia().getConexion();
		PreparedStatement comando;
		try {
			comando = conexion.prepareStatement(sql);
			comando.setString(1, Character.toString(p.getLetra()));
			comando.setInt(2, p.getNumero());
			comando.setInt(3, idPieza);
			comando.setInt(4, idPartida);
			comando.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
	}
	public static void matarPieza(int idPartida, Pieza piezaenp) {
		String sql="update piezas_partidas set estado = '0', numero = '9', letra = '9' where ((idPartida = ?) and (idPieza = ?))";
		Connection conexion = FactoriaConexion.getInstancia().getConexion();
		try {
			PreparedStatement comando = conexion.prepareStatement(sql);
			comando.setInt(1, idPartida);
			comando.setInt(2, piezaenp.getIdPieza());
			comando.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FactoriaConexion.getInstancia().releaseConexion();
		
	}

}
