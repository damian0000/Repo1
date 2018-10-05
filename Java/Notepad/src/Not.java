import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.undo.UndoManager;

public class Not extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	public Not() 
	{
		initWindow();
		
	}
	private JMenuBar pasek_menu=new JMenuBar();
	private void initWindow()
	{
		this.setTitle("Notatnik");
		//wyswietlanie ramki na srodku
		int szer=Toolkit.getDefaultToolkit().getScreenSize().width;
		int wys=Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(szer/4, wys/2);
		int szerRamki=this.getSize().width;
		int wysRamki=this.getSize().height;
		setLocation((szer-szerRamki)/2, (wys-wysRamki)/2);
		
		actionMenu();
		textArrea();
		
		this.setJMenuBar(pasek_menu);
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void actionMenu()
	{
		JMenu menu_plik=pasek_menu.add(new JMenu("Plik"));
		//dodajemy menu rozwijane
		JMenuItem pod_menu_nowy= menu_plik.add(new JMenuItem("Nowy"));
		JMenuItem pod_menu_otworz= menu_plik.add(new JMenuItem("Otwórz"));
		menu_plik.addSeparator();
		JMenuItem pod__menu_zapisz= menu_plik.add(new JMenuItem("Zapisz"));
		JMenuItem pod__menu_zapisz_jako= menu_plik.add(new JMenuItem("Zapisz jako..."));	
		JMenu menu_edycja=pasek_menu.add(new JMenu("Edycja"));
		JMenuItem pod_edycja_cofnij= menu_edycja.add(new JMenuItem("Cofnij"));
		menu_edycja.addSeparator();
		JMenuItem pod_edycja_wytnij= menu_edycja.add(new JMenuItem("Wytnij"));
		JMenuItem pod_edycja_kopiuj= menu_edycja.add(new JMenuItem("Kopiuj"));
		JMenuItem pod_edycja_wklej= menu_edycja.add(new JMenuItem("Wklej"));
		JMenu menu_pomoc=pasek_menu.add(new JMenu("Pomoc"));
		menu_pomoc.add(new JMenuItem("FAQ"));
		
		pod_menu_nowy.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		pod_menu_nowy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new Not();
			}
		});
		pod_menu_otworz.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		pod_menu_otworz.addActionListener(new ActionListener() {
			private Scanner scanner;

			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				fc.setFileFilter(new Filtr_rozszerzen("pola tekstowe"));
				int status=fc.showOpenDialog(new JFrame());
	            File plik;            
	            if(status==JFileChooser.APPROVE_OPTION)
	            {
	                plik=fc.getSelectedFile();
	               
	            	try
	                {
	            		scanner = new Scanner(plik);
	            		String buffer="";
	            		while(scanner.hasNext())
	            		{
	            			buffer+=scanner.nextLine();
	            		}
	            		
	            		pole_tekstowe.setText(buffer);
	                }
	                catch (Exception ex)
	                {
	                    ex.printStackTrace();
	                }
	            }
	            
	        }      
		
			});
	
		JFileChooser save=new JFileChooser();
		pod__menu_zapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		pod__menu_zapisz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File plik=new File(save.getSelectedFile()+".txt");
				if(!plik.exists())
				{
					pod__menu_zapisz_jako.doClick();
				}
				else
				{
					try {
						BufferedWriter w=new BufferedWriter(new FileWriter(save.getSelectedFile().getAbsolutePath()+".txt"));
						w.append(pole_tekstowe.getText().trim());
						w.close();
					
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "B³¹d");
					}
				}
			}
		});
		pod__menu_zapisz_jako.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				save.setCurrentDirectory(new File(System.getProperty("user.dir")));
			    save.addChoosableFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						return "Pliki"; 
					}
					
					@Override
					public boolean accept(File f) {
						return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
					}
				});
				int retrival = save.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION)
			    {
			    	if(save.getSelectedFile().exists())
			    	{
			    		try {
							PrintWriter w=new PrintWriter(new FileWriter(save.getSelectedFile().getAbsoluteFile()+".txt", true));	
			
							w.println(pole_tekstowe.getText().trim()+" ");
							w.close();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "B³¹d");
						}
			    	}
			    	else
			    	{
						try {
							PrintWriter w=new PrintWriter(new FileWriter(save.getSelectedFile().getAbsolutePath()+".txt"));
							w.write(pole_tekstowe.getText().trim()+" ");
							w.close();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "B³¹d");
						}
			    	}
			    }	
			}
		});
		UndoManager editManager =new UndoManager();
		pole_tekstowe.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        editManager.addEdit(e.getEdit());
                    }
                });
		pod_edycja_cofnij.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
		pod_edycja_cofnij.addActionListener(new ActionListener() {           
			 public void actionPerformed(ActionEvent e) {	            	
	                if (editManager.canUndo()) {
	                    editManager.undo();
	                }
	            }
	        });
		 final Clipboard clip=Toolkit.getDefaultToolkit().getSystemClipboard();
		 pod_edycja_wytnij.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		pod_edycja_wytnij.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String wybor=pole_tekstowe.getSelectedText();
				StringSelection tekst=new StringSelection(wybor);
				clip.setContents(tekst, tekst);
				pole_tekstowe.replaceRange("", pole_tekstowe.getSelectionStart(), pole_tekstowe.getSelectionEnd());
			}
		});
		pod_edycja_kopiuj.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		pod_edycja_kopiuj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String wybor=pole_tekstowe.getSelectedText();
				StringSelection tekst=new StringSelection(wybor);
				clip.setContents(tekst, tekst);
				
			}
		});
		pod_edycja_wklej.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
		pod_edycja_wklej.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Transferable clipdata =clip.getContents(clip);
				try
				{
					if(clipdata.isDataFlavorSupported(DataFlavor.stringFlavor));
					String s=(String)(clipdata.getTransferData(DataFlavor.stringFlavor));
					pole_tekstowe.replaceSelection(s);
				}catch(Exception ex){}
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int opcja = JOptionPane.showConfirmDialog(rootPane, "czy chcesz zapisaæ zmiany?");
				if(opcja==JOptionPane.YES_OPTION)
					pod__menu_zapisz.doClick();
				else if(opcja==JOptionPane.NO_OPTION)
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					
				else if(opcja==JOptionPane.CANCEL_OPTION)
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
		});
		
	}
	private JPanel panel_tekstowy=new JPanel();
	private JTextArea pole_tekstowe =new JTextArea();
	private JScrollPane obszar_przes =new JScrollPane(pole_tekstowe);
	private void textArrea()
	{
		pole_tekstowe.setFont(new Font("Times new roman", Font.PLAIN, 14));
		panel_tekstowy.setLayout(new GridLayout(1, 1));
		panel_tekstowy.add(obszar_przes);;
		this.getContentPane().add(panel_tekstowy);
	}
	
	private class Filtr_rozszerzen extends FileFilter
	{
		public Filtr_rozszerzen(String op) 
		{
			this.opis=op;
		}
		@Override
		public boolean accept(File f) 
		{
			return f.getName().toLowerCase().endsWith(".txt") | f.isDirectory();
		}

		@Override
		public String getDescription() 
		{
			return opis;
		}
		private String opis;
	}

	public static void main(String[] args) {
		new Not();

	}

}