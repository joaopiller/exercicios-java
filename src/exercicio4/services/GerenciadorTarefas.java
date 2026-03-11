package exercicio4.services;

import exercicio4.entities.Tarefa;
import exercicio4.enums.Prioridade;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefa> listaDeTarefas = new ArrayList<>();
    private int proximoId = 0;

    public void adicionar(Tarefa tarefa) {
        tarefa.setId(proximoId++);
        listaDeTarefas.add(tarefa);
    }

    public void concluirTarefa(int id) {
        Tarefa tarefaPorId = null;
        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId() == id) {
                tarefaPorId = tarefa;
                break;
            }
        }
        if (tarefaPorId == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        tarefaPorId.concluir();
    }

    public List<Tarefa> listarPendentes() {
        return listaDeTarefas.stream().filter(t -> !t.isConcluida()).toList();
    }

    public List<Tarefa> filtrarPorPrioridade(Prioridade prioridade) {
        return listaDeTarefas.stream().filter(x -> x.getPrioridade() == prioridade).toList();
    }

    public int total() {
        return listaDeTarefas.size();
    }

    public int totalConcluidas() {
        int totalConcluidas = (int)listaDeTarefas.stream().filter(Tarefa::isConcluida).count();
        return totalConcluidas;
    }
}
