import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import weka.core.converters.ConverterUtils.DataSource;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.trees.J48;



public class Plansza extends JPanel implements ActionListener {
	
	private Rectangle pojazd;
	Rectangle[] kontenery = new Rectangle[] {
			
			new Rectangle(485,765,30,30),
			new Rectangle(525,765,30,30),
			new Rectangle(565,765,30,30),
			new Rectangle(605,765,30,30),
			new Rectangle(645,765,30,30),
			new Rectangle(685,765,30,30)
				
	};
	
	  
	
	private Rectangle przeszkoda1;private Rectangle przeszkoda2;private Rectangle przeszkoda3;private Rectangle przeszkoda4;
	private Rectangle przeszkoda5;private Rectangle przeszkoda6;private Rectangle przeszkoda7;private Rectangle przeszkoda8;
	private Rectangle przeszkoda9;private Rectangle przeszkoda10;
	private Rectangle przeszkoda11;private Rectangle przeszkoda12;private Rectangle przeszkoda13;private Rectangle przeszkoda14;
	private Rectangle przeszkoda15;private Rectangle przeszkoda16;private Rectangle przeszkoda17;private Rectangle przeszkoda18;
	private Rectangle przeszkoda19;private Rectangle przeszkoda20;private Rectangle przeszkoda21;

	private Rectangle klient1;
	private Rectangle klient2;
	private Rectangle klient3;
	private Rectangle klient4;
	private Rectangle klient5;
	private Rectangle klient6;


	private Rectangle krzeslo1;
	private Rectangle krzeslo2;
	private Rectangle krzeslo3;
	private Rectangle krzeslo4;
	private Rectangle krzeslo5;
	private Rectangle krzeslo6;
	private Rectangle krzeslo7;
	private Rectangle krzeslo8;

	
	int[][] Blokady = {

			{1,3},{1,4},{1,5},{1,13},{1,14},{1,15},
			{2,3},{2,4},{2,5},{2,13},{2,14},{2,15},
			{3,3},{3,4},{3,5},{3,13},{3,14},{3,15},
			{7,3},{7,4},{7,5},{7,13},{7,14},{7,15},
			{8,3},{8,4},{8,5},{8,13},{8,14},{8,15},
			{9,3},{9,4},{9,5},{9,13},{9,14},{9,15},
			{11,4},{11,5},{11,6},{11,7},{11,8},{11,9},{11,10},{11,11},{11,12},{11,13},{11,14},
			{2,2},{2,6},{2,12},{2,16},{8,2},{8,6},{8,12},{8,16}
	
	
	};
	
