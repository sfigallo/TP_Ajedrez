package Capa_de_Entidades;

public class Dama extends Pieza {
	public Dama(){
		setNombre('d');
	}
	
	public boolean isMovimientoValido (Posicion p, Pieza piezaEnP){
		boolean resp = false;	
		if(piezaEnP!=null){
			if(piezaEnP.getColor().equals(this.getColor())==false){
				if(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()))
					resp = true;
				else if((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else resp = false;
			}
		}
		else{
			if(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()))
					resp = true;
				else if((this.getPosicion().getNumero() == p.getNumero())||
					(this.getPosicion().getLetra() == p.getLetra()))
					resp = true;
				else resp = false;			
		}
		if(this.equals(piezaEnP)) resp = false;
		return resp;		
	}
	
}
