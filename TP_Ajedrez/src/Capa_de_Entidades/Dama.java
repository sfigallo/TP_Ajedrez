package Capa_de_Entidades;

public class Dama extends Pieza {
	private static char nombre='d';
	
	public boolean isMovimientoValido (Posicion p, Pieza piezaEnP){
		boolean resp;	
		if(piezaEnP.getColor()==this.getColor()) resp=false;
		else
		{
			if(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()))
					resp = true;
				else if((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else resp = false;
		}
		return resp;		
	}

	public static char getNombre() {
		return nombre;
	}
	
}
