
public class SecretarioQueOperaGestor {


    public static void main (String[] args) {


        Sindicalista a =  new Sindicalista("Alvaro", Area.LITIGIOS);
        Sindicalista b =  new Sindicalista("Bernardo", Area.GERAL); // sindicalista senior
        Sindicalista c =  new Sindicalista("Carlos", Area.LICENCAS);

        Sindicalista[] sindicalistasHoje = {a, b, c};

        GestorDeSolicitacoes solicitacoes = new GestorDeSolicitacoes(sindicalistasHoje);

        //chegam os pacientes
        solicitacoes.registaAssociado("P1");
        solicitacoes.registaTriagem("P1", Area.LITIGIOS, Tipo.PRESENCIAL);

        solicitacoes.registaAssociado("P2");
        solicitacoes.registaTriagem("P2", Area.APOIO_JURIDICO, Tipo.NAO_PRESENCIAL);
        solicitacoes.registaAssociado("P3");
        solicitacoes.registaTriagem("P3", Area.LICENCAS, Tipo.NAO_PRESENCIAL);
        solicitacoes.registaAssociado("P4");
        solicitacoes.registaTriagem("P4", Area.LICENCAS, Tipo.PRESENCIAL);
        solicitacoes.registaAssociado("P5");
        solicitacoes.registaTriagem("P5", Area.GERAL, Tipo.NAO_PRESENCIAL);
        solicitacoes.registaAssociado("P6");
        solicitacoes.registaTriagem("P6", Area.GERAL, Tipo.PRESENCIAL);

        System.out.println(solicitacoes.toString());

        System.out.println("########## Sindicalista com mais servico ############");

        imprime(solicitacoes.sindicalistasComMaisDoQueIAssociados(3));

        System.out.println("########## Apos algum tempo ############");

        atendeEImprime(solicitacoes, "Carlos");
        atendeEImprime(solicitacoes, "Bernardo");
        atendeEImprime(solicitacoes, "Alvaro");

        System.out.println("########## Aparecem mais solicitacoes de associados ############");
        
        solicitacoes.registaAssociado("P7");
        solicitacoes.registaTriagem("P7", Area.APOIO_JURIDICO, Tipo.NAO_PRESENCIAL);
        solicitacoes.registaAssociado("P8");
        solicitacoes.registaTriagem("P8", Area.GERAL, Tipo.PRESENCIAL);
        solicitacoes.registaAssociado("P9");
        solicitacoes.registaTriagem("P9", Area.LICENCAS, Tipo.PRESENCIAL);
        solicitacoes.registaAssociado("P10");
        solicitacoes.registaTriagem("P10", Area.GERAL, Tipo.NAO_PRESENCIAL);

        System.out.println(solicitacoes.toString());

        System.out.println(solicitacoes.associadoMaisTempoAEspera() + " eh o associado que mais espera");
    }

    /**
     * Imprime os valores de um vector de Strings
     * @param nomes - o vector a imprimir
     * @requires nomes != null
     */
    private static void imprime (String[] nomes) {
        for (String string : nomes) {
            System.out.println(string);
        }
    }
    private static void atendeEImprime(GestorDeSolicitacoes solicitacoes, String nome){
    	
    	if (solicitacoes.sindicalistaAindaTemAssociados(nome)){
    		int ordemAtendido = solicitacoes.proximoAssociado(nome);
    		System.out.println("O Colaborador " + nome + " ja atendeu o cliente n0. " + ordemAtendido);
    	} else System.out.println("O Colaborador " + nome +" nao tem clientes ah espera");
    }
}
