package game_looping;

public class Game implements Runnable {
	
	private boolean isRunning;
	private Thread thread;
	
	public static void main (String [] args) {
		
		Game game = new Game();
		game.start();
		
	}
	
	public synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void tickt() {
		//Atualizando o jogo
		System.out.println("Tickt");
	}
	
	public void render() {
		//Renderizando o jogo
		System.out.println("Render");
	}

	@Override
	public void run() {
		System.out.println("Jogo começou:");
		while(isRunning) {
			tickt();
			render();
			
			//Modo velocidade genérico básico de rodar o jogo
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
