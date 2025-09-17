package Componentes;

import Estruturas.ListaDeProcessos;
import LeitorTXT.Leitor;

public class Scheduler {
    public ListaDeProcessos<Processo> lista_alta_prioridade;
    public ListaDeProcessos<Processo> lista_media_prioridade;
    public ListaDeProcessos<Processo> lista_baixa_prioridade;
    public ListaDeProcessos<Processo> lista_bloqueados;
    private int contador;

    public Scheduler(ListaDeProcessos<Processo> lista_alta_prioridade , ListaDeProcessos<Processo> lista_media_prioridade, ListaDeProcessos<Processo> lista_baixa_prioridade, ListaDeProcessos<Processo> lista_bloqueados){
        this.lista_alta_prioridade = lista_alta_prioridade;
        this.lista_media_prioridade = lista_media_prioridade;
        this.lista_baixa_prioridade = lista_baixa_prioridade;
        this.lista_bloqueados = new ListaDeProcessos<Processo>();
        this.contador = 0;
    }

    public void executarCicloDeCpu(){
        System.out.println("Lista de alta prioridade:");
        lista_alta_prioridade.imprimir();
        System.out.println("Lista de media prioridade:");
        lista_media_prioridade.imprimir();
        System.out.println("Lista de baixa prioridade:");
        lista_baixa_prioridade.imprimir();
        System.out.println("Lista de bloqueados:");
        lista_bloqueados.imprimir();
        if(lista_bloqueados.tamanho != 0){
            Processo processo = lista_bloqueados.get(0);
            processo.setRecurso_necessario("Null");
            lista_bloqueados.remover(0);
            System.out.println("Desbloqueando processo: " + processo);
            if (processo.getPrioridade() == 1){
                lista_alta_prioridade.add(processo,lista_alta_prioridade.tamanho);
            } else if (processo.getPrioridade() == 2) {
                lista_media_prioridade.add(processo, lista_media_prioridade.tamanho);
            } else {
                lista_baixa_prioridade.add(processo , lista_baixa_prioridade.tamanho);
            }
        }
        if (this.contador != 5 && lista_alta_prioridade.tamanho != 0){
            Processo processo = lista_alta_prioridade.get(0);
            if (processo.getRecurso_necessario().equals("DISCO")){
                lista_bloqueados.add(processo,lista_bloqueados.tamanho);
                lista_alta_prioridade.remover(0);
            }else{
                System.out.println("Executando processo: " + processo);
                processo.setCiclos_necessarios(processo.getCiclos_necessarios() - 1);
                lista_alta_prioridade.remover(0);
                if (processo.getCiclos_necessarios() > 0){
                    lista_alta_prioridade.add(processo, lista_alta_prioridade.tamanho);
                }else{
                    System.out.println("Processo " + processo + " finalizado.");
                }
            }
            this.contador++;
        } else if (lista_media_prioridade.tamanho != 0) {
            Processo processo = lista_media_prioridade.get(0);
            if (processo.getRecurso_necessario().equals("DISCO")){
                lista_bloqueados.add(processo,lista_bloqueados.tamanho);
                lista_media_prioridade.remover(0);
            }else{
                System.out.println("Executando processo " + processo);
                processo.setCiclos_necessarios(processo.getCiclos_necessarios() - 1);
                lista_media_prioridade.remover(0);
                if (processo.getCiclos_necessarios() > 0){
                    lista_media_prioridade.add(processo, lista_media_prioridade.tamanho);
                }else{
                    System.out.println("Processo " + processo + " finalizado");
                }
            }
            this.contador = 0;
        } else if (lista_baixa_prioridade.tamanho != 0) {
            Processo processo = lista_baixa_prioridade.get(0);
            if (processo.getRecurso_necessario().equals("DISCO")){
                lista_bloqueados.add(processo, lista_bloqueados.tamanho);
                lista_baixa_prioridade.remover(0);
            }else{
                System.out.println("Executando processo: " + processo);
                processo.setCiclos_necessarios(processo.getCiclos_necessarios() - 1);
                lista_baixa_prioridade.remover(0);
                if (processo.getCiclos_necessarios() > 0){
                    lista_baixa_prioridade.add(processo, lista_baixa_prioridade.tamanho);
                }else{
                    System.out.println("Processo " + processo + " finalizado.");
                }
            }
            this.contador = 0;
        }else{
            this.contador = 0;
        }
    }
}
