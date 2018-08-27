import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Slownik 
{


	private static BufferedReader reader;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException 
	{

		try {
			reader = new BufferedReader(new FileReader("slownik.txt"));
			System.out.println("Napisz t³umaczenie:");
	
			for(String line; (line=reader.readLine())!=null;)
			{	
				String line_lower=line.toLowerCase();
				
				int zwr_ind_sr=line_lower.indexOf(";");
				int zwr_koncowy_ind=line_lower.length();
				
				
				String uc_linia_do_sr=line_lower.substring(0, zwr_ind_sr+1).toLowerCase();
				String uc_linia_po_sr=line_lower.substring(zwr_ind_sr+1, zwr_koncowy_ind).toLowerCase();
				
				
				System.out.print(uc_linia_do_sr);
				
				String odp_uz=scanner.nextLine().toLowerCase();
				
				int i=2;
				while(i!=0)
				{
					if(!uc_linia_po_sr.equals(odp_uz))
					{
						System.out.println("B³êdne t³umaczenie. Masz jeszcze "+i+" szanse");
						System.out.print(uc_linia_do_sr);
						odp_uz=scanner.nextLine().toLowerCase();
						i--;
					}
					else
					{
						
						i=0;
					}
				}
				System.out.println("Odpowied¿: "+line_lower);
				
				
			}
			reader.close();
			
//			while(!znaki.equals(";"))
//			{	
//				for(int i=0;i<znaki.length;i++)
//				{
//					System.out.print(znaki[i]);
//					
//				}
//			}	
			

//			Scanner skaner=new Scanner(System.in);
//			
//			
//			while(character!=';')
//			{
//				
//				System.out.print((char)character);
//				String p=skaner.nextLine();
//				
//				
//				character=reader.read();
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		
//		Scanner scanner = new Scanner(new FileReader("slownik.txt"));
//		scanner.useDelimiter(";");
//        String str;
//        while (scanner.hasNext())
//        {
//            // No need to convert to char array before printing
//            System.out.println(scanner.next());
//        }
//	


	}
}
