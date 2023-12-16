import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aktualnosci {
    JFrame frame;
    Aktualnosci()
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
                new Wyloguj_sie();
            }
        });
        // logo
        ImageIcon logo = new ImageIcon("logo.PNG");
        JLabel label = new JLabel(logo);
        label.setBounds(10, 10, 70, 70);
        frame.add(label);



        // aktualnosci
        JLabel label2 = new JLabel("Informacje o tym co gramy w najbliższym czasie w kinie");
        label2.setBounds(600, 300, 800, 80);
        label2.setFont(new Font("Arial", Font.PLAIN, 30));
        frame.add(label2);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film infoprmatyczny ","obrazek.png", 950, 400);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film infoprmatyczny ","obrazek.png", 950, 800);



    }

    public void add_film_text_and_image(String tytul,String data_i_godzina,String text,String path, int x, int y) {
        JLabel label1 = new JLabel(tytul);
        label1.setBounds(x, y, 1000, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        this.frame.add(label1);
        JLabel label2 = new JLabel(data_i_godzina);
        label2.setBounds(x, y + 50, 1000, 50);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label2);
        String[] tab = Slacer(text);
        for (int i= 0; i < tab.length; i++) {
            JLabel label = new JLabel(tab[i]);
            label.setBounds(x, (y+100) + i * 30, 1000, 50);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            this.frame.add(label);
        }
        ImageIcon image = new ImageIcon(path);
        JLabel label = new JLabel(image);
        label.setBounds(x- 800, y, 200, 200);
        this.frame.add(label);
    }

    private String[] Slacer(String tekst)
    {
        String[] tab = new String[(tekst.length()/80)+1];
        for(int i =0;i<(tekst.length()/80)+1;i++)
        {
            try {
                tab[i] = tekst.substring(i * 80, (i + 1) * 80);
            }
            catch (Exception e)
            {
                tab[i] = tekst.substring(i * 80);
            }
            System.out.println(tab[i]);
        }
        return tab;
    }

}