	static Timer timer;
	private int rozmiarPojazdu = 40;
	private int rozmiarPlanszy=880;
	JTextArea pole;
	JTextField pole2;
	JButton potwierdz;
	private int x=400;
	private int y=400;
	Plansza(){

		pojazd = new Rectangle(x,y,rozmiarPojazdu,rozmiarPojazdu);
		
		
		//Przeszkody
		przeszkoda1 = new Rectangle(40*4,40*5,120,120);
		przeszkoda2 = new Rectangle(40*14,40*5,120,120);
		przeszkoda3 = new Rectangle(40*4,40*11,120,120);
		przeszkoda4 = new Rectangle(40*14,40*11,120,120);
	/*	przeszkoda5 = new Rectangle(40*10,40*5,40,40);
		przeszkoda6 = new Rectangle(40*11,40*5,40,40);
		przeszkoda7 = new Rectangle(40*16,40*6,40,40);
		przeszkoda8 = new Rectangle(40*17,40*6,40,40);
		przeszkoda9 = new Rectangle(40*18,40*6,40,40);*/
		przeszkoda10 = new Rectangle(40*5,40*15,40,40);
		przeszkoda11 = new Rectangle(40*6,40*15,40,40);
		przeszkoda12 = new Rectangle(40*7,40*15,40,40);
		przeszkoda13 = new Rectangle(40*8,40*15,40,40);
		przeszkoda14 = new Rectangle(40*9,40*15,40,40);
		przeszkoda15 = new Rectangle(40*10,40*15,40,40);
		przeszkoda16 = new Rectangle(40*12,40*15,40,40);
		przeszkoda17 = new Rectangle(40*13,40*15,40,40);
		przeszkoda18 = new Rectangle(40*14,40*15,40,40);
		przeszkoda19 = new Rectangle(40*15,40*15,40,40);
		przeszkoda20 = new Rectangle(40*11,40*15,40,40);

		klient1 = new Rectangle(40*3+5,40*6+5,30,30);
		klient2 = new Rectangle(40*13+5,40*6+5,30,30);
		klient3 = new Rectangle(40*3+5,40*12+5,30,30);
		klient4 = new Rectangle(40*13+5,40*12+5,30,30);
		klient5 = new Rectangle(40*17+5,40*6+5,30,30);
		klient6 = new Rectangle(40*7+5,40*12+5,30,30);

		krzeslo1 = new Rectangle(40*3,40*6,40,40);
		krzeslo2 = new Rectangle(40*13,40*6,40,40);
		krzeslo3 = new Rectangle(40*3,40*12,40,40);
		krzeslo4 = new Rectangle(40*13,40*12,40,40);
		krzeslo5 = new Rectangle(40*17,40*6,40,40);
		krzeslo6 = new Rectangle(40*7,40*12,40,40);
		krzeslo7 = new Rectangle(40*7,40*6,40,40);
		krzeslo8 = new Rectangle(40*17,40*12,40,40);

		
		
		
		setBackground(Color.lightGray);
		setPreferredSize(new Dimension(500,500));
		setLayout(null);
		JPanel polecenia=new Polecenia();
		polecenia.setBounds(rozmiarPlanszy,0, 300, rozmiarPlanszy);
		add(polecenia);
		polecenia.setLayout(null);
		
		pole = new JTextArea();
		pole2 = new JTextField();
		pole.setFont(new Font("Arial", Font.PLAIN, 16));
		pole.setLineWrap(true);
		pole.setWrapStyleWord(true);
		JScrollPane sp = new JScrollPane(pole);
		sp.setBounds(10, 10, 275, 700);
		pole2.setBounds(10, 710, 275, 40);
		pole2.addActionListener(this);
		polecenia.add(pole2);
		polecenia.add(sp);
		potwierdz = new JButton("A*");
		potwierdz.setBounds(10, 755, 200,50);
		polecenia.add(potwierdz);
		potwierdz.addActionListener(this);
		
		setFocusable(true);
		ruch();	
		
	}
	public void paintComponent(Graphics graphics){
		
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		Graphics2D droga = (Graphics2D) graphics;
		droga.setStroke(new BasicStroke(5));
		graphics2d.setColor(Color.GRAY);
		graphics2d.fill(przeszkoda1);
		graphics2d.fill(przeszkoda2);
		graphics2d.fill(przeszkoda3);
		graphics2d.fill(przeszkoda4);
		//graphics2d.fill(przeszkoda5);
		//graphics2d.fill(przeszkoda6);
		//graphics2d.fill(przeszkoda7);
		//graphics2d.fill(przeszkoda8);
		//graphics2d.fill(przeszkoda8);
		//graphics2d.fill(przeszkoda9);
		graphics2d.fill(przeszkoda10);
		graphics2d.fill(przeszkoda11);
		graphics2d.fill(przeszkoda12);
		graphics2d.fill(przeszkoda13);
		graphics2d.fill(przeszkoda14);
		graphics2d.fill(przeszkoda15);
		graphics2d.fill(przeszkoda16);
		graphics2d.fill(przeszkoda17);
		graphics2d.fill(przeszkoda18);
		graphics2d.fill(przeszkoda19);
		graphics2d.fill(przeszkoda20);
		graphics2d.setColor(Color.ORANGE);
		graphics2d.fill(krzeslo1);
		graphics2d.fill(krzeslo2);
		graphics2d.fill(krzeslo3);
		graphics2d.fill(krzeslo4);
		graphics2d.fill(krzeslo5);
		graphics2d.fill(krzeslo6);
		graphics2d.fill(krzeslo7);
		graphics2d.fill(krzeslo8);
		graphics2d.setColor(Color.GREEN);
		graphics2d.fill(klient1);
		graphics2d.fill(klient2);
		graphics2d.fill(klient3);
		graphics2d.fill(klient4);
		graphics2d.fill(klient5);
		graphics2d.fill(klient6);


		graphics2d.setColor(Color.black);
		graphics2d.fill(pojazd);
		graphics2d.setColor(Color.red);
		graphics2d.fill(kontenery[0]);
		graphics2d.setColor(Color.red);
		graphics2d.fill(kontenery[1]);
		graphics2d.setColor(Color.red);
		graphics2d.fill(kontenery[2]);
		graphics2d.setColor(Color.red);
		graphics2d.fill(kontenery[3]);
		graphics2d.setColor(Color.red);
		graphics2d.fill(kontenery[4]);
		graphics2d.setColor(Color.red);
		graphics2d.fill(kontenery[5]);
		

		
	
		
		droga.setColor(Color.black);
		
		Font font = new Font("Arial", Font.BOLD, 24);
		droga.setFont(font);		
		
		Rectangle2D stolik1 = new Rectangle2D.Double(160,200,120,120);
		droga.draw(stolik1);
		
		Rectangle2D stolik2 = new Rectangle2D.Double(560,200,120,120);
		droga.draw(stolik2);
			
		Rectangle2D stolik3 = new Rectangle2D.Double(160,440,120,120);
		droga.draw(stolik3);
			
		
		Rectangle2D stolik4 = new Rectangle2D.Double(560,440,120,120);
		droga.draw(stolik4);
		
		Rectangle2D przyjazd = new Rectangle2D.Double(440,720,320,120);
		droga.draw(przyjazd);
		
		droga.setStroke(new BasicStroke(1));
		droga.setColor(Color.gray);
		for(int i=0; i<rozmiarPojazdu; i++){
			droga.draw(new Line2D.Double(i*rozmiarPojazdu, 0, i*rozmiarPojazdu, rozmiarPlanszy));
			droga.draw(new Line2D.Double(0, i*rozmiarPojazdu, rozmiarPlanszy, i*rozmiarPojazdu));
		}
		
		droga.setStroke(new BasicStroke(3));
		droga.setColor(Color.black);
		droga.draw(new Line2D.Double(40, 160, 20*40, 160));
		droga.draw(new Line2D.Double(40, 18*40, 20*40, 18*40));
		droga.draw(new Line2D.Double(40, 160, 40, 18*40));
		droga.draw(new Line2D.Double(20*40, 160, 20*40, 18*40));
		
		
		droga.setStroke(new BasicStroke(1));
		droga.setColor(Color.gray);
		
		droga.drawString("0", 5, 190);
		droga.drawString("2", 5, 190+2*40);
		droga.drawString("4", 5, 190+4*40);
		droga.drawString("6", 5, 190+6*40);
		droga.drawString("8", 5, 190+8*40);
		droga.drawString("10", 5, 190+10*40);
		droga.drawString("12", 5, 190+12*40);
		
		droga.drawString("0", 45, 190+14*40);
		droga.drawString("2", 45+2*40, 190+14*40);
		droga.drawString("4", 45+4*40, 190+14*40);
		droga.drawString("18", 45+18*40, 190+14*40);
		
		
		droga.setColor(Color.blue);
		droga.drawString("Stolik 1", 4*40+15, 4*40+30);
		droga.drawString("Stolik 2", 14*40+15, 4*40+30);
		droga.drawString("Stolik 3", 4*40+15, 10*40+30);
		droga.drawString("Stolik 4", 14*40+15, 10*40+30);
		droga.drawString("Kuchnia", 455, 750);
	}
		
	
	public void przesunPojazdX(int przesuniecie){	
		pojazd.setBounds((int)pojazd.getX()+przesuniecie, (int)pojazd.getY(), (int)pojazd.getWidth(), (int)pojazd.getHeight());		
	}
	
