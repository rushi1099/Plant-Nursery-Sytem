import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Home1 extends JFrame implements ActionListener//,ItemListener
 {
   JLabel L1,L2;
   JComboBox jcb;
 JPanel p1,p2;
 public Home1()
 {
   setTitle("HOMEPAGE OF NURSERY MANAGEMENT SYSTEM");
   setLayout(new BorderLayout());
   L1=new JLabel("HOMEPAGE",JLabel.CENTER);
   L2=new JLabel("WELCOME TO NURSERY MANAGEMENT SYSTEM",JLabel.CENTER);
    p1=new JPanel();
    p2=new JPanel();


	jcb=new JComboBox();
	p1.add(jcb);
	add(p1,BorderLayout.CENTER);
	jcb.addItem("CUSTOMER");
	jcb.addItem("ADMIN");
//	jcb.addactionlistener(new ActionListener());
	add(L1);
	add(L2);
	add(p1);
	add(p2);
	add(jcb);		
}
	public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==jcb)
	{
	new Login();
	}
	setSize(400,200);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class Home
{
public static void main(String[] args)
{
 new Home1();
}
}
    
