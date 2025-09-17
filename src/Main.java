import Componentes.Processo;
import Componentes.Scheduler;
import Estruturas.ListaDeProcessos;
import LeitorTXT.Leitor;

public class Main {
    public static void main(String[] args){
        Leitor leitor = new Leitor();
        if (args.length < 1){
            System.out.println("Uso: java Main <arquivo_de_processos.txt>");
            System.exit(1);
        }
        ListaDeProcessos<Processo> lista_alta_prioridade = new ListaDeProcessos<Processo>();
        ListaDeProcessos<Processo> lista_media_prioridade = new ListaDeProcessos<Processo>();
        ListaDeProcessos<Processo> lista_baixa_prioridade = new ListaDeProcessos<Processo>();
        String caminho = "processos.txt";
        ListaDeProcessos<Processo> processos = leitor.carregarProcessos(caminho);
        for (int i = 0; i < processos.tamanho; i++){
            if (processos.get(i).getPrioridade() == 1){
                lista_alta_prioridade.add(processos.get(i), lista_alta_prioridade.tamanho);
            }
        }
    }
}