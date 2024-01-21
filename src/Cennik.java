import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
                JOptionPane.showMessageDialog(frame, "Znajdujesz się już na stronie Cennik!");

            }
        });
        if(!Colors.logged)
        {
            JButton button6 = new JButton("Zaloguj się/Zarejestruj się");
            button6.setBounds(1600, 0, 200, 60);
            button6.setBackground(Colors.logginColor);
            frame.add(button6);
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Zaloguj_sie();
                    frame.dispose();
                }
            });

        }
        else {
            JButton button7 = new JButton("Wyloguj się");
            button7.setBounds(1600, 0, 200, 60);
            button7.setBackground(Colors.loggoutColor);
            frame.add(button7);
            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // jakis komentarz ze znajdujemy sie wlasnie w tej sekcji
                    try {
                        new Wyloguj_sie();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                }
            });
        }
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
        label2.setBounds(300, 250, 800, 50);
        label2.setFont(new Font("Serif", Font.PLAIN, 40));
        frame.add(label2);
        add_ticket(20,"Normalny", 350);
        add_ticket(15,"Studencki", 400);
        add_ticket(10,"Z kartą dużej rodziny",450);
        JLabel label3 = new JLabel("Zniżki");
        label3.setBounds(300, 600, 600, 50);
        label3.setFont(new Font("Serif", Font.PLAIN, 40));
        frame.add(label3);
        add_discount(10,"Bilet grupowy", 700);
        add_discount(20,"Senior 60+", 750);
        add_discount(30,"Dzieci do 8 roku życia", 800);

    }



    private void add_ticket(double ticket_prize ,String ticket_name,int y) {
        JLabel label = new JLabel(ticket_name);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(300, y, 800, 50);
        frame.add(label);

        JLabel labelPrize = new JLabel(ticket_prize+" zł");
        labelPrize.setFont(new Font("Serif", Font.PLAIN, 20));
        labelPrize.setBounds(600, y, 800, 50);
        frame.add(labelPrize);
    }

    private void add_discount(double discount_procent ,String discount_name,int y) {
        JLabel label = new JLabel(discount_name);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(300, y, 800, 50);
        frame.add(label);

        JLabel labelPercent = new JLabel(discount_procent+" %");
        labelPercent.setFont(new Font("Serif", Font.PLAIN, 20));
        labelPercent.setBounds(600, y, 800, 50);
        frame.add(labelPercent);
    }
}
