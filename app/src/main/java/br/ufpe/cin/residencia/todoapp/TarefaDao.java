package br.ufpe.cin.residencia.todoapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TarefaDao {

    @Insert
    void inserirTarefa(Tarefa tarefa);

    @Update
    void atualizarTarefa(Tarefa tarefa);

    @Delete
    void excluirTarefa(Tarefa tarefa);

    @Query("DELETE FROM tarefas")
    void deleteAllTarefas();

    @Query("SELECT * FROM tarefas WHERE id = :id")
    Tarefa buscarPeloId(int id);


    @Query("SELECT * FROM tarefas ORDER BY dataCriacao DESC")
    LiveData<List<Tarefa>> getTodasTarefas();

}
