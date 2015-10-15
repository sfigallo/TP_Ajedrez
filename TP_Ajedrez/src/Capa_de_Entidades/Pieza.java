package Capa_de_Entidades;

public abstract class Pieza {
	private int idPieza;
	private String color="0";
	private Posicion posicion;
	private boolean estado = true;
	private char nombre;
	public int getIdPieza() {
		return idPieza;
	}
	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public abstract boolean isMovimientoValido(Posicion p, Pieza piezaEnP);

	public char getNombre(){
		return nombre;
	}
	public void moverA(Posicion p){
		this.posicion= p;
		
		//Falta incluír acá la parte que hace que cambie en la BD
	}
	public void setNombre(char nombre) {
		this.nombre = nombre;
	}
	
	
	

}
