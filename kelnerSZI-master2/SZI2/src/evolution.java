import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class evolution {

	public static void main(String[] args) {
		
		List<table> tables = new ArrayList<table>();
		tables.add(new table(140, 143, 1));
		tables.add(new table(343, 543, 2));
		tables.add(new table(400, 400, 3));
		tables.add(new table(544, 224, 4));
		tables.add(new table(304, 604, 5));
		tables.add(new table(124, 304, 6));
		tables.add(new table(544, 224, 7));
		tables.add(new table(304, 604, 8));
		tables.add(new table(124, 304, 9));

		individual path = new individual(tables);
		
		for (int k = 1; k< 10000; k++) {
			List<individual> ind = new ArrayList<individual>();
				for (int i = 0; i < tables.size(); i++){
					Collections.shuffle(tables);
					ind.add(new individual(tables));
			
				}
		
				generation gen = new generation(ind);
					for (int i = 0; i < tables.size(); i++) {
						for (int j= 0; j < ind.get(i).num.size(); j++) {
							System.out.print(ind.get(i).num.get(j) + " ");	
						}
						System.out.println("  " + gen.probability.get(i));
					}
		
		
					roulette_wheel_selection r = new roulette_wheel_selection(gen);
					System.out.println(r.parent_x.num);
					System.out.println(r.parent_y.num);
		
					crossover c = new crossover(r);
					mutation m = new mutation();
					m.mutation(c.child);
					
					if (path.fitness < c.child.fitness) {
						path = c.child;
					}
				System.out.println(path.fitness);
				System.out.println(path.num);
			}
		}

}
