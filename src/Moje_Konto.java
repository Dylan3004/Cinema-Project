import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.floor;

public class Moje_Konto {
    private List<JComponent> mainComponents = new ArrayList<>();
    private Integer liczbaBiletowNaStrone = 5;
    private Integer obecnaStronaBiletow = 1;

    // po zapomnialem hasla
    public List<JComponent> forgotPasswordComponents = new ArrayList<>();

    // po zaloguj sie
    public List<JComponent> mainAccComponents = new ArrayList<>();
    public List<JComponent> ticketsComponents = new ArrayList<>();
    public List<JComponent> verifyComponents = new ArrayList<>();
    public List<JComponent> changePasswordComponents = new ArrayList<>();

    // po zarejestruj sie
    public List<JComponent> registerComponents = new ArrayList<>();

    // prawy gorny rog
    JButton button6 = new JButton("Zaloguj się/Zarejestruj się");

    Moje_Konto()
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

        JLabel label2 = new JLabel("Aby uzyskać informacje o swoim koncie, zaloguj się.");
        label2.setBounds(400, 200, 1200, 90);
        label2.setFont(new Font("Verdana", Font.PLAIN, 40));
        frame.add(label2);
        mainComponents.add(label2);

        JLabel label3 = new JLabel("Login:");
        label3.setBounds(400, 300, 1200, 90);
        label3.setFont(new Font("Verdana", Font.PLAIN, 22));
        frame.add(label3);
        mainComponents.add(label3);

        JTextField login = new JTextField();
        login.setBounds(500, 320, 400, 50);
        login.setFont(new Font("Verdana", Font.PLAIN, 22));
        frame.add(login);
        mainComponents.add(login);

        JLabel label4 = new JLabel("Hasło:");
        label4.setBounds(400, 400, 1200, 90);
        label4.setFont(new Font("Verdana", Font.PLAIN, 22));
        frame.add(label4);
        mainComponents.add(label4);

        JPasswordField haslo = new JPasswordField();
        haslo.setBounds(500, 420, 400, 50);
        haslo.setFont(new Font("Verdana", Font.PLAIN, 22));
        frame.add(haslo);
        mainComponents.add(haslo);

        JButton login_button = new JButton("Zaloguj się");
        login_button.setBounds(840, 500, 200, 50);
        login_button.setBackground(Colors.buttonColor);
        frame.add(login_button);
        mainComponents.add(login_button);

        JButton register_button = new JButton("Zarejestruj się");
        register_button.setBounds(620, 500, 200, 50);
        register_button.setBackground(Colors.buttonColor);
        frame.add(register_button);
        mainComponents.add(register_button);

        JButton forgot_password_button = new JButton("Nie pamiętam hasła");
        forgot_password_button.setBounds(400, 500, 200, 50);
        forgot_password_button.setBackground(Colors.buttonColor);
        frame.add(forgot_password_button);
        mainComponents.add(forgot_password_button);


        // forgot password
        JLabel napis = new JLabel("Aby odzyskać hasło podaj adres e-mail");
        napis.setBounds(400, 200, 1200, 90);
        napis.setFont(new Font("Verdana", Font.PLAIN, 40));
        napis.setVisible(false);
        forgotPasswordComponents.add(napis);
        frame.add(napis);

        JLabel napis2 = new JLabel("Adres e-mail:");
        napis2.setBounds(100, 300, 400, 90);
        napis2.setFont(new Font("Verdana", Font.PLAIN, 22));
        napis2.setVisible(false);
        forgotPasswordComponents.add(napis2);
        frame.add(napis2);

        JTextField email = new JTextField();
        email.setBounds(500, 320, 400, 50);
        email.setFont(new Font("Verdana", Font.PLAIN, 22));
        email.setVisible(false);
        forgotPasswordComponents.add(email);
        frame.add(email);

        JButton odzyskaj = new JButton("Wyślij e-mail");
        odzyskaj.setBounds(840, 400, 200, 50);
        odzyskaj.setBackground(Colors.buttonColor);
        odzyskaj.setVisible(false);
        forgotPasswordComponents.add(odzyskaj);
        frame.add(odzyskaj);

        // register
        JLabel napisr = new JLabel("Aby uzyskać pełny dostęp zarejestruj się");
        napisr.setBounds(400, 200, 1200, 90);
        napisr.setFont(new Font("Verdana", Font.PLAIN, 40));
        napisr.setVisible(false);
        registerComponents.add(napisr);
        frame.add(napisr);

