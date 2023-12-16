import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wyloguj_sie {

    private JFrame frame;
        Wyloguj_sie()
        {
            frame = new JFrame("Aplikacja Kinomaniak");
            frame.setSize(2000, 1200);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Color kremowy = new Color(255, 248, 220);
            Color kolorPrzycisku = new Color(200, 100, 50);
            Color kolorPrzycisku2 = new Color(180, 120, 70);
            frame.getContentPane().setBackground(kremowy);

            // przyciski
            JButton button = new JButton("Strona główna");
            button.setBounds(130, 100, 200, 80);
            button.setBackground(kolorPrzycisku);
            frame.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                    new MainFrame();
                }
            });
            JButton button2 = new JButton("Repertuar");
            button2.setBounds(340, 100, 200, 80);
            button2.setBackground(kolorPrzycisku);
            frame.add(button2);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                    new Repertuar();
                }
            });
            JButton button3 = new JButton("Aktualności");
            button3.setBounds(550, 100, 200, 80);
            button3.setBackground(kolorPrzycisku);
            frame.add(button3);
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                    new Aktualnosci();
                }
            });
            JButton button4 = new JButton("Moje konto");
            button4.setBounds(760, 100, 200, 80);
            button4.setBackground(kolorPrzycisku);
            frame.add(button4);
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                    new Moje_Konto();
                }
            });
            JButton button5 = new JButton("Cennik");
            button5.setBounds(970, 100, 200, 80);
            button5.setBackground(kolorPrzycisku);
            frame.add(button5);
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                    new Cennik();
                }
            });
            JButton button6 = new JButton("Zaloguj się");
            button6.setBounds(1280, 20, 150, 60);
            button6.setBackground(kolorPrzycisku2);
            frame.add(button6);
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                    new Zaloguj_sie();
                }
            });
            JButton button7 = new JButton("Wyloguj się");
            button7.setBounds(1490, 20, 150, 60);
            button7.setBackground(kolorPrzycisku2);
            frame.add(button7);
            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // jakis komentarz ze znajdujemy sie wlasnie w tej sekcji
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");
                }
            });
            // logo
            ImageIcon logo = new ImageIcon("logo.PNG");
            JLabel label = new JLabel(logo);
            label.setBounds(10, 10, 70, 70);
            frame.add(label);

            //napis
            JLabel labelwyolgowania = new JLabel("Wylogowano pomyślnie!");
            label.setBounds(600, 600, 800, 80);
            label.setFont(new Font("Arial", Font.PLAIN, 30));
            frame.add(labelwyolgowania);

            JButton button8 = new JButton("Wylogowano pomyślnie!");
            button8.setBounds(600, 600, 800, 80);
            button8.setBackground(kolorPrzycisku);
            frame.add(button8);
            button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Przycisk został kliknięty!");

                }
            });
        }





}
