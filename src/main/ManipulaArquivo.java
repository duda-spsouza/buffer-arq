package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ManipulaArquivo {
	
	@SuppressWarnings("unchecked")
	public static void leitor(String path) throws IOException {
		
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
          
        try (FileReader reader = new FileReader(path))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
  
            JSONArray contasList = (JSONArray) obj;
            System.out.println(contasList);
              
            //Iterate over  array
            contasList.forEach( contas -> parseData( (JSONObject) contas ) );
  
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }
		
		
	}
	
	private static Object parseData(JSONObject contas) {
        JSONObject dataObject = (JSONObject) contas;
          
         
        String agencia = (String) dataObject.get("agencia");   
        //System.out.println("Agencia =>"+agencia);
          
      
        String conta = (String) dataObject.get("conta"); 
        //System.out.println("Conta=>"+conta);
          
         
        String tipo = (String) dataObject.get("tipo");   
        //System.out.println("Tipo=>"+tipo);
        
        Double saldo = (Double) dataObject.get("saldo");   
       // System.out.println("Saldo=>"+saldo);
		return montaretorno(agencia,conta, tipo , saldo);
	
	}
	
	private static Object montaretorno(String agencia, String conta, String tipo , Double saldo) {
		 
		 String arroba = "@";
		 String jogo_velha = "#";
		 
		 String montaString =jogo_velha+agencia+arroba+conta.replace("-", "")+arroba+tipo+arroba+saldo+arroba;
		 
		 int totalString  = montaString.length();
		 
		 System.out.println(String.format("%03d", totalString)+montaString);
		 
		return String.format("%03d", totalString)+jogo_velha+montaString;
		 
	 }
	
	
}
