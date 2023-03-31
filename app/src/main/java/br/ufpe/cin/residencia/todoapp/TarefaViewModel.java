package br.ufpe.cin.residencia.todoapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TarefaViewModel extends AndroidViewModel {

    private LiveData<List<Tarefa>> tarefas;
    private TarefaRepository repository;

    public TarefaViewModel(@NonNull Application application) {
        super(application);
        this.repository = new TarefaRepository(application);
        this.tarefas = repository.getTodasTarefas();
    }

    public LiveData<List<Tarefa>> getTodasTarefas() {
        return tarefas;
    }

    public void inserir(Tarefa tarefa) {
        repository.inserirTarefa(tarefa);
    }

    public void atualizar(Tarefa tarefa) {
        repository.atualizarTarefa(tarefa);
    }

    public void excluir(Tarefa tarefa) {
        repository.excluirTarefa(tarefa);
    }
}
