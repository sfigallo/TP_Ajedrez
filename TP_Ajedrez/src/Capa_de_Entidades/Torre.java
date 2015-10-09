package Capa_de_Entidades;

public class Torre  extends Pieza {
	private static char nombre='t';
	
	public boolean isMovimientoValido (Posicion p, Pieza piezaEnP){
		boolean resp;
		if(piezaEnP.getColor()==this.getColor()) resp=false;
		else
		{
			resp=((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()));
		}
		return resp;
	}
	
	public static char getNombre() {
		return nombre;
	}
	
}
