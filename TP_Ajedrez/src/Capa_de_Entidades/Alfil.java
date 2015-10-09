package Capa_de_Entidades;

public class Alfil extends Pieza {
	private static char nombre='a';
	
	public boolean isMovimientoValido (Posicion p, Pieza piezaEnP){
		boolean resp=false;
		if(piezaEnP.getColor()==this.getColor()) resp=false;
		else
		{
			resp=(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()));
		}
		return resp;
	}

	public static char getNombre() {
		return nombre;
	}
	
}
