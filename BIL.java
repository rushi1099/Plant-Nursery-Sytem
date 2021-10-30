import java.lang.String.*;
import java.io.*;
import java.awt.*;
import java.awt.Font.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class BIL extends JFrame implements ActionListener

{
	JTextField billid,cust_sup,d,tot_amt,Qty,rate,customer;
	JLabel c1,c2,c3,c4,c5,c6;
	JButton save,clear,calculate,exit;
//	static JComboBox customer =new JComboBox();
			
	
	
	Connection con;
	Statement s11,s0,s111,s01,s;
	ResultSet result;
	
	  
	Calendar cal=Calendar.getInstance();
	  
    String dt=""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)+"  "+cal.get(Calendar.HOUR)+":"+(cal.get(Calendar.MINUTE))+":"+cal.get(Calendar.SECOND);;
   

int flag=0;
						
	 BIL()
		{

			Container cp=getContentPane();
            cp.setLayout(null);
		

      

		c1=new JLabel("BILL ID");
		c1.setBounds(20,50,200,20);
		cp.add(c1);
		
		c2=new JLabel("CUSTOMER SUPPLIER NAME");
		c2.setBounds(20,100,200,20);
		cp.add(c2);
		
		c3=new JLabel("DATE");
		c3.setBounds(20,150,200,20);
		cp.add(c3);
		
		c4=new JLabel(" TOTAL AMOUNT  ");
		c4.setBounds(20,200,200,20);
		cp.add(c4);
		
		c5=new JLabel("QUANTITY");
		c5.setBounds(20,250,200,20);
		cp.add(c5);

		c6=new JLabel("RATE");
		c6.setBounds(20,300,200,20);
		cp.add(c6);
		
		
	
		
		billid=new JTextField();
		billid.setBounds(200,50,200,20);
			
		cp.add(billid);
		 
		
        	customer=new JTextField();
		customer.setBounds(200,100,200,20);
		cp.add(customer);
		
		d=new JTextField();
		d.setBounds(200,150,200,20);
		d.setText(dt);	
		d.setEditable(true);	
		cp.add(d);			
		
		tot_amt=new JTextField();
		tot_amt.setBounds(200,200,200,20);
		cp.add(tot_amt);

		Qty=new JTextField();
		Qty.setBounds(200,250,200,20);
		cp.add(Qty);

		rate=new JTextField();
		rate.setBounds(200,300,200,20);
		cp.add(rate);

		save=new JButton("Print");
		save.setBounds(450,250,150,30);
		save.addActionListener(this);
		cp.add(save);
	
		clear=new JButton("CLEAR");
		clear.setBounds(450,100,150,30);
		clear.addActionListener(this);
		cp.add(clear);		
		
		
		calculate=new JButton("Get");
		calculate.setBounds(450,150,150,30);
		calculate.addActionListener(this);
		cp.add(calculate);		
		
	        
	
		exit=new JButton("HOME");
		exit.setBounds(450,200,150,30);
		exit.addActionListener(this);
		cp.add(exit);
	
	        Vector d=new Vector();Vector colname=new Vector();

		try
                {        

                   /*    Class.forName("org.postgresql.Driver");
                       Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.100.190/tydb21","ty21", "rushi1099");
                       Statement  stmt=cn.createStatement();
                       ResultSet rs=stmt.executeQuery("select * from bill");
                        while(rs.next())
                        {
                           Vector row1=new Vector();
                           row1.add(rs.getInt(1));
                           row1.add(rs.getInt(2));
                           row1.add(rs.getString(3));
			   row1.add(rs.getInt(4));
			   row1.add(rs.getInt(5));
			   row1.add(rs.getInt(6));
                           d.add(row1);
                         }
                        colname.add("bill_id");
                        colname.add("customer_id");
                        colname.add("date");
 		        colname.add("total_amt");
 			colname.add("quantity");
 			colname.add("rate");
                }*/
               

          /* try
          {        	
    		Class.forName("com.mysql.jdbc.Driver");

			String stra="nursery";
			String strb="jdbc:mysql://localhost:3306/";
			String strc="root";
			String strd="root";
			*/
			 Class.forName("org.postgresql.Driver");
                       Connection cn=DriverManager.getConnection("jdbc:postgresql://192.168.100.190/tydb21","ty21", "rushi1099");
                      
                      
				
    				String sq1="select * from supplier";
				s=con.createStatement();
		 
   				result=s.executeQuery(sq1);
   				while(result.next())
   				{ 
     		  	//customer.add(result.getString("supplier_name"));
     
    			}
    	  }
    	  catch(Exception e3)
 		  {  
 		    System.out.println(e3);
 		  }  
 		 
      	setTitle("** BILL ENTRIES **");
		
		setResizable(false);
		setSize(650,420);
		setLocationRelativeTo(null);
		setVisible(true);
	
    }		
	
            
	
	public void actionPerformed(ActionEvent ae)
	{
		Object source=ae.getSource();
		
		 if(source==save)
                {

                 int type1=Integer.parseInt(billid.getText());
                          
                String type2=cust_sup.getText();
				int type3=Integer.parseInt(d.getText());
                 float type4=Float.parseFloat(tot_amt.getText());
                   float type5=Float.parseFloat(Qty.getText());
				float type6=Float.parseFloat(rate.getText());
                         
                         
               		 
                }
                  
		
		if(source==calculate)
		{
			
		   try
          {        	
              
			String name=customer.getText();
			Class.forName("org.postgresql.Driver");
                       Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.100.190/tydb21","ty21", "rushi1099");
                      
//			con=DriverManager.getConnection(strb+stra,strc,strd);
    			String sq1="select * from supplier where supplier_name='"+name+"'";
			    s=con.createStatement();
		 
   				result=s.executeQuery(sq1);
   				while(result.next())
   				{ 
			String a11=result.getString("tplant");
			Qty.setText(a11);

     		     	billid.setText(result.getString("pid"));
     		  	d.setText(result.getString("sdate"));	
     	//Qty.setText(result.getString("tplant"));
     		  		rate.setText(result.getString("prate"));
     		  		
                    tot_amt.setText(result.getString("tamt"));
     
    			}
    	  }
    	  catch(Exception e3)
 		  {  
 		    System.out.println(e3);
 		  }  
	 	}
		
	
		if(source==clear)
		{
			billid.setText(null);
			cust_sup.setText(null);
			d.setText(null);
			Qty.setText(null);
			rate.setText(null);
			tot_amt.setText(null);
			//billid,cust_sup,d,tot_amt,Qty,rate;
		}

	
		if(source==exit)
	{
		  dispose();
	} 
	
} 

	public static void main(String args[])

	{

	new BIL();

	}





	
}
