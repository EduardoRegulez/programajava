package juego;
import java.util.Random;

public class Funciones {

	private ClaseCartas[] CCArray;
	private ClaseCartas[] Piramide;
	private ClaseCartas[] Mazo;
	
	public Funciones(){

		this.CCArray = new ClaseCartas[41];
		this.Piramide = new ClaseCartas[22];
		this.Mazo = new ClaseCartas[20];
		
	}
		
	
	public void MeterCartas() {
		
		ClaseCartas currentCarta;
		

		int ii= 1,iii= 1, iv = 1;
		for (int i = 1; i <= 40; i++) {
			if (i <= 10) {
				
				currentCarta = new ClaseCartas(i,i,"bastos");
				CCArray[i] = currentCarta;
			} if (i >= 11 && i <= 20) {			
				currentCarta = new ClaseCartas(i,ii++,"copas");
				CCArray[i] = currentCarta;
			} if (i >= 21 && i <= 30) {
				currentCarta = new ClaseCartas(i,iii++,"espadas");
				CCArray[i] = currentCarta;
			} if (i >= 31 && i <= 40) {
				currentCarta = new ClaseCartas(i,iv++,"oros");
				CCArray[i] = currentCarta;
			}
		}

		printCartas();
	}
	
	public void printCartas(){
		for(int i = 1 ; i < this.CCArray.length ; i++){
			System.out.println("Carta en posicion " + i + " :  " + CCArray[i]);
		}}
		
		public void barajarCartas(){
			for(int i = 0 ; i < 10000 ; i++){
				
				Random randomGenerator = new Random();
				int randNum = randomGenerator.nextInt(40);
				int randNum2 = randomGenerator.nextInt(40);
				ClaseCartas auxiliar;
				auxiliar=CCArray[randNum+1];
		        CCArray[randNum+1]=CCArray[randNum2+1];
		        CCArray[randNum2+1]=auxiliar;
			}
			for(int i = 1 ; i < this.CCArray.length; i++){
				System.out.println("Carta en posicion " + i + " :  " + CCArray[i]);
			}
			
			
	}
		
	public void Piramide(){

		for(int i = 0; i<=21; i++){
			Piramide[i]=CCArray[i];		}
		
	
	for(int i = 1 ; i < this.Piramide.length; i++){
		System.out.println("Carta at position " + i + " :  " + Piramide[i]);
	}
}
	public int PiramideID(int ID){

		
		
		return Piramide[ID].getID();
	
}
     public int PiramideNum(int Num){

		
		
		return Piramide[Num].getNumero();
	
}
	
	
	public void Mazo(){
		int increment = 0;

		for(int i = 21; i<=40; i++){
			Mazo[increment++]=CCArray[i];		}	
	
	for(int i = 1 ; i < this.Mazo.length; i++){
		System.out.println("Carta en posicion " + i + " :  " + Mazo[i]);
	}
}
	public int MazoID(int ID){
		return Mazo[ID].getID();
}
	public int MazoNum(int Num){
		return Mazo[Num].getNumero();
}
	
}
