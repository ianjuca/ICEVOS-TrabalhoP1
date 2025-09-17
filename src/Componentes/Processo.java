package Componentes;

public class Processo {
    private int id;
    private String nome;
    private int prioridade;
    private int ciclos_necessarios;
    private String recurso_necessario;

    public Processo(int id, String nome, int prioridade, int ciclos_necessarios, String recurso_necessario) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclos_necessarios = ciclos_necessarios;
        this.recurso_necessario = recurso_necessario;
    }

    @Override
    public String toString() {
        return String.format(
                "Processo{id='%s', nome = '%s' , prioridade= %d, ciclos= %d , recurso = %s}",
                id, nome, prioridade, ciclos_necessarios, recurso_necessario == null ? "null" : ("'" + recurso_necessario + "'")
        );
    }

    public int getPrioridade(){
        return prioridade;
    }

    public int getCiclos_necessarios(){
        return ciclos_necessarios;
    }

    public void setCiclos_necessarios(int ciclos_necessarios){
        this.ciclos_necessarios = ciclos_necessarios;
    }

    public String getRecurso_necessario(){
        return recurso_necessario;
    }

    public void setRecurso_necessario(String recurso_necessario){
        this.recurso_necessario = recurso_necessario;
    }
}

