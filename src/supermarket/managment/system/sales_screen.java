/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ME2
 */
public class sales_screen extends JFrame implements ActionListener{
   
    JTextField pid,pammount;
    JButton m_order,k_order,more,new1;
    JLabel make,cancel;
    private Component frame;
    JOptionPane message;
            
    
    public void show_sales_screen () throws SQLException, ClassNotFoundException{
    this.setLayout(null);
    
    
    make=new JLabel("Product id");
    cancel = new JLabel("Product ammount");
    make.setBounds(220, 60, 110, 30);
    cancel.setBounds(220, 160, 110, 30);
    
    make.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14)); 
    cancel.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
    
    add(make);
        add(cancel);
        
        pid=new JTextField();
        pammount = new JTextField();
        
        pid.setBounds(390, 60, 170, 30);
        pammount.setBounds(390, 160, 170, 30);
        
        add(pid);
        add(pammount);
        
        //.................
        m_order = new JButton("make order");
        m_order.setAlignmentX(CENTER_ALIGNMENT);
        m_order.setBounds(120, 270, 120, 25);
        m_order.setBackground(Color.white);
        m_order.addActionListener(this);
        add(m_order);
        k_order = new JButton("cancel order");
        k_order.setAlignmentX(CENTER_ALIGNMENT);
        k_order.setBounds(250, 270, 120, 25);
        k_order.setBackground(Color.white);
        k_order.addActionListener(this);
        add(k_order);
        more=new JButton("more opthions");
        more.setBounds(510, 270, 120, 25);
        more.setBackground(Color.white);
        more.addActionListener(this);
        add(more);
        new1 = new JButton("new one");
        
        new1.setBounds(380, 270, 120, 25);
        new1.setBackground(Color.white);
        new1.addActionListener( this);
        add(new1);
        //.................
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(850, 600);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        try{
            if (e.getSource()==new1){
             pid.setText(" ");
             pammount.setText(" ");
          }
           if (e.getSource() == m_order) {
               int i;
            i=database.inventory_db.make_order(Integer.parseInt(pid.getText()),Float.parseFloat( pammount.getText()));
            if (i == 1)
                message.showMessageDialog( frame , "be carefull product "+pid.getText()+" become less than 20");
            
            else if (i==0) message.showMessageDialog( frame , "Error :: the product "+pid.getText()+" has no ammount in inventory");
            
             message.showMessageDialog( frame , "the price of order is " +database.inventory_db.select3(Integer.parseInt(pid.getText()))*Float.parseFloat( pammount.getText()) );
            
        }
          if (e.getSource() == k_order) {
             database.inventory_db.cancel_order(Integer.parseInt(pid.getText()), Float.parseFloat( pammount.getText()));
             message.showMessageDialog( frame , "Order canceled");
          
          }
          if(e.getSource()==more){
            new more_option_sales().show_more_option_sales_screen();
          
          }
         
          }
           catch(Exception j){
                j.getLocalizedMessage();
              }
    }
    
}
