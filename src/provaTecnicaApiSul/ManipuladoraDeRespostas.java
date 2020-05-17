package provaTecnicaApiSul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ManipuladoraDeRespostas implements IElevadorService {
    
    private final List<Resposta> respostas;

    public ManipuladoraDeRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
    
    
	/** Deve retornar uma List contendo o(s) andar(es) menos utilizado(s). */
     @Override
    public List<Integer> andarMenosUtilizado(){
        Map<Integer, Integer> andaresUtilizados = new HashMap<>();
        inicializarMapaDeAndares(andaresUtilizados);
        contarAndares(andaresUtilizados);
        Map<Integer, Integer> andaresMenosUtilizados = ordernarPorAndarMenosUtilizado(andaresUtilizados);
        final ArrayList<Integer> listaDeAndaresMenosUtilizados = new ArrayList<>(andaresMenosUtilizados.keySet());

        return listaDeAndaresMenosUtilizados;
    }

    private void inicializarMapaDeAndares(Map<Integer, Integer> andaresUtilizados) {
        for (int i = 0; i <= 15; i++) {
            andaresUtilizados.put(i, 0);
        }
    }

    private void contarAndares(Map<Integer, Integer> andaresUtilizados) {
        for(Resposta res: respostas){
            int andar = res.getAndar();
            
            int contadorAndar = andaresUtilizados.get(andar);
            andaresUtilizados.replace(andar, ++contadorAndar);
            
        }
    }

    private Map<Integer, Integer> ordernarPorAndarMenosUtilizado(Map<Integer, Integer> andaresUtilizados) {
        List<Entry<Integer, Integer>> list = new ArrayList<>(andaresUtilizados.entrySet());
        list.sort(Entry.comparingByValue());
        Map<Integer, Integer> andaresMenosUtilizados = new LinkedHashMap<>();
        for (Entry<Integer, Integer> entry : list) {
            andaresMenosUtilizados.put(entry.getKey(), entry.getValue());
        }
        return andaresMenosUtilizados;
    }

    
	/** Deve retornar uma List contendo o(s) elevador(es) mais frequentado(s). */
     @Override
    public List<Character> elevadorMaisFrequentado(){
        Map<Character, Integer> elevadoresUtilizados = new HashMap<>();
        inicializarMapaDeElevadores(elevadoresUtilizados);
        contarElevadores(elevadoresUtilizados);
        Map<Character, Integer> elevadoresMaisUtilizados = ordernarPorElevadorFrequentado(elevadoresUtilizados);
        final ArrayList<Character> listaDeElevadoresMaisUtilizados = new ArrayList<>(elevadoresMaisUtilizados.keySet());
        
        return listaDeElevadoresMaisUtilizados;
    }
    
    private void inicializarMapaDeElevadores(Map<Character, Integer> elevadoresUtilizados) {
                elevadoresUtilizados.put('A', 0);
                elevadoresUtilizados.put('B', 0);
                elevadoresUtilizados.put('C', 0);
                elevadoresUtilizados.put('D', 0);
                elevadoresUtilizados.put('E', 0);
    }
    
    private void inicializarMapaDeElevadoresFloat(Map<Character, Float> elevadoresUtilizados) {
                elevadoresUtilizados.put('A', 0f);
                elevadoresUtilizados.put('B', 0f);
                elevadoresUtilizados.put('C', 0f);
                elevadoresUtilizados.put('D', 0f);
                elevadoresUtilizados.put('E', 0f);
    }
    
    private void contarElevadores(Map<Character, Integer> elevadoresUtilizados) {
        for(Resposta res: respostas){
            Character elevador = res.getElevador();
            
            Integer contadorElevador = elevadoresUtilizados.get(elevador);
            elevadoresUtilizados.replace(elevador, ++contadorElevador);
            
        }
    }
    
    private Map<Character, Integer> ordernarPorElevadorFrequentado(Map<Character, Integer> elevadoresUtilizados) {
        List<Entry<Character, Integer>> list = new ArrayList<>(elevadoresUtilizados.entrySet());
        list.sort(Entry.comparingByValue());
        Map<Character, Integer> elevadoresMaisUtilizados = new LinkedHashMap<>();
        for (Entry<Character, Integer> entry : list) {
            elevadoresMaisUtilizados.put(entry.getKey(), entry.getValue());
        }
        return elevadoresMaisUtilizados;
    }
    
    
	/** Deve retornar uma List contendo o período de maior fluxo de cada um dos elevadores mais frequentados (se houver mais de um). */
     @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado(){
        Map<Character, Integer> maiorFluxo = new HashMap<>();
        inicializarMapaDeFluxo(maiorFluxo);
        contarFluxo(maiorFluxo);
        Map<Character, Integer> periodoDeMaiorFluxo = ordernarFluxo(maiorFluxo);
        final ArrayList<Character> listaDePeriodoDeMaiorFluxo = new ArrayList<>(periodoDeMaiorFluxo.keySet());
        
        return listaDePeriodoDeMaiorFluxo;
    }
	
    private void inicializarMapaDeFluxo(Map<Character, Integer> maiorFluxo) {
                maiorFluxo.put('M', 0);
                maiorFluxo.put('N', 0);
                maiorFluxo.put('V', 0);
    }
    
    private void contarFluxo(Map<Character, Integer> maiorFluxo) {
        for(Resposta res: respostas){
            Character turno = res.getTurno();
            
            Integer contadorMaiorFluxo = maiorFluxo.get(turno);
            maiorFluxo.replace(turno, ++contadorMaiorFluxo);
        }
    }
    
    private Map<Character, Integer> ordernarFluxo(Map<Character, Integer> maiorFluxo) {
        List<Entry<Character, Integer>> list = new ArrayList<>(maiorFluxo.entrySet());
        list.sort(Entry.comparingByValue());
        Map<Character, Integer> periodoDeMaiorFluxo = new LinkedHashMap<>();
        for (Entry<Character, Integer> entry : list) {
            periodoDeMaiorFluxo.put(entry.getKey(), entry.getValue());
        }
        return periodoDeMaiorFluxo;
    }

    
	/** Deve retornar uma List contendo o(s) elevador(es) menos frequentado(s). */
     @Override
    public List<Character> elevadorMenosFrequentado(){
        Map<Character, Integer> elevadoresNãoUtilizados = new HashMap<>();
        inicializarMapaDeElevadores(elevadoresNãoUtilizados);
        contarElevadores(elevadoresNãoUtilizados);
        Map<Character, Integer> elevadoresMenosUtilizados = ordernarPorElevadorFrequentado(elevadoresNãoUtilizados);
        final ArrayList<Character> listaDeElevadoresMenosUtilizados = new ArrayList<>(elevadoresMenosUtilizados.keySet());
        
        return listaDeElevadoresMenosUtilizados;
    }
    
    
	/** Deve retornar uma List contendo o período de menor fluxo de cada um dos elevadores menos frequentados (se houver mais de um). */
     @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado(){
        Map<Character, Integer> menorFluxo = new HashMap<>();
        inicializarMapaDeFluxo(menorFluxo);
        contarFluxo(menorFluxo);
        Map<Character, Integer> periodoDeMenorFluxo = ordernarFluxo(menorFluxo);
        final ArrayList<Character> listaDePeriodoDeMenorFluxo = new ArrayList<>(periodoDeMenorFluxo.keySet());
        
        return listaDePeriodoDeMenorFluxo;
    }
    
    
	/** Deve retornar uma List contendo o(s) periodo(s) de maior utilização do conjunto de elevadores. */
     @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores(){
        Map<Character, Integer> usoConjunto = new HashMap<>();
        inicializarMapaDeFluxo(usoConjunto);
        contarFluxo(usoConjunto);
        Map<Character, Integer> periodoDeConjunto = ordernarFluxo(usoConjunto);
        final ArrayList<Character> listaDeConjunto = new ArrayList<>(periodoDeConjunto.keySet());
        
        return listaDeConjunto;
    }
    
    
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador A em relação a todos os serviços prestados. */
     @Override
    public float percentualDeUsoElevadorA(){
        Map<Character, Float> usoDeElevadores = new HashMap<>();
        inicializarMapaDeElevadoresFloat(usoDeElevadores);
        contarUsoElevadores(usoDeElevadores);
        Integer quantidadeTotalDeUsos = respostas.size();
        float percentualDeUsoElevadorA = (usoDeElevadores.get('A') / quantidadeTotalDeUsos) * 100;

        return percentualDeUsoElevadorA;
    }
    
    private void contarUsoElevadores(Map<Character, Float> usoDeElevadores) {
        for(Resposta res: respostas){
            Character elevador = res.getElevador();
            
            Float contadorDeUso = usoDeElevadores.get(elevador);
            usoDeElevadores.replace(elevador, ++contadorDeUso);
        }
    }
    
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador B em relação a todos os serviços prestados. */
     @Override
    public float percentualDeUsoElevadorB(){
        Map<Character, Float> usoDeElevadores = new HashMap<>();
        inicializarMapaDeElevadoresFloat(usoDeElevadores);
        contarUsoElevadores(usoDeElevadores);
        Integer quantidadeTotalDeUsos = respostas.size();
        float percentualDeUsoElevadorB = (usoDeElevadores.get('B') / quantidadeTotalDeUsos) * 100;

        return percentualDeUsoElevadorB;
    }
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador C em relação a todos os serviços prestados. */
     @Override
    public float percentualDeUsoElevadorC(){
        Map<Character, Float> usoDeElevadores = new HashMap<>();
        inicializarMapaDeElevadoresFloat(usoDeElevadores);
        contarUsoElevadores(usoDeElevadores);
        Integer quantidadeTotalDeUsos = respostas.size();
        float percentualDeUsoElevadorC = (usoDeElevadores.get('C') / quantidadeTotalDeUsos) * 100;

        return percentualDeUsoElevadorC;
    }
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador D em relação a todos os serviços prestados. */
     @Override
    public float percentualDeUsoElevadorD(){
        Map<Character, Float> usoDeElevadores = new HashMap<>();
        inicializarMapaDeElevadoresFloat(usoDeElevadores);
        contarUsoElevadores(usoDeElevadores);
        Integer quantidadeTotalDeUsos = respostas.size();
        float percentualDeUsoElevadorD = (usoDeElevadores.get('D') / quantidadeTotalDeUsos) * 100;

        return percentualDeUsoElevadorD;
    }
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador E em relação a todos os serviços prestados.*/
     @Override
    public float percentualDeUsoElevadorE(){
        Map<Character, Float> usoDeElevadores = new HashMap<>();
        inicializarMapaDeElevadoresFloat(usoDeElevadores);
        contarUsoElevadores(usoDeElevadores);
        Integer quantidadeTotalDeUsos = respostas.size();
        float percentualDeUsoElevadorE = (usoDeElevadores.get('E') / quantidadeTotalDeUsos) * 100;

        return percentualDeUsoElevadorE;
    }
}
