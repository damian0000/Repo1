import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class Form extends javax.swing.JFrame {

    public Form() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_polacz = new javax.swing.JButton();
        jPanel_pracownicy = new javax.swing.JPanel();
        jTextField_pr_imie = new javax.swing.JTextField();
        jLabel_pr_imie = new javax.swing.JLabel();
        jLabel_pr_nazwisko = new javax.swing.JLabel();
        jLabel_pr_telefon = new javax.swing.JLabel();
        jLabel_st_semestr = new javax.swing.JLabel();
        jLabel_st_przedmiot = new javax.swing.JLabel();
        jLabel_pr_przedmiot = new javax.swing.JLabel();
        jTextField_pr_nazwisko = new javax.swing.JTextField();
        jTextField_pr_telefon = new javax.swing.JTextField();
        jTextField_pr_ulica = new javax.swing.JTextField();
        jTextField_pr_miejscowosc = new javax.swing.JTextField();
        jButton_pracow_zapisz = new javax.swing.JButton();
        jLabel_Pracownicy = new javax.swing.JLabel();
        jButton_pracow_usun = new javax.swing.JButton();
        jLabel_pr_id = new javax.swing.JLabel();
        jTextField_pr_id = new javax.swing.JTextField();
        jComboBox_pr_przedmiot = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_pracownicy = new javax.swing.JTable();
        jPanel_studenci = new javax.swing.JPanel();
        jTextField_st_imie = new javax.swing.JTextField();
        jLabel_st_imie1 = new javax.swing.JLabel();
        jLabel_st_nazwisko1 = new javax.swing.JLabel();
        jLabel_st_kierunek1 = new javax.swing.JLabel();
        jLabel_st_semestr1 = new javax.swing.JLabel();
        jLabel_st_przedmiot1 = new javax.swing.JLabel();
        jLabel_st_grupa1 = new javax.swing.JLabel();
        jTextField_st_nazwisko = new javax.swing.JTextField();
        jTextField_st_kierunek = new javax.swing.JTextField();
        jTextField_st_semestr = new javax.swing.JTextField();
        jButton_st_zapisz1 = new javax.swing.JButton();
        jLabel_studenci1 = new javax.swing.JLabel();
        jButton_st_usun1 = new javax.swing.JButton();
        jComboBox_st_przedmiot = new javax.swing.JComboBox<>();
        jComboBox_st_grupa = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_studenci = new javax.swing.JTable();
        jPanel_przedmioty = new javax.swing.JPanel();
        jLabel_prz_przedmiot = new javax.swing.JLabel();
        jTextField_prz_przedmiot = new javax.swing.JTextField();
        jButton_prz_zapisz = new javax.swing.JButton();
        jLabel_przedmioty = new javax.swing.JLabel();
        jButton_prz_usun = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_przedmioty = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_grupy = new javax.swing.JTable();
        jPanel_grupy = new javax.swing.JPanel();
        jLabel_gr_grupa = new javax.swing.JLabel();
        jTextField_gr_grupa = new javax.swing.JTextField();
        jButton_gr_zapisz = new javax.swing.JButton();
        jLabel_grupy = new javax.swing.JLabel();
        jButton_gr_usun = new javax.swing.JButton();
        jButton_odswiez = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dziekanat");
        setResizable(false);

        jButton_polacz.setText("Połącz");
        jButton_polacz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_polaczActionPerformed(evt);
            }
        });

        jPanel_pracownicy.setName("panel1"); // NOI18N

        jTextField_pr_imie.setName("textField_imie"); // NOI18N

        jLabel_pr_imie.setText("Imię");

        jLabel_pr_nazwisko.setText("Nazwisko");

        jLabel_pr_telefon.setText("Telefon");

        jLabel_st_semestr.setText("Ulica");

        jLabel_st_przedmiot.setText("Miejscowość");

        jLabel_pr_przedmiot.setText("Przedmiot");

        jTextField_pr_nazwisko.setName("textField_nazwisko"); // NOI18N

        jTextField_pr_telefon.setName("textField_kierunek"); // NOI18N

        jTextField_pr_ulica.setName("textField_semestr"); // NOI18N

        jTextField_pr_miejscowosc.setName("textField_grupa"); // NOI18N

        jButton_pracow_zapisz.setText("Zapisz do bazy");
        jButton_pracow_zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pracow_zapiszActionPerformed(evt);
            }
        });

        jLabel_Pracownicy.setText("Pracownicy");

        jButton_pracow_usun.setText("Usuń");
        jButton_pracow_usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pracow_usunActionPerformed(evt);
            }
        });

        jLabel_pr_id.setText("ID");

        jTextField_pr_id.setName("textField_nazwisko"); // NOI18N

        javax.swing.GroupLayout jPanel_pracownicyLayout = new javax.swing.GroupLayout(jPanel_pracownicy);
        jPanel_pracownicy.setLayout(jPanel_pracownicyLayout);
        jPanel_pracownicyLayout.setHorizontalGroup(
            jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel_Pracownicy))
                    .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_pr_id)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_pracownicyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_pracow_usun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_pracow_zapisz))
                    .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_st_przedmiot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_pr_przedmiot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                                .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_st_semestr)
                                    .addComponent(jLabel_pr_nazwisko)
                                    .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel_pr_imie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_pr_telefon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jTextField_pr_nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_pr_id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_pr_imie, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_pr_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_pr_ulica, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_pr_miejscowosc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_pr_przedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(164, 164, 164))
        );
        jPanel_pracownicyLayout.setVerticalGroup(
            jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel_Pracownicy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pr_id)
                    .addComponent(jTextField_pr_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_pracownicyLayout.createSequentialGroup()
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pr_nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_pr_nazwisko))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pr_imie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_pr_imie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pr_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_pr_telefon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pr_ulica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_st_semestr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pr_miejscowosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_st_przedmiot))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_pr_przedmiot)
                        .addComponent(jComboBox_pr_przedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel_pracownicyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_pracow_usun)
                    .addComponent(jButton_pracow_zapisz)))
        );

        jTable_pracownicy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nazwisko", "Imię", "Telefon", "Ulica", "Miejscowość", "Przedmiot"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_pracownicy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_pracownicyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_pracownicy);
        if (jTable_pracownicy.getColumnModel().getColumnCount() > 0) {
            jTable_pracownicy.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel_studenci.setName("panel1"); // NOI18N

        jTextField_st_imie.setName("textField_imie"); // NOI18N

        jLabel_st_imie1.setText("Imię");

        jLabel_st_nazwisko1.setText("Nazwisko");

        jLabel_st_kierunek1.setText("Kierunek");

        jLabel_st_semestr1.setText("Semetr");

        jLabel_st_przedmiot1.setText("Przedmiot");

        jLabel_st_grupa1.setText("Grupa");

        jTextField_st_nazwisko.setName("textField_nazwisko"); // NOI18N

        jTextField_st_kierunek.setName("textField_kierunek"); // NOI18N

        jTextField_st_semestr.setName("textField_semestr"); // NOI18N

        jButton_st_zapisz1.setText("Zapisz do bazy");
        jButton_st_zapisz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_st_zapisz1ActionPerformed(evt);
            }
        });

        jLabel_studenci1.setText("Studenci");

        jButton_st_usun1.setText("Usuń");
        jButton_st_usun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_st_usun1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_studenciLayout = new javax.swing.GroupLayout(jPanel_studenci);
        jPanel_studenci.setLayout(jPanel_studenciLayout);
        jPanel_studenciLayout.setHorizontalGroup(
            jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_studenciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_studenciLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel_studenci1)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel_studenciLayout.createSequentialGroup()
                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_studenciLayout.createSequentialGroup()
                                .addGap(0, 39, Short.MAX_VALUE)
                                .addComponent(jButton_st_usun1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_st_zapisz1))
                            .addGroup(jPanel_studenciLayout.createSequentialGroup()
                                .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_st_przedmiot1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_st_grupa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel_studenciLayout.createSequentialGroup()
                                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_st_semestr1)
                                            .addComponent(jLabel_st_nazwisko1)
                                            .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel_st_imie1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel_st_kierunek1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_st_kierunek)
                                    .addComponent(jTextField_st_imie)
                                    .addComponent(jTextField_st_nazwisko)
                                    .addComponent(jComboBox_st_przedmiot, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox_st_grupa, 0, 140, Short.MAX_VALUE)
                                    .addComponent(jTextField_st_semestr))))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel_studenciLayout.setVerticalGroup(
            jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_studenciLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel_studenci1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_studenciLayout.createSequentialGroup()
                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_st_nazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_st_nazwisko1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_st_imie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_st_imie1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_st_kierunek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_st_kierunek1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_st_semestr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_st_semestr1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_st_przedmiot1)
                            .addComponent(jComboBox_st_przedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_st_grupa1)
                        .addComponent(jComboBox_st_grupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_studenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_st_zapisz1)
                    .addComponent(jButton_st_usun1))
                .addGap(8, 8, 8))
        );

        jTable_studenci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nazwisko", "Imię", "Kierunek", "Semestr", "Przedmiot", "Grupa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_studenci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_studenciMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_studenci);
        if (jTable_studenci.getColumnModel().getColumnCount() > 0) {
            jTable_studenci.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel_przedmioty.setName("panel1"); // NOI18N

        jLabel_prz_przedmiot.setText("Przedmiot");

        jTextField_prz_przedmiot.setName("textField_nazwisko"); // NOI18N

        jButton_prz_zapisz.setText("Zapisz do bazy");
        jButton_prz_zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_prz_zapiszActionPerformed(evt);
            }
        });

        jLabel_przedmioty.setText("Przedmioty");

        jButton_prz_usun.setText("Usuń");
        jButton_prz_usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_prz_usunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_przedmiotyLayout = new javax.swing.GroupLayout(jPanel_przedmioty);
        jPanel_przedmioty.setLayout(jPanel_przedmiotyLayout);
        jPanel_przedmiotyLayout.setHorizontalGroup(
            jPanel_przedmiotyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_przedmiotyLayout.createSequentialGroup()
                .addGroup(jPanel_przedmiotyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_przedmiotyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_prz_przedmiot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_prz_przedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_przedmiotyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_przedmiotyLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(jLabel_przedmioty))
                        .addGroup(jPanel_przedmiotyLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton_prz_usun)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton_prz_zapisz))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel_przedmiotyLayout.setVerticalGroup(
            jPanel_przedmiotyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_przedmiotyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_przedmioty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_przedmiotyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_prz_przedmiot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_prz_przedmiot))
                .addGap(18, 18, 18)
                .addGroup(jPanel_przedmiotyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_prz_zapisz)
                    .addComponent(jButton_prz_usun))
                .addGap(31, 31, 31))
        );

        jTable_przedmioty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Przedmiot"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_przedmioty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_przedmiotyMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_przedmioty);

        jTable_grupy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grupa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_grupy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_grupyMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_grupy);

        jPanel_grupy.setName("panel1"); // NOI18N

        jLabel_gr_grupa.setText("Grupa");

        jTextField_gr_grupa.setName("textField_nazwisko"); // NOI18N

        jButton_gr_zapisz.setText("Zapisz do bazy");
        jButton_gr_zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gr_zapiszActionPerformed(evt);
            }
        });

        jLabel_grupy.setText("Grupy");

        jButton_gr_usun.setText("Usuń");
        jButton_gr_usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gr_usunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_grupyLayout = new javax.swing.GroupLayout(jPanel_grupy);
        jPanel_grupy.setLayout(jPanel_grupyLayout);
        jPanel_grupyLayout.setHorizontalGroup(
            jPanel_grupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_grupyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_gr_grupa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_gr_grupa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(jPanel_grupyLayout.createSequentialGroup()
                .addGroup(jPanel_grupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_grupyLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel_grupy))
                    .addGroup(jPanel_grupyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_gr_usun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_gr_zapisz)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_grupyLayout.setVerticalGroup(
            jPanel_grupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_grupyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_grupy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_grupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_gr_grupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_gr_grupa))
                .addGap(18, 18, 18)
                .addGroup(jPanel_grupyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_gr_zapisz)
                    .addComponent(jButton_gr_usun))
                .addGap(31, 31, 31))
        );

        jButton_odswiez.setText("Odśwież");
        jButton_odswiez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_odswiezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_studenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel_pracownicy, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel_przedmioty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel_grupy, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_polacz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_odswiez)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_polacz)
                    .addComponent(jButton_odswiez))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel_studenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_przedmioty, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel_pracownicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_grupy, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //  pol z baza-----------------------------------------------------------------------------------------------------
    private  Connection getConnection()
    {  //łączy z bazą danych
        Connection conn = null;
        try {
            //rejestracja sterownika - jest pod klasami "sqljdbc41.jar"
//            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//            link do połączenia. "SQLEXPRESS;databaseName=Dziekanat" nazwa instancji serwera i bazy
//            String dbURL = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS;databaseName=Dziekanat;integratedSecurity=true";
//            String user = "dbo";
//            String pass = "";  
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://127.0.0.1:3306/dziekanat";
            String user = "root";
            String pass = "";   
            
            conn = DriverManager.getConnection(dbURL, user, pass);
            //JOptionPane.showMessageDialog(null, "Połączono");
    
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Nie można połączyć z serwerem");
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problem ze sterownikiem");
            return null;
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    private void jButton_polaczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_polaczActionPerformed
        //wywołuje funkcje
        getConnection();
    }//GEN-LAST:event_jButton_polaczActionPerformed
                                                   
    //Przedmioty
    private void jButton_prz_zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_prz_zapiszActionPerformed
        String prz=jTextField_prz_przedmiot.getText();
        
        //spr czy pole zaw znaki alf. i dodaj do bazy
        if(z_alf(prz.toString())==true)
        {
            Connection conn=getConnection();
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Przedmioty (Przedmiot) values (?)");
                ps.setString(1, prz);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Przedmiot dodany do bazy");
                //czyszczenie pola
                jTextField_prz_przedmiot.setText("");
                pokaz_przedmioty_w_tabeli();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Przedmiot już istnieje w bazie");
//                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Pole jest puste, bądź nie zawiera znaków alfanumerycznych");
    }//GEN-LAST:event_jButton_prz_zapiszActionPerformed

    private void jButton_prz_usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_prz_usunActionPerformed
        if(z_alf(jTextField_prz_przedmiot.getText())==true)
        {
            try {
                Connection conn=getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Przedmioty WHERE Przedmiot = ?");
                ps.setString(1, jTextField_prz_przedmiot.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Przedmiot usunięty");
                jTextField_prz_przedmiot.setText("");
                pokaz_przedmioty_w_tabeli();
            } catch (SQLException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Przedmiot nie został usunięty");
            }
        }else
            JOptionPane.showMessageDialog(null, "Pole jest puste, bądź nie ma takiego przedmiotu");
    }//GEN-LAST:event_jButton_prz_usunActionPerformed
    //główne menu
    private void jButton_odswiezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_odswiezActionPerformed
        pokaz_przedmioty_w_tabeli();
        pokaz_grupy_w_tabeli();
        pokaz_studentow_w_tabeli();
        pokaz_pracownikow_w_tabeli();
        dane_combobox();
        czyszczenie_wszystkich_pol();
    }//GEN-LAST:event_jButton_odswiezActionPerformed
   //Przedmioty tabela
    private void jTable_przedmiotyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_przedmiotyMouseClicked
        //klikniecie mysza powoduje wybranie przedmiotu
        int index=jTable_przedmioty.getSelectedRow();
        jTextField_prz_przedmiot.setText(getPrzedmiotyList().get(index).getPrzedmiot());
        
    }//GEN-LAST:event_jTable_przedmiotyMouseClicked
