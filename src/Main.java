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
            else if (processos.get(i).getPrioridade() == 2) {
                lista_media_prioridade.add(processos.get(i), lista_media_prioridade.tamanho);
            }else {
                lista_baixa_prioridade.add(processos.get(i), lista_baixa_prioridade.tamanho);
            }
        }
        Scheduler scheduler = new Scheduler(lista_alta_prioridade , lista_media_prioridade , lista_baixa_prioridade);
        while (scheduler.lista_alta_prioridade.tamanho != 0 || scheduler.lista_media_prioridade.tamanho != 0 || scheduler.lista_baixa_prioridade.tamanho != 0){
            scheduler.executarCicloDeCpu();
        }
    }
}