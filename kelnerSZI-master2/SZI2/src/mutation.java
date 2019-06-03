import java.util.Random;

public class mutation {

	double probability = 0.015; //szansa ze zajdzie mutacja 3%
	
	void mutation(individual in) {
		Random rand = new Random();
		double zakres = rand.nextDouble();
		double liczba = rand.nextDouble();
		
		if (liczba <= zakres + probability && liczba >= zakres - probability) {
			Random rant = new Random();
			int i = rant.nextInt(8);
			int j = rant.nextInt(8);
			
				int num = in.num.get(i);
				int x = in.Ox.get(i);
				int y = in.Oy.get(i);
				
			in.num.set(i, in.num.get(j));
			in.Ox.set(i, in.Ox.get(j));
			in.Oy.set(i, in.Oy.get(j));
			
				in.num.set(j, num);
				in.Ox.set(j, x);
				in.Oy.set(j, y);
				in.fitness();
			//System.out.println(in.num);
		}
		
		
		
		
		
	}

}
