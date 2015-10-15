package Capa_de_Entidades;

public class Posicion {
	private char letra;
	private int numero;
	
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isDentroTablero(){
		if((this.letra>='a')&&(this.letra<='h'))
			if((this.numero>=1)&&(this.numero<=8))
				return true;
			else return false;
		else return false;	 
	}
	public boolean equals(Posicion p){
		return (this.getLetra() == p.getLetra()) && (this.getNumero()==p.getNumero());
	}
	
}
