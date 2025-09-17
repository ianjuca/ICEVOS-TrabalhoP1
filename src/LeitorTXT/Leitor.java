package LeitorTXT;
import Componentes.Processo;
import Estruturas.ListaDeProcessos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
    ListaDeProcessos<Processo> processos = new ListaDeProcessos<>();
    int i = 0;
    public ListaDeProcessos<Processo> carregarProcessos(String caminhoArquivo){
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
            String linha;
            while ((linha = br.readLine()) != null){

                if (linha.isBlank()) continue;

                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0].trim());
                String nome = partes[1].trim();
                int prioridade = Integer.parseInt(partes[2].trim());
                int ciclos = Integer.parseInt(partes[3].trim());
                String recurso = partes.length > 4 ? partes[4].trim() : "Null";
                processos.add(new Processo(id,nome,prioridade,ciclos,recurso), i);
                i++;
            }

        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo " + e.getMessage());
        }

        return processos;
    }
}
