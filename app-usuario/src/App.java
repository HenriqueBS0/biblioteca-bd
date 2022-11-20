import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.dbgenerator.Construtor;

public class App {
    public static void main(String[] args) throws Exception {
        Construtor construtor = new Construtor(getStringJson());
        // construtor.executar();
        System.out.println(construtor.getSql());
        // System.out.println(getStringJson());
    }

    private static String getStringJson() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("data-base-config.json"));
		String linha    = ""; 
        String conteudo = "";

        while (true) {
			linha = buffRead.readLine();

            if(linha == null) {
                break;
            }

            conteudo += linha;
		}

        buffRead.close();
        
        return conteudo;
    }
}
