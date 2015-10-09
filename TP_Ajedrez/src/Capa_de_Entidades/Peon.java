package Capa_de_Entidades;

public class Peon extends Pieza {
	private static char nombre='p';

	public boolean isMovimientoValido(Posicion p, Pieza piezaEnP){
		boolean resp=false;
		if(piezaEnP.getColor()==this.getColor()) resp = false;
		else if((this.getColor()=="b")&&(piezaEnP.getColor()=="n")){
			//Falta terminar este bloque
		}
		else if((this.getColor()=="n")&&(piezaEnP.getColor()=="b")){
			//Falta terminar este bloque tambien
		}
		else if(piezaEnP.getColor()=="0"){
			if(this.getPosicion().getLetra()==p.getLetra()){
				if((this.getColor()=="b")&&(this.getPosicion().getNumero() - p.getNumero() == (-1)))
					resp = true;
				if((this.getColor()=="n")&&(this.getPosicion().getNumero() - p.getNumero() == (1)))
					resp = true;
			}
			else resp = false;
		}
		return resp;
	}
	
	public static char getNombre() {
		return nombre;
	}
}


