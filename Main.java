ackage juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {
	static int  x = 1;
	static int a = 0;
	static int b = 0;
	static int c = 0;
	static int big=0;
	static boolean start =true;
	

	public static void main(String[] args) throws InterruptedException {
		
				
		final Funciones obj = new Funciones();
		final int [] Rond2 = new int [19];
        final int [] Rond3 = new int [19];
        for(int i = 0; i>=19;i++){
        	Rond2[i]=-1;
        	Rond3[i]=-1;
        }
		System.out.println("\n meter \n");
		obj.MeterCartas();
		System.out.println("\n barajado \n");
		obj.barajarCartas();
		System.out.println("\n Piramide \n");
		obj.Piramide();
		System.out.println("\n Mazo \n");
		obj.Mazo();
		
		final JFrame menu = new JFrame("Menú Solitario Pirámide");
		menu.setSize(1900, 1000);
		menu.setVisible(true);
		//Para centrar la ventana al abrirla
		menu.setLocationRelativeTo(null);
		menu.getContentPane().setBackground(new java.awt.Color(0, 102, 0));
		menu.setLayout(null);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton boton1 = new JButton();
		boton1.setText("Jugar partida");
		boton1.setBounds(500,425,200,50);
		boton1.setBackground(new java.awt.Color(89,89,89));
		//Establece color del texto
		boton1.setForeground(Color.black);
		//Quita el marco alrededor del texto
		boton1.setFocusable(false);
		menu.add(boton1);
		
		JButton boton2 = new JButton();
		boton2.setText("Instrucciones");
		boton2.setBounds(800,425,200,50);
		boton2.setBackground(new java.awt.Color(89,89,89));
		boton2.setForeground(Color.black);
		boton2.setFocusable(false);
		menu.add(boton2);
		
	
		final JFrame frame = new JFrame("Solitario de Piramides");
		frame.setSize(1900, 1900);

		 
		JLayeredPane panel = new JLayeredPane();
		panel.setOpaque(true);
        Color tapetecolor = Color.decode("#336600");
        panel.setBackground(tapetecolor);

        
        final JButton[] cartasP = new JButton[41];
        final JLabel[] cartasPL = new JLabel[41];
        JTextArea tempor = new JTextArea();
        tempor.setBounds(50, 50, 90, 35); 
        Font font = new Font("Monospaced", Font.BOLD, 30);
        tempor.setFont(font);
        panel.add(tempor,1,0 );
        
        JTextArea puntua = new JTextArea();
        puntua.setBounds(1200, 50, 75, 50); 
        Color scoreb = Color.decode("#000000");
        puntua.setBackground(scoreb);
        Font font2 = new Font("Verdana", Font.BOLD, 40);
        puntua.setForeground(Color.WHITE);
        puntua.setFont(font2);
        panel.add(puntua,1,0);
        int score=0;
        
        
        //JLabel tecnica = new JLabel("Caja enseña posicion de carta selecionada, uso tecnico");
        //tecnica.setBounds(50, 450, 500, 30);
        //panel.add(tecnica);
        final JTextArea Valor1 = new JTextArea();
        Valor1.setBounds(50, 500, 50, 50);
        //panel.add(Valor1);
        int incre= 900;
        int incre2= 850;
        int incre3= 800;
        int incre4= 750;
        int incre5= 700;
        
        
        for(int i = 21;i>=1;i--){
        cartasP[i-1] = new JButton();
        cartasP[i-1].setIcon(new ImageIcon(  obj.PiramideID(i)+".jpg"));
        cartasPL[i-1] =new JLabel();
        cartasPL[i-1].setIcon(new ImageIcon(  obj.PiramideID(i)+".jpg"));
        
       cartasP[i-1].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	
            	for(int i = 21;i>=0;i--){
            		
            		if(e.getSource() == cartasP[i]){
            		 Valor1.setText(String.valueOf(i));	
                		
            		
            		}}}});   
       
        if(i==1){
        	 cartasPL[i-1].setBounds(950, 100, 90, 135);
        	 cartasP[i-1].setBounds(950, 100, 90, 135);
        	 panel.add(cartasPL[i-1],1,0);
        }
        if(i>=2 && i<=3){
        	cartasPL[i-1].setBounds(incre, 200, 90, 135);
        	cartasP[i-1].setBounds(incre, 200, 90, 135);
        	panel.add(cartasPL[i-1], 2, 0);
        	incre+=100;
        }
        if(i>=4 && i<=6){
        	cartasPL[i-1].setBounds(incre2, 300, 90, 135);
        	cartasP[i-1].setBounds(incre2, 300, 90, 135);
        	panel.add(cartasPL[i-1],3,0);
        	incre2+=100;
        }
        if(i>=7 && i<=10){
        	cartasPL[i-1].setBounds(incre3, 400, 90, 135);
        	cartasP[i-1].setBounds(incre3, 400, 90, 135);
        	panel.add(cartasPL[i-1],4,0);
        	incre3+=100;
        }
        if(i>=11 && i<=15){
        	cartasPL[i-1].setBounds(incre4, 500, 90, 135);  
        	cartasP[i-1].setBounds(incre4, 500, 90, 135);  
        	incre4+=100;
        	panel.add(cartasPL[i-1],5,0);
        }
        if(i>=16 && i<=21){
        	cartasP[i-1].setBounds(incre5, 600, 90, 135);
        	incre5+=100;
        	panel.add(cartasP[i-1],6,0);
        }
        
       
        }
        Valor1.setText(null);
        
        
        
        
        
        panel.add(tempor,1 ,0);
        final JButton cartasM = new JButton();
        
        if(x != 18){
        	 cartasM.setIcon(new ImageIcon(obj.MazoID(x)+".jpg")); 	
        }
        //if(a !=17 || x>=18){
        	//cartasM.setIcon(new ImageIcon(Rond2[a]+".jpg"));
        //}
        //if(b != 17 || a==17){
        	//cartasM.setIcon(new ImageIcon(Rond2[b]+".jpg"));
        //}
        
        
        
        
        
        cartasM.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {         		
            		if(e.getSource() == cartasM){
            		String m = "22";
                	Valor1.setText(String.valueOf(m));	
                	
            		
            		}}});
        cartasM.setBounds(500, 100, 90, 135); 
        panel.add(cartasM, 1, 0);
        
        JButton cartaBack = new JButton();  
        
        cartaBack = new JButton();
        cartaBack.setIcon(new ImageIcon(  "back.jpg"));
        
        
        cartaBack.addActionListener(new ActionListener (){
        	
       	 public void actionPerformed(ActionEvent e){
       		if(x!=19){
       		Rond2[big]= obj.MazoID(x);
       		System.out.println(Rond2[big]);
       		 x++;
       		 cartasM.setIcon(new ImageIcon(obj.MazoID(x)+".jpg"));
      		 big++;}
       		
       		if(x>18){
       			
       	
       		if(Rond2[a]!=-1 && a <=17){
       			cartasM.setIcon(new ImageIcon(Rond2[a]+".jpg"));
       			Rond3[c]=Rond2[a+1];
       			System.out.println(Rond3[c]);
       			a++;
       			c++;
       			
       		}
       		//if((Rond3[b]!=-1 && a>=18)){
       			//cartasM.setIcon(new ImageIcon(Rond3[b]+".jpg"));
       			
       			//b++;
       			
       		//}if(/*Rond3[b]==-1*/ b>=17){
          		// JOptionPane.showMessageDialog(null, "has perdido");
       			 //frame.dispose();

       		//}
       		  		
      
      		
       		
       		
       		 
       	//	} 
    	 
       	 
    	
    }}});
        cartaBack.setBounds(400, 100, 90, 135); 
        panel.add(cartaBack,1, 0);
        
        
        panel.setLayout(null);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setVisible(true);	
        
        final JFrame instrucciones = new JFrame("Solitario de Piramides");
        instrucciones.setSize(1900, 1900);
        instrucciones.setVisible(false);
        instrucciones.setSize(1900, 1900);
        //Para centrar la ventana al abrirla
        instrucciones.setLocationRelativeTo(null);
        instrucciones.setContentPane(new JLabel(new ImageIcon("imagenes/pergamino.png")));

        instrucciones.getContentPane().setBackground(new java.awt.Color(0, 102, 0));
        instrucciones.setLayout(null);
        instrucciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       

       
       
        boton1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e1){
        		frame.setVisible(true);
        		menu.setVisible(false);
        		start = true;

        	}});
        
        boton2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        		instrucciones.setVisible(true);
        		menu.setVisible(false);
        		

        	}});
        
        
        
        
     
     
        
         
        int minuto, minutos, segundos, milisegundos, lineas;
        lineas = 10;
        minuto = 0;
        minutos = 0;
        segundos = 0;
        milisegundos = 0;
        int[] Valores = new int[2];
        Valores[0]= 0;
        Valores[1]= 0;
        int Suma;
        int[] Borrar = new int[2];
        boolean para = true;
        boolean usado1 = false;
        boolean usado2 = false;
        if(start==true)
        	while(minuto != 2 || minutos != 5) {
        	
        	if(cartasP[0].isVisible() == false || score ==21){
        		JOptionPane.showMessageDialog(null, "has Ganado!!!!!");
        		frame.dispose();
        	}
        	
        	
        	for(int i = 0; i<20; i++){
        		
        	if(i==0 && cartasP[i+1].isVisible() == false && cartasP[i+2].isVisible() == false ){
        		panel.remove(cartasPL[i]);
    			panel.add(cartasP[i], 5, 0);
        	}
        		
        		
        	if( i>=10 && i<=14 && cartasP[i+5].isVisible() == false && cartasP[i+6].isVisible() == false ){
    			panel.remove(cartasPL[i]);
    			panel.add(cartasP[i], 4, 0);
    			
    		
        	}
        	if(i>=3 && i<=5 &&  cartasP[i+4].isVisible() == false && cartasP[i+3].isVisible() == false){
        		panel.remove(cartasPL[i]);
    			panel.add(cartasP[i],2,0);
        	}
        	
        	if( i==1 || i==2 && cartasP[i+2].isVisible() == false && cartasP[i+3].isVisible() == false){
    			
        	panel.remove(cartasPL[i]);
			panel.add(cartasP[i],1,0);
    	}
        	if(i>=6 && i<=9 && cartasP[i+4].isVisible() == false && cartasP[i+5].isVisible() == false){
        	panel.remove(cartasPL[i]);
			panel.add(cartasP[i],3,0);
    	}
        	
        }
        	
            if( Valor1.getText().isEmpty() != true && Valores[0]== 0){
            	if((Integer.valueOf(Valor1.getText())+1) >= 0 && (Integer.valueOf(Valor1.getText()) < 21 )) {
            	Valores[0]=obj.PiramideNum(Integer.valueOf(Valor1.getText())+1);
            	usado1=false;
            	
            	
            	}
            	else if((Integer.valueOf(Valor1.getText())) >= 22){
            		if(obj.MazoID(x) != obj.MazoID(18)){
            		Valores[0]=obj.MazoNum(x);
            		//JOptionPane.showMessageDialog(null, obj.MazoNum(x));
            		usado1=true;}
            		
            		 if(obj.MazoID(x) == obj.MazoID(18) /*&& Rond2[a]!=-1*/){
                		Valores[0]=obj.MazoNum(Rond2[a]);
          
                		//JOptionPane.showMessageDialog(null, obj.MazoNum(Rond2[a]));
                		usado1=true;}
            	}
            	Borrar[0] =Integer.valueOf(Valor1.getText());
            	System.out.println(Valores[0]);
            	Valor1.setText("");
            
            	
            }  if( Valor1.getText().isEmpty() != true && Valores[1]== 0 && Valores[0]!= 0) {
            	if((Integer.valueOf(Valor1.getText())+1) >= 0 && (Integer.valueOf(Valor1.getText()) < 21 )) {
            	Valores[1]=obj.PiramideNum(Integer.valueOf(Valor1.getText())+1);
            	usado2 = false;
            	
            	
            	}
            	else if((Integer.valueOf(Valor1.getText())) >= 22){
            		if(obj.MazoID(x) != obj.MazoID(18)){
            		Valores[1]=obj.MazoNum(x);
            		usado2 = true;}
            		 if(obj.MazoID(x) == obj.MazoID(18)/* && Rond2[a]!=-1*/){
            			
            		Valores[1]=obj.MazoNum(Rond2[a]);
                	usado2 = true;
            		}
            		
            	
            		
            	}
            	Borrar[1] = (Integer.valueOf(Valor1.getText()));
            	System.out.println(Valores[1]);
            	Valor1.setText("");
            	para = true;
            	//score++;
          
            }
            if(Valores[0]==10 && usado1 == false){
            	JOptionPane.showMessageDialog(null, "Es igual a 10!");
            	cartasP[Borrar[0]].setVisible(false);
            	Valor1.setText("");
            	Valores[0]= 0;
            	score++;
            }
            if(Valores[0]==10 && usado1 == true){
            	JOptionPane.showMessageDialog(null, "Es igual a 10!");
         
            	
            	Valor1.setText("");
            	Valores[0]= 0;
            	if(obj.MazoID(x) != obj.MazoID(18)){
            	x= x +1;
            	cartasM.setIcon(new ImageIcon(obj.MazoID(x)+".jpg"));
            	}
            	  
            	 if(obj.MazoID(x) == obj.MazoID(18) ){
            	a=a+1;
    			cartasM.setIcon(new ImageIcon(Rond2[a]+".jpg"));  
            }}
            
            
            
            
            
            
            if(Valores[0]!= 0 && Valores[1]!= 0 && para ==true){
            	Suma =  Valores[1] +  Valores[0];
            	
            	System.out.println("resultado"+ Suma);
            	para = false;
            	if(Suma == 10){
            		JOptionPane.showMessageDialog(null, "bien hecho!");
            		if(usado1==false){
            		cartasP[Borrar[0]].setVisible(false);
            		score++;
            		}
            		else if(usado1==true){
            			if(obj.MazoID(x) != obj.MazoID(18)){
            			x= x +1;
            			cartasM.setIcon(new ImageIcon(obj.MazoID(x)+".jpg"));  
            			}
            			
            			
            			 if(obj.MazoID(x) == obj.MazoID(18)){
            				
            				a=a+1;
            				cartasM.setIcon(new ImageIcon(Rond2[a]+".jpg"));
            				
            			}
            			
            			
    //        			array
            		}
            		if(usado2==false){
            		cartasP[Borrar[1]].setVisible(false);
            		score++;}
            		else if(usado2==true){
            			if(obj.MazoID(x) != obj.MazoID(18)){
            			x= x +1;
            			cartasM.setIcon(new ImageIcon(obj.MazoID(x)+".jpg")); 
            			}
            			
            			
            			
            			 if(obj.MazoID(x) == obj.MazoID(18) /*&& Rond2[a]!=-1*/){
            				 x= x +1;
            				cartasM.setIcon(new ImageIcon(Rond2[a]+".jpg"));
            				
            			}
            			
            			
            			
            		}
            		Valores[0]= 0;
                    Valores[1]= 0;
            		
            	}
            	
            	
            	if(Suma != 10){
            		JOptionPane.showMessageDialog(null, "No te da resultado de 10!");
            		Valores[0]= 0;
                    Valores[1]= 0;
            	}
            	
            }
            
               
			Thread.sleep(1000);
	        milisegundos = milisegundos + 1;
	        if(milisegundos > 9) {
	            milisegundos = 0;
	            segundos = segundos + 1;
	        }
	        if(segundos > 5) {
	            segundos = 0;
	            minutos = minutos + 1;
	        }
	        if(minutos > 9) {
	            minutos = 0;
	            minuto = minuto + 1;
	        }
	        
	        for (int i=0; i < lineas; i++)
	        {
	        System.out.println("");
	        }
	    	tempor.setText(null);
			puntua.setText(String.valueOf(score));
			
			tempor.append(String.valueOf(minuto)+ String.valueOf(minutos)+  ":" + String.valueOf(segundos)+ String.valueOf(milisegundos));
			
	        
	        }
	     
	            
	        
	            
	            JFrame ventana = new JFrame("¡Tiempo agotado!");
	            ventana.setSize(250,100);
	            ventana.setLocationRelativeTo(null);
	            ventana.setVisible(true);
	            ventana.setLayout(null);
	            ventana.getContentPane().setBackground(new java.awt.Color(0, 102, 0));
	            
	            final JButton boton = new JButton("Ok");
	            boton.setBounds(80,5,90,50);
	            boton.setFocusable(false);
	            //boton.setBackground(java.awt.Color.red);
	            ventana.add(boton);
	          
	        
	            boton.addActionListener(new ActionListener(){
	                public void actionPerformed(ActionEvent e) {
	             if (e.getSource()==boton) {
	                    System.exit(0);
	                }    
	}});
		
	}





	}
