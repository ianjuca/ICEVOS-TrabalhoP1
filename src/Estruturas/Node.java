package Estruturas;

public class Node<Tipo> {
    public Tipo valor;
    public Node<Tipo> prox;
    public Node<Tipo> ant;
    public Node(Tipo valor){
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}
