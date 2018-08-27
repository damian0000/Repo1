//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//
//
//public class Test {
//  
//    public Test() {
//      
//    }
//    
//    //  pol z baza-----------------------------------------------------------------------------------------------------
//    public  Connection getConnection()
//    {  //łączy z bazą danych
//        Connection conn = null;
//        try {
//            //rejestracja sterownika - jest pod klasami "sqljdbc41.jar"
//            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//            //link do połączenia. "SQLEXPRESS;databaseName=Dziekanat" nazwa instancji serwera i bazy
//            String dbURL = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS;databaseName=Dziekanat;integratedSecurity=true";
//            String user = "dbo";
//            String pass = "";            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection(dbURL, user, pass);
//            //JOptionPane.showMessageDialog(null, "Połączono");
//            return conn;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Błąd");
//            return null;
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Problem ze sterownikiem");
//            return null;
//        }
//    }
//        //przedmioty
//    public boolean z_alf(String zn) 
//    {
//        if(!zn.equals(""))
//            return true;
//        else if(zn.matches("[A-Za-z0-9]")) 
//            return true;
//        return false;
//    }
//    //umieszczenie danych w tabeli - wykorzystana w pokaz_przedmioty_w_tabeli()
//    public ArrayList<Przedmioty> getPrzedmiotyList()
//    {
//        ArrayList<Przedmioty> przedmiotyList=new ArrayList<Przedmioty>();
//        Connection conn=getConnection();
//        try {        
//            Statement st;
//            ResultSet rs;
//            st=conn.createStatement();
//            rs=st.executeQuery("SELECT * FROM Przedmioty");
//            //z klasy Przedmioty
//            Przedmioty prz;
//            //petla po przedmiotach
//            while(rs.next())
//            {   //tworze instancje
//                prz=new Przedmioty(rs.getString("przedmiot"));
//                przedmiotyList.add(prz);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return przedmiotyList;
//    }
//    // pokazuje produkty w tabeli - Funcja jest wykorzystana w przyciskach jButton_prz_zapisz
//    public void pokaz_przedmioty_w_tabeli()
//    {
//        ArrayList<Przedmioty> list= getPrzedmiotyList();
//        DefaultTableModel model=(DefaultTableModel)jTable_przedmioty.getModel();
//        //czyscimy tabele - potrzebne, gdyz jak dodajemy rekord to zeby nam sie nie nadpisywaly poprzednie rekordy
//        model.setRowCount(0);
//        //tablica obiektow - kolumna
//        Object[] row=new Object[1];
//        //petla po liscie
//        for(int i=0; i<list.size(); i++)
//        {
//            row[0]=list.get(i).getPrzedmiot();
//            
//            model.addRow(row);
//        }
//    }
//    //grupy-----------------------------------------------------------------------------------------------------------------
//    public ArrayList<Grupy> getGrupyList()
//    {
//        ArrayList<Grupy> grupyList=new ArrayList<Grupy>();
//        Connection conn=getConnection();
//        try {        
//            Statement st;
//            ResultSet rs;
//            st=conn.createStatement();
//            rs=st.executeQuery("SELECT * FROM Grupy");
//            while(rs.next())
//            {   //tworze instancje
//                Grupy gr=new Grupy(rs.getString("grupa"));
//                grupyList.add(gr);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return grupyList;
//    }
//    public  void pokaz_grupy_w_tabeli()
//    {
//        ArrayList<Grupy> list= getGrupyList();
//        DefaultTableModel model=(DefaultTableModel)jTable_grupy.getModel();
//        model.setRowCount(0);
//        Object[] row=new Object[1];
//        for(int i=0; i<list.size(); i++)
//        {
//            row[0]=list.get(i).getGrupa();
//            model.addRow(row);
//        }
//    }
//    //-----------------------------------------------------------------------------------------------------------------------
//    //Studenci
//    public boolean spr_cyfry_sem()
//    {
//        String sem=jTextField_st_semestr.getText();
//        if(sem.equals(""))
//            return false;
//        else if(sem.matches("[0-9]")) 
//        {
//            //zamieniam tekst na liczbe całkowita
//            int semestr=Integer.parseInt(jTextField_st_semestr.getText());
//            if(semestr>0 && semestr<9)
//                return true;
//            return false; 
//        }else
//            return false;
//    }
//    public void dane_combobox()
//    {
//        Connection conn=getConnection();
//        Statement st1, st2, st3;
//        ResultSet rs1, rs2, rs3;        
//        try {
//            st1=conn.createStatement();
//            rs1=st1.executeQuery("SELECT Przedmiot FROM Przedmioty");
//            st2=conn.createStatement();
//            rs2=st2.executeQuery("SELECT Grupa FROM Grupy");            
//            st3=conn.createStatement();
//            rs3=st3.executeQuery("SELECT Przedmiot FROM Przedmioty");
//            
//            //czyszcze itemy
//            jComboBox_st_przedmiot.removeAllItems();
//            jComboBox_st_grupa.removeAllItems();
//            jComboBox_pr_przedmiot.removeAllItems();
//            while(rs1.next())
//            {
//                jComboBox_st_przedmiot.addItem(rs1.getString(1));
//            }
//            while(rs2.next())
//            {
//                jComboBox_st_grupa.addItem(rs2.getString(1));
//            }
//            while(rs3.next())
//            {
//                jComboBox_pr_przedmiot.addItem(rs3.getString(1));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public ArrayList<Studenci> getStudenciList()
//    {
//        ArrayList<Studenci> studenciList=new ArrayList<Studenci>();
//        Connection conn=getConnection();
//        try {        
//            Statement st;
//            ResultSet rs;
//            st=conn.createStatement();
//            rs=st.executeQuery("SELECT * FROM Studenci");
//            while(rs.next())
//            {   //tworze instancje
//                Studenci stud=new Studenci(rs.getString("nazwisko"), rs.getString("imię"), rs.getString("kierunek"), 
//                        Integer.parseInt(rs.getString("semestr")), rs.getString("przedmiot"), rs.getString("grupa"));
//                studenciList.add(stud);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return studenciList;
//    }
//    public void pokaz_studentow_w_tabeli()
//    {
//        ArrayList<Studenci> list= getStudenciList();
//        DefaultTableModel model=(DefaultTableModel)jTable_studenci.getModel();
//        model.setRowCount(0);
//        Object[] row=new Object[6];
//        for(int i=0; i<list.size(); i++)
//        {
//            row[0]=list.get(i).getNazwisko();
//            row[1]=list.get(i).getImie();
//            row[2]=list.get(i).getKierunek();
//            row[3]=list.get(i).getSemestr();
//            row[4]=list.get(i).getPrzedmiot();
//            row[5]=list.get(i).getGrupa();
//            model.addRow(row);
//        }
//    }
//    
//    
//}
