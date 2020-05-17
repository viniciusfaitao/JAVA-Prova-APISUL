package provaTecnicaApiSul;

import java.util.List;

public interface IElevadorService {
    
	/** Deve retornar uma List contendo o(s) andar(es) menos utilizado(s).
     * @return  */
	List<Integer> andarMenosUtilizado();
	
	/** Deve retornar uma List contendo o(s) elevador(es) mais frequentado(s).
     * @return  */
	List<Character> elevadorMaisFrequentado();
	
	/** Deve retornar uma List contendo o período de maior fluxo de cada um dos elevadores mais frequentados (se houver mais de um).
     * @return  */
	List<Character> periodoMaiorFluxoElevadorMaisFrequentado();
	
	/** Deve retornar uma List contendo o(s) elevador(es) menos frequentado(s).
     * @return  */
	List<Character> elevadorMenosFrequentado();
	
	/** Deve retornar uma List contendo o período de menor fluxo de cada um dos elevadores menos frequentados (se houver mais de um).
     * @return  */
	List<Character> periodoMenorFluxoElevadorMenosFrequentado();
	
	/** Deve retornar uma List contendo o(s) periodo(s) de maior utilização do conjunto de elevadores.
     * @return  */
	List<Character> periodoMaiorUtilizacaoConjuntoElevadores();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador A em relação a todos os serviços prestados.
     * @return  */
	float percentualDeUsoElevadorA();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador B em relação a todos os serviços prestados.
     * @return  */
	float percentualDeUsoElevadorB();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador C em relação a todos os serviços prestados.
     * @return  */
	float percentualDeUsoElevadorC();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador D em relação a todos os serviços prestados.
     * @return  */
	float percentualDeUsoElevadorD();
	
	/** Deve retornar um float (duas casas decimais) contendo o percentual de uso do elevador E em relação a todos os serviços prestados.
     * @return  */
	float percentualDeUsoElevadorE();
}