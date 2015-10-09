package Capa_de_Entidades;

public class Rey extends Pieza {
	private static char nombre='r';
	
	public boolean isMovimientoValido(Posicion p, Pieza piezaEnP){
		boolean resp;
		
		if(piezaEnP.getColor()==this.getColor()) resp=false;
		else
		{
			if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==1) &&
					(this.getPosicion().getNumero() == p.getNumero()))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
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
