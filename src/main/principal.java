package main;

import java.io.IOException;

public class principal {
	
@SuppressWarnings("static-access")
public static void main(String[] args) {
		
		String path = "contas.json";
		
		ManipulaArquivo manipulaArq = new ManipulaArquivo();     
		try {
			manipulaArq.leitor(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
