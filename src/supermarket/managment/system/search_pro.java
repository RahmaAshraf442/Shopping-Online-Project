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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import jdk.nashorn.internal.runtime.Debug;

/**
 *
 * @author Ahmed
 */
public class search_pro extends JPanel implements ActionListener {

    JTable tabel;
    JLabel id;
    JTextField search;
    JScrollPane jsp;
    JOptionPane jop;
    JButton search1;
    String a[][];
    String header[] = {"pro Id", "pro Name", "pro Price", "pro Ammount"};
    ArrayList<products> arr;
    private Component frame;

    public search_pro() throws SQLException, ClassNotFoundException {
        this.arr = database.inventory_db.List();
        this.setLayout(null);
         id = new JLabel("Enter Id");
        id.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        id.setBounds(200, 40, 100, 30);
        add(id);
        search = new JTextField();
        search.setBounds(300, 40, 100, 30);
        add(search);
        search1 = new JButton("Search");
        search1.setBounds(410, 40, 100, 30);
        search1.setBackground(Color.WHITE);
        search1.addActionListener(this);
        add(search1);
        a = new String[1][4];

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == search1) {
                if (search.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter id !!");
                } else {
                    try {
                        this.arr = database.inventory_db.search(Integer.parseInt(search.getText()));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(search_pro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < arr.size(); i++) {
                       
                        a[i][0] = Integer.toString( arr.get(i).getPro_id());
                        a[i][1] = arr.get(i).getPro_name();
                        a[i][2] =Float.toString( arr.get(i).getPro_price());
                        a[i][3] =Float.toString( arr.get(i).getPro_ammount());
                        
                    }

                    tabel = new JTable(a, header);
                    jsp = new JScrollPane(tabel);
                    jsp.setBounds(0, 100, 750, 500);
                    add(jsp);
                }
            }
        } catch (SQLException ex) {
                             jop.showMessageDialog(frame, ex.getMessage());              }


    }

}
