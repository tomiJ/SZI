import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class crossover {

	individual child = null;
	
	crossover(roulette_wheel_selection r){
		
		child = new individual(r.parent_x.num, r.parent_x.Ox, r.parent_x.Oy);

		for (int i = 0; i < child.num.size(); i++) {
			child.num.set(i, 0);
		}
		int k = 0;
		int temp;
		int i = 0;
		while(i < child.num.size())
		{
		child.num.set(k, r.parent_x.num.get(k));
		child.Ox.set(k, r.parent_x.Ox.get(k));
		child.Oy.set(k, r.parent_x.Oy.get(k));
		k = r.parent_y.num.indexOf(child.num.get(k)); 
		i++;
		}
		
	
		
		for (int j = 0; j < child.num.size(); j++) 
		{
			if (child.num.get(j) == 0) 
			{
				
				child.num.set(j, r.parent_y.num.get(j));
				child.Ox.set(j, r.parent_y.Ox.get(j));
				child.Oy.set(j, r.parent_y.Oy.get(j));
			}
			
		}
		child.fitness();
		System.out.println(child.num + " ");
		//System.out.println(child.fitness + " ");
		
		
		
	}
	
	
}
