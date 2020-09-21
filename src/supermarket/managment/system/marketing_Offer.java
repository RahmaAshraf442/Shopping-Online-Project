/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ahmed
 */
public class marketing_Offer extends JPanel {
    JTable jTable;
    JScrollPane jsp;
    String a[][];
    String header[]={"Date","Offer from Marketing"};
    ArrayList<markets_offer> arr;
    public marketing_Offer() throws SQLException, ClassNotFoundException {
        this.arr = database.Marketing_DB.get_offer();
        this.setLayout(null);
        a=new String[arr.size()][2];
        for(int i=0;i<arr.size();i++)
        {
            a[i][0]=arr.get(i).getDate1();
            a[i][1]=arr.get(i).getOffer()+"";
            
            
        }
        jTable=new JTable(a, header);
        jsp =new JScrollPane(jTable);
        jsp.setBounds(0, 0, 850, 600);
        add(jsp);
    }
    
}
