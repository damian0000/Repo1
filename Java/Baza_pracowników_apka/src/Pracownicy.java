import javax.swing.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class Pracownicy extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l_imie=new JLabel("Imiê");
	private JLabel l_nazwisko=new JLabel("Nazwisko");
	private JLabel l_adres=new JLabel("Adres [ul, nr m, miasto]");
	private JLabel l_telefon=new JLabel("Telefon");
	protected JTextField t_imie=new JTextField(8);
	protected JTextField t_nazwisko=new JTextField(11);
	protected JTextField t_adres=new JTextField(20);
	protected JTextField t_tel=new JTextField(11);
	protected JButton zapisz_do_pliku=new  JButton("Zapisz do pliku");
	protected JButton nadpisz_plik=new  JButton("Nadpisz plik");
	
	
	private JPanel panel_1=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel panel_2=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel panel_3=new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	public Pracownicy() 
	{
		init_components();
	}
	void init_components()
	{
		this.setTitle("Program do zapisu danych do pliku");
		this.setBounds(300,300,540,150);
		this.setResizable(false);
		
		l_imie.setPreferredSize(new Dimension(92, 10));
		l_nazwisko.setPreferredSize(new Dimension(123, 10));
		l_adres.setPreferredSize(new Dimension(225, 10));
		l_telefon.setPreferredSize(new Dimension(110, 10));
			
		this.panel_1.add(l_imie);
		this.panel_1.add(l_nazwisko);
		this.panel_1.add(l_adres);
		this.panel_1.add(l_telefon);
		this.panel_2.add(t_imie);
		this.panel_2.add(t_nazwisko);
		this.panel_2.add(t_adres);
		this.panel_2.add(t_tel);
		this.panel_3.add(nadpisz_plik);
		this.panel_3.add(zapisz_do_pliku);
	//------------------------------------------------------------------------------------------------------------------------------
		GroupLayout layout=new GroupLayout(getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup
			(
				layout.createSequentialGroup()				
				.addGroup
					(
						//komponenty beda ze soba rownolegle 
						layout.createParallelGroup().addComponent(panel_1).addComponent(panel_2).addComponent(panel_3)						
					)
			);
		//ustawaiamy grupe pionowa
		layout.setVerticalGroup
			(
				layout.createSequentialGroup()
				.addComponent(panel_1).addComponent(panel_2).addComponent(panel_3)
			);
	//----------------------------------------------------------------------------------------------------------------------------------------
		this.t_imie.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				key_typed_handler_imie_i_naz(e);
			}
			public void keyPressed(KeyEvent e)
			{
				zabezp_przed_kop_liczb(e);
			}
		});
		this.t_nazwisko.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				key_typed_handler_imie_i_naz(e);
			}
			public void keyPressed(KeyEvent e)
			{
				zabezp_przed_kop_liczb(e);
			}
		});
		
		this.t_tel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				key_typed_handler_tel(e);
			}
			public void keyPressed(KeyEvent e)
			{
				zabezp_przed_kop_tekstu(e);
			}
		});
		this.t_adres.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e)
			{
				key_typed_handler_adres(e);
			}
			public void keyPressed(KeyEvent e)
			{
				zabezp_przed_niewl_adresem(e);;
			}
		});
		
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void zabezp_przed_kop_tekstu(KeyEvent e)
	{
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_V)
        {
                //robimy schowek i pobieramy go
                Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
                //przyjmujemy tylko tekst, bez obrazkow itp
                DataFlavor flavor=DataFlavor.stringFlavor;
                //przypisujemy gdzies zawartosc schowka
                String schowek="";
            try {         
                //rzutujemy na stringa
                schowek=(String)clipboard.getData(flavor);
            } catch (UnsupportedFlavorException ex) {
                JOptionPane.showMessageDialog(null,"to nie jest liczba");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"blad ");
            }
            // sprawdzamy po  kolei znaki czy sa tam liczby
            for(int i=0; i<schowek.length();i++)
            {
                //jezeli nie jest liczba znak na pozycji "i"
                if(!jest_liczba(schowek.charAt(i)))
                {
                    e.consume();
                    break;
                }
            }      
        }
    }
	private void zabezp_przed_kop_liczb(KeyEvent e)
	{
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_V)
        {
                //robimy schowek i pobieramy go
                Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
                //przyjmujemy tylko tekst, bez obrazkow itp
                DataFlavor flavor=DataFlavor.stringFlavor;
                //przypisujemy gdzies zawartosc schowka
                String schowek="";
            try {         
                //rzutujemy na stringa
                schowek=(String)clipboard.getData(flavor);
            } catch (UnsupportedFlavorException ex) {
                JOptionPane.showMessageDialog(null,"to nie jest Tekst");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"blad ");
            }
            // sprawdzamy po  kolei znaki czy sa tam liczby
            for(int i=0; i<schowek.length();i++)
            {
                //jezeli nie jest liczba znak na pozycji "i"
                if(!jest_stringiem(schowek.charAt(i)))
                {
                    e.consume();
                    break;
                }
            }      
        }
    }
	private void zabezp_przed_niewl_adresem(KeyEvent e)
	{
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_V)
        {
                //robimy schowek i pobieramy go
                Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
                //przyjmujemy tylko tekst, bez obrazkow itp
                DataFlavor flavor=DataFlavor.stringFlavor;
                //przypisujemy gdzies zawartosc schowka
                String schowek="";
            try {         
                //rzutujemy na stringa
                schowek=(String)clipboard.getData(flavor);
            } catch (UnsupportedFlavorException ex) {
                JOptionPane.showMessageDialog(null,"to nie jest Tekst");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"blad ");
            }
            // sprawdzamy po  kolei znaki czy sa tam liczby
            for(int i=0; i<schowek.length();i++)
            {
                //jezeli nie jest liczba znak na pozycji "i"
                if(!spr_adresu(schowek.charAt(i)))
                {
                    e.consume();
                    break;
                }
            }      
        }
    }

	private void key_typed_handler_tel(KeyEvent e)
	{
		if(!jest_liczba(e.getKeyChar()))
				e.consume();
	}
	private void key_typed_handler_imie_i_naz(KeyEvent e)
	{
		if(!jest_stringiem(e.getKeyChar()))
				e.consume();	
	}
	private void key_typed_handler_adres(KeyEvent e)
	{
		if(!spr_adresu(e.getKeyChar()))
				e.consume();	
	}
	
	private boolean spr_adresu(char zn)
	{

		if((zn>='a' && zn<='z') || (zn>='A' && zn<='Z') || (zn>='¹' && zn<='¿') || (zn>='¥' && zn<='¯') || (zn>='0' && zn<='9') || zn=='/' || zn==' ' || zn=='-' || zn=='.')
			return true;
		return false;
	}
	private boolean jest_liczba(char zn)
	{
		if(zn>='0' && zn<='9')
			return true;		
		return false;
	}
	private boolean jest_stringiem(char zn) 
	{
		if((zn>='a' && zn<='z') || (zn>='A' && zn<='Z'))
			return true;
		return false;
	}
	protected void czyszczenie_pol()
	{
		t_imie.setText("");
		t_nazwisko.setText("");
		t_adres.setText("");
		t_tel.setText("");
		
	}
	

}
