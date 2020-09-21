/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ahmed
 */
public class marketing_main extends JFrame {
     JTabbedPane jtp;
     marketing_Screen ms;
     update_ur_info mos;
    
    public marketing_main() {
      
       
        
    
    }
    public void shoe ()throws SQLException, ClassNotFoundException{
        ms=new marketing_Screen();
        mos=new update_ur_info();
        jtp = new JTabbedPane();
        jtp.add("Marketing Screen", ms);
        jtp.add("Update your info",mos);
        add(jtp);
           setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(650, 600);
    }
    
    
    
}
