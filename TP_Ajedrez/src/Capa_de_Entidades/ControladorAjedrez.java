package Capa_de_Entidades;

import java.util.ArrayList;

import Capa_de_Datos.DataJugadores;
import Capa_de_Datos.DataPartidas;
import Capa_de_Datos.FactoriaConexion;

public class ControladorAjedrez {
	
	public Jugador buscarJugador(int dni){
		return DataJugadores.buscarJugador(dni);
	}
	
	public ArrayList<Partida> buscarPartidas(int dni1, int dni2){
		return DataPartidas.buscarPartidas(dni1, dni2);
	}
	public Partida pasarTurno(Partida p){
		if(p.getTurno()=='b'){
			p.setTurno('n');
			DataPartidas.setTurno(p.getIdPartida(), p.getTurno());
		}
		if(p.getTurno()=='n'){
			p.setTurno('b');
			DataPartidas.setTurno(p.getIdPartida(), p.getTurno());
		}
		
		FactoriaConexion.getInstancia().releaseConexion();
		return p;
	}

}
