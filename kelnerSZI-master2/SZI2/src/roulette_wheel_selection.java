
import java.util.Random;

public class roulette_wheel_selection {
	
	individual parent_x = null, parent_y = null;
		
	roulette_wheel_selection(generation gen)
	{	
		this.parent_x = gen.select_individual(random());
		this.parent_y = gen.select_individual(random());
	}
	
	double random() {
		Random rand = new Random();
		double random = rand.nextDouble();
		return random; 
	}

}
