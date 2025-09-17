package Estruturas;

public class ListaDeProcessos<Tipo> {
    Node<Tipo> head, tail;
    public int tamanho;

    public ListaDeProcessos() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean add(Tipo valor, int pos) {
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        Node<Tipo> novo = new Node<>(valor);

        if (pos == 0) {
            if (this.head == null) {
                this.head = novo;
                this.tail = novo;
            } else {
                novo.prox = this.head;
                this.head.ant = novo;
                this.head = novo;
            }
        } else if (pos == tamanho) {
            novo.ant = this.tail;
            this.tail.prox = novo;
            this.tail = novo;
        } else {
            Node<Tipo> atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            novo.ant = atual;
            atual.prox.ant = novo;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }

    public void imprimir() {
        Node<Tipo> atual = this.head;
        System.out.print("head -> ");

        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
    }

    public Node<Tipo> remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        Node<Tipo> removido;
        if (pos == 0) {
            removido = this.head;
            if (tamanho == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = removido.prox;
                removido.prox = null;
                this.head.ant = null;
            }
        }else if(pos == tamanho - 1){
            removido = this.tail;
            this.tail = removido.ant;
            this.tail.prox = null;
            removido.ant = null;
        }
        else{
            Node<Tipo> atual = this.head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
            removido.prox.ant = removido.ant;
            removido.ant = null;
            removido.prox = null;
        }
        tamanho--;
        return removido;
    }

    public Tipo get(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return null;
        }
        Node<Tipo> atual = this.head;
        for (int i = 0; i < pos; i++) {
            atual = atual.prox;
        }
        return atual.valor;
    }
}