package logica;

import java.awt.Graphics;

import myUtilities.SquareImage;

public class JugadorFuego extends SquareImage {
	
	Thread threadFire;
		
	public JugadorFuego(Jugador jugador) {
		super("/fuegoJugador.png", jugador.xPosition + 10, jugador.yPosition-50+20, 30, 30);
		yVelocity = 20;
		
		threadFire = new Thread(new Runnable() {
			@Override
			public void run() {
				while (yPosition > 0 - imgHeight) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					move(0, -yVelocity);
				}
				
			}
		});
		threadFire.start();
	}

	public void drawBullet(Graphics g) {
		g.drawImage(img, xPosition, yPosition, imgWidth, imgHeight, null);
	}
}
