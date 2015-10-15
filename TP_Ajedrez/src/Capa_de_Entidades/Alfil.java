package Capa_de_Entidades;

public class Alfil extends Pieza {
	public Alfil(){
		setNombre('a');
	}
	
	public boolean isMovimientoValido (Posicion p, Pieza piezaEnP){
		boolean resp=false;
		if(piezaEnP!=null){
			if(piezaEnP.getColor().equals(this.getColor())==false){
				resp=(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()));
			}
		}
		else{
			resp=(Math.abs(this.getPosicion().getNumero() - p.getNumero()) == 
					Math.abs(this.getPosicion().getLetra() - p.getLetra()));;
		}
		if(this.equals(piezaEnP)) resp = false;
		return resp;
	}

}
	

