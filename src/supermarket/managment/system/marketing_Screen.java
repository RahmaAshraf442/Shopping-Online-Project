/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class marketing_Screen extends JPanel implements ActionListener{
    JLabel offer;
    JTextField offer1;
    JLabel Date;
    JTextField Date1;
    JLabel report;
    JTextArea report1;
    
    JButton Add;
    JOptionPane jop;
    private Component frame;
    public marketing_Screen() {
        this.setLayout(null);
        offer=new JLabel("Offer");
        offer1=new JTextField();
        offer.setBounds(140, 40, 100, 30);
        offer.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        offer1.setBounds(250, 40, 220, 30);
        add(offer);
        add(offer1);
        Date=new JLabel("Date");
        Date1=new JTextField();
        Date.setBounds(140, 90, 100, 30);
        Date.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        Date1.setBounds(250, 90, 220, 30);
        add(Date);
        add(Date1);
        report=new JLabel("Make Report");
        report1=new JTextArea();
        report.setBounds(140, 150, 100, 30);
        report.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        report1.setBounds(250, 140, 220, 150);
        add(report);
        add(report1);
        Add=new JButton("ADD !!");
        Add.setBounds(260, 330, 110, 30);
        Add.setBackground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);
         
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Add){
            if(offer1.getText().isEmpty()|| report1.getText().isEmpty()){
                 jop.showMessageDialog(frame, "Enter ALL information !!");
            }
            else{
                try {
                    database.Marketing_DB.insert(offer1.getText(), Date1.getText(), report1.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(marketing_Screen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 jop.showMessageDialog(frame, "Successfull !!");

            }
        }
         
    }
    
    
}
