/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ahmed
 */
public class more_option_sales extends JFrame {

    JTabbedPane jtp;
    
    list_pro ls;
    search_pro sc;
    update_ur_info up;
    

    public more_option_sales() {
    }

    public void show_more_option_sales_screen() throws SQLException, ClassNotFoundException {

        ls = new list_pro();
        sc=new search_pro();
        up=new update_ur_info();
        jtp = new JTabbedPane();
        jtp.add("Search on product",sc);
        jtp.add("List Of Products", ls);
        jtp.add("Update your info",up);
        add(jtp);
        
        //.................
        setTitle("SuperMarket Management System");
        setResizable(false);
        setVisible(true);
        setSize(850, 600);
    }

}
