package dpong;

import javax.crypto.SecretKey;

public class Main {
	
	public static final int TICKS_PER_SECOND = 20;
	public static final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	public static final int MAX_FRAMESKIP = 5;
	
	public static long next_game_tick;
	public static int loops;
	public static float interpolation;
	
	public static void main(String[] args) {
		DPong game = new DPong();
		
		next_game_tick = System.currentTimeMillis();
		
		while(!game.isClosed()){
			loops = 0;
			//tick
			while(System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP){
				game.tick();
				next_game_tick += SKIP_TICKS;
				loops++;
			}
			//render
			interpolation = (float)(System.currentTimeMillis() + SKIP_TICKS - next_game_tick) / (float)SKIP_TICKS;
			/*System.out.println(interpolation);
			System.out.println(System.currentTimeMillis());
			System.out.println(SKIP_TICKS);
			System.out.println(next_game_tick);
			System.out.println(SKIP_TICKS - next_game_tick / SKIP_TICKS);*/
			game.draw(interpolation);
			/*try {
				//Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		game.dispose();		
	}

}
