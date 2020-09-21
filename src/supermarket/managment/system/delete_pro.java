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
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class delete_pro extends JPanel implements ActionListener {

    JLabel de;
    JOptionPane jop;
    JTextField tx;
    JButton del;
    private Component frame;

    public delete_pro() {
        this.setLayout(null);
        de = new JLabel("Enter the id of Employee");
        de.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        de.setBounds(190, 100, 200, 30);
        add(de);
        tx = new JTextField();
        tx.setBounds(400, 100, 190, 30);
        add(tx);
        del = new JButton("Delete");
        del.setBounds(320, 165, 100, 30);
        del.setBackground(Color.WHITE);
        del.addActionListener(this);
        add(del);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == del) {
            if (tx.getText().isEmpty()) {
                jop.showMessageDialog(frame, "Enter id !!");
            } else {

                try {
                    database.inventory_db.delete(Integer.parseInt(tx.getText().trim()));
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }

                jop.showMessageDialog(frame, "Delete Successfuly");
            }
        }
    }

}
