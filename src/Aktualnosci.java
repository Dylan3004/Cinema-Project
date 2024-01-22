import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Aktualnosci {
    JFrame frame;

    JPanel panel ;

    JScrollPane scrollPane;
    
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    private int Uper = 0;
    private int Downer = 0;

    Aktualnosci()
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
                JOptionPane.showMessageDialog(frame, "Znajdujesz się już na stronie Aktualności!");
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



        // aktualnosci
        panel = new JPanel();
        panel.setBounds(200, 200, 1000, 1000);
        panel.setBackground(new Color(0,0,0,0));
        panel.setLayout(null);
        panel.setVisible(true);



        JLabel label2 = new JLabel("Informacje o tym co gramy w najbliższym czasie ");
        label2.setBounds(200, 0, 800, 80);
        label2.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(label2);
        
        String query = "SELECT * FROM newses";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=");
        	st = con.createStatement();
        	rs= st.executeQuery(query);
        	while (rs.next()) {
        		add_film_text_and_image(rs.getString("Title"), "", rs.getString("Content"), "", 0, 100 + 200 * (rs.getInt("NewsID") - 1));

        	}
        }
        catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
        
        /*add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","python/cinema.jpg", 0, 100);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 300);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 500);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 700);*/
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(200, 200, 1200, 700);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.setLayout(null);
        frame.add(scrollPane);







        Button Up =  new Button(">");
        Up.setBounds(1500,600,100,100);
        Up.setVisible(true);
        frame.add(Up);
        Up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Uper +=1;
                panel.setVisible(false);
                panel = new JPanel();
                panel.setBounds(200, 200, 1000, 1000);
                panel.setBackground(new Color(0,0,0,0));
                panel.setLayout(null);
                panel.setVisible(true);
                JLabel label2 = new JLabel("Informacje o tym co gramy w najbliższym czasie ");
                label2.setBounds(200, 0, 800, 80);
                label2.setFont(new Font("Arial", Font.PLAIN, 30));
                panel.add(label2);

                String query = "SELECT * FROM newses";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=");
                    st = con.createStatement();
                    rs= st.executeQuery(query);
                    int i = 0;
                    while (rs.next()) {
                        System.out.println(Downer - Uper);
                        if(i < Downer - Uper )
                            continue;
                        add_film_text_and_image(rs.getString("Title"), "", rs.getString("Content"), "", 0, 100 + 200 * (rs.getInt("NewsID") - 1));
                        i++;
                    }
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

        /*add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","python/cinema.jpg", 0, 100);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 300);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 500);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 700);*/
                scrollPane = new JScrollPane(panel);
                scrollPane.setBounds(200, 200, 1200, 700);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                frame.setLayout(null);
                frame.add(scrollPane);
            }

        });




        Button Down =  new Button("<");
        Down.setBounds(1500,800,100,100);
        Down.setVisible(true);
        frame.add(Down);
        Down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // jakis komentarz ze znajdujemy sie wlasnie w tej sekcji
                Downer +=1;
                panel.setVisible(false);
                panel = new JPanel();
                panel.setBounds(200, 200, 1000, 1000);
                panel.setBackground(new Color(0,0,0,0));
                panel.setLayout(null);
                panel.setVisible(true);
                JLabel label2 = new JLabel("Informacje o tym co gramy w najbliższym czasie ");
                label2.setBounds(200, 0, 800, 80);
                label2.setFont(new Font("Arial", Font.PLAIN, 30));
                panel.add(label2);

                String query = "SELECT * FROM newses";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=");
                    st = con.createStatement();
                    rs= st.executeQuery(query);
                    int i = 0;
                    while (rs.next()) {
                        System.out.println(Downer - Uper);
                        if(i < Downer - Uper )
                            continue;
                        add_film_text_and_image(rs.getString("Title"), "", rs.getString("Content"), "", 0, 100 + 200 * (rs.getInt("NewsID") - 1));
                        i++;

                    }
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

        /*add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","python/cinema.jpg", 0, 100);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 300);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 500);
        add_film_text_and_image("Paythonokalipsa" ,"Sobota 16:30","Film został stworzony przez twórców Trylogii C nauka od podstaw i został nagrodzony złotym wierszem poleceń za najciekawszy film informatyczny ","obrazek.png", 0, 700);*/
                scrollPane = new JScrollPane(panel);
                scrollPane.setBounds(200, 200, 1200, 700);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                frame.setLayout(null);
                frame.add(scrollPane);
            }
        });





    }

    public void add_film_text_and_image(String tytul,String data_i_godzina,String text,String path, int x, int y) {
        JLabel label1 = new JLabel(tytul);
        label1.setBounds(x, y, 1000, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        this.panel.add(label1);
        JLabel label2 = new JLabel(data_i_godzina);
        label2.setBounds(x, y + 50, 1000, 50);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        this.panel.add(label2);
        String[] tab = Slacer(text);
        for (int i= 0; i < tab.length; i++) {
            JLabel label = new JLabel(tab[i]);
            label.setBounds(x, (y+100) + i * 30, 1100, 50);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            this.panel.add(label);
        }
        try {
            ImageIcon kino = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(kino);
            label.setBounds(x- 800, y, 200, 200);
            this.panel.add(label);
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku");
        }


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
            //System.out.println(tab[i]);
        }
        return tab;
    }

}