//grupy-----------------------------------------------------------------------------------------------------------------------------
    private void jButton_gr_zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gr_zapiszActionPerformed
        String gr=jTextField_gr_grupa.getText();
        if(z_alf(gr.toString())==true)
        {
            Connection conn=getConnection();
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Grupy (Grupa) values (?)");
                ps.setString(1, gr);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Grupa dodana do bazy");
                jTextField_gr_grupa.setText("");
                pokaz_grupy_w_tabeli();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Grupa już istnieje w bazie");
//                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Pole jest puste, bądź nie zawiera znaków alfanumerycznych");
    }//GEN-LAST:event_jButton_gr_zapiszActionPerformed

    private void jButton_gr_usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gr_usunActionPerformed
        if(!jTextField_gr_grupa.getText().equals(""))
        {
            try {
                Connection conn=getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Grupy WHERE Grupa = ?");
                ps.setString(1, jTextField_gr_grupa.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Grupa usunięta");
                jTextField_gr_grupa.setText("");
                pokaz_grupy_w_tabeli();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Grupa nie została usunięta");
                //Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Pole jest puste, bądź nie ma takiego przedmiotu");
    }//GEN-LAST:event_jButton_gr_usunActionPerformed

    private void jTable_grupyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_grupyMouseClicked
        int index=jTable_grupy.getSelectedRow();
        jTextField_gr_grupa.setText(getGrupyList().get(index).getGrupa());
    }//GEN-LAST:event_jTable_grupyMouseClicked
    //sudenci
    private void jButton_st_zapisz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_st_zapisz1ActionPerformed
        String nazwisko=jTextField_st_nazwisko.getText();
        String imie=jTextField_st_imie.getText();
        String kierunek=jTextField_st_kierunek.getText();
        String semestr=jTextField_st_semestr.getText();
        String przedmiot=jComboBox_st_przedmiot.getSelectedItem().toString();
        String grupa=jComboBox_st_grupa.getSelectedItem().toString();        
        if((z_alf(nazwisko.toString())==true) && (z_alf(imie.toString())==true) 
                && (z_alf(kierunek.toString())==true) && (spr_cyfry_sem()==true))
        {
            Connection conn=getConnection();
            try {
                
                String query="INSERT INTO `dziekanat`.`Studenci`(`Nazwisko`, `Imie`, `Kierunek`, `Semestr`, `Przedmiot`, `Grupa`) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nazwisko);
                ps.setString(2, imie);
                ps.setString(3, kierunek);
                ps.setString(4, semestr);
                ps.setString(5, przedmiot);
                ps.setString(6, grupa);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dodane do bazy");
                jTextField_st_nazwisko.setText("");
                jTextField_st_imie.setText("");
                jTextField_st_kierunek.setText("");
                jTextField_st_semestr.setText("");
                
                pokaz_studentow_w_tabeli();
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Student o tym nazwisku już istnieje w bazie");
                //Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Pola są puste, bądź nie zawierają znaków alfanumerycznych. "
                    + "Semestr musi być mniejszy od 9");
    }//GEN-LAST:event_jButton_st_zapisz1ActionPerformed

    private void jButton_st_usun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_st_usun1ActionPerformed
        String nazwisko=jTextField_st_nazwisko.getText();
        String imie=jTextField_st_imie.getText();
        String kierunek=jTextField_st_kierunek.getText();
        String semestr=jTextField_st_semestr.getText();
        String przedmiot=jComboBox_st_przedmiot.getSelectedItem().toString();
        String grupa=jComboBox_st_grupa.getSelectedItem().toString();
        if((z_alf(nazwisko.toString())==true) && (z_alf(imie.toString())==true) 
                && (z_alf(kierunek.toString())==true) && (spr_cyfry_sem()==true))
        {
            try {
                Connection conn=getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Studenci WHERE (Nazwisko = ? AND Imie =?) AND Kierunek=?");
                ps.setString(1, jTextField_st_nazwisko.getText());
                ps.setString(2, jTextField_st_imie.getText());
                ps.setString(3, jTextField_st_kierunek.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dane usunięte");
                jTextField_st_nazwisko.setText("");
                jTextField_st_imie.setText("");
                jTextField_st_kierunek.setText("");
                jTextField_st_semestr.setText("");
                pokaz_studentow_w_tabeli();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Dane nie zostały usunięte");
                //Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Pola są puste");
    }//GEN-LAST:event_jButton_st_usun1ActionPerformed

    private void jTable_studenciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_studenciMouseClicked
        int index=jTable_studenci.getSelectedRow();
        jTextField_st_nazwisko.setText(getStudenciList().get(index).getNazwisko());
        jTextField_st_imie.setText(getStudenciList().get(index).getImie());
        jTextField_st_kierunek.setText(getStudenciList().get(index).getKierunek());
        jTextField_st_semestr.setText(getStudenciList().get(index).getSemestr_string());
        jComboBox_st_przedmiot.setSelectedItem(getStudenciList().get(index).getPrzedmiot());
        jComboBox_st_grupa.setSelectedItem(getStudenciList().get(index).getGrupa());
    }//GEN-LAST:event_jTable_studenciMouseClicked

    private void jButton_pracow_zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pracow_zapiszActionPerformed
        String ID=jTextField_pr_id.getText();
        String nazwisko=jTextField_pr_nazwisko.getText();
        String imie=jTextField_pr_imie.getText();
        String telefon=jTextField_pr_telefon.getText();
        String ulica=jTextField_pr_ulica.getText();
        String miejscowosc=jTextField_pr_miejscowosc.getText();
        String przedmiot=jComboBox_pr_przedmiot.getSelectedItem().toString();
        
        if((z_alf(ID.toString())==true) && (z_alf(nazwisko.toString())==true) 
                && (z_alf(imie.toString())==true) && (spr_num_tel()==true) && (z_alf(ulica.toString()))
                && z_alf(miejscowosc))
        {
            Connection conn=getConnection();
            try {
                String query="INSERT INTO Pracownicy (ID, Nazwisko, Imie, Telefon, Ulica, Miejscowosc, Przedmiot) values (?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, ID);
                ps.setString(2, nazwisko);
                ps.setString(3, imie);
                ps.setString(4, telefon);
                ps.setString(5, ulica);
                ps.setString(6, miejscowosc);
                ps.setString(7, przedmiot);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dodane do bazy");
                jTextField_pr_id.setText("");
                jTextField_pr_nazwisko.setText("");
                jTextField_pr_imie.setText("");
                jTextField_pr_telefon.setText("");
                jTextField_pr_ulica.setText("");
                jTextField_pr_miejscowosc.setText("");
                pokaz_pracownikow_w_tabeli();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Pracownik o tym ID już istnieje w bazie");
                //Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Pola są puste, bądź nie zawierają znaków alfanumerycznych. "
                    + "Telefon musi zawirać 9 cyfr");
    }//GEN-LAST:event_jButton_pracow_zapiszActionPerformed

    private void jButton_pracow_usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pracow_usunActionPerformed
        String ID=jTextField_pr_id.getText();
        String nazwisko=jTextField_pr_nazwisko.getText();
        String imie=jTextField_pr_imie.getText();
        String telefon=jTextField_pr_telefon.getText();
        String ulica=jTextField_pr_ulica.getText();
        String miejscowosc=jTextField_pr_miejscowosc.getText();
        String przedmiot=jComboBox_pr_przedmiot.getSelectedItem().toString();
        
        if((z_alf(ID.toString())==true) && (z_alf(nazwisko.toString())==true) 
                && (z_alf(imie.toString())==true) && (spr_num_tel()==true) && (z_alf(ulica.toString()))
                && z_alf(miejscowosc))
        {
            Connection conn=getConnection();
            try {
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Pracownicy WHERE ID=?");
                ps.setString(1, jTextField_pr_id.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dane usunięte z bazy");
                jTextField_pr_id.setText("");
                jTextField_pr_nazwisko.setText("");
                jTextField_pr_imie.setText("");
                jTextField_pr_telefon.setText("");
                jTextField_pr_ulica.setText("");
                jTextField_pr_miejscowosc.setText("");
                pokaz_pracownikow_w_tabeli();
            } catch (SQLException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            JOptionPane.showMessageDialog(null, "Błąd");
    }//GEN-LAST:event_jButton_pracow_usunActionPerformed

    private void jTable_pracownicyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_pracownicyMouseClicked
        int index=jTable_pracownicy.getSelectedRow();
        jTextField_pr_id.setText(getPracownicyList().get(index).getID());
        jTextField_pr_nazwisko.setText(getPracownicyList().get(index).getNazwisko());
        jTextField_pr_imie.setText(getPracownicyList().get(index).getImie());
        jTextField_pr_telefon.setText(getPracownicyList().get(index).getTelefon());
        jTextField_pr_ulica.setText(getPracownicyList().get(index).getUlica());
        jTextField_pr_miejscowosc.setText(getPracownicyList().get(index).getMiejscowosc());
        jComboBox_pr_przedmiot.setSelectedItem(getPracownicyList().get(index).getPrzedmiot());
    }//GEN-LAST:event_jTable_pracownicyMouseClicked
  //-----------------------------------------------------------------------------------------------------------------------------------
    //przedmioty
    private boolean z_alf(String zn) 
    {
        if(!zn.equals(""))
            return true;
        else if(zn.matches("[A-Za-z0-9][/]")) 
            return true;
        return false;
    }
    //umieszczenie danych w tabeli - wykorzystana w pokaz_przedmioty_w_tabeli()
    public ArrayList<Przedmioty> getPrzedmiotyList()
    {
        ArrayList<Przedmioty> przedmiotyList=new ArrayList<Przedmioty>();
        Connection conn=getConnection();
        try {        
            Statement st;
            ResultSet rs;
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM Przedmioty");
            //z klasy Przedmioty
            Przedmioty prz;
            //petla po przedmiotach
            while(rs.next())
            {   //tworze instancje
                prz=new Przedmioty(rs.getString("przedmiot"));
                przedmiotyList.add(prz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return przedmiotyList;
    }
    // pokazuje produkty w tabeli - Funcja jest wykorzystana w przyciskach jButton_prz_zapisz
    public void pokaz_przedmioty_w_tabeli()
    {
        ArrayList<Przedmioty> list= getPrzedmiotyList();
        DefaultTableModel model=(DefaultTableModel)jTable_przedmioty.getModel();
        //czyscimy tabele - potrzebne, gdyz jak dodajemy rekord to zeby nam sie nie nadpisywaly poprzednie rekordy
        model.setRowCount(0);
        //tablica obiektow - kolumna
        Object[] row=new Object[1];
        //petla po liscie
        for(int i=0; i<list.size(); i++)
        {
            row[0]=list.get(i).getPrzedmiot();
            
            model.addRow(row);
        }
    }
    //grupy-----------------------------------------------------------------------------------------------------------------
    public ArrayList<Grupy> getGrupyList()
    {
        ArrayList<Grupy> grupyList=new ArrayList<Grupy>();
        Connection conn=getConnection();
        try {        
            Statement st;
            ResultSet rs;
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM Grupy");
            while(rs.next())
            {   //tworze instancje
                Grupy gr=new Grupy(rs.getString("grupa"));
                grupyList.add(gr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grupyList;
    }
    public void pokaz_grupy_w_tabeli()
    {
        ArrayList<Grupy> list= getGrupyList();
        DefaultTableModel model=(DefaultTableModel)jTable_grupy.getModel();
        model.setRowCount(0);
        Object[] row=new Object[1];
        for(int i=0; i<list.size(); i++)
        {
            row[0]=list.get(i).getGrupa();
            model.addRow(row);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    //Studenci
    public boolean spr_cyfry_sem()
    {
        String sem=jTextField_st_semestr.getText();
        if(sem.equals(""))
            return false;
        else if(sem.matches("[0-9]")) 
        {
            //zamieniam tekst na liczbe całkowita
            int semestr=Integer.parseInt(jTextField_st_semestr.getText());
            if(semestr>0 && semestr<9)
                return true;
            return false; 
        }else
            return false;
    }
    public void dane_combobox()
    {
        Connection conn=getConnection();
        Statement st1, st2, st3;
        ResultSet rs1, rs2, rs3;        
        try {
            st1=conn.createStatement();
            rs1=st1.executeQuery("SELECT Przedmiot FROM Przedmioty");
            st2=conn.createStatement();
            rs2=st2.executeQuery("SELECT Grupa FROM Grupy");            
            st3=conn.createStatement();
            rs3=st3.executeQuery("SELECT Przedmiot FROM Przedmioty");
            
            //czyszcze itemy
            jComboBox_st_przedmiot.removeAllItems();
            jComboBox_st_grupa.removeAllItems();
            jComboBox_pr_przedmiot.removeAllItems();
            while(rs1.next())
            {
                jComboBox_st_przedmiot.addItem(rs1.getString(1));
            }
            while(rs2.next())
            {
                jComboBox_st_grupa.addItem(rs2.getString(1));
            }
            while(rs3.next())
            {
                jComboBox_pr_przedmiot.addItem(rs3.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Studenci> getStudenciList()
    {
        ArrayList<Studenci> studenciList=new ArrayList<Studenci>();
        Connection conn=getConnection();
        try {        
            Statement st;
            ResultSet rs;
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM Studenci");
            while(rs.next())
            {   //tworze instancje
                Studenci stud=new Studenci(rs.getString("nazwisko"), rs.getString("imie"), rs.getString("kierunek"), 
                        Integer.parseInt(rs.getString("semestr")), rs.getString("przedmiot"), rs.getString("grupa"));
                studenciList.add(stud);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studenciList;
    }
    public void pokaz_studentow_w_tabeli()
    {
        ArrayList<Studenci> list= getStudenciList();
        DefaultTableModel model=(DefaultTableModel)jTable_studenci.getModel();
        model.setRowCount(0);
        Object[] row=new Object[6];
        for(int i=0; i<list.size(); i++)
        {
            row[0]=list.get(i).getNazwisko();
            row[1]=list.get(i).getImie();
            row[2]=list.get(i).getKierunek();
            row[3]=list.get(i).getSemestr();
            row[4]=list.get(i).getPrzedmiot();
            row[5]=list.get(i).getGrupa();
            model.addRow(row);
        }
    }
    //pracownicy
    public boolean spr_num_tel()
    {
        String numer=jTextField_pr_telefon.getText();
        if(numer.equals(""))
            return false;
        else if(numer.matches("[0-9]{9}")) //9 cyfr
            return true;
        else
            return false;
    }
    public ArrayList<Pracownicy> getPracownicyList()
    {
        ArrayList<Pracownicy> pracownicyList=new ArrayList<Pracownicy>();
        Connection conn=getConnection();
        try {        
            Statement st;
            ResultSet rs;
            st=conn.createStatement();
            rs=st.executeQuery("SELECT * FROM Pracownicy");
            while(rs.next())
            {   //tworze instancje
                Pracownicy pracow=new Pracownicy(rs.getString("ID"), rs.getString("nazwisko"), rs.getString("imie"), rs.getString("telefon"), 
                        rs.getString("ulica"), rs.getString("miejscowosc"), rs.getString("przedmiot"));
                pracownicyList.add(pracow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pracownicyList;
    }
    public void pokaz_pracownikow_w_tabeli()
    {
        ArrayList<Pracownicy> list= getPracownicyList();
        DefaultTableModel model=(DefaultTableModel)jTable_pracownicy.getModel();
        model.setRowCount(0);
        Object[] row=new Object[7];
        for(int i=0; i<list.size(); i++)
        {
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getNazwisko();
            row[2]=list.get(i).getImie();
            row[3]=list.get(i).getTelefon();
            row[4]=list.get(i).getUlica();
            row[5]=list.get(i).getMiejscowosc();
            row[6]=list.get(i).getPrzedmiot();
            model.addRow(row);
        }
    }
    //czyszczenie wszystkich pól tekstowych - wywołane pod przyciskiem odśwież
    public void czyszczenie_wszystkich_pol()
    {
        jTextField_prz_przedmiot.setText("");
        jTextField_gr_grupa.setText("");
        jTextField_st_nazwisko.setText("");
        jTextField_st_imie.setText("");
        jTextField_st_kierunek.setText("");
        jTextField_st_semestr.setText("");
        jTextField_pr_id.setText("");
        jTextField_pr_nazwisko.setText("");
        jTextField_pr_imie.setText("");
        jTextField_pr_telefon.setText("");
        jTextField_pr_ulica.setText("");
        jTextField_pr_miejscowosc.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(
	    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gr_usun;
    private javax.swing.JButton jButton_gr_zapisz;
    private javax.swing.JButton jButton_odswiez;
    private javax.swing.JButton jButton_polacz;
    private javax.swing.JButton jButton_pracow_usun;
    private javax.swing.JButton jButton_pracow_zapisz;
    private javax.swing.JButton jButton_prz_usun;
    private javax.swing.JButton jButton_prz_zapisz;
    private javax.swing.JButton jButton_st_usun1;
    private javax.swing.JButton jButton_st_zapisz1;
    public javax.swing.JComboBox<String> jComboBox_pr_przedmiot;
    public javax.swing.JComboBox<String> jComboBox_st_grupa;
    public static javax.swing.JComboBox<String> jComboBox_st_przedmiot;
    private javax.swing.JLabel jLabel_Pracownicy;
    private javax.swing.JLabel jLabel_gr_grupa;
    private javax.swing.JLabel jLabel_grupy;
    private javax.swing.JLabel jLabel_pr_id;
    private javax.swing.JLabel jLabel_pr_imie;
    private javax.swing.JLabel jLabel_pr_nazwisko;
    private javax.swing.JLabel jLabel_pr_przedmiot;
    private javax.swing.JLabel jLabel_pr_telefon;
    private javax.swing.JLabel jLabel_prz_przedmiot;
    private javax.swing.JLabel jLabel_przedmioty;
    private javax.swing.JLabel jLabel_st_grupa1;
    private javax.swing.JLabel jLabel_st_imie1;
    private javax.swing.JLabel jLabel_st_kierunek1;
    private javax.swing.JLabel jLabel_st_nazwisko1;
    private javax.swing.JLabel jLabel_st_przedmiot;
    private javax.swing.JLabel jLabel_st_przedmiot1;
    private javax.swing.JLabel jLabel_st_semestr;
    private javax.swing.JLabel jLabel_st_semestr1;
    private javax.swing.JLabel jLabel_studenci1;
    public javax.swing.JPanel jPanel_grupy;
    private javax.swing.JPanel jPanel_pracownicy;
    private javax.swing.JPanel jPanel_przedmioty;
    public javax.swing.JPanel jPanel_studenci;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jTable_grupy;
    private javax.swing.JTable jTable_pracownicy;
    public javax.swing.JTable jTable_przedmioty;
    public javax.swing.JTable jTable_studenci;
    public javax.swing.JTextField jTextField_gr_grupa;
    private javax.swing.JTextField jTextField_pr_id;
    private javax.swing.JTextField jTextField_pr_imie;
    private javax.swing.JTextField jTextField_pr_miejscowosc;
    private javax.swing.JTextField jTextField_pr_nazwisko;
    private javax.swing.JTextField jTextField_pr_telefon;
    private javax.swing.JTextField jTextField_pr_ulica;
    public javax.swing.JTextField jTextField_prz_przedmiot;
    private javax.swing.JTextField jTextField_st_imie;
    private javax.swing.JTextField jTextField_st_kierunek;
    private javax.swing.JTextField jTextField_st_nazwisko;
    public javax.swing.JTextField jTextField_st_semestr;
    // End of variables declaration//GEN-END:variables
}
