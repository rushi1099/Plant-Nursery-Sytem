import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class hm extends JFrame implements ActionListener
{
	JButton b1,b2;
	//JPanel p1,p2,p3;
	JLabel l1,L2,l3;

public hm()
{
	setTitle("Homepage");
	//setLayout(new GridLayout(6,1));
	setLayout(null);
	setSize(1400,900);

	//Container c=this.getContentPane();
	//setLayout(new GridLayout(6,1));
	JLabel l1=new JLabel("WELCOME TO",JLabel.CENTER);
	setLayout(null);
	l1.setBounds(150,50,1000,50);
	l1.setFont(new Font("Arial",Font.BOLD,50));
	l1.setForeground(Color.white);
	 
	JLabel l3=new JLabel(" PLANT NURSERY MANAGEMENT SYSTEM",JLabel.CENTER);
	setLayout(null);
	l3.setBounds(20,150,1400,50);
	l3.setFont(new Font("Arial",Font.BOLD,50));
		

		
	JLabel l2=new JLabel("LOGIN ",JLabel.CENTER);
	setLayout(null);
	l2.setBounds(500,300,250,50);
	l2.setFont(new Font("Arial",Font.BOLD,40));
	      

	b1=new JButton("CUSTOMER");	
	setLayout(null);
	b1.setBounds(500,400,250,40);
	b1.setFont(new Font("Arial",Font.BOLD,30));
	b1.setBackground(new Color(0,255,255));

	b2=new JButton("MANAGER");
	setLayout(null);
	b2.setBounds(500,500,250,40);	
	b2.setFont(new Font("Arial",Font.BOLD,30));
	b2.setBackground(new Color(0,255,255));
	b1.addActionListener(this);
	b2.addActionListener(this);

/*	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	
	p1.add(b1);
	p2.add(b2);*/

	add(l1);
	add(l3);
	add(l2);
	//add(p2);
	//add(p1);
		
	add(b1);
	add(b2);

		JLabel jlabel3=new JLabel(new ImageIcon("plant/hm.jpg"));    
		jlabel3.setBounds(1,1,1400,900);
		add(jlabel3);

	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		if (str.equals("CUSTOMER"))
		{
			new Login();
			setVisible(false);
		}	
		else if (str.equals("MANAGER"))
                {
                        new Login();
                        setVisible(false);
                }



}

	public static void main(String args[])
	{
	      
	new hm();        
	}
}


