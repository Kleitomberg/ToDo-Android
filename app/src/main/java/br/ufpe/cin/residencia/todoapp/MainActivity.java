package br.ufpe.cin.residencia.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    RecyclerView recyclerViewTarefas;
    TaskAdapter taskAdapter;
    List<Tarefa> tarefas;
    TarefaViewModel tarefaViewModel;
    TextView nenhum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nenhum = findViewById(R.id.nenhuma);

        this.btn_add = findViewById(R.id.button_add);

        this.btn_add.setOnClickListener(view -> {
            Intent i = new Intent(this,Formulario.class);
            startActivity(i);
        });

        this.recyclerViewTarefas = findViewById(R.id.recycler_view);
        //popular LIST DE TAREFAS

        this.tarefas = new ArrayList<Tarefa>();

        this.taskAdapter = new TaskAdapter(MainActivity.this,this.tarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);

        this.recyclerViewTarefas.setLayoutManager(layoutManager);
        this.recyclerViewTarefas.setAdapter(taskAdapter);

        tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);

        tarefaViewModel.getTodasTarefas().observe(this, listatarefas -> {
            tarefas.clear();
            tarefas.addAll(listatarefas);
            taskAdapter.notifyDataSetChanged();
        });
        //if (tarefaViewModel.getTodasTarefas().getValue().size() == 0 ){
            //nenhum.setVisibility(View.VISIBLE);
        //}

    }
}
