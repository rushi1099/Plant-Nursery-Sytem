import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class HomePage extends JFrame implements ActionListener
{
	JMenuBar mb1;
	JMenu m1,m2,m3,m4;
	JMenuItem mi1,mi2;
	JLabel j1;
	public HomePage()
	{
		setLayout(null);
		setBounds(0,0,1400,900);
		ImageIcon img =new ImageIcon("rose1.jpg");

		JLabel back=new JLabel(img);
		back.setBounds(0,0,1400,700);
		
		mb1=new JMenuBar();
	
		
		m1=new JMenu("Home");
		m1.setFont(new Font("Arial",Font.BOLD,20));
		
		m2=new JMenu("Login");
		m2.setFont(new Font("Arial",Font.BOLD,20));
	
		m3=new JMenu("About us");
		m3.setFont(new Font("Arial",Font.BOLD,20));

		mi1=new JMenuItem("Customer");
		mi2=new JMenuItem("Admin");
		m2.add(mi1);
		m2.add(mi2);
		mb1.add(m1);
		mb1.add(m2);
		mb1.add(m3);
		j1=new JLabel("     PLANT NURSERY SYSTEM");
		j1.setOpaque(true);
		
		j1.setFont(new Font("Arial",Font.BOLD,40));
		j1.setLayout(null);
		j1.setBounds (350,300,700,250);
		j1.setBackground(new Color(128,128,128));
		j1.setForeground(new Color(128,0,0));
//		j1.setForeground("rose1.jpg");
		setJMenuBar(mb1);
		
		back.add(j1);
		add(back);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		if (str.equals("Customer"))
		{
			new Login();
			setVisible(false);
		}	
		else if (str.equals("Admin"))
                {
                        new Login();
                        setVisible(false);
                }
	}
	public static void main(String args[])
	{
		new HomePage();
	}
}
	
