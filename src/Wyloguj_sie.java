import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


public class Wyloguj_sie {

    private JFrame frame;
        Wyloguj_sie() throws InterruptedException {
            frame = new JFrame("Aplikacja Kinomaniak");
            frame.setSize(1800, 1000);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Colors.bacgorundColor);

            // przyciski
            JButton button = new JButton("Strona główna");
            button.setBounds(130, 100, 200, 80);
            button.setBackground(Colors.buttonColor);
            frame.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MainFrame();
                    frame.dispose();
                }
            });
            JButton button2 = new JButton("Repertuar");
            button2.setBounds(340, 100, 200, 80);
            button2.setBackground(Colors.buttonColor);
            frame.add(button2);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Repertuar();
                    frame.dispose();
                }
            });
            JButton button3 = new JButton("Aktualności");
            button3.setBounds(550, 100, 200, 80);
            button3.setBackground(Colors.buttonColor);
            frame.add(button3);
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Aktualnosci();
                    frame.dispose();
                }
            });
            JButton button4 = new JButton("Moje konto");
            button4.setBounds(760, 100, 200, 80);
            button4.setBackground(Colors.buttonColor);
            frame.add(button4);
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Moje_Konto();
                    frame.dispose();
                }
            });
            JButton button5 = new JButton("Cennik");
            button5.setBounds(970, 100, 200, 80);
            button5.setBackground(Colors.buttonColor);
            frame.add(button5);
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Cennik();
                    frame.dispose();
                }
            });
            try {
                ImageIcon logo = new ImageIcon(new ImageIcon("images/logo.PNG").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                JLabel label = new JLabel(logo);
                label.setBounds(10, 10, 70, 70);
                frame.add(label);
            } catch (Exception e) {
                System.out.println("Nie znaleziono pliku");
            }

            //napis
//            JLabel labelwylogowania = new JLabel("Wylogowano pomyślnie!");
//
//            // TODO: tu wczesniej bylo zamiast labelwylogowania samo label
//
//            labelwylogowania.setBounds(600, 600, 800, 80);
//            labelwylogowania.setFont(new Font("Arial", Font.PLAIN, 30));
//            frame.add(labelwylogowania, BorderLayout.CENTER);
            Colors.logged = false;
            JOptionPane.showMessageDialog(frame, "Wylogowano pomyślnie");
            new MainFrame();
            frame.dispose();

        }





}
