import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Repertuar {
    JFrame frame;
    private List<JComponent> mainElements = new ArrayList<>();
    private List<JComponent> detailsElements = new ArrayList<>();
    private List<JComponent> numbersElements = new ArrayList<>();
    private List<JComponent> placesElements = new ArrayList<>();
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
//        ImageIcon logo = new ImageIcon("images/logo.PNG");
//        JLabel label = new JLabel(logo);
//        label.setBounds(10, 10, 70, 70);
//        frame.add(label);
        try {
            ImageIcon logo = new ImageIcon(new ImageIcon("images/logo.PNG").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(logo);
            label.setBounds(10, 10, 70, 70);
            frame.add(label);
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku");
        }

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
        mainElements.add(label1);

        JLabel label2 = new JLabel(data_i_godzina);
        label2.setBounds(x, y + 50, 1000, 50);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label2);
        mainElements.add(label2);

        JLabel label3 = new JLabel(opis);
        label3.setBounds(x, y + 100, 1000, 50);
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        this.frame.add(label3);
        mainElements.add(label3);

        ImageIcon image = new ImageIcon(path);
        JLabel label = new JLabel(image);
        label.setBounds(x - 500, y, 200, 200);
        this.frame.add(label);
        mainElements.add(label);

        //przycisk do kupowania
        JButton check_and_buy = new JButton("Zobacz szczegóły i kup bilet");
        check_and_buy.setBounds(x + 800, y + 20, 200, 50);
        frame.add(check_and_buy);
        mainElements.add(check_and_buy);
        check_and_buy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (JComponent c : mainElements) {
                    c.setVisible(false);
                }
                JLabel label_movie_title = new JLabel("Chłopi");
                label_movie_title.setBounds(100, 200, 1200, 50);
                label_movie_title.setFont(new Font("Verdana", Font.PLAIN, 40));
                frame.add(label_movie_title);
                detailsElements.add(label_movie_title);

                JButton go_back = new JButton("Powrót");
                go_back.setBounds(100, 270, 100, 30);
                frame.add(go_back);
                detailsElements.add(go_back);

                String description = "<html>Tytuł: Chłopi<br><br>Termin: 2023-12-17 16:00<br><br>Rok produkcji: 2023<br><br>Kategoria wiekowa: 12+<br><br>Reżyser: Dorota Kobiela, Hugh Welchman<br><br>Opis: Film jest trzecią (po wersjach z 1922 i 1973 roku) pełnometrażową adaptacją powieści Władysława Reymonta pod tym samym tytułem, ukazującej cykl życia wiejskiego pod koniec XIX wieku. Chłopi są filmem wykonanym tą samą metodą animacji, co Twój Vincent w reżyserii tego samego duetu – nagrane wcześniej przed kamerą kadry zostały powtórnie namalowane farbą olejną na płótnie.\r\n"
                        + "\r\n"
                        + "Film Chłopi został uhonorowany czterema nagrodami na Festiwalu Polskich Filmów Fabularnych, w tym Nagrodą Specjalną Jury oraz Nagrodą Publiczności. Przeważały pozytywne recenzje, choć kontrowersje budziły kwestie zastosowanej metody animacji malarskiej oraz feministycznego przesłania filmu. Chłopi zostali zgłoszeni jako polski kandydat do rywalizacji o Oscara dla najlepszego pełnometrażowego filmu międzynarodowego. (zródło: Wikipedia)</html>";
                JLabel label_description = new JLabel(description);
                label_description.setBounds(100, 300, 800, 600);
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

                                JLabel label_select_places = new JLabel("Wybierz miejsca ze schematu:");
                                label_select_places.setBounds(100, 200, 1200, 50);
                                label_select_places.setFont(new Font("Verdana", Font.PLAIN, 40));
                                frame.add(label_select_places);
                                placesElements.add(label_select_places);

                                JButton back_to_numbers = new JButton("Powrót");
                                back_to_numbers.setBounds(100, 270, 100, 30);
                                frame.add(back_to_numbers);
                                placesElements.add(back_to_numbers);

                                //......

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
                            }
                        });
                    }
                });

            }
        });
    }
}