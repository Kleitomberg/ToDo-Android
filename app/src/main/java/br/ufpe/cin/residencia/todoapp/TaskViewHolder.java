package br.ufpe.cin.residencia.todoapp;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    TarefaViewModel tarefaViewModel;
    TarefaRepository tarefaRepository;
    TextView titulo, descricao;
    CheckBox concluida;
    Button buttonDelete;

    int id_tarefa;
    Context context = null;

    TarefaDao dao;

    public TaskViewHolder(@NonNull View itemView, Context c) {
        super(itemView);

        this.titulo = itemView.findViewById(R.id.tarefa_titulo);
        this.descricao = itemView.findViewById(R.id.tarefa_descricao);
        this.concluida = itemView.findViewById(R.id.tarefa_check);
        this.buttonDelete = itemView.findViewById(R.id.tarefa_delete);
        this.context = c;

        AppDatabase db = AppDatabase.getInstance(context);
        this.dao =db.tarefaDao();

    }

    void bindTo(Tarefa tarefa){

        this.id_tarefa = tarefa.getId();

        this.titulo.setText(tarefa.getTitulo());
        this.descricao.setText(tarefa.getDescricao());
        this.concluida.setChecked(tarefa.isConcluida());

        if (tarefa.isConcluida()){
            itemView.setAlpha(0.5f);
        }else {
            itemView.setAlpha(1.0f);
        }

        this.buttonDelete.setOnClickListener(view -> {
            AppDatabase.databaseWriteExecutor.execute(() -> {
                dao.excluirTarefa(tarefa);
            });

            Toast.makeText(context, "Tarefa removida!", Toast.LENGTH_SHORT).show();

        });

        this.concluida.setOnClickListener(view -> {

            if (tarefa.isConcluida()){
                tarefa.setConcluida(false);
                AppDatabase.databaseWriteExecutor.execute(() -> {
                    dao.atualizarTarefa(tarefa);
                });
                Toast.makeText(context, "Tarefa marcada como não concluída!", Toast.LENGTH_SHORT).show();
               //itemView.setAlpha(1.0f);
            }
            else{
                tarefa.setConcluida(true);
                AppDatabase.databaseWriteExecutor.execute(() -> {
                    dao.atualizarTarefa(tarefa);
                });
                Toast.makeText(context, "Tarefa marcada como concluída!", Toast.LENGTH_SHORT).show();
               // itemView.setAlpha(0.5f);
            }




        });

    }
}
