/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JWindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.LineBorder;


/**
 *
 * @author Marseal
 */
public class MainClass extends JWindow {
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize(); // Fixed typo: dimensil -> dimensi
    private JLabel labelLogo1 = new JLabel(new ImageIcon("D:/University/4th Semester/Pemrograman I/MenuGUI15/src/GUI/apache-netbeans.png/"));
    private JProgressBar barisProgres1 = new JProgressBar();
    private int time1 = 0; 
    private Timer timer1;
    
    public MainClass() {
        Color Warna = Color.blue;
        barisProgres1.setValue(0);
        barisProgres1.setPreferredSize(new Dimension(100, 15));
        barisProgres1.setBackground(Color.white);
        barisProgres1.setForeground(Color.red);
        barisProgres1.setStringPainted(true);
        barisProgres1.setBorder(new LineBorder(Warna, 1));
        labelLogo1.setBorder(new LineBorder(Warna, 1));
        
        getContentPane().add(labelLogo1, BorderLayout.NORTH);
        getContentPane().add(barisProgres1, BorderLayout.CENTER);
        
        timer1 = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                time1++; // Fixed: time -> time1
                barisProgres1.setValue(time1);
                if (barisProgres1.getPercentComplete() == 1.0) {
                    timer1.stop();
                    setVisible(false);
                    new LoginForm16().setVisible(true);
                    dispose(); // Bersihkan splash screen dari memory
                }
            }
        }); // Fixed: Removed extra bracket and semicolon
        
        timer1.start();
        pack(); // Fixed: Added missing semicolon
        setLocation(dimensi.width / 2 - getWidth() / 2, dimensi.height / 2 - getHeight() / 2); // Fixed: dimensil -> dimensi
        setVisible(true); // Fixed: show() is deprecated, use setVisible(true)
    }
    
    public static void main(String[] args){
        new MainClass();
    }
}
