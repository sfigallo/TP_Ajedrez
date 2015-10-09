package Capa_de_Entidades;

public class Caballo extends Pieza {
	private static char nombre='c';
	
	public boolean isMovimientoValido(Posicion p, Pieza piezaEnP){
		boolean resp;
		if(piezaEnP.getColor()==this.getColor()) resp=false;
		else
		{
			if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - p.getNumero())==1))
					resp = true;
			else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
			else resp = false;
		}
		return resp;
	}

	public static char getNombre() {
		return nombre;
	}
	
}
