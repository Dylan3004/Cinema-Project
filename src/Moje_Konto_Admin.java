import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.floor;

public class Moje_Konto_Admin {
    private List<JComponent> mainComponents = new ArrayList<>();
    private Integer liczbaBiletowNaStrone = 5;
    private Integer obecnaStronaBiletow = 1;

    // po zaloguj sie
    public List<JComponent> mainAccComponents = new ArrayList<>();
    public List<JComponent> deleteORAddMovieComponents = new ArrayList<>();
    public List<JComponent> editDeleteOrAddSeanceComponents = new ArrayList<>();
    public List<JComponent> changePasswordComponents = new ArrayList<>();
    public List<JComponent> ticketsComponents = new ArrayList<>();
    List<JComponent> addMovieComponents = new ArrayList<>();
    List<JComponent> deleteMovieComponents = new ArrayList<>();

    List<JComponent> EditSeanceComponents = new ArrayList<>();
    List<JComponent> AddSeanceComponents = new ArrayList<>();
    List<JComponent> LastOnEditSeanceComponents = new ArrayList<>();


    // prawy gorny rog
    JButton button6 = new JButton("Zaloguj się/Zarejestruj się");

    Moje_Konto_Admin()
    {
        JFrame frame = new JFrame("Aplikacja Kinomaniak");
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
                JOptionPane.showMessageDialog(frame, "Znajdujesz się już na stronie Moje konto!");
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

        try {
            ImageIcon logo = new ImageIcon(new ImageIcon("images/logo.PNG").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            JLabel label = new JLabel(logo);
            label.setBounds(10, 10, 70, 70);
            frame.add(label);
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku");
        }

        // po zaloguj
        JButton edit_movies = new JButton("Edytuj filmy");
        edit_movies.setBounds(100, 350, 200, 50);
        edit_movies.setBackground(Colors.buttonColor);
        edit_movies.setVisible(true);
        mainAccComponents.add(edit_movies);
        frame.add(edit_movies);

        JButton edit_seances = new JButton("Edytuj seanse");
        edit_seances.setBounds(100, 450, 200, 50);
        edit_seances.setBackground(Colors.buttonColor);
        edit_seances.setVisible(true);
        mainAccComponents.add(edit_seances);
        frame.add(edit_seances);

        JButton change_password_button = new JButton("Zmień hasło");
        change_password_button.setBounds(100, 550, 200, 50);
        change_password_button.setBackground(Colors.buttonColor);
        change_password_button.setVisible(true);
        mainAccComponents.add(change_password_button);
        frame.add(change_password_button);

        JButton bought_tickets_button = new JButton("Kupione bilety");
        bought_tickets_button.setBounds(100, 650, 200, 50);
        bought_tickets_button.setBackground(Colors.buttonColor);
        bought_tickets_button.setVisible(true);
        mainAccComponents.add(bought_tickets_button);
        frame.add(bought_tickets_button);

        // bilety
        Integer liczbaStron = 0;
        liczbaStron = (int) floor(getTicketIDs(getPersonID()).size()/liczbaBiletowNaStrone);
        JLabel pageNumber = new JLabel("Strona: " + obecnaStronaBiletow + " z " + liczbaStron);
        pageNumber.setBounds(700, 750, 350, 50);
        pageNumber.setFont(new Font("Verdana", Font.PLAIN, 22));
        pageNumber.setVisible(false);
        frame.add(pageNumber);
        ticketsComponents.add(pageNumber);

        List<JLabel> ticketsLabels = new ArrayList<>();
        for (int i = 0; i < getTicketIDs(getPersonID()).size(); i++) {
            int j = i%liczbaBiletowNaStrone + 1;
            JLabel ticket = new JLabel("TWÓJ BILET " + i);
            ticket.setBounds(550, 250+(j*70), 250, 50);
            ticket.setFont(new Font("Verdana", Font.PLAIN, 22));
            ticket.setVisible(false);

            frame.add(ticket);
            ticketsLabels.add(ticket);
            ticketsComponents.add(ticket);
        }

        List<JButton> downloadTicketButtons = new ArrayList<>();
        for (int i = 0; i < ticketsLabels.size(); i++) {
            int j = i%liczbaBiletowNaStrone + 1;
            JButton download_tickets_button = new JButton("Pobierz");
            download_tickets_button.setBounds(820, 250+(j*70), 120, 50);
            download_tickets_button.setBackground(Colors.buttonColor);
            download_tickets_button.setVisible(false);

            frame.add(download_tickets_button);
            downloadTicketButtons.add(download_tickets_button);
            ticketsComponents.add(download_tickets_button);
        }

        List<JButton> returnTicketButtons = new ArrayList<>();
        for (int i = 0; i < ticketsLabels.size(); i++) {
            int j = i%liczbaBiletowNaStrone + 1;
            JButton return_button = new JButton("Zwróć");
            return_button.setBounds(960, 250+(j*70), 90, 50);
            return_button.setBackground(Colors.buttonColor);
            return_button.setVisible(false);

            frame.add(return_button);
            returnTicketButtons.add(return_button);
            ticketsComponents.add(return_button);
        }

        JButton goRightButton = new JButton(">");
        goRightButton.setBounds(1050, 750, 50, 50);
        goRightButton.setBackground(Colors.buttonColor);
        goRightButton.setVisible(false);
        frame.add(goRightButton);
        ticketsComponents.add(goRightButton);

        JButton goLeftButton = new JButton("<");
        goLeftButton.setBounds(350, 750, 50, 50);
        goLeftButton.setBackground(Colors.buttonColor);
        goLeftButton.setVisible(false);
        frame.add(goLeftButton);
        ticketsComponents.add(goLeftButton);



        // zmiana hasla
        JLabel change_password = new JLabel("Podaj nowe hasło:");
        change_password.setBounds(500, 335, 400, 50);
        change_password.setFont(new Font("Verdana", Font.PLAIN, 36));
        change_password.setVisible(false);
        frame.add(change_password);
        changePasswordComponents.add(change_password);

        JPasswordField new_password = new JPasswordField();
        new_password.setBounds(500, 400, 300, 50);
        new_password.setFont(new Font("Verdana", Font.PLAIN, 28));
        new_password.setVisible(false);
        frame.add(new_password);
        changePasswordComponents.add(new_password);

        JButton change_password_button2 = new JButton("Zmień hasło");
        change_password_button2.setBounds(700, 500, 200, 50);
        change_password_button2.setBackground(Colors.buttonColor);
        change_password_button2.setVisible(false);
        frame.add(change_password_button2);
        changePasswordComponents.add(change_password_button2);

        // edytuj filmy
        JButton add_movie = new JButton("Dodaj film");
        add_movie.setBounds(360, 350, 200, 50);
        add_movie.setBackground(Colors.buttonColor);
        add_movie.setVisible(false);
        frame.add(add_movie);
        deleteORAddMovieComponents.add(add_movie);

        JButton delete_movie = new JButton("Usuń film");
        delete_movie.setBounds(360, 450, 200, 50);
        delete_movie.setBackground(Colors.buttonColor);
        delete_movie.setVisible(false);
        frame.add(delete_movie);
        deleteORAddMovieComponents.add(delete_movie);

        // dodanie filmu
        JLabel add_movie_label = new JLabel("Podaj szczegóły filmu:");
        add_movie_label.setBounds(700, 250, 500, 50);
        add_movie_label.setFont(new Font("Verdana", Font.PLAIN, 36));
        add_movie_label.setVisible(false);
        frame.add(add_movie_label);
        addMovieComponents.add(add_movie_label);

        JLabel add_movie_title_label = new JLabel("Tytuł:");
        add_movie_title_label.setBounds(700, 300, 300, 35);
        add_movie_title_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_title_label.setVisible(false);
        frame.add(add_movie_title_label);
        addMovieComponents.add(add_movie_title_label);

        JTextField add_movie_title = new JTextField();
        add_movie_title.setBounds(700, 335, 300, 35);
        add_movie_title.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_title.setVisible(false);
        frame.add(add_movie_title);
        addMovieComponents.add(add_movie_title);

        JLabel add_movie_genre_label = new JLabel("Gatunek:");
        add_movie_genre_label.setBounds(700, 370, 400, 35);
        add_movie_genre_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_genre_label.setVisible(false);
        frame.add(add_movie_genre_label);
        addMovieComponents.add(add_movie_genre_label);

        JTextField add_movie_genre = new JTextField();
        add_movie_genre.setBounds(700, 405, 300, 35);
        add_movie_genre.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_genre.setVisible(false);
        frame.add(add_movie_genre);
        addMovieComponents.add(add_movie_genre);

        JLabel add_movie_studio_label = new JLabel("Studio:");
        add_movie_studio_label.setBounds(700, 440, 300, 35);
        add_movie_studio_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_studio_label.setVisible(false);
        frame.add(add_movie_studio_label);
        addMovieComponents.add(add_movie_studio_label);

        JTextField add_movie_studio = new JTextField();
        add_movie_studio.setBounds(700, 475, 300, 35);
        add_movie_studio.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_studio.setVisible(false);
        frame.add(add_movie_studio);
        addMovieComponents.add(add_movie_studio);

        JLabel add_movie_director_label = new JLabel("Reżyser:");
        add_movie_director_label.setBounds(700, 510, 400, 35);
        add_movie_director_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_director_label.setVisible(false);
        frame.add(add_movie_director_label);
        addMovieComponents.add(add_movie_director_label);

        JTextField add_movie_director = new JTextField();
        add_movie_director.setBounds(700, 545, 300, 35);
        add_movie_director.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_director.setVisible(false);
        frame.add(add_movie_director);
        addMovieComponents.add(add_movie_director);

        JLabel add_movie_cast_label = new JLabel("Obsada:");
        add_movie_cast_label.setBounds(700, 580, 300, 35);
        add_movie_cast_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_cast_label.setVisible(false);
        frame.add(add_movie_cast_label);
        addMovieComponents.add(add_movie_cast_label);

        JTextField add_movie_cast = new JTextField();
        add_movie_cast.setBounds(700, 615, 300, 35);
        add_movie_cast.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_cast.setVisible(false);
        frame.add(add_movie_cast);
        addMovieComponents.add(add_movie_cast);

        JLabel add_movie_description_label = new JLabel("Opis:");
        add_movie_description_label.setBounds(700, 650, 300, 35);
        add_movie_description_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_description_label.setVisible(false);
        frame.add(add_movie_description_label);
        addMovieComponents.add(add_movie_description_label);

        JTextField add_movie_description = new JTextField();
        add_movie_description.setBounds(700, 685, 300, 35);
        add_movie_description.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_description.setVisible(false);
        frame.add(add_movie_description);
        addMovieComponents.add(add_movie_description);

        JLabel add_movie_year_label = new JLabel("Rok produkcji:");
        add_movie_year_label.setBounds(700, 720, 400, 35);
        add_movie_year_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_year_label.setVisible(false);
        frame.add(add_movie_year_label);
        addMovieComponents.add(add_movie_year_label);

        JTextField add_movie_year = new JTextField();
        add_movie_year.setBounds(700, 755, 300, 35);
        add_movie_year.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_movie_year.setVisible(false);
        frame.add(add_movie_year);
        addMovieComponents.add(add_movie_year);


        JButton add_movie_button = new JButton("Dodaj film");
        add_movie_button.setBounds(1050, 780, 150, 50);
        add_movie_button.setBackground(Colors.buttonColor);
        add_movie_button.setVisible(false);
        frame.add(add_movie_button);
        addMovieComponents.add(add_movie_button);


        // usuneicie filmu

        JLabel delete_movie_label = new JLabel("Wybierz film do usunięcia:");
        delete_movie_label.setBounds(700, 250, 500, 50);
        delete_movie_label.setFont(new Font("Verdana", Font.PLAIN, 36));
        delete_movie_label.setVisible(false);
        frame.add(delete_movie_label);
        deleteMovieComponents.add(delete_movie_label);

        JLabel delete_movie_title_label = new JLabel("Podaj tytuł filmu:");
        delete_movie_title_label.setBounds(700, 330, 300, 35);
        delete_movie_title_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        delete_movie_title_label.setVisible(false);
        frame.add(delete_movie_title_label);
        deleteMovieComponents.add(delete_movie_title_label);

        JTextField delete_movie_title = new JTextField();
        delete_movie_title.setBounds(700, 365, 300, 35);
        delete_movie_title.setFont(new Font("Verdana", Font.PLAIN, 22));
        delete_movie_title.setVisible(false);
        frame.add(delete_movie_title);
        deleteMovieComponents.add(delete_movie_title);

        JButton delete_movie_button = new JButton("Usuń film");
        delete_movie_button.setBounds(1050, 400, 150, 50);
        delete_movie_button.setBackground(Colors.buttonColor);
        delete_movie_button.setVisible(false);
        frame.add(delete_movie_button);
        deleteMovieComponents.add(delete_movie_button);

        // edytuj seanse
        JButton add_seance = new JButton("Dodaj termin seansu");
        add_seance.setBounds(360, 350, 200, 50);
        add_seance.setBackground(Colors.buttonColor);
        add_seance.setVisible(false);
        frame.add(add_seance);
        editDeleteOrAddSeanceComponents.add(add_seance);

        JButton delete_edit_seance = new JButton("Edytuj lub usuń termin seansu");
        delete_edit_seance.setBounds(360, 450, 200, 50);
        delete_edit_seance.setBackground(Colors.buttonColor);
        delete_edit_seance.setVisible(false);
        frame.add(delete_edit_seance);
        editDeleteOrAddSeanceComponents.add(delete_edit_seance);



        // dodaj nowe seanse
        JLabel add_seance_label = new JLabel("Dodaj nowy seans:");
        add_seance_label.setBounds(700, 250, 500, 50);
        add_seance_label.setFont(new Font("Verdana", Font.PLAIN, 36));
        add_seance_label.setVisible(false);
        frame.add(add_seance_label);
        AddSeanceComponents.add(add_seance_label);

        JLabel add_seance_movie_label = new JLabel("Podaj tytuł filmu:");
        add_seance_movie_label.setBounds(700, 300, 300, 35);
        add_seance_movie_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_movie_label.setVisible(false);
        frame.add(add_seance_movie_label);
        AddSeanceComponents.add(add_seance_movie_label);

        JTextField add_seance_movie = new JTextField();
        add_seance_movie.setBounds(700, 335, 300, 35);
        add_seance_movie.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_movie.setVisible(false);
        frame.add(add_seance_movie);
        AddSeanceComponents.add(add_seance_movie);

        JLabel add_seance_date_label = new JLabel("Podaj datę:");
        add_seance_date_label.setBounds(700, 370, 300, 35);
        add_seance_date_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_date_label.setVisible(false);
        frame.add(add_seance_date_label);
        AddSeanceComponents.add(add_seance_date_label);

        JTextField add_seance_date = new JTextField();
        add_seance_date.setBounds(700, 405, 300, 35);
        add_seance_date.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_date.setVisible(false);
        frame.add(add_seance_date);
        AddSeanceComponents.add(add_seance_date);

        JLabel add_seance_hour_label = new JLabel("Podaj godzinę:");
        add_seance_hour_label.setBounds(700, 440, 300, 35);
        add_seance_hour_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_hour_label.setVisible(false);
        frame.add(add_seance_hour_label);
        AddSeanceComponents.add(add_seance_hour_label);

        JTextField add_seance_hour = new JTextField();
        add_seance_hour.setBounds(700, 475, 300, 35);
        add_seance_hour.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_hour.setVisible(false);
        frame.add(add_seance_hour);
        AddSeanceComponents.add(add_seance_hour);

        JLabel add_seanse_price = new JLabel("Podaj cenę biletu:");
        add_seanse_price.setBounds(700, 510, 300, 35);
        add_seanse_price.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seanse_price.setVisible(false);
        frame.add(add_seanse_price);
        AddSeanceComponents.add(add_seanse_price);

        JTextField add_seance_price = new JTextField();
        add_seance_price.setBounds(700, 545, 300, 35);
        add_seance_price.setFont(new Font("Verdana", Font.PLAIN, 22));
        add_seance_price.setVisible(false);
        frame.add(add_seance_price);
        AddSeanceComponents.add(add_seance_price);

        JButton add_seance_button = new JButton("Dodaj seans");
        add_seance_button.setBounds(1050, 580, 150, 50);
        add_seance_button.setBackground(Colors.buttonColor);
        add_seance_button.setVisible(false);
        frame.add(add_seance_button);
        AddSeanceComponents.add(add_seance_button);


        // edytuj i usun (isActive) seanse
        JLabel edit_seance_label = new JLabel("Wybierz seans:");
        edit_seance_label.setBounds(700, 250, 500, 50);
        edit_seance_label.setFont(new Font("Verdana", Font.PLAIN, 36));
        edit_seance_label.setVisible(false);
        frame.add(edit_seance_label);
        EditSeanceComponents.add(edit_seance_label);

        JLabel edit_seance_movie_label = new JLabel("Podaj tytuł filmu:");
        edit_seance_movie_label.setBounds(700, 300, 300, 35);
        edit_seance_movie_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        edit_seance_movie_label.setVisible(false);
        frame.add(edit_seance_movie_label);
        EditSeanceComponents.add(edit_seance_movie_label);

        JTextField edit_seance_movie = new JTextField();
        edit_seance_movie.setBounds(700, 335, 300, 35);
        edit_seance_movie.setFont(new Font("Verdana", Font.PLAIN, 22));
        edit_seance_movie.setVisible(false);
        frame.add(edit_seance_movie);
        EditSeanceComponents.add(edit_seance_movie);

        JLabel edit_seance_date_label = new JLabel("Podaj datę:");
        edit_seance_date_label.setBounds(700, 370, 300, 35);
        edit_seance_date_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        edit_seance_date_label.setVisible(false);
        frame.add(edit_seance_date_label);
        EditSeanceComponents.add(edit_seance_date_label);

        JTextField edit_seance_date = new JTextField();
        edit_seance_date.setBounds(700, 405, 300, 35);
        edit_seance_date.setFont(new Font("Verdana", Font.PLAIN, 22));
        edit_seance_date.setVisible(false);
        frame.add(edit_seance_date);
        EditSeanceComponents.add(edit_seance_date);

        JLabel edit_seance_hour_label = new JLabel("Podaj godzinę:");
        edit_seance_hour_label.setBounds(700, 440, 300, 35);
        edit_seance_hour_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        edit_seance_hour_label.setVisible(false);
        frame.add(edit_seance_hour_label);
        EditSeanceComponents.add(edit_seance_hour_label);

        JTextField edit_seance_hour = new JTextField();
        edit_seance_hour.setBounds(700, 475, 300, 35);
        edit_seance_hour.setFont(new Font("Verdana", Font.PLAIN, 22));
        edit_seance_hour.setVisible(false);
        frame.add(edit_seance_hour);
        EditSeanceComponents.add(edit_seance_hour);

        JButton edit_seance_button = new JButton("Edytuj ten seans");
        edit_seance_button.setBounds(1050, 510, 200, 50);
        edit_seance_button.setBackground(Colors.buttonColor);
        edit_seance_button.setVisible(false);
        frame.add(edit_seance_button);
        EditSeanceComponents.add(edit_seance_button);


        // teraz sama edycja
        JLabel last_on_edit_seance_label = new JLabel("Zmień szczegóły seansu:");
        last_on_edit_seance_label.setBounds(700, 250, 500, 50);
        last_on_edit_seance_label.setFont(new Font("Verdana", Font.PLAIN, 36));
        last_on_edit_seance_label.setVisible(false);
        frame.add(last_on_edit_seance_label);
        LastOnEditSeanceComponents.add(last_on_edit_seance_label);

        JLabel last_on_edit_seance_date_label = new JLabel("Data:");
        last_on_edit_seance_date_label.setBounds(700, 300, 300, 35);
        last_on_edit_seance_date_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_date_label.setVisible(false);
        frame.add(last_on_edit_seance_date_label);
        LastOnEditSeanceComponents.add(last_on_edit_seance_date_label);

        JTextField last_on_edit_seance_date = new JTextField();
        last_on_edit_seance_date.setBounds(700, 335, 300, 35);
        last_on_edit_seance_date.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_date.setVisible(false);
        frame.add(last_on_edit_seance_date);
        LastOnEditSeanceComponents.add(last_on_edit_seance_date);

        JLabel last_on_edit_seance_hour_label = new JLabel("Godzina:");
        last_on_edit_seance_hour_label.setBounds(700, 370, 300, 35);
        last_on_edit_seance_hour_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_hour_label.setVisible(false);
        frame.add(last_on_edit_seance_hour_label);
        LastOnEditSeanceComponents.add(last_on_edit_seance_hour_label);

        JTextField last_on_edit_seance_hour = new JTextField();
        last_on_edit_seance_hour.setBounds(700, 405, 300, 35);
        last_on_edit_seance_hour.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_hour.setVisible(false);
        frame.add(last_on_edit_seance_hour);
        LastOnEditSeanceComponents.add(last_on_edit_seance_hour);

        JLabel last_on_edit_seance_price_label = new JLabel("Cena biletu:");
        last_on_edit_seance_price_label.setBounds(700, 440, 300, 35);
        last_on_edit_seance_price_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_price_label.setVisible(false);
        frame.add(last_on_edit_seance_price_label);
        LastOnEditSeanceComponents.add(last_on_edit_seance_price_label);

        JTextField last_on_edit_seance_price = new JTextField();
        last_on_edit_seance_price.setBounds(700, 475, 300, 35);
        last_on_edit_seance_price.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_price.setVisible(false);
        frame.add(last_on_edit_seance_price);
        LastOnEditSeanceComponents.add(last_on_edit_seance_price);

        JLabel last_on_edit_seance_isActive_label = new JLabel("Czy seans jest aktywny:");
        last_on_edit_seance_isActive_label.setBounds(700, 510, 300, 35);
        last_on_edit_seance_isActive_label.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_isActive_label.setVisible(false);
        frame.add(last_on_edit_seance_isActive_label);
        LastOnEditSeanceComponents.add(last_on_edit_seance_isActive_label);

        JCheckBox last_on_edit_seance_isActive = new JCheckBox();
        last_on_edit_seance_isActive.setBounds(700, 545, 35, 35);
        last_on_edit_seance_isActive.setFont(new Font("Verdana", Font.PLAIN, 22));
        last_on_edit_seance_isActive.setVisible(false);
        frame.add(last_on_edit_seance_isActive);
        LastOnEditSeanceComponents.add(last_on_edit_seance_isActive);

        JButton last_on_edit_seance_button = new JButton("Zatwierdź");
        last_on_edit_seance_button.setBounds(1050, 580, 200, 50);
        last_on_edit_seance_button.setBackground(Colors.buttonColor);
        last_on_edit_seance_button.setVisible(false);
        frame.add(last_on_edit_seance_button);
        LastOnEditSeanceComponents.add(last_on_edit_seance_button);







        last_on_edit_seance_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = last_on_edit_seance_date.getText();
                String hour = last_on_edit_seance_hour.getText();
                String price = last_on_edit_seance_price.getText();
                boolean isActive = last_on_edit_seance_isActive.isSelected();
                // TODO: zmiana danych w bazie danych

                JOptionPane.showMessageDialog(frame, "Zmieniono szczegóły seansu");

                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });




