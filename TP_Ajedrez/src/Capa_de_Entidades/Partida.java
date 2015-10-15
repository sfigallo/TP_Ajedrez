package Capa_de_Entidades;

import Capa_de_Datos.DataPartidas;

public class Partida {
	private Pieza[] piezas= new Pieza[32];
	private int idPartida;
	private Jugador j1;
	private Jugador j2;
	private char turno;
	
	public void iniciarPartida(){
		//Se debe hacer conexion a BD, traer todas las piezas, rellenar el array piezas
		//darle sus respectivas posiciones, y setear el turno en 'b'
		piezas = DataPartidas.getPiezas();
		/*for (int i = 0; i < piezas.length; i++) {
			if(piezas[i].getIdPieza()==1){
				Posicion p = new Posicion();
				p.setLetra('a'); p.setNumero(2);
				piezas[i].setPosicion(p);
			}
			
		}*/
		
	}

	public Pieza[] getPiezas() {
		return piezas;
	}

	public void setPiezas(Pieza[] piezas) {
		this.piezas = piezas;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public void acomodarPiezas() {
		for (Pieza pieza : piezas) {
			pieza.setPosicion(DataPartidas.getPosicion(pieza.getIdPieza(), idPartida));
		}
		
	}
	public void acomodarPiezasPosicionInicial(){
		for (Pieza pieza : piezas) {
			pieza.setPosicion(DataPartidas.getPosicion(pieza.getIdPieza(), 0));
		}
	}

	public Pieza buscarPiezaEn(Posicion p) {
		Pieza piezaenp = null;
		for (Pieza pieza : piezas) {
			if(pieza.getPosicion().equals(p)){
				piezaenp=pieza;
			}
		}
		return piezaenp;
	}

	public Pieza buscarPieza(int idPieza) {
		Pieza piezabuscada = null;
		for (Pieza pieza : piezas) {
			if(pieza.getIdPieza()==idPieza){
				piezabuscada = pieza;
				break;
			}
		}
		return piezabuscada;
	}

	public void updatePieza(Pieza pi) {
		for (Pieza pieza : piezas) {
			if(pi.getIdPieza()==pieza.getIdPieza()){
				pieza = pi;
				break;
			}
		}
		
	}
	
	
	

}
