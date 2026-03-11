package exercicio4.entities;

import exercicio4.enums.Prioridade;

public class Tarefa {
    private String descricao;
    private int id;
    private boolean concluida;
    private Prioridade prioridade;

    public Tarefa(String descricao, Prioridade prioridade) {
        this.descricao = descricao;
        this.concluida = false;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        concluida = true;
    }

    public String toString() {
        String status = concluida ? "concluída" : "pendente";
        return "ID: " + id + " | Descrição: " + descricao + " | Prioridade: " + prioridade.toString().toLowerCase() + " | Status: " + status;
    }
}