        JLabel napisr2 = new JLabel("Adres e-mail:");
        napisr2.setBounds(100, 300, 400, 90);
        napisr2.setFont(new Font("Verdana", Font.PLAIN, 22));
        napisr2.setVisible(false);
        registerComponents.add(napisr2);
        frame.add(napisr2);

        JTextField r_email = new JTextField();
        r_email.setBounds(500, 320, 400, 50);
        r_email.setFont(new Font("Verdana", Font.PLAIN, 22));
        r_email.setVisible(false);
        registerComponents.add(r_email);
        frame.add(r_email);

        JLabel napisr3 = new JLabel("Imię:");
        napisr3.setBounds(100, 400, 400, 90);
        napisr3.setFont(new Font("Verdana", Font.PLAIN, 22));
        napisr3.setVisible(false);
        registerComponents.add(napisr3);
        frame.add(napisr3);

        JTextField r_imie = new JTextField();
        r_imie.setBounds(500, 420, 400, 50);
        r_imie.setFont(new Font("Verdana", Font.PLAIN, 22));
        r_imie.setVisible(false);
        registerComponents.add(r_imie);
        frame.add(r_imie);

        JLabel napisr4 = new JLabel("Nazwisko:");
        napisr4.setBounds(100, 500, 400, 90);
        napisr4.setFont(new Font("Verdana", Font.PLAIN, 22));
        napisr4.setVisible(false);
        registerComponents.add(napisr4);
        frame.add(napisr4);

        JTextField r_nazwisko = new JTextField();
        r_nazwisko.setBounds(500, 520, 400, 50);
        r_nazwisko.setFont(new Font("Verdana", Font.PLAIN, 22));
        r_nazwisko.setVisible(false);
        registerComponents.add(r_nazwisko);
        frame.add(r_nazwisko);

        JLabel napisr5 = new JLabel("Hasło:");
        napisr5.setBounds(100, 600, 400, 90);
        napisr5.setFont(new Font("Verdana", Font.PLAIN, 22));
        napisr5.setVisible(false);
        registerComponents.add(napisr5);
        frame.add(napisr5);

        JPasswordField r_haslo = new JPasswordField();
        r_haslo.setBounds(500, 620, 400, 50);
        r_haslo.setFont(new Font("Verdana", Font.PLAIN, 22));
        r_haslo.setVisible(false);
        registerComponents.add(r_haslo);
        frame.add(r_haslo);

        JLabel napisr6 = new JLabel("Powtórz hasło:");
        napisr6.setBounds(100, 700, 1200, 90);
        napisr6.setFont(new Font("Verdana", Font.PLAIN, 22));
        napisr6.setVisible(false);
        registerComponents.add(napisr6);
        frame.add(napisr6);

        JPasswordField r_haslo2 = new JPasswordField();
        r_haslo2.setBounds(500, 720, 400, 50);
        r_haslo2.setFont(new Font("Verdana", Font.PLAIN, 22));
        r_haslo2.setVisible(false);
        registerComponents.add(r_haslo2);
        frame.add(r_haslo2);

        JButton zarejestruj = new JButton("Zarejestruj");
        zarejestruj.setBounds(840, 800, 200, 50);
        zarejestruj.setBackground(Colors.buttonColor);
        zarejestruj.setVisible(false);
        registerComponents.add(zarejestruj);
        frame.add(zarejestruj);


        // po zaloguj
        JButton bought_tickets_button = new JButton("Kupione bilety");
        bought_tickets_button.setBounds(100, 350, 200, 50);
        bought_tickets_button.setBackground(Colors.buttonColor);
        bought_tickets_button.setVisible(false);
        mainAccComponents.add(bought_tickets_button);
        frame.add(bought_tickets_button);

        JButton verify_account_button = new JButton("Zweryfikuj konto");
        verify_account_button.setBounds(100, 450, 200, 50);
        verify_account_button.setBackground(Colors.buttonColor);
        verify_account_button.setVisible(false);
        mainAccComponents.add(verify_account_button);
        frame.add(verify_account_button);

        JButton change_password_button = new JButton("Zmień hasło");
        change_password_button.setBounds(100, 550, 200, 50);
        change_password_button.setBackground(Colors.buttonColor);
        change_password_button.setVisible(false);
        mainAccComponents.add(change_password_button);
        frame.add(change_password_button);


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


        // weryfikacja
        JLabel verify = new JLabel("Ile masz lat?");
        verify.setBounds(500, 335, 500, 50);
        verify.setFont(new Font("Verdana", Font.PLAIN, 36));
        verify.setVisible(false);
        frame.add(verify);
        verifyComponents.add(verify);

