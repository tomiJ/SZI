import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class generation {
	List<individual> generation = new ArrayList<individual>();
	List<Double> probability = new ArrayList<Double>();
	double total_fitness = 0;
	

	
	
	generation(){;
		
	}
	
	void generation_shuffle() {
		Collections.shuffle(generation);
		
	}
	generation(List<individual> p){
		this.generation = p;
		
		for(int i=0;i<generation.size();i++){ 
		    this.total_fitness += generation.get(i).fitness;
		} 
		
		for (int i=0; i<generation.size() ;i++) {
			probability.add(generation.get(i).fitness / total_fitness);
		}
		
	}
	
	
	
	individual select_individual(double rand) {
		individual res = null;
		double position = probability.get(0);
		int i = 0;
		System.out.println(rand);
		while(position < rand)
		{
			i++;
			position += probability.get(i);
			
		}
		
		res = generation.get(i);
		//generation.remove(i); jest problem z gen.size
		generation_shuffle();
		return res;
	}
	
	
	void print_generation(){
		//napisz
	}
	
	
}
