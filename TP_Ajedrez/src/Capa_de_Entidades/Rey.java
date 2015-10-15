package Capa_de_Entidades;

public class Rey extends Pieza {
	public Rey(){
		setNombre('r');
	}
	
	public boolean isMovimientoValido(Posicion p, Pieza piezaEnP){
		boolean resp = false;
		if(piezaEnP!=null){
			if(piezaEnP.getColor().equals(this.getColor())==false){
				if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==1) &&
					(this.getPosicion().getNumero() == p.getNumero()))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
			}
			else{
				if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
						(this.getPosicion().getLetra() == p.getLetra()))
						resp = true;
					else if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==1) &&
						(this.getPosicion().getNumero() == p.getNumero()))
						resp = true;
					else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==1) &&
						(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
						resp = true;
			}		
		}
		if(this.equals(piezaEnP)) resp = false;
		return resp;
	}
}
