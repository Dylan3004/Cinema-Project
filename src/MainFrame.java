import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;

public class MainFrame{

    MainFrame() {
        JFrame frame = new JFrame("Aplikacja Kinomaniak");
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
                new Cennik();
                frame.dispose();
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

        //tekst na temat kina
        JLabel label2 = new JLabel("Nasze kino działa już od 30 lat. " +
                "To miejsce, gdzie światła gasną, a ekran ożywa." );
        JLabel label3 = new JLabel("Kino to miejsce, gdzie można się zrelaksować, odpocząć od codziennych obowiązków " +
                "i zatopić się w świecie wyobraźni. ");
        JLabel label4 = new JLabel("To także miejsce, gdzie można spędzić czas z rodziną i przyjaciółmi.");
        label2.setBounds(130, 700, 800, 100);
        label3.setBounds(130, 750, 800, 100);
        label4.setBounds(130, 800, 800, 100);
        frame.add(label4);
        frame.add(label3);
        frame.add(label2);

        // Tekst na temat lokalizacji kina
        JLabel label6 = new JLabel("Kino znajduje się w centrum miasta, w pobliżu dworca kolejowego i autobusowego. ");
        JLabel label8 = new JLabel("Adres: ul. Kino 1, 00-000 Warszawa");
        label8.setBounds(1000, 700, 800, 100);
        label6.setBounds(1000, 750, 800, 100);
        frame.add(label6);
        frame.add(label8);

        // Tekst na temat godzin otwarcia kina
        JLabel label7 = new JLabel("Kino jest czynne od poniedziałku do niedzieli w godzinach 8:00 - 22:00. " +
                "Zapraszamy do rezerwacji online. ");
        label7.setBounds(1000, 800, 800, 100);
        frame.add(label7);

        // obrazek kina
        try {
            ImageIcon kino = new ImageIcon(new ImageIcon("images/cinema.jpg").getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT));
            JLabel label5 = new JLabel(kino);
            label5.setBounds(130, 250, 550, 450);
            frame.add(label5);
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku");
        }

        // TODO: to jest do tego, zeby zawsze po uruchomieniu zawsze bylo wszystko narysowane poprawnie - potem to albo usunac jak sie uda znalezc czemu sie nie zawsze wszystko rysuje albo zrobic jakiegos if'a zeby repaint() byl tylko raz po uruchomieniu
        frame.repaint();

        // TODO: uwaga bez podania pelnej sciezki mi nie dzialalo, a tez mam te obrazki w src, z podaniem pelnej sciezki juz dziala
//        SwingUtilities.invokeLater(() -> {
//            try {
//                JFrame fdebugjpg = new JFrame();
//                fdebugjpg.setSize(400, 400);
//                fdebugjpg.setVisible(true);
//                fdebugjpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                ImageIcon debugjpg = new ImageIcon("images/cinema.jpg");
//                JLabel ldebugjpg = new JLabel(debugjpg);
//                fdebugjpg.add(ldebugjpg);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });

    }
}
