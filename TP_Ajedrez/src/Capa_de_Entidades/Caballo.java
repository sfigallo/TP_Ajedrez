package Capa_de_Entidades;

public class Caballo extends Pieza {
	public Caballo(){
		setNombre('c');
	}
	
	public boolean isMovimientoValido(Posicion p, Pieza piezaEnP){
		boolean resp = false;
		if(piezaEnP!=null){
			if(piezaEnP.getColor().equals(this.getColor())==false){
				if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - p.getNumero())==1))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
				else resp = false;
			}
		}
		else{
			if((Math.abs(this.getPosicion().getLetra() - p.getLetra())==2)&&
					(Math.abs(this.getPosicion().getNumero() - p.getNumero())==1))
					resp = true;
				else if((Math.abs(this.getPosicion().getNumero() - p.getNumero())==2)&&
					(Math.abs(this.getPosicion().getLetra() - p.getLetra())==1))
					resp = true;
				else resp = false;
		}
		if(this.equals(piezaEnP)) resp = false;
		return resp;
	}

	
}
