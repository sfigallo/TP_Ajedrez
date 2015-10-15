package Capa_de_Entidades;

public class Peon extends Pieza {
	public Peon(){
		setNombre('p');
	}

	public boolean isMovimientoValido(Posicion p, Pieza piezaEnP){
		boolean resp=false;
		if(piezaEnP!=null){ 							//Si hay una pieza en la posición a mover...
			if(piezaEnP.getColor().equals(this.getColor())==false){ 	//y además, la pieza es del otro color...
				if((this.getColor().equals("b"))&&(piezaEnP.getColor().equals("n"))){
					if((Math.abs(this.getPosicion().getLetra()-p.getLetra())==1)&&(this.getPosicion().getNumero() - p.getNumero() == (-1)))
						resp=true;
				}
				if((this.getColor().equals("n"))&&(piezaEnP.getColor().equals("b"))){
					if((Math.abs(this.getPosicion().getLetra()-p.getLetra())==1)&&(this.getPosicion().getNumero() - p.getNumero() ==(1)))
						resp = true;
				}
			}
		}
		else{											//Si no hay pieza en la posicion a mover...
			if(this.getPosicion().getLetra()==p.getLetra()){
				if((this.getColor().equals("b"))&&(this.getPosicion().getNumero() - p.getNumero() == -1))
					resp = true;
				if((this.getColor().equals("n"))&&(this.getPosicion().getNumero() - p.getNumero() == 1))
					resp = true;
			}
		}
		if(this.equals(piezaEnP)) resp = false;
		return resp;
	}
}


