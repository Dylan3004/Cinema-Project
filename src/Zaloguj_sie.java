import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Zaloguj_sie {



    private java.util.List<JComponent> mainComponents = new ArrayList<>();

    //po zapomnialem hasla
    public java.util.List<JComponent> forgotPasswordComponents = new ArrayList<>();

    // po zaloguj sie
    public java.util.List<JComponent> mainAccComponents = new ArrayList<>();
    public java.util.List<JComponent> ticketsComponents = new ArrayList<>();
    public java.util.List<JComponent> verifyComponents = new ArrayList<>();
    public java.util.List<JComponent> changePasswordComponents = new ArrayList<>();

    // po zarejestruj sie
    public List<JComponent> registerComponents = new ArrayList<>();

        Zaloguj_sie()
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

            // logo
            try {
                ImageIcon logo = new ImageIcon(new ImageIcon("images/logo.PNG").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                JLabel label = new JLabel(logo);
                label.setBounds(10, 10, 70, 70);
                frame.add(label);
            } catch (Exception e) {
                System.out.println("Nie znaleziono pliku");
            }
            


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
            JLabel ticket = new JLabel("TWÓJ BILET");
            ticket.setBounds(650, 400, 250, 50);
            ticket.setFont(new Font("Verdana", Font.PLAIN, 22));
            ticket.setVisible(false);
            frame.add(ticket);
            ticketsComponents.add(ticket);

            JButton download_tickets_button = new JButton("Pobierz bilet");
            download_tickets_button.setBounds(900, 450, 300, 50);
            download_tickets_button.setBackground(Colors.buttonColor);
            download_tickets_button.setVisible(false);
            frame.add(download_tickets_button);
            ticketsComponents.add(download_tickets_button);

            JButton return_button = new JButton("Zwróć");
            return_button.setBounds(900, 520, 300, 50);
            return_button.setBackground(Colors.buttonColor);
            return_button.setVisible(false);
            frame.add(return_button);
            ticketsComponents.add(return_button);

            // weryfikacja
            JLabel verify = new JLabel("Ile masz lat?");
            verify.setBounds(500, 250, 500, 50);
            verify.setFont(new Font("Verdana", Font.PLAIN, 36));
            verify.setVisible(false);
            frame.add(verify);
            verifyComponents.add(verify);

            JTextField verify_age = new JTextField();
            verify_age.setBounds(500, 400, 150, 50);
            verify_age.setFont(new Font("Verdana", Font.PLAIN, 28));
            verify_age.setVisible(false);
            frame.add(verify_age);
            verifyComponents.add(verify_age);

            JButton verify_button = new JButton("Zweryfikuj");
            verify_button.setBounds(600, 600, 200, 50);
            verify_button.setBackground(Colors.buttonColor);
            verify_button.setVisible(false);
            frame.add(verify_button);
            verifyComponents.add(verify_button);

            // zmiana hasla
            JLabel change_password = new JLabel("Nowe hasło:");
            change_password.setBounds(500, 250, 400, 50);
            change_password.setFont(new Font("Verdana", Font.PLAIN, 36));
            change_password.setVisible(false);
            frame.add(change_password);
            changePasswordComponents.add(change_password);

            JPasswordField new_password = new JPasswordField();
            new_password.setBounds(500, 400, 200, 50);
            new_password.setFont(new Font("Verdana", Font.PLAIN, 28));
            new_password.setVisible(false);
            frame.add(new_password);
            changePasswordComponents.add(new_password);

            JButton change_password_button2 = new JButton("Zmień hasło");
            change_password_button2.setBounds(600, 600, 200, 50);
            change_password_button2.setBackground(Colors.buttonColor);
            change_password_button2.setVisible(false);
            frame.add(change_password_button2);
            changePasswordComponents.add(change_password_button2);

            change_password_button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(JComponent component : changePasswordComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : ticketsComponents){
                        component.setVisible(true);
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
                    new Moje_Konto();
                    frame.dispose();
                }
            });

            forgot_password_button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(JComponent component : mainComponents) {
                        component.setVisible(false);
                    }

                    for(JComponent component : forgotPasswordComponents) {
                        component.setVisible(true);
                    }
                }
            });

            verify_button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(JComponent component : verifyComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : ticketsComponents){
                        component.setVisible(true);
                    }
                }
            });

            odzyskaj.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Moje_Konto();
                    frame.dispose();
                }
            });


            login_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JComponent component : mainComponents) {
                        component.setVisible(false);
                    }

                    for (JComponent component : mainAccComponents) {
                        component.setVisible(true);
                    }

                    for (JComponent component : ticketsComponents) {
                        component.setVisible(true);
                    }
                }
            });

            verify_account_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(JComponent component : ticketsComponents) {
                        component.setVisible(false);
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
                }
            });

            change_password_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(JComponent component : verifyComponents) {
                        component.setVisible(false);
                    }
                    for(JComponent component : ticketsComponents) {
                        component.setVisible(false);
                    }

                    for(JComponent component : changePasswordComponents) {
                        component.setVisible(true);
                    }
                }
            });


            // todo dodać przyciski do logowania i rejestracji
        }








}
