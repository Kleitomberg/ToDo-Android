package br.ufpe.cin.residencia.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private List<Tarefa> tarefas;
    Context context;

    public TaskAdapter(Context c,List<Tarefa> tarefas){
        this.context = c;
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tarefa,parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(view,context);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bindTo(tarefas.get(position));



    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }
}//Fim da class
