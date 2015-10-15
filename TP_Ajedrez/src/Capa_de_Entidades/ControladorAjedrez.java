package Capa_de_Entidades;

import java.util.ArrayList;

import Capa_de_Datos.DataJugadores;
import Capa_de_Datos.DataPartidas;

public class ControladorAjedrez {
	private static Partida partidaActual;
	
	public Jugador buscarJugador(int dni){
		return DataJugadores.buscarJugador(dni);
	}
	
	public ArrayList<Partida> buscarPartidas(int dni1, int dni2){
		return DataPartidas.buscarPartidas(dni1, dni2);
	}
	protected void pasarTurno(){
		if(partidaActual.getTurno()=='b'){
			partidaActual.setTurno('n');
			DataPartidas.setTurno(partidaActual.getIdPartida(), partidaActual.getTurno());
		}
		else if(partidaActual.getTurno()=='n'){
			partidaActual.setTurno('b');
			DataPartidas.setTurno(partidaActual.getIdPartida(), partidaActual.getTurno());
		}
	}

	public boolean moverPieza(int idPieza, Posicion p) {
		//Este método devuelve true si se movió la pieza
		//o devuelve false si el movimiento no se pudo hacer.
		boolean resp = false;
		//----------------------------------------------------
		//resp = p.isDentroTablero();							//Verifico que el parámetro p sea válido
		Pieza piezaenp=partidaActual.buscarPiezaEn(p); 		//Busco pieza en posicion p
		//Busco la pieza a mover
		Pieza piezaActual = partidaActual.buscarPieza(idPieza);
		if((p.isDentroTablero())&&(piezaActual.isMovimientoValido(p, piezaenp))&&(piezaActual.getColor().equals(Character.toString(partidaActual.getTurno())))){
			piezaActual.setPosicion(p);
			partidaActual.updatePieza(piezaActual);
			DataPartidas.moverPieza(partidaActual.getIdPartida(), piezaActual.getIdPieza(), p);
			pasarTurno();
			resp = true;
		}
		if(piezaenp!=null){
			if(piezaenp.getPosicion().equals(piezaActual.getPosicion())){
				piezaenp.setEstado(false);
				piezaenp.getPosicion().setLetra('9');
				piezaenp.getPosicion().setNumero(9);
				partidaActual.updatePieza(piezaenp);
				DataPartidas.matarPieza(partidaActual.getIdPartida(), piezaenp);
			}
		}
		return resp;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public void nuevaPartida(int dni1, int dni2) {
		partidaActual = new Partida();
		partidaActual.setJ1(DataJugadores.buscarJugador(dni1));
		partidaActual.setJ2(DataJugadores.buscarJugador(dni2));
		partidaActual.setPiezas(DataPartidas.getPiezas());
		partidaActual.acomodarPiezasPosicionInicial();
		partidaActual = DataPartidas.nuevaPartida(partidaActual);
	}

	public String getGanador() {
		if(partidaActual.buscarPieza(17).isEstado()==false) return "Negras";
		else if(partidaActual.buscarPieza(18).isEstado()==false) return "Blancas";
		else return null;
	}

	public void buscarPartida(int idPartida) {
		setPartidaActual(DataPartidas.buscarPartida(idPartida));
	}

	public static void setPartidaActual(Partida partidaActual) {
		ControladorAjedrez.partidaActual = partidaActual;
	}

}
