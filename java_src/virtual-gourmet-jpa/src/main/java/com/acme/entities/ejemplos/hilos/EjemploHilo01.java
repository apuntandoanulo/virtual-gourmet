package com.acme.entities.ejemplos.hilos;

class MiHilo implements Runnable {

	@Override
	public void run() {
		
			for(int i=1; i<=10; i++) {
				System.out.println(i + " Estoy corriendo desde el hilo " + Thread.currentThread().getName() +"...");
			}
		
	}
	
}

public class EjemploHilo01 {
	
	public static void main(String[] args) throws InterruptedException {
		MiHilo tarea = new MiHilo();
		Thread tr1 = new Thread(tarea, "Colombia");
		Thread tr2 = new Thread(tarea, "Peru");
		Thread tr3 = new Thread(tarea, "Chile");
		
		tr1.start();
		tr1.join();
		
		tr2.start();
		tr2.join();
		
		tr3.start();
		tr3.join();
	}
}
