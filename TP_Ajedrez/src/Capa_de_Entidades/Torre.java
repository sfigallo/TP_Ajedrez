package Capa_de_Entidades;

public class Torre  extends Pieza {
	public Torre(){
		setNombre('t');
	}
	
	public boolean isMovimientoValido (Posicion p, Pieza piezaEnP){
		boolean resp = false;
		if(piezaEnP!=null){
			if(piezaEnP.getColor().equals(this.getColor())==false)
				resp=((this.getPosicion().getNumero() == p.getNumero())||(this.getPosicion().getLetra() == p.getLetra()));
		}
		else{
			resp=((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()));
		}
		if(this.equals(piezaEnP)) resp = false;
		return resp;
	}	
}