	public void przesunPojazdY(int przesuniecie){
		pojazd.setBounds((int)pojazd.getX(), (int)pojazd.getY()+przesuniecie, (int)pojazd.getWidth(), (int)pojazd.getHeight());
	}
	
	
	
	public void ruch(){
		timer = new Timer();
	}
	
	//wspolrzedne kontenerow
	int[] kontener1xy = {485,765};
	int[] kontener2xy = {525,765};
	int[] kontener3xy = {565,765};
	
	int[] polka1temp={0,0}; 
	int polka2temp=0, polka3temp=0, polka4temp=0, polka5temp=0, intemp=0;
	//polka 1
	int[] polka1miejsce1 = {4*40+5,6*40+5,0};
	int[] polka1miejsce2 = {6*40+5,6*40+5,0};
	//polka 2
	int[] polka2miejsce1 = {14*40+5,6*40+5,0};
	int[] polka2miejsce2 = {16*40+5,6*40+5,0};
	//polka 3
	int[] polka3miejsce1 = {4*40+5,12*40+5,0};
	int[] polka3miejsce2 = {6*40+5,12*40+5,0};
	//polka 4
	int[] polka4miejsce1 = {14*40+5,12*40+5,0};
	int[] polka4miejsce2 = {16*40+5,12*40+5,0};
	

	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {



		Klient[] klienci = new Klient[] {
				new Klient("good", "average", "long", "good", "$$"),
				new Klient("low", "dirty", "short", "average", "$$$"),
				new Klient("average", "scrapHeap", "average", "bad", "$"),
				new Klient("good", "dirty", "long", "good", "$$$$"),
				new Klient("great", "clean", "short", "good", "$$"),
				new Klient("average", "clean", "tooLong", "terrible", "$"),
				};

		if(e.getSource()==pole2 || e.getSource()==potwierdz){

		int pom_x = -1; int pom_y = -1;
		int ppom_x = -1; int ppom_y = -1;

		String sciezka_astar="";




		// tree decision------------------------------------------------------------
							DataSource source = null;
							try {
								source = new DataSource("resources/dataSet.arff");
							} catch (Exception e1) {

								e1.printStackTrace();
							}
							 Instances data = null;
							try {
								data = source.getDataSet();
							} catch (Exception e1) {

								e1.printStackTrace();
							}
							 // setting class attribute if the data format does not provide this information
							 // For example, the XRFF format saves the class attribute information as well
							 if (data.classIndex() == -1)
							   data.setClassIndex(data.numAttributes() - 1);

							 String[] options = new String[1];
							 options[0] = "-U";
							 J48 tree = new J48();
							 try {
								tree.setOptions(options);
							} catch (Exception e1) {

								e1.printStackTrace();
							}     // set the options
							 try {
								tree.buildClassifier(data);
							} catch (Exception e1) {

								e1.printStackTrace();
							}   // build classifier

							 System.out.println(tree);




		// ruch wozka od srodka do strefy in --------------------------------------------------------

		pole.append("W->: Ruszam do kuchni\n");

		sciezka_astar=AStar.test(1, 14, 19, 6, 9, 13, 11, Blokady);
		//pole.append("W->:"+ sciezka_astar +"\n");

		sciezka_astar.substring(0,sciezka_astar.length()-1);

		String[] tab_sciezka = sciezka_astar.split("\\s+");

		for (int i = tab_sciezka.length-1; i >= 1 ; i--) {

			String temp;
			temp = tab_sciezka[i].replace("[", "");
			temp = temp.replace("]", "");


		   	String[] parts = temp.split(",");
		   	String part1 = parts[0];
		   	String part2 = parts[1];


		   	int y = Integer.parseInt(part1);
		   	int x = Integer.parseInt(part2);

		   	pojazd.setLocation(x*40 + 40, y*40 + 160);
			paintAll(getGraphics());

			try {     // krok co 0.5 sekundy
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}

		}


		// koniec ruchu wozka od srodka do strefy in --------------------------------------------------------



		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}



		List<table> tables = new ArrayList<table>();
		tables.add(new table(160, 200, 1));
		tables.add(new table(560, 200, 2));
		tables.add(new table(160, 440, 3));
		tables.add(new table(560, 444, 4));
		tables.add(new table(160, 200, 1));
		tables.add(new table(560, 200, 2));

		
		individual path = new individual(tables);
		
		for (int k = 1; k< 10; k++) {
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
		
		
		int dw = 0;
		// OBSLUGA KLIENTOW	---------------------------------------
		for (int n = 0; n < klienci.length ; n++) 
		{
			
			 dw = path.num.get(n);
			
			
			


					Instance instance = new DenseInstance(7);
					instance.setDataset(data);
					instance.setValue(data.attribute(0), klienci[n].jakoscJedzenia);
					instance.setValue(data.attribute(1), klienci[n].czystoscRestauracji);
					instance.setValue(data.attribute(2), klienci[n].czasOczekiwania);
					instance.setValue(data.attribute(3), klienci[n].jakoscObslugi);
					instance.setValue(data.attribute(4), klienci[n].cenaPosilku);


					int stolik = 0;
					if(dw == 1) {
						pom_x = 4;
						pom_y = 4;
						stolik = 1;
						if (polka1miejsce1[2] == 0) {
							ppom_x = polka1miejsce1[0];
							ppom_y = polka1miejsce1[1];
							polka1miejsce1[2] = 1;
						} else if (polka1miejsce2[2] == 0) {
							ppom_x = polka1miejsce2[0];
							ppom_y = polka1miejsce2[1];
							polka1miejsce2[2] = 1;
						}
					}
					else if(dw == 2)
					{
						pom_x = 4;
						pom_y = 14;
						stolik = 2;
						if (polka2miejsce1[2]==0){
							ppom_x = polka2miejsce1[0];
							ppom_y = polka2miejsce1[1];
							polka2miejsce1[2]=1;
						} else if (polka2miejsce2[2]==0) {
							ppom_x = polka2miejsce2[0];
							ppom_y = polka2miejsce2[1];
							polka2miejsce2[2] = 1;
						}
					}
					else if(dw == 3)
					{
						pom_x = 10;
						pom_y = 4;
						stolik = 3;
						if (polka3miejsce1[2]==0){
							ppom_x = polka3miejsce1[0];
							ppom_y = polka3miejsce1[1];
							polka3miejsce1[2]=1;
						} else if (polka3miejsce2[2]==0) {
							ppom_x = polka3miejsce2[0];
							ppom_y = polka3miejsce2[1];
							polka3miejsce2[2] = 1;
						}
					}
					else if (dw == 4) {
						pom_x = 10;
						pom_y = 14;
						stolik = 4;
						if (polka4miejsce1[2] == 0) {
							ppom_x = polka4miejsce1[0];
							ppom_y = polka4miejsce1[1];
							polka4miejsce1[2] = 1;
						} else if (polka4miejsce2[2] == 0) {
							ppom_x = polka4miejsce2[0];
							ppom_y = polka4miejsce2[1];
							polka4miejsce2[2] = 1;
						}
					}


					sciezka_astar=AStar.test(1, 14, 19, 13, 11, pom_x, pom_y, Blokady);
					sciezka_astar.substring(0,sciezka_astar.length()-1);

					String[] tab_sciezka2 = sciezka_astar.split("\\s+");

					for (int i = tab_sciezka2.length-1; i >= 1 ; i--) {

						String temp;
						temp = tab_sciezka2[i].replace("[", "");
						temp = temp.replace("]", "");


					   	String[] parts = temp.split(",");
					   	String part1 = parts[0];
					   	String part2 = parts[1];


					   	int y = Integer.parseInt(part1);
					   	int x = Integer.parseInt(part2);

					   	pojazd.setLocation(x*40 + 40, y*40 + 160);
					   	kontenery[n].setLocation(x*40 + 40, y*40 + 160);
						paintAll(getGraphics());

						try {     // krok co 0.5 sekundy
							TimeUnit.MILLISECONDS.sleep(300);
						} catch (InterruptedException e1) {

							e1.printStackTrace();
						}

					}

					kontenery[n].setLocation(ppom_x,ppom_y);
					paint(getGraphics());
					pole.append("W:-> Przeniesiono zamowienie na stolik: " + stolik + ".\n");



	//////////////////// CZY DAC NAPIWEK
					int result = -1;

					try {
						result = (int) tree.classifyInstance(instance);
					} catch (Exception e1) {

						e1.printStackTrace();
					}

					pole.append("\n");
					pole.append("KLIENT:-> Jakosc jedzenia: " + klienci[n].jakoscJedzenia + "\n");
					pole.append("KLIENT:-> Czystosc restauracji: " + klienci[n].czystoscRestauracji + "\n");
					pole.append("KLIENT:-> Czas oczekiwania: " + klienci[n].czasOczekiwania + "\n");
					pole.append("KLIENT:-> Jakosc obslugi: " + klienci[n].jakoscObslugi + "\n");
					pole.append("KLIENT:-> Cena posilku: " + klienci[n].cenaPosilku + "\n");
					pole.append("\n");

					if(result == 1){
						pole.append("TREE:-> Klient stwierdzil, ze nie otrzymasz napiwku :(\n");
					}
					else if (result == 0){
						pole.append("TREE:-> Klient stwierdzil, ze otrzymasz napiwek :)\n");
					}
					else{
						pole.append("TREE:->Drzewko nie ogarnelo sprawy :O.\n");
					}

					pole.append("\n");



					sciezka_astar=AStar.test(1, 14, 19, pom_x, pom_y, 13, 11, Blokady);
					sciezka_astar.substring(0,sciezka_astar.length()-1);

					String[] tab_sciezka3 = sciezka_astar.split("\\s+");

					for (int i = tab_sciezka3.length-1; i >= 1 ; i--) {

						String temp;
						temp = tab_sciezka3[i].replace("[", "");
						temp = temp.replace("]", "");


					   	String[] parts = temp.split(",");
					   	String part1 = parts[0];
					   	String part2 = parts[1];


					   	int y = Integer.parseInt(part1);
					   	int x = Integer.parseInt(part2);

					   	pojazd.setLocation(x*40 + 40, y*40 + 160);

						paintAll(getGraphics());

						try {     // krok co 0.5 sekundy
							TimeUnit.MILLISECONDS.sleep(300);
						} catch (InterruptedException e1) {

							e1.printStackTrace();
						}

					}




		}

		}

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		repaint();

	}
}
