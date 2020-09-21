/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

/**
 *
 * @author lenovo
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;

public class update_ur_info extends JPanel implements ActionListener {

    JLabel Id, Pass, username, age, Gender;
    JTextField FI, FL, age1;
    JPasswordField FP;
    JComboBox BG;
    JButton Click, Up_info;
    JPanel panel;
    private Component frame;
    JOptionPane jop;

    public update_ur_info() {

        panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Update_Info"));
        panel.setBounds(60, 45, 450, 370);

        Id = new JLabel("ID");
        Id.setBounds(30, 50, 100, 25);
        panel.add(Id);

        FI = new JTextField();
        FI.setBounds(130, 50, 130, 25);
        panel.add(FI);

        Pass = new JLabel("Password");
        Pass.setBounds(30, 90, 100, 25);
        panel.add(Pass);

        FP = new JPasswordField();
        FP.setBounds(130, 90, 130, 25);
        panel.add(FP);
        age = new JLabel("Age");
        age.setBounds(30, 250, 160, 25);
        Gender = new JLabel("Gender");
        Gender.setBounds(30, 290, 100, 25);
        username = new JLabel("Username");
        username.setBounds(30, 210, 100, 25);
        panel.add(username);
        panel.add(age);
        panel.add(Gender);

        Click = new JButton("Confirm");
        Click.setBounds(130, 130, 130, 25);
        panel.add(Click);
        Click.setBackground(Color.white);

        Click.addActionListener(this);

        Up_info = new JButton("Update");
        Up_info.setBounds(130, 330, 130, 25);
        Up_info.addActionListener(this);
        panel.add(Up_info);
        Up_info.setBackground(Color.white);

        this.add(panel);

        this.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Click) {
            System.out.println("Hello");
            if( Pass.getText().isEmpty()){
                jop.showMessageDialog(frame, "Enter password of Employee !!");
            }
            else if( FI.getText().isEmpty()){
                jop.showMessageDialog(frame, "Enter ID of Employee !!");
            }
            else{
            try {
                FI.setEditable(false);
                int i = database.Admin_DB.Check2(Integer.parseInt(FI.getText()), Pass.getText());
                if (i == 1) {
                    jop.showMessageDialog(frame, "Make sure that information is yourth");
                } else if (i == 0) {

                    age1 = new JTextField();
                    age1.setBounds(130, 250, 130, 25);
                    panel.add(age1);

                    BG = new JComboBox(new String[]{"Male", "Female"});
                    BG.setBounds(130, 290, 130, 25);
                    panel.add(BG);

                    FL = new JTextField();
                    FL.setBounds(130, 210, 130, 25);
                    panel.add(FL);

                    FP.setText("");
                    this.add(panel);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                ex.getMessage();
            }
        }
        if (e.getSource() == Up_info) {
            FI.setEditable(false);
            if (FI.getText().isEmpty() && FP.getText().isEmpty() && FL.getText().isEmpty()
                    && age1.getText().isEmpty()) {
                jop.showMessageDialog(frame, "Enter your information !!");
            } else if (FL.getText().isEmpty()) {
                jop.showMessageDialog(frame, "Enter User name !!");
            } else if (FP.getText().isEmpty()) {
                jop.showMessageDialog(frame, "Enter password !!");
            } else if (age1.getText().isEmpty()) {
                jop.showMessageDialog(frame, "Enter Age of Employee !!");
            } else {
                try {
                    database.Admin_DB.update2(Integer.parseInt(FI.getText()), FP.getText(), FL.getText(), Integer.parseInt(age1.getText()), BG.getSelectedItem());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(update_ur_info.class.getName()).log(Level.SEVERE, null, ex);
                }
                jop.showMessageDialog(frame, "Updated succesfully");
            }

        }

    }

}
}