package br.ufpe.cin.residencia.todoapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TarefaRepository {
    private TarefaDao tarefaDao;

    public TarefaRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        tarefaDao = db.tarefaDao();
    }

    public LiveData<List<Tarefa>> getTodasTarefas() {
        return tarefaDao.getTodasTarefas();
    }

    public void inserirTarefa(Tarefa tarefa) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            tarefaDao.inserirTarefa(tarefa);
        });
    }

    public void atualizarTarefa(Tarefa tarefa) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            tarefaDao.atualizarTarefa(tarefa);
        });
    }

    public Tarefa buscarPeloId(int id) {
          return  tarefaDao.buscarPeloId(id);
    }

    public void excluirTarefa(Tarefa tarefa) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            tarefaDao.excluirTarefa(tarefa);
        });
    }
}

