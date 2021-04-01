package javaDrawing;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;
class Wheel extends JFrame implements ActionListener{
	JLabel arcsLabel = new JLabel("Arcs ");
   	JTextField arcsText = new JTextField(4);
   	JButton draw_stop = new JButton("Draw / Stop");
   	JButton spin = new JButton("Spin");
   	int arcs = 14, startAngle =0, arcAngle;
   	Timer T;
        double rot=0;
	public Wheel() { 
    	setLayout(new FlowLayout());
     	add(arcsLabel);
     	add(arcsText);
     	arcsText.setText(arcs+""); 	
     	add(draw_stop);
    	draw_stop.addActionListener(this);
     	add(spin);
     	spin.addActionListener(this);
     	setSize(300,300);
     	setResizable(false);
     	setVisible(true);
    
   	}
   	public void paint(Graphics g){
  		super.paint(g);	
   		Graphics2D go = (Graphics2D) g;
		arcAngle = (int)(Math.round(360.0/arcs));
		g.setColor(Color.black);
		g.fillOval(60,100,180, 180);

		for (int i=1;i<=arcs;i++){
			if (i%2==0) 
                	go.setColor(Color.darkGray);	
			else
			g.setColor(Color.white);
			g.fillArc(70,110,160,160,startAngle,arcAngle);
			startAngle += arcAngle;
		}
                	
		
  }
  public void actionPerformed(ActionEvent event){
 	if (event.getSource()==draw_stop){
  		arcs = Integer.parseInt(arcsText.getText());
  	 	repaint();
  	 }	
  	 //  complete the code for spinning
         try{
 	if (event.getSource()== spin){
 		T = new Timer(10, new ActionListener() {
 	        public void actionPerformed(ActionEvent e) {
 	            repaint();
 	        }
               
 	    });
 	    T.start();
  	 }	
   	if (event.getSource()== draw_stop){
              T.stop();
        }} catch (Exception e) {
  }
  }

  public static void main(String args[]){
  	new Wheel();
  }
}