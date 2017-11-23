package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

/*
 * Autor:Diego Úbeda-Romero
 * 
 * El Arkanoid pero orientado a objetos
 */

import acm.graphics.*;
public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(6, Color.yellow);
	//Pelota pelota2 = new Pelota(30, Color.BLUE);
	Barra barra1 = new Barra(900 , 10, Color.red);
	int anchoLadrillo = 27;
	int altoLadrillo = 13;
	int espacioMenu = 200;

	//el sistema del marcador
	int puntuacion = 0;
	Marcador marcador = new Marcador(48, 40);

	public void init(){
		addMouseListeners();
		setSize(600, 600);
		GRect lateral = new GRect(3,getHeight());
		lateral.setFilled(true);
		add(lateral, getWidth()- espacioMenu - lateral.getWidth() - pelota1.getWidth(), 0);
		add(pelota1, 50,  getHeight()*0.60 - pelota1.getHeight());
		//add(pelota2, 50,  getHeight()*0.70 - pelota2.getHeight());
		add(barra1, 0, getHeight()*0.80);


	}

	public void run(){
		dibujaNivel01();		
		marcador.dibuja(this);
		//add(marcador.texto, 0, 20);
		while(true){
			pelota1.muevete(this);
			//pelota2.muevete(this); 
			pause(0.0001);			
		}


	}
//este codigo mueve la barra
	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth());
	}

	private void dibujaNivel01(){
		for (int j=0; j<14; j++){
			for(int i=j; i < 14; i++){
				Ladrillo miLadrillo = new Ladrillo(anchoLadrillo*i - anchoLadrillo*j/2,
						altoLadrillo*j + altoLadrillo,
						anchoLadrillo, altoLadrillo, Color.red);
				add(miLadrillo);
				pause(7);
			}
		}
	}
}

