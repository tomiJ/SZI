
import java.util.ArrayList;
import java.util.List;



public class individual {
	double fitness;
	List<Integer> num = new ArrayList<Integer>();
	List<Integer> Ox = new ArrayList<Integer>();
	List<Integer> Oy = new ArrayList<Integer>();
	
	double bezwz(double a) {
		if (a < 0) {	
		return -a;
		}
		else 
		return a;
	}
	
	void fitness(){
		this.fitness = Math.sqrt(bezwz( (Ox.get(Ox.size()-1) - Ox.get(0))^2 + 
				(Oy.get(Oy.size()-1) - Oy.get(0) )^2 ));
		
		for(int i = 1; i<num.size(); i++)
		{
			this.fitness += Math.sqrt(bezwz( (Ox.get(i-1) - Ox.get(i))^2 + 
					(Oy.get(i-1) - Oy.get(i) )^2));
		}
		
	}
	
	individual(List<table> tab)
	{
		
		for (int i = 0; i < tab.size(); i++)
		{
			this.num.add(tab.get(i).number);
		}
		
		for (int i = 0; i< tab.size(); i++) {
			this.Ox.add(tab.get(i).ox);
			this.Oy.add(tab.get(i).oy);
		}
		
		this.fitness = Math.sqrt(bezwz( (Ox.get(Ox.size()-1) - Ox.get(0))^2 + 
				(Oy.get(Oy.size()-1) - Oy.get(0) )^2 ));
		
		for(int i = 1; i<tab.size(); i++)
		{
			this.fitness += Math.sqrt(bezwz( (Ox.get(i-1) - Ox.get(i))^2 + 
					(Oy.get(i-1) - Oy.get(i) )^2));
		}
	}
	
	individual(List<Integer> num, List<Integer> a, List<Integer> b){
		for (int i = 0; i < num.size(); i++)
		{
			this.num.add(num.get(i));
			this.Ox.add(a.get(i));
			this.Oy.add(b.get(i));
		}
		
		this.fitness = Math.sqrt(bezwz( (Ox.get(Ox.size()-1) - Ox.get(0))^2 + 
				(Oy.get(Oy.size()-1) - Oy.get(0) )^2 ));
		
		for(int i = 1; i<num.size(); i++)
		{
			this.fitness += Math.sqrt(bezwz( (Ox.get(i-1) - Ox.get(i))^2 + 
					(Oy.get(i-1) - Oy.get(i) )^2));
		}
		
		
	}
	
	
}
