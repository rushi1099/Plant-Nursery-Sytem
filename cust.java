import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cust extends JFrame implements ActionListener
{
	Container con=this.getContentPane();
	DefaultTableModel dm;
	JTable jt;
	Vector rows,header,row1;

	
	Connection cn;
	String str;
	Statement stmt;
	
	JButton close=new JButton("CLOSE");

	public cust()
	{
		con.setLayout(null);
		
		rows=new Vector();
		header=new Vector();
		header.addElement("CUSTOMER ID");
		header.addElement("CUSTOMER NAME");
		header.addElement("CUSTOMER CONTACT");
	
    
	
           	      /*	try
		{
    	          Class.forName("org.postgresql.Driver");
                  Connection conn=DriverManager.getConnection("jdbc:postgresql://192.168.100.190/tydb21","ty21", "rushi1099");
 

                  
                     String stra="nursery";
			String strb="jdbc:mysql://localhost:3306/";
			String strc="root";
			String strd="root";
			
			
			Connection cn=DriverManager.getConnection(strb+stra,strc,strd);
		       Statement  stmt=conn.createStatement();
                }
		catch(SQLException ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		catch(ClassNotFoundException ae)
		{
			System.out.print("Class not found");
				ae.printStackTrace();
		}*/ Vector d=new Vector();Vector colname=new Vector();
		try
		{        
                       Class.forName("org.postgresql.Driver");
                       Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.100.190/tydb21","ty21", "rushi1099");
                        Statement  stmt=cn.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from customer");
                       
			while(rs.next())
			{
			       Vector row1=new Vector();
				row1.add(rs.getInt(1));
				row1.add(rs.getString(2));
				row1.add(rs.getInt(3));
				
		       		d.add(row1);
                                
                        }
                        
			colname.add("customer_id");
			colname.add("customer_name");
			colname.add("customer_contact");
                    
                      
		}
                 catch(Exception e)
                 {
                    System.out.println(e);
                  }
		/*catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}*/
		
		
		dm=new DefaultTableModel(rows,header);
		jt=new JTable(d,colname);		
		JScrollPane p=new JScrollPane(jt);
		p.setBounds(30,40,700,450);
		con.add(p);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);

		close.setBounds(320,505,100,30);
		con.add(close);
	        close.addActionListener(this);
		close.setToolTipText("Close");
		
		setTitle("**  CUSTOMER LIST  **");
		setResizable(false);
		
		setSize(765,580);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new cust();
	
	}


	public void actionPerformed(ActionEvent e)
	{
		String title=e.getActionCommand();
		if(title=="CLOSE")
		{
			dispose();
		}
		
	
	}
}
