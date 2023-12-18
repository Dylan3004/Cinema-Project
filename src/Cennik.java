import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cennik {

    private JFrame frame;
    Cennik()
    {
        frame = new JFrame("Aplikacja Kinomaniak");
        frame.setSize(1800, 1000);
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
                frame.dispose();
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
                frame.dispose();
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
                frame.dispose();
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
                frame.dispose();
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
                frame.dispose();
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
                new Wyloguj_sie();
                frame.dispose();
            }
        });
        // logo
        try {
            ImageIcon logo = new ImageIcon(new ImageIcon("images/logo.PNG").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(logo);
            label.setBounds(10, 10, 70, 70);
            frame.add(label);
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku");
        }

        // cennik
        JLabel label2 = new JLabel("Cennik");
        label2.setBounds(700, 400, 600, 50);
        label2.setFont(new Font("Serif", Font.PLAIN, 40));
        frame.add(label2);
        add_ticket(20,"Normalny", 700, 500);
        add_ticket(15,"Ulgowy", 700, 550);
        add_ticket(10,"Senior", 700, 600);
        JLabel label3 = new JLabel("Znizki");
        label3.setBounds(700, 700, 600, 50);
        label3.setFont(new Font("Serif", Font.PLAIN, 40));
        frame.add(label3);
        add_discount(10,"Studencki", 700, 800);
        add_discount(20,"Senior", 700, 850);
        add_discount(30,"Dzieci", 700, 900);

    }



    private void add_ticket(double ticket_prize ,String ticket_name,int x ,int y) {
        JLabel label = new JLabel(ticket_name + "...................................................................................................................." + ticket_prize);
        label.setBounds(x, y, 600, 50);
        frame.add(label);

    }

    private void add_discount(double discount_procent ,String discount_name,int x ,int y) {
        JLabel label = new JLabel(discount_name + "...................................................................................................................." + discount_procent + "%");
        label.setBounds(x, y, 600, 50);
        frame.add(label);

    }
}