        JTextField verify_age = new JTextField();
        verify_age.setBounds(500, 400, 100, 50);
        verify_age.setFont(new Font("Verdana", Font.PLAIN, 28));
        verify_age.setVisible(false);
        frame.add(verify_age);
        verifyComponents.add(verify_age);

        JButton verify_button = new JButton("Zweryfikuj");
        verify_button.setBounds(700, 500, 200, 50);
        verify_button.setBackground(Colors.buttonColor);
        verify_button.setVisible(false);
        frame.add(verify_button);
        verifyComponents.add(verify_button);

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

        change_password_button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Zmieniono hasło");

                    for(JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : ticketsComponents){
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

        register_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JComponent component : mainComponents) {
                    component.setVisible(false);
                }

                for(JComponent component : registerComponents) {
                    component.setVisible(true);
                }
            }
        });

        zarejestruj.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(r_haslo.getText().equals(r_haslo2.getText())) {
                    // TODO: dodanie danych do bazy danych
                    String haslo = r_haslo.getText();
                    String email = r_email.getText();
                    String imie = r_imie.getText();
                    String nazwisko = r_nazwisko.getText();


                    new Moje_Konto();
                    frame.dispose();
                } else{
                    JOptionPane.showMessageDialog(frame, "Hasła nie są takie same");
                }
            }
        });

        forgot_password_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    for (JComponent component : mainComponents) {
                        component.setVisible(false);
                    }

                    for (JComponent component : forgotPasswordComponents) {
                        component.setVisible(true);
                    }
                }
        });

        verify_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = Integer.parseInt(verify_age.getText());
                if(age < 18) {
                    JOptionPane.showMessageDialog(frame, "Nie możesz weryfikować konta");
                } else {
                    JOptionPane.showMessageDialog(frame, "Konto zostało zweryfikowane");
                    // TODO: dodac do bazy danych ze konto jest zweryfikowane
                }
                for(JComponent component : verifyComponents) {
                    component.setVisible(false);
                }
                for(JComponent component : ticketsComponents){
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
            }
        });

        odzyskaj.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: sprawdzic czy jest w bazie
                boolean JestWBazie = true;

                if(JestWBazie) {
                JOptionPane.showMessageDialog(frame, "Wysłano e-mail z linkiem do zmiany hasła");

                new Moje_Konto();
                frame.dispose();
                } else{
                    JOptionPane.showMessageDialog(frame, "Niepoprawny adres e-mail");
                }
            }
        });


        login_button.addActionListener(new ActionListener() {
            boolean DaneSaWBazie = true;
            boolean czyToAdmin = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                // to to pole co bylo wczesniej zbugowane
                button6.setVisible(false);

                // TODO: sprawdzic czy dane sa w bazie danych
                if(DaneSaWBazie) {
                    Colors.logged = true;
                    Colors.personID = getPersonID();

                    //TODO: sprawdzic czy to admin z bazy danych
                    if(czyToAdmin){
                        Colors.admin = true;

                        new Moje_Konto_Admin();
                        frame.dispose();
                    } else{
                        Colors.admin = false;
                    }

                    for (JComponent component : mainComponents) {
                        component.setVisible(false);
                    }

                    for (JComponent component : mainAccComponents) {
                        component.setVisible(true);
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
                } else {
                    JOptionPane.showMessageDialog(frame, "Niepoprawne dane logowania");
                }
            }
        });

        verify_account_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(JComponent component : ticketsComponents) {
                            component.setVisible(false);
                        }
                        for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                            ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                            downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                            returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                        }
                        for(JComponent component : changePasswordComponents) {
                            component.setVisible(false);
                        }

                        for(JComponent component : verifyComponents) {
                            component.setVisible(true);
                        }
                    }
        });

        bought_tickets_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(JComponent component : verifyComponents) {
                            component.setVisible(false);
                        }
                        for(JComponent component : changePasswordComponents) {
                            component.setVisible(false);
                        }
                        for(JComponent component : ticketsComponents) {
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
                    }
        });

        change_password_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(JComponent component : verifyComponents) {
                            component.setVisible(false);
                        }
                        for(JComponent component : changePasswordComponents) {
                            component.setVisible(true);
                        }
                        for(JComponent component : ticketsComponents) {
                            component.setVisible(false);
                        }
                        for(int i = 0; i < getTicketIDs(getPersonID()).size(); i++){
                            ticketsLabels.get(i*obecnaStronaBiletow).setVisible(false);
                            downloadTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
                            returnTicketButtons.get(i*obecnaStronaBiletow).setVisible(false);
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
                }
            });
        }



    }

    // TODO: zamienic to na odczyt z bazy
    private List<Integer> getSeanceIDs(Integer movieID) {
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