        edit_seance_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = edit_seance_movie.getText();
                String date = edit_seance_date.getText();
                String hour = edit_seance_hour.getText();

                // TODO: sprawdzenie czy taki seans jest w bazie
                boolean jestWBazie = true;

                if(jestWBazie){
                    for(JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : ticketsComponents){
                        component.setVisible(false);
                    }
                    for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                        ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                        downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                        returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    }
                    for(JComponent component : deleteORAddMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : editDeleteOrAddSeanceComponents) {
                        component.setVisible(true);
                    }
                    for(JComponent component : addMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : deleteMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : AddSeanceComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : EditSeanceComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : LastOnEditSeanceComponents){
                        component.setVisible(true);
                    }
                } else{
                    JOptionPane.showMessageDialog(frame, "Nie ma takiego seansu w bazie danych");
                }
            }
        });


        add_seance_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = add_seance_movie.getText();
                String date = add_seance_date.getText();
                String hour = add_seance_hour.getText();
                String price = add_seance_price.getText();

                // TODO: sprawdzic z baza danych
                boolean jestWBazie = true;

                if(jestWBazie){
                    // TODO: dodac do bazy danych nowy seans

                    JOptionPane.showMessageDialog(frame, "Dodano nowy seans");

                    for(JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : ticketsComponents){
                        component.setVisible(false);
                    }
                    for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                        ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                        downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                        returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    }
                    for(JComponent component : deleteORAddMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : editDeleteOrAddSeanceComponents) {
                        component.setVisible(true);
                    }
                    for(JComponent component : addMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : deleteMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : AddSeanceComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : EditSeanceComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : LastOnEditSeanceComponents){
                        component.setVisible(false);
                    }
                } else{
                    JOptionPane.showMessageDialog(frame, "Nie ma takiego filmu w bazie danych");
                }
            }
        });

        add_seance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });

        delete_edit_seance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });


        delete_movie_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = delete_movie_title.getText();
                // TODO: sprawdzenie czy jest w bazie danych ten tytul

                boolean jestWBazie = false;
                if (jestWBazie) {
                    JOptionPane.showMessageDialog(frame, "Usunięto film z bazy danych");
                    for (JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for (JComponent component : ticketsComponents) {
                        component.setVisible(false);
                    }
                    for (int i = 0; i < getTicketIDs(getPersonID()).size(); i++) {
                        ticketsLabels.get(i * obecnaStronaBiletow).setVisible(false);
                        downloadTicketButtons.get(i * obecnaStronaBiletow).setVisible(false);
                        returnTicketButtons.get(i * obecnaStronaBiletow).setVisible(false);
                    }
                    for (JComponent component : deleteORAddMovieComponents) {
                        component.setVisible(true);
                    }
                    for (JComponent component : editDeleteOrAddSeanceComponents) {
                        component.setVisible(false);
                    }
                    for (JComponent component : addMovieComponents) {
                        component.setVisible(false);
                    }
                    for (JComponent component : deleteMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : AddSeanceComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : EditSeanceComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : LastOnEditSeanceComponents){
                        component.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Nie ma takiego filmu w bazie danych");
                }
            }
        });


        edit_seances.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });


        delete_movie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JComponent component : deleteMovieComponents) {
                    component.setVisible(true);
                }
                for (JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for (JComponent component : ticketsComponents) {
                    component.setVisible(false);
                }
                for (int i = 0; i < getTicketIDs(getPersonID()).size(); i++) {
                    ticketsLabels.get(i * obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i * obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i * obecnaStronaBiletow).setVisible(false);
                }
                for (JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(true);
                }
                for (JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for (JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });


        add_movie_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = add_movie_title.getText();
                String genre = add_movie_genre.getText();
                String studio = add_movie_studio.getText();
                String director = add_movie_director.getText();
                String cast = add_movie_cast.getText();
                String description = add_movie_description.getText();
                String year = add_movie_year.getText();

                // TODO: wpisanie tego do bazy danych
                JOptionPane.showMessageDialog(frame, "Dodano film do bazy danych");

                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });


        edit_movies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });

        add_movie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });



        change_password_button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Zmieniono hasło");

                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });

        goRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obecnaStronaBiletow < floor(getTicketIDs(getPersonID()).size()/liczbaBiletowNaStrone))
                    obecnaStronaBiletow++;

                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(int i = 0; i < liczbaBiletowNaStrone; i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(true);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                }
            }
        });

        goLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obecnaStronaBiletow > 1)
                    obecnaStronaBiletow--;
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(int i = 0; i < liczbaBiletowNaStrone; i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(true);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                }
            }
        });

        bought_tickets_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(int i = 0; i < liczbaBiletowNaStrone; i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(true);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });

        change_password_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : ticketsComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : changePasswordComponents) {
                    component.setVisible(true);
                }
                for(JComponent component : deleteORAddMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : editDeleteOrAddSeanceComponents) {
                    component.setVisible(false);
                }
                for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                    ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                    downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                }
                for(JComponent component : addMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : deleteMovieComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : AddSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : EditSeanceComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : LastOnEditSeanceComponents){
                    component.setVisible(false);
                }
            }
        });

        for(int i = 0; i < returnTicketButtons.size(); i++){
            final int index = i;
            returnTicketButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: usunac bilet z bazy danych

                    JOptionPane.showMessageDialog(frame, "Bilet został zwrócony");

                    for (JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for (JComponent component : ticketsComponents) {
                        component.setVisible(true);
                    }
                    for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                        ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                        downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                        returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    }
                    for(int i = 0; i < liczbaBiletowNaStrone; i++){
                        ticketsLabels.get(i*obecnaStronaBiletow).setVisible(true);
                        downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                        returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                    }
                    for(JComponent component : addMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : deleteMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : LastOnEditSeanceComponents){
                        component.setVisible(false);
                    }
                }
            });
        }

        for(int i = 0; i < downloadTicketButtons.size(); i++){
            final int index = i;
            downloadTicketButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: ponizsze odkomentowac + dorobic odczytanie tych rzeeczy z bazy
//                try {
//                    BufferedWriter bw = new BufferedWriter(new FileWriter("tickets/ticket.txt"));
//                    bw.write("Bilet na seans: " + m.getTitle());
//                    bw.write("\nData:" + m.getDate());
//                    bw.write("\nGodzina: " + m.getTime());
//                    bw.write("\nMiejsca na widowni: " + selectedPlaces);
//                    bw.write("\nLiczba osób bez zniżek: " + number_normal_tickets);
//                    bw.write("\nLiczba osób ze zniżką uczniowską: " + number_student_tickets);
//                    bw.write("\nLiczba osób ze zniżką seniorską: " + number_senior_tickets);
//                    bw.write("\nLiczba osób niepełnosprawnych: " + number_invalids);
//                    JOptionPane.showMessageDialog(frame, "Bilet zapisano pomyślnie");
//                    bw.close();
//                }
//                catch(IOException ex) {
//                    JOptionPane.showMessageDialog(frame, "Błąd zapisu biletu");
//                    ex.printStackTrace();
//                }
                    JOptionPane.showMessageDialog(frame, "Bilet został pobrany");

                    for (JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for (JComponent component : ticketsComponents) {
                        component.setVisible(true);
                    }
                    for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                        ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                        downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                        returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                    }
                    for(int i = 0; i < liczbaBiletowNaStrone; i++){
                        ticketsLabels.get(i*obecnaStronaBiletow).setVisible(true);
                        downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                        returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(true);
                    }
                    for(JComponent component : addMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : deleteMovieComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : LastOnEditSeanceComponents){
                        component.setVisible(false);
                    }
                }
            });
        }













    }


    // TODO: zamienic to na odczyt z bazy
    private List<Integer> getSeanceIDs(int movieID) {
        List<Integer> seanceIDs = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < random.nextInt(4); i++) {
            seanceIDs.add(random.nextInt(121));
        }
        return seanceIDs;
    }

    private Integer getMovieID(Integer seanceID) {
        Random random = new Random();
        return random.nextInt(121);
    }

    private List<Integer> getTicketIDs(Integer PersonID) {
        List<Integer> ticketIDs = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < (random.nextInt(4)+8); i++) {
            ticketIDs.add(random.nextInt(121));
        }
        return ticketIDs;
    }

    private Integer getPersonID() {
        Random random = new Random();
        return random.nextInt(121);
    }
}
