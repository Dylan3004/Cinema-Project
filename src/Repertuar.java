import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class Repertuar {
    JFrame frame;
    private List<JComponent> mainElements = new ArrayList<>();
    private List<JComponent> resultsElements = new ArrayList<>();
    private List<JComponent> detailsElements = new ArrayList<>();
    private List<JComponent> numbersElements = new ArrayList<>();
    private List<JComponent> placesElements = new ArrayList<>();
    private List<JComponent> summaryElements = new ArrayList<>();
    private List<JComponent> methodsElements = new ArrayList<>();
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    Repertuar()
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
            }
        });
        JButton button3 = new JButton("Aktualności");
        button3.setBounds(550, 100, 200, 80);
        button3.setBackground(kolorPrzycisku);
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
        button4.setBackground(kolorPrzycisku);
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
        button5.setBackground(kolorPrzycisku);
        frame.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                new Wyloguj_sie();
                frame.dispose();
            }
        });
        // logo
        ImageIcon logo = new ImageIcon("logo.PNG");
        JLabel label = new JLabel(logo);
        label.setBounds(10, 10, 70, 70);
        frame.add(label);

        JLabel label_movie_title = new JLabel("Wyszukaj film");
        label_movie_title.setBounds(100, 200, 1200, 50);
        label_movie_title.setFont(new Font("Verdana", Font.PLAIN, 40));
        frame.add(label_movie_title);
        mainElements.add(label_movie_title);

        //formularz do wyszukiwania seansow
        JLabel label_date_from = new JLabel("Data od:");
        label_date_from.setBounds(100, 270, 100, 30);
        label_date_from.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_date_from);
        mainElements.add(label_date_from);

        JTextField date_from = new JTextField();
        date_from.setBounds(200, 270, 200, 30);
        date_from.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(date_from);
        mainElements.add(date_from);

        JLabel label_date_to = new JLabel("Data do:");
        label_date_to.setBounds(420, 270, 100, 30);
        label_date_to.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_date_to);
        mainElements.add(label_date_to);

        JTextField date_to = new JTextField();
        date_to.setBounds(520, 270, 200, 30);
        date_to.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(date_to);
        mainElements.add(date_to);

        JLabel label_hour_from = new JLabel("Godzina od:");
        label_hour_from.setBounds(740, 270, 150, 30);
        label_hour_from.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_hour_from);
        mainElements.add(label_hour_from);

        JTextField hour_from = new JTextField();
        hour_from.setBounds(880, 270, 100, 30);
        hour_from.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(hour_from);
        mainElements.add(hour_from);

        JLabel label_hour_to = new JLabel("Godzina do:");
        label_hour_to.setBounds(1000, 270, 150, 30);
        label_hour_to.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(label_hour_to);
        mainElements.add(label_hour_to);

        JTextField hour_to = new JTextField();
        hour_to.setBounds(1140, 270, 100, 30);
        hour_to.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(hour_to);
        mainElements.add(hour_to);

        JButton look_for = new JButton("Szukaj");
        look_for.setBounds(1260, 270, 100, 30);
        frame.add(look_for);
        mainElements.add(look_for);

        //przykladowe filmy lub wyniki wyszukiwania
        String query = "SELECT * FROM seances INNER JOIN movies USING (MovieID) WHERE seances.IsActive = 1 AND movies.IsActive = 1 ORDER BY Date, Time ASC";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=");
        	st = con.createStatement();
        	rs= st.executeQuery(query);
        	int i = 0;
        	while (rs.next()) {
        		Seance m = new Seance(rs.getString("Date"), rs.getString("Time"), rs.getDouble("Price"), rs.getBoolean("seances.IsActive"), rs.getString("Title"),
        				rs.getString("Type"), rs.getString("Studio"), rs.getString("Director"), rs.getString("Cast"), rs.getString("Description"), rs.getString("Year"),
        				rs.getInt("Age"), rs.getBoolean("movies.IsActive"));
        		add_film_text_and_image(m, 650, 350 + i);
        		i += 200;
        	}
        }
        catch (Exception ex) {
        	System.out.println("Problem z bazą danych");
        }
        finally {
        	if (rs != null) {
        		try {
        			rs.close();
        		}
        		catch (SQLException sqlEx) {}
        		rs = null;
        	}
        	if (st != null) {
        		try {
        			st.close();
        		}
        		catch (SQLException sqlEx) {}
        		st = null;
        	}
        	if (con != null) {
        		try {
        			con.close();
        		}
        		catch (SQLException sqlEx) {}
        		con = null;
        	}
        }
        
        look_for.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		for (JComponent c : resultsElements) {
        			c.setVisible(false);
        		}
        		String query = "SELECT * FROM seances INNER JOIN movies USING (MovieID) WHERE seances.IsActive = 1 AND movies.IsActive = 1 AND Date >= '"
        				+ date_from.getText() + "' AND Date <= '" + date_to.getText()
        				+ "' ORDER BY Date, Time ASC";
                
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                	con = DriverManager.getConnection("jdbc:mysql://localhost/cinema?user=root&password=");
                	st = con.createStatement();
                	rs= st.executeQuery(query);
                	int i = 0;
                	while (rs.next()) {
                		Seance m = new Seance(rs.getString("Date"), rs.getString("Time"), rs.getDouble("Price"), rs.getBoolean("seances.IsActive"), rs.getString("Title"),
                				rs.getString("Type"), rs.getString("Studio"), rs.getString("Director"), rs.getString("Cast"), rs.getString("Description"), rs.getString("Year"),
                				rs.getInt("Age"), rs.getBoolean("movies.IsActive"));
                		add_film_text_and_image(m, 650, 350 + i);
                		i += 200;
                	}
                }
                catch (Exception ex) {
                	System.out.println("Problem z bazą danych");
                }
                finally {
                	if (rs != null) {
                		try {
                			rs.close();
                		}
                		catch (SQLException sqlEx) {}
                		rs = null;
                	}
                	if (st != null) {
                		try {
                			st.close();
                		}
                		catch (SQLException sqlEx) {}
                		st = null;
                	}
                	if (con != null) {
                		try {
                			con.close();
                		}
                		catch (SQLException sqlEx) {}
                		con = null;
                	}
                }
            }
        });
    }

    private void add_film_text_and_image(Seance m, int x, int y) {
        //dane filmu / seansu
        JLabel label1 = new JLabel(m.getTitle());
        label1.setBounds(x, y, 1000, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 30));
        this.frame.add(label1);
        resultsElements.add(label1);

        JLabel label2 = new JLabel(m.getDate() + " " + m.getTime());
        label2.setBounds(x, y + 50, 1000, 50);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label2);
        resultsElements.add(label2);

        JLabel label3 = new JLabel(m.getDescription());
        label3.setBounds(x, y + 100, 1000, 50);
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label3);
        resultsElements.add(label3);

        ImageIcon image = new ImageIcon("obrazek.png");
        JLabel label = new JLabel(image);
        label.setBounds(x - 500, y, 200, 200);
        this.frame.add(label);
        resultsElements.add(label);

        //przycisk do kupowania
        JButton check_and_buy = new JButton("Zobacz szczegóły i kup bilet");
        check_and_buy.setBounds(x + 800, y + 20, 200, 50);
        frame.add(check_and_buy);
        resultsElements.add(check_and_buy);
        check_and_buy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (JComponent c : mainElements) {
                    c.setVisible(false);
                }
                JLabel label_movie_title = new JLabel(m.getTitle());
                label_movie_title.setBounds(100, 200, 1200, 50);
                label_movie_title.setFont(new Font("Verdana", Font.PLAIN, 40));
                frame.add(label_movie_title);
                detailsElements.add(label_movie_title);

                JButton go_back = new JButton("Powrót");
                go_back.setBounds(100, 270, 100, 30);
                frame.add(go_back);
                detailsElements.add(go_back);

                String description = "<html>Tytuł:" + m.getTitle() + "<br><br>Termin: " + m.getDate() + " " + m.getTime() + "<br>" 
                		+ "<br>Rok produkcji: " + m.getYear().substring(0, 4) + "<br><br>Kategoria wiekowa: " + m.getAge() + "<br><br>Reżyser: " + m.getDirector() + "<br>"
                		+ "<br>Opis: " + m.getDescription() + "</html>";
                JLabel label_description = new JLabel(description);
                label_description.setBounds(100, 200, 800, 600);
                label_description.setFont(new Font("Verdana", Font.PLAIN, 20));
                frame.add(label_description);
                detailsElements.add(label_description);

                JButton buy_ticket = new JButton("Kup bilet");
                buy_ticket.setBounds(1200, 800, 200, 100);
                buy_ticket.setFont(new Font("Arial", Font.PLAIN, 40));
                frame.add(buy_ticket);
                detailsElements.add(buy_ticket);

                go_back.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (JComponent c : detailsElements) {
                            c.setVisible(false);
                        }

                        for (JComponent c : mainElements) {
                            c.setVisible(true);
                        }
                    }
                });

                buy_ticket.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (JComponent c : detailsElements) {
                            c.setVisible(false);
                        }

                        JLabel label_number_of_people = new JLabel("Podaj liczbę biletów:");
                        label_number_of_people.setBounds(100, 200, 1200, 50);
                        label_number_of_people.setFont(new Font("Verdana", Font.PLAIN, 40));
                        frame.add(label_number_of_people);
                        numbersElements.add(label_number_of_people);

                        JButton back_to_details = new JButton("Powrót");
                        back_to_details.setBounds(100, 270, 100, 30);
                        frame.add(back_to_details);
                        numbersElements.add(back_to_details);

                        JLabel label_seance_details = new JLabel("Chłopi (2023-12-17 16:00)");
                        label_seance_details.setBounds(100, 300, 1200, 50);
                        label_seance_details.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(label_seance_details);
                        numbersElements.add(label_seance_details);

                        JLabel label_normal_tickets = new JLabel("Bilety normalne:");
                        label_normal_tickets.setBounds(100, 400, 400, 30);
                        label_normal_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(label_normal_tickets);
                        numbersElements.add(label_normal_tickets);

                        JTextField normal_tickets = new JTextField("0");
                        normal_tickets.setBounds(500, 400, 200, 30);
                        normal_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(normal_tickets);
                        numbersElements.add(normal_tickets);

                        JLabel label_student_tickets = new JLabel("Bilety ulgowe (dla uczniów):");
                        label_student_tickets.setBounds(100, 450, 400, 30);
                        label_student_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(label_student_tickets);
                        numbersElements.add(label_student_tickets);

                        JTextField student_tickets = new JTextField("0");
                        student_tickets.setBounds(500, 450, 200, 30);
                        student_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(student_tickets);
                        numbersElements.add(student_tickets);

                        JLabel label_senior_tickets = new JLabel("Bilety ulgowe (dla seniorów):");
                        label_senior_tickets.setBounds(100, 500, 400, 30);
                        label_senior_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(label_senior_tickets);
                        numbersElements.add(label_senior_tickets);

                        JTextField senior_tickets = new JTextField("0");
                        senior_tickets.setBounds(500, 500, 200, 30);
                        senior_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(senior_tickets);
                        numbersElements.add(senior_tickets);

                        JLabel label_invalids = new JLabel("Bilety dla niepełnosprawnych:");
                        label_invalids.setBounds(100, 550, 400, 30);
                        label_invalids.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(label_invalids);
                        numbersElements.add(label_invalids);

                        JTextField invalids = new JTextField("0");
                        invalids.setBounds(500, 550, 200, 30);
                        invalids.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(invalids);
                        numbersElements.add(invalids);

                        JCheckBox group_ticket = new JCheckBox("Bilet grupowy (od 10 osób)");
                        group_ticket.setBounds(100, 600, 200, 40);
                        group_ticket.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(group_ticket);
                        numbersElements.add(group_ticket);

                        JButton approve_number_of_tickets = new JButton("Dalej");
                        approve_number_of_tickets.setBounds(550, 640, 150, 30);
                        approve_number_of_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(approve_number_of_tickets);
                        numbersElements.add(approve_number_of_tickets);

                        JLabel label_discounts_info = new JLabel("Informacje o zniżkach:");
                        label_discounts_info.setBounds(100, 680, 1200, 50);
                        label_discounts_info.setFont(new Font("Verdana", Font.PLAIN, 30));
                        frame.add(label_discounts_info);
                        numbersElements.add(label_discounts_info);

                        JLabel label_discounts = new JLabel("<html><ol><li>Dla uczniów - przysługują uczniom, studentom i doktorantom po okazaniu ważnej legitymacji oraz dzieciom do 7. roku życia. Konieczna jest weryfikacja wieku.</li><li>Dla seniorów - przysługuje emerytom i rencistom po okazaniu ważnej legitymacji oraz osobom powyżej 70. roku życia. Konieczna jest weryfikacja wieku.</li><li>Dla osób poruszających się na wózkach inwalidzkich - na sali dostępne są 2 miejsca dostosowane do osób na wózkach inwalidzkich.</li></ol></html>");
                        label_discounts.setBounds(100, 710, 1200, 250);
                        label_discounts.setFont(new Font("Verdana", Font.PLAIN, 20));
                        frame.add(label_discounts);
                        numbersElements.add(label_discounts);

                        back_to_details.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //usuniecie wszystkiego oprocz menu
                                for (JComponent c : numbersElements) {
                                    c.setVisible(false);
                                }

                                //przywrocenie elementow poprzedniej strony
                                for (JComponent c : detailsElements) {
                                    c.setVisible(true);
                                }

                            }
                        });

                        //na razie pomijam przypadek, gdy wprowadzimy nieprawidłowe dane, np. niedodatnia liczbe osob
                        approve_number_of_tickets.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //usuniecie wszystkiego oprocz menu
                                for (JComponent c : numbersElements) {
                                    c.setVisible(false);
                                }

                                //zmienna przechowujaca liczbe biletow, pilnuje, zeby nie zaznaczyc wiecej siedzien niz osob
                                final int[] number_of_people = {5};

                                JLabel label_select_places = new JLabel("Wybierz miejsca ze schematu:");
                                label_select_places.setBounds(100, 200, 1200, 50);
                                label_select_places.setFont(new Font("Verdana", Font.PLAIN, 40));
                                frame.add(label_select_places);
                                placesElements.add(label_select_places);

                                JButton back_to_numbers = new JButton("Powrót");
                                back_to_numbers.setBounds(100, 270, 100, 30);
                                frame.add(back_to_numbers);
                                placesElements.add(back_to_numbers);

                                JLabel label_screen = new JLabel("Ekran");
                                label_screen.setBounds(100, 320, 100 * 10 + 9 * 10, 80);
                                label_screen.setFont(new Font("Verdana", Font.PLAIN, 30));
                                label_screen.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
                                frame.add(label_screen);
                                placesElements.add(label_screen);

                                JLabel label_number_of_tickets = new JLabel("Wybierz jeszcze: " + Integer.toString(number_of_people[0]) + " miejsc");
                                label_number_of_tickets.setBounds(100, 800, 500, 50);
                                label_number_of_tickets.setFont(new Font("Verdana", Font.PLAIN, 20));
                                frame.add(label_number_of_tickets);
                                placesElements.add(label_number_of_tickets);

                                for (int i = 0; i < 10; i++) {
                                    for (int j = 0; j < 5; j++) {
                                        String place_description;
                                        if (j * 10 + i != 4 && j * 10 + i != 5)
                                            place_description = Integer.toString(j * 10 + i);
                                        else if (i == 4)
                                            place_description = "N4";
                                        else
                                            place_description = "N5";
                                        JButton place = new JButton(place_description);
                                        place.setBounds(100 + (i % 10) * 110, 450 + (j % 10) * 70, 100, 60);
                                        place.setFont(new Font("Verdana", Font.PLAIN, 12));
                                        if (j == 4)
                                            place.setBackground(Color.red);
                                        else
                                            place.setBackground(Color.green);
                                        frame.add(place);
                                        placesElements.add(place);

                                        place.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                if (number_of_people[0] > 0 && place.getBackground() == Color.green) {
                                                    place.setBackground(Color.orange);
                                                    number_of_people[0]--;
                                                    label_number_of_tickets.setVisible(false);
                                                    label_number_of_tickets.setText("Wybierz jeszcze: " + Integer.toString(number_of_people[0]) + " miejsc");
                                                    label_number_of_tickets.setVisible(true);
                                                }
                                            }
                                        });


                                    }
                                }

                                JButton approve_all_details = new JButton("Przejdź do podsumowania");
                                approve_all_details.setBounds(800, 900, 400, 50);
                                approve_all_details.setFont(new Font("Verdana", Font.PLAIN, 20));
                                frame.add(approve_all_details);
                                placesElements.add(approve_all_details);

                                back_to_numbers.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for (JComponent c : placesElements) {
                                            c.setVisible(false);
                                        }
                                        for (JComponent c : numbersElements) {
                                            c.setVisible(true);
                                        }
                                    }
                                });

                                approve_all_details.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for (JComponent c : placesElements) {
                                            c.setVisible(false);
                                        }

                                        JLabel label_summary = new JLabel("Podsumowanie");
                                        label_summary.setBounds(100, 200, 1200, 50);
                                        label_summary.setFont(new Font("Verdana", Font.PLAIN, 40));
                                        frame.add(label_summary);
                                        summaryElements.add(label_summary);

                                        JButton back_to_places = new JButton("Powrót");
                                        back_to_places.setBounds(100, 270, 100, 30);
                                        frame.add(back_to_places);
                                        summaryElements.add(back_to_places);

                                        back_to_places.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                for (JComponent c : summaryElements) {
                                                    c.setVisible(false);
                                                }
                                                for (JComponent c : placesElements) {
                                                    c.setVisible(true);
                                                }
                                            }
                                        });

                                        JLabel label_revision = new JLabel("<html>Tytuł filmu: Chłopi<br>" +
                                                "Godzina rozpoczęcia: 16:00<br>" +
                                                "Miejsca: 10, 11, 12, 13, 14<br>" +
                                                "Rodzaje biletów: Normalne - 1, Uczniowskie / studenckie - 4<br>" +
                                                "Do zapłaty: 100.00 zł</html>");
                                        label_revision.setBounds(100, 320, 1200, 200);
                                        label_revision.setFont(new Font("Verdana", Font.PLAIN, 20));
                                        frame.add(label_revision);
                                        summaryElements.add(label_revision);

                                        JButton buy_and_pay = new JButton("Kupuję i płacę");
                                        buy_and_pay.setBounds(500, 550, 200, 50);
                                        buy_and_pay.setFont(new Font("Verdana", Font.PLAIN, 20));
                                        frame.add(buy_and_pay);
                                        summaryElements.add(buy_and_pay);

                                        buy_and_pay.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                for (JComponent c : summaryElements) {
                                                    c.setVisible(false);
                                                }
                                                JLabel select_payment_form = new JLabel("Wybierz formę płatności");
                                                select_payment_form.setBounds(100, 200, 1200, 50);
                                                select_payment_form.setFont(new Font("Verdana", Font.PLAIN, 40));
                                                frame.add(select_payment_form);
                                                methodsElements.add(select_payment_form);

                                                JButton back_to_summary = new JButton("Powrót");
                                                back_to_summary.setBounds(100, 270, 100, 30);
                                                frame.add(back_to_summary);
                                                methodsElements.add(back_to_summary);

                                                back_to_summary.addActionListener(new ActionListener() {

                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        for (JComponent c : methodsElements) {
                                                            c.setVisible(false);
                                                        }
                                                        for (JComponent c : summaryElements) {
                                                            c.setVisible(true);
                                                        }
                                                    }
                                                });

                                                JButton card = new JButton("Karta płatnicza");
                                                card.setBounds(100, 370, 200, 50);
                                                card.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(card);
                                                methodsElements.add(card);

                                                JButton blik = new JButton("Kod BLIK");
                                                blik.setBounds(350, 370, 200, 50);
                                                blik.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(blik);
                                                methodsElements.add(blik);

                                                JLabel label_write_card_number = new JLabel("Podaj numer karty: ");
                                                label_write_card_number.setBounds(100, 470, 350, 50);
                                                label_write_card_number.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(label_write_card_number);
                                                methodsElements.add(label_write_card_number);
                                                label_write_card_number.setVisible(false);

                                                JTextField write_card_number = new JTextField();
                                                write_card_number.setBounds(400, 470, 500, 50);
                                                write_card_number.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(write_card_number);
                                                methodsElements.add(write_card_number);
                                                write_card_number.setVisible(false);

                                                JLabel label_write_exp_date = new JLabel("Podaj datę ważności karty: ");
                                                label_write_exp_date.setBounds(100, 530, 350, 50);
                                                label_write_exp_date.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(label_write_exp_date);
                                                methodsElements.add(label_write_exp_date);
                                                label_write_exp_date.setVisible(false);

                                                JTextField write_exp_date = new JTextField();
                                                write_exp_date.setBounds(400, 530, 100, 50);
                                                write_exp_date.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(write_exp_date);
                                                methodsElements.add(write_exp_date);
                                                write_exp_date.setVisible(false);

                                                JLabel label_write_CVC = new JLabel("Podaj CVC / CVV: ");
                                                label_write_CVC.setBounds(100, 590, 350, 50);
                                                label_write_CVC.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(label_write_CVC);
                                                methodsElements.add(label_write_CVC);
                                                label_write_CVC.setVisible(false);

                                                JTextField write_CVC = new JTextField();
                                                write_CVC.setBounds(400, 590, 100, 50);
                                                write_CVC.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(write_CVC);
                                                methodsElements.add(write_CVC);
                                                write_CVC.setVisible(false);

                                                JLabel label_write_blik = new JLabel("Podaj kod BLIK: ");
                                                label_write_blik.setBounds(100, 470, 200, 50);
                                                label_write_blik.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(label_write_blik);
                                                methodsElements.add(label_write_blik);
                                                label_write_blik.setVisible(false);

                                                JTextField write_blik = new JTextField();
                                                write_blik.setBounds(350, 470, 200, 50);
                                                write_blik.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(write_blik);
                                                methodsElements.add(write_blik);
                                                write_blik.setVisible(false);

                                                JButton pay = new JButton("Zapłać");
                                                pay.setBounds(500, 750, 200, 50);
                                                pay.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                frame.add(pay);
                                                methodsElements.add(pay);
                                                pay.setVisible(false);

                                                card.addActionListener(new ActionListener() {

                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        label_write_blik.setVisible(false);
                                                        write_blik.setVisible(false);

                                                        label_write_card_number.setVisible(true);
                                                        label_write_exp_date.setVisible(true);
                                                        label_write_CVC.setVisible(true);

                                                        write_card_number.setVisible(true);
                                                        write_exp_date.setVisible(true);
                                                        write_CVC.setVisible(true);

                                                        pay.setVisible(true);
                                                    }
                                                });

                                                blik.addActionListener(new ActionListener() {

                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        label_write_card_number.setVisible(false);
                                                        label_write_exp_date.setVisible(false);
                                                        label_write_CVC.setVisible(false);

                                                        write_card_number.setVisible(false);
                                                        write_exp_date.setVisible(false);
                                                        write_CVC.setVisible(false);
                                                        label_write_blik.setVisible(true);
                                                        write_blik.setVisible(true);

                                                        pay.setVisible(true);
                                                    }
                                                });

                                                pay.addActionListener(new ActionListener() {

                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        for (JComponent c : methodsElements) {
                                                            c.setVisible(false);
                                                        }

                                                        JLabel done = new JLabel("Bilet zakupiony pomyślnie");
                                                        done.setBounds(100, 200, 1200, 50);
                                                        done.setFont(new Font("Verdana", Font.PLAIN, 40));
                                                        frame.add(done);

                                                        JButton download = new JButton("Pobierz bilet");
                                                        download.setBounds(100, 270, 200, 50);
                                                        download.setFont(new Font("Verdana", Font.PLAIN, 20));
                                                        frame.add(download);
                                                    }
                                                });

                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });

            }
        });
    }
}