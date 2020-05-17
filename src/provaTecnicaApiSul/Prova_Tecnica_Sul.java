package provaTecnicaApiSul;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Prova_Tecnica_Sul {
    public static void main(String[] args) throws FileNotFoundException{
        
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = (JsonArray) parser.parse(new FileReader("input.json"));

        Gson gson = new Gson(); 

        Resposta[] respostaArray = gson.fromJson(jsonArray, Resposta[].class);
        List<Resposta> respostaLista = Arrays.asList(respostaArray);
        
        ManipuladoraDeRespostas manipulador = new ManipuladoraDeRespostas(respostaLista);
         
        System.out.println("A - Qual é o andar menos utilizado pelos usuários?");
        System.out.println(manipulador.andarMenosUtilizado().get(0));
        
        System.out.println(" ");
        
        System.out.println("B - Qual é o elevador mais utilizado pelos usuários e o período que se encontra maior fluxo?");
        System.out.println("Mais utilizado: " + manipulador.elevadorMaisFrequentado().get(4) + "\nMaior fluxo:  " + manipulador.periodoMaiorFluxoElevadorMaisFrequentado().get(2));
        
        System.out.println(" ");
        
        System.out.println("c - Qual é o elevador menos frequentado e o período que se encontra menor fluxo?");
        System.out.println("Menos utilizado: " + manipulador.elevadorMenosFrequentado().get(0) + " e " + manipulador.elevadorMenosFrequentado().get(1) + "\nMenor Fluxo:  " + manipulador.periodoMenorFluxoElevadorMenosFrequentado().get(0));
        
        System.out.println(" ");
        
        System.out.println("D - Qual é o período de maior utilização do conjunto de elevadores?");
        System.out.println(manipulador.periodoMaiorUtilizacaoConjuntoElevadores().get(2));
        
        System.out.println(" ");
        
        System.out.println("E - Qual é o percentual de uso de cada elevador com relação a todos os serviços prestados?");
        System.out.printf("Elevador A: " + "%.2f%%\n", manipulador.percentualDeUsoElevadorA());
        System.out.printf("Elevador B: " + "%.2f%%\n", manipulador.percentualDeUsoElevadorB());  
        System.out.printf("Elevador C: " + "%.2f%%\n", manipulador.percentualDeUsoElevadorC());  
        System.out.printf("Elevador D: " + "%.2f%%\n", manipulador.percentualDeUsoElevadorD());
        System.out.printf("Elevador E: " + "%.2f%%\n", manipulador.percentualDeUsoElevadorE()); 
    

        
        
        
    }
}
