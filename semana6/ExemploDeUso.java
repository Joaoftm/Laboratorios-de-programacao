
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploDeUso {

    public static void main(String[] args) throws FileNotFoundException {
        // Recebe os dados de input
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza o ficheiro com a lista de items a empacotar:");
        String fich = sc.nextLine();
        Scanner reader = new Scanner(new File(fich));
        System.out.println("Introduza o double com a capacidade dos pacotes:");
        double capacidade = Double.parseDouble(sc.nextLine());

        // Cria os pacotes
        List<Par<String, Double>> listaDeItems = leItems(reader);
        reader.close();

        GestorPacotes<String> gestor = new GestorPacotes<String>(capacidade);

        gestor.criaPacotes(listaDeItems);

        // Mostra a informacao dos pacotes
        System.out.println("Pacotes formados:");
        System.out.println(gestor.toString());


        // Pesquisa de pacotes por peso
        boolean acaba = false;
        while(!acaba) {
            System.out.println("Para procurar um pacote pela capacidade usada, " +
                    "introduza a capacidade, ou insira q para sair.");

            String lido = sc.nextLine();
            // Acaba a pesquisa
            if(lido.equals("q")) {
                acaba = true;
            } else  {
                // Procura pacotes pelo seu peso
                double target = Double.parseDouble(lido);

                int quantos = gestor.quantosPacoteComACapacidade(target);
                if(quantos == 0){
                    System.out.println("Nenhum pacote encontrado.");
                } else{
                    System.out.println("Existem " +  quantos + " com capacidade"
                            + " ocupada acima do indicado");
                }

            }
        }

        // Pesquisa de pacotes por item
        acaba = false;
        while(!acaba) {
            System.out.println("Para procurar os pacotes que contem um " +
                    "determinado tipo de item, introduza o nome do item,"
                    + " ou insira q para sair.");

            String lido = sc.nextLine();
            // Acaba a pesquisa
            if(lido.equals("q")){
                acaba = true;
            } else {
                // Procura pacotes por item
                List<Pacote<String>> result = gestor.pesquisaPacotes(lido);

                int numPacotes = result.size();
                if( numPacotes == 0 ){
                    System.out.println( "Nenhum pacote criado tem "+lido );
                } else {
                    System.out.println("-- Pacotes com " + lido + ": ");
                    for( Pacote<String> pacote : result ) {
                        System.out.println(pacote.toString());
                    }
                }
            }
        }

        System.out.println("Terminado.");
        sc.close();
    }

    /**
     * Para leitura dos items a dar ao constructor
     * @param reader o scanner usado para o efeito
     * @return Uma lista com os itens e respectivos tamanhos
     * @requires reader != null
     */
    private static List<Par<String, Double>> leItems (Scanner reader) {
        List<Par<String, Double>> listaDeItems = new ArrayList<Par<String, Double>>();

        String line;
        while( reader.hasNext() ) {
            line = reader.nextLine();
            Par<String, Double> item = parseItem( line );
            listaDeItems.add(item);
        }
        return listaDeItems;
    }

    /**
     * Criacao de um par a partir de dados
     * @param str a string com os eltos descritivos
     * @return um par com o formto adquado
     * @requires str != null
     */
    public static Par<String, Double> parseItem(String str){
        String[] dados = str.split(";");

        return new Par<String, Double>( dados[0], Double.parseDouble(dados[1]) );
    }

}
