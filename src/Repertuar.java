import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Repertuar {
    JFrame frame;
	private List<JComponent> dynamicElements = new ArrayList<>();
    Repertuar()
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
                new Wyloguj_sie();
            }
        });
        // logo
        ImageIcon logo = new ImageIcon("logo.PNG");
        JLabel label = new JLabel(logo);
        label.setBounds(10, 10, 70, 70);
        frame.add(label);

        JLabel label_header = new JLabel("Wyszukaj film");
        label_header.setBounds(100, 200, 1200, 50);
        label_header.setFont(new Font("Verdana", Font.PLAIN, 40));
        frame.add(label_header);
        dynamicElements.add(label_header);
        
        //formularz do wyszukiwania seansow
        JLabel label_date_from = new JLabel("Data od:");
        label_date_from.setBounds(100, 270, 100, 30);
        label_date_from.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_date_from);
        dynamicElements.add(label_date_from);
        
        JTextField date_from = new JTextField();
        date_from.setBounds(200, 270, 100, 30);
        frame.add(date_from);
        dynamicElements.add(date_from);
        
        JLabel label_date_to = new JLabel("Data do:");
        label_date_to.setBounds(320, 270, 100, 30);
        label_date_to.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_date_to);
        dynamicElements.add(label_date_to);
        
        JTextField date_to = new JTextField();
        date_to.setBounds(420, 270, 100, 30);
        frame.add(date_to);
        dynamicElements.add(date_to);
        
        JLabel label_hour_from = new JLabel("Godzina od:");
        label_hour_from.setBounds(540, 270, 150, 30);
        label_hour_from.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_hour_from);
        dynamicElements.add(label_hour_from);
        
        JTextField hour_from = new JTextField();
        hour_from.setBounds(680, 270, 100, 30);
        frame.add(hour_from);
        dynamicElements.add(hour_from);
        
        JLabel label_hour_to = new JLabel("Godzina do:");
        label_hour_to.setBounds(800, 270, 150, 30);
        label_hour_to.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_hour_to);
        dynamicElements.add(label_hour_to);
        
        JTextField hour_to = new JTextField();
        hour_to.setBounds(940, 270, 100, 30);
        frame.add(hour_to);
        dynamicElements.add(hour_to);
        
        JButton look_for = new JButton("Szukaj");
        look_for.setBounds(1060, 270, 100, 30);
        frame.add(look_for);
        dynamicElements.add(look_for);
        
        //przykladowe filmy lub wyniki wyszukiwania
        add_film_text_and_image("Minionki 4", "2023-12-17 16:00", "To już czwarta część przygód zwariowanych żółtych ludzików", "obrazek.png", 600, 350);
        add_film_text_and_image("Chłopi", "2023-12-17 19:00", "Najnowsza adaptacja historycznej powieści W. Reymonta zrealizowana w nieszablonowej technice", "obrazek.png", 600, 550);
        add_film_text_and_image("Sylwestrowy maraton filmowy", "2023-12-31 20:00", "Spędz sylwestra i powitaj Nowy Rok w kinie", "obrazek.png", 600, 750);
    
    }

    private void add_film_text_and_image(String tytul, String data_i_godzina, String opis, String path, int x, int y) {
    	//dane filmu / seansu
        JLabel label1 = new JLabel(tytul);
        label1.setBounds(x, y, 1000, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        this.frame.add(label1);
        dynamicElements.add(label1);
        
        JLabel label2 = new JLabel(data_i_godzina);
        label2.setBounds(x, y + 50, 1000, 50);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label2);
        dynamicElements.add(label2);
        
        JLabel label3 = new JLabel(opis);
        label3.setBounds(x, y + 100, 1000, 50);
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label3);
        dynamicElements.add(label3);
        
        ImageIcon image = new ImageIcon(path);
        JLabel label = new JLabel(image);
        label.setBounds(x - 500, y, 200, 200);
        this.frame.add(label);
        dynamicElements.add(label);
        
        //przycisk do kupowania
        JButton check_and_buy = new JButton("Zobacz szczegóły i kup bilet");
        check_and_buy.setBounds(x + 800, y + 20, 200, 50);
        frame.add(check_and_buy);
        dynamicElements.add(check_and_buy);
        check_and_buy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                for (JComponent c : dynamicElements) {
                	c.setVisible(false);
                }
                JLabel label_header = new JLabel("Chłopi");
                label_header.setBounds(100, 200, 1200, 50);
                label_header.setFont(new Font("Verdana", Font.PLAIN, 40));
                frame.add(label_header);
                //dynamicElements.add(label_header);
                
                JButton go_back = new JButton("Powrót");
                go_back.setBounds(100, 270, 100, 30);
                frame.add(go_back);
                
                String description = "<html>Tytuł: Chłopi<br><br>Termin: 2023-12-17 16:00<br><br>Rok produkcji: 2023<br><br>Kategoria wiekowa: 12+<br><br>Reżyser: Dorota Kobiela, Hugh Welchman<br><br>Opis: Film jest trzecią (po wersjach z 1922 i 1973 roku) pełnometrażową adaptacją powieści Władysława Reymonta pod tym samym tytułem, ukazującej cykl życia wiejskiego pod koniec XIX wieku. Chłopi są filmem wykonanym tą samą metodą animacji, co Twój Vincent w reżyserii tego samego duetu – nagrane wcześniej przed kamerą kadry zostały powtórnie namalowane farbą olejną na płótnie.\r\n"
                		+ "\r\n"
                		+ "Film Chłopi został uhonorowany czterema nagrodami na Festiwalu Polskich Filmów Fabularnych, w tym Nagrodą Specjalną Jury oraz Nagrodą Publiczności. Przeważały pozytywne recenzje, choć kontrowersje budziły kwestie zastosowanej metody animacji malarskiej oraz feministycznego przesłania filmu. Chłopi zostali zgłoszeni jako polski kandydat do rywalizacji o Oscara dla najlepszego pełnometrażowego filmu międzynarodowego. (zródło: Wikipedia)</html>";
                JLabel label_description = new JLabel(description);
                label_description.setBounds(100, 300, 800, 600);
                label_description.setFont(new Font("Verdana", Font.PLAIN, 20));
                frame.add(label_description);
                
                JButton buy_ticket = new JButton("Kup bilet");
                buy_ticket.setBounds(1200, 800, 200, 100);
                buy_ticket.setFont(new Font("Arial", Font.PLAIN, 40));
                frame.add(buy_ticket);
                
                go_back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						label_header.setVisible(false);
						go_back.setVisible(false);
						label_description.setVisible(false);
						buy_ticket.setVisible(false);
						
						for (JComponent c : dynamicElements) {
							c.setVisible(true);
						}
						dynamicElements.removeAll(dynamicElements);
					}
				});
                
        	}
        });
    }
}
