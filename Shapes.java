import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

class Shapes extends JFrame implements ActionListener{
	  
	JComboBox <String> comboBox;
	public Shapes(){
        
        setLayout(new FlowLayout());
		add(new JLabel("Choose the Shape"));
		
		String [] shapes ={"None", "Shape 1", "Shape 2"};
		comboBox = new JComboBox<>(shapes);
		comboBox.addActionListener(this);
		add(comboBox);
		setSize(500,500);
		setVisible(true);
	}

	void drawShape1( int x,  int y,  int r1,  int r2,  int n,  Graphics g ){
		double angle1 =0;
        double angle2 = 360/(2*n);
        int x1,y1,x2,y2;
        Polygon p = new Polygon();
            for (int i=1;i<=n;i++){
                x1= (int)(x+ r1 * Math.cos(angle1*Math.PI/180));
                y1= (int)(y + r1 *Math.sin(angle1*Math.PI/180));
                x2= (int)(x+ r2 * Math.cos(angle2*Math.PI/180));
                y2= (int)(y+ r2 *Math.sin(angle2*Math.PI/180));
            p.addPoint(x1,y1);
            p.addPoint(x2,y2);
            angle1 += 360.0/n;
            angle2 += 360.0/n;
            }
        g.setColor(Color.red);
        g.drawPolygon(p);
        g.setColor(Color.blue);
        g.drawOval(x-r1,y-r1,2*r1,2*r1);
        g.drawOval(x-r2,y-r2,2*r2,2*r2);

		}
	void drawShape(Graphics g, int x, int y, int hr, int vr, int n){
		    g.setColor(Color.blue);
		    g.drawLine(x,y-2*vr,x+2*vr,y);
		    g.drawLine(x+2*vr,y,x,y+2*vr);
		    g.drawLine(x,y+2*vr,x-2*vr,y);
		    g.drawLine(x-2*vr,y,x,y-2*vr);
		    g.setColor(Color.red); 
		   for (int  i  =  1  ;  i <=  n   ;  i++  ){
		        g.drawOval ( x-hr  ,y-2*vr ,  2*hr  , 2*vr);
		       g.drawOval (  x  ,  y-hr ,  2*vr  , 2*hr  );
		       g.drawOval (  x-hr ,  y  ,  2*hr ,  2*vr  );
		        g.drawOval (  x-2*vr ,  y-hr ,  2*vr ,  2*hr  );
		        hr  =   hr - i;
		        vr  =  vr - i;

		  }
			  
			}

	
	public void paint(Graphics g){
		super.paint(g);	 
		if (comboBox.getSelectedIndex() == 1) {
			drawShape1(250,250,100,50,10,g);

	}else if (comboBox.getSelectedIndex() == 2)
		drawShape(g,250,250,40,100,10);

}
	public void actionPerformed(ActionEvent event){
		repaint();
	} 
	public static void main(String args[]){
		new Shapes();
		
	}
}
