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
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ME2
 */
public class add_pro extends JPanel implements ActionListener {
    
    JLabel pro_id,pro_name, pro_price, pro_ammount;
    JTextField id1,fname1, lname1, age1;
    JButton add_Em, new1;
    JOptionPane jop;
    private Component frame;
        

    public add_pro() {
        this.setLayout(null);
        //............

        //.........
        pro_id=new JLabel("Pro ID");
        pro_name = new JLabel("Pro name");
        pro_price = new JLabel("Pro Price");
        pro_ammount = new JLabel("Pro Ammount");
        
        pro_id.setBounds(200, 50, 100, 30);
        pro_name.setBounds(200, 100, 100, 30);
        pro_price.setBounds(200, 150, 100, 30);
        pro_ammount.setBounds(200, 200, 100, 30);
        
        pro_id.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        pro_name.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        pro_price.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        pro_ammount.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        
        add(pro_id);
        add(pro_name);
        add(pro_price);
        add(pro_ammount);
        
        //..................
        id1=new JTextField();
        fname1 = new JTextField();
        lname1 = new JTextField();
        age1 = new JTextField();
        
        id1.setBounds(350, 50, 170, 30);
        fname1.setBounds(350, 100, 170, 30);
        lname1.setBounds(350, 150, 170, 30);
        age1.setBounds(350, 200, 170, 30);
        
        add(id1);
        add(fname1);
        add(lname1);
        add(age1);
        
        //.................
        add_Em = new JButton("ADD");
        add_Em.setAlignmentX(CENTER_ALIGNMENT);
        add_Em.setBounds(250, 270, 80, 25);
        add_Em.setBackground(Color.white);
        add_Em.addActionListener(this);
        add(add_Em);
        new1 = new JButton("NEW");
        new1.setAlignmentX(CENTER_ALIGNMENT);
        new1.setBounds(380, 270, 80, 25);
        new1.setBackground(Color.white);
        new1.addActionListener(this);
        add(new1);
        
        
}
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new1) {
            id1.setText("");
            fname1.setText("");
            lname1.setText("");
            age1.setText("");
            
        }
       
          if (e.getSource() == add_Em) {
              try{
                   if(fname1.getText().isEmpty()&&lname1.getText().isEmpty()&&age1.getText().isEmpty() &&id1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter items !!");
                  }
                   else if(id1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter id !!");
                  }
                else if(fname1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter first name !!");
                  }
                else if(lname1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter last name !!");
                  }
                else if(age1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter Age of Employee !!");
                  }
                 
                  
                  
                  else{
              database.inventory_db.insert(Integer.parseInt(id1.getText().trim()),fname1.getText(), 
                                          Float.parseFloat(lname1.getText().trim()), Float.parseFloat(age1.getText().trim()));
              
                jop.showMessageDialog(frame, "Add Successfull");
                  }
              }
              catch(Exception j){
                 jop.showMessageDialog(frame, j.getMessage());              }
              }
          }
    }
