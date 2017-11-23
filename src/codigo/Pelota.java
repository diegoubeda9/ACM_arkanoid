package codigo;
/*
 * Autor:Diego Úbeda-Romero
 * La clase pelota es la que vamos a utilizar para
 * el juego de Arkanoid
 * Tiene dos constructores
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{
	
	double xVelocidad = 1; //velocidad de la bola en el eje x
	double yVelocidad = -1; //velocidad de la bola en el eje Y
	
	
	/**
	 * Este es el constructor básico, que es identico
	 * al de la clase GOval
	 * @param _ancho indica el ancho y el alto de la bola
	 * @param _alto 
	 */
	public Pelota(double _ancho, double _alto){
		super(_ancho, _alto);
	}

	/**
	 * Este es el constructor debuti que permite
	 * pasar el color como parametro
	 * 
	 * @param _ancho indica el ancho y el alto de la bola
	 * @param _color
	 */
	public Pelota(double _ancho, Color _color){	
		super(_ancho, _ancho);
		if(_ancho <=0){
			this.setSize(1, 1);
		}
		this.setFillColor(_color);
		this.setFilled(true);
	}
	/**
	 * Se encarga de mover a la pelota y chequear si ha habido colision
	 */
	public void muevete(Arkanoid _arkanoid){
		//chequea si a chocado con las paredes izq o derecha
		if(this.getX() + getWidth() >= _arkanoid.getWidth() - _arkanoid.espacioMenu|| getX()<0){
			xVelocidad *= -1;
		}
		//chequea si ha tocado con el techo
		if(this.getY()<0){
			yVelocidad *= -1;
		}
		if(chequeaColision(getX(), getY(), _arkanoid)){//chequeo la esquina superior izquierda
			if(chequeaColision(getX() + getWidth(), getY(), _arkanoid)){//chequeo la esquina superior derecha
				if(chequeaColision(getX(), getY() + getHeight(), _arkanoid)){//chequeo la esquina inferior izquierda
					if(chequeaColision(getX(), getY() + getHeight(), _arkanoid)){//chequeo la esquina inferior derecha
						
					}
				}
			}
		}
		
		
		//voy a crear un metodo chequeacolision generico
		//que sirva para comprobar los choqies entre la bola y los ladrillos
		//y la bola y el cursor
		
		
		move(xVelocidad,yVelocidad);
	}
	
	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado = true;
		GObject auxiliar;
		auxiliar = _arkanoid.getElementAt(posX, posY);
		
		if (auxiliar instanceof Ladrillo){
			if (auxiliar.getY() == posY || auxiliar.getY() + auxiliar.getHeight() == posY){
				yVelocidad *= -1;
			}
			else if(auxiliar.getX() == posX || auxiliar.getX() + auxiliar.getWidth() == posX){
				xVelocidad *= -1;
			}
			_arkanoid.remove(auxiliar);
			noHaChocado = false;
		}
		else if (auxiliar instanceof Barra){
			yVelocidad *= -1;
			noHaChocado = false;
		}
		return noHaChocado;
	}
	
	
	
}
