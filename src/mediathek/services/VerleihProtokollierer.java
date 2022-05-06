package mediathek.services;
import java.io.FileWriter;
import java.io.IOException;

import mediathek.materialien.Verleihkarte;

public class VerleihProtokollierer {
	
	public static final String _ausleihen = "Ausleihen";
	public static final String _zurueckgeben = "Zurueckgeben";
	
//	static
//	{
//		try
//		{
//			
//		}
//		catch(IOException e)
//		{
//			System.err.println(e);
//		}
//		
//	}
	
/**Protokolliert das Ausleihen bzw. Zurückgeben eines Mediums. Zeigt Fehler an, falls nicht protokolliert werden kann.
 * 	
 * @param ereignis
 * @param verleihkarte
 * @throws ProtokollierException 
 */
	public static void protokolliere (String ereignis, Verleihkarte verleihkarte) throws ProtokollierException
	{
		//System.out.println(ereignis);
		//System.out.println(verleihkarte.toString());
	
			try (FileWriter fileWriter = new FileWriter("./protokoll.txt", true))
			{
				fileWriter.write(ereignis + "\n" + verleihkarte.toString() + "\n");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				throw new ProtokollierException("Protokollieren fehlgeschlagen, weil Datei nicht zugreifbar");
			}
			finally
			{
				System.out.println("Protokolliervorgang beendet.");
			}
			
			
		
	}

	
	
	
}
