import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class Buttony extends Pracownicy 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int k=0;
	
	public Buttony() 
	{
		super();
		
		JFileChooser save=new JFileChooser();
		
		zapisz_do_pliku.addActionListener(new ActionListener() {
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
							k++;
							w.println(k+". "+t_imie.getText().trim()+" "+t_nazwisko.getText().trim()+", "+t_adres.getText().trim()+" tel:"+t_tel.getText().trim()+"\r");
							w.close();
							czyszczenie_pol();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "B³¹d");
						}
			    	}
			    	else
			    	{
						try {
							PrintWriter w=new PrintWriter(new FileWriter(save.getSelectedFile().getAbsolutePath()+".txt"));
							k++;
							w.write(k+". "+t_imie.getText().trim()+" "+t_nazwisko.getText().trim()+", "+t_adres.getText().trim()+" tel:"+t_tel.getText().trim()+"\r\n");
							w.close();
							
							czyszczenie_pol();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "B³¹d");
						}
			    	}
			    }	
			}
		});
		nadpisz_plik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File plik=new File(save.getSelectedFile()+".txt");
				if(!plik.exists())
				{
					zapisz_do_pliku.doClick();
				}
				else
				{
					try {
						PrintWriter w=new PrintWriter(new FileWriter(save.getSelectedFile().getAbsolutePath()+".txt", true));
						k++;
						w.println(k+". "+t_imie.getText().trim()+" "+t_nazwisko.getText().trim()+", "+t_adres.getText().trim()+" tel:"+t_tel.getText().trim()+"\r");
						w.close();
						czyszczenie_pol();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "B³¹d");
					}
					
				
				}
				
				
			}
		});
	}
	public static void main(String[] args) 
	{
		new Buttony();
	}
}
