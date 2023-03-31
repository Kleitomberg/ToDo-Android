package br.ufpe.cin.residencia.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    Button btn_back, btn_salvar;
    EditText titulo,descricao;

    TarefaViewModel tarefaViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.btn_back = findViewById(R.id.btn_back);
        this.titulo = findViewById(R.id.form_titulo);
        this.descricao = findViewById(R.id.form_descricao);
        this.btn_salvar = findViewById(R.id.button_salvar);

        this.btn_salvar.setOnClickListener(view -> {
            String titulo = this.titulo.getText().toString();
            String descricao = this.descricao.getText().toString();
            Tarefa t = new Tarefa(titulo,descricao,false );

            tarefaViewModel = new ViewModelProvider(this).get(TarefaViewModel.class);
            tarefaViewModel.inserir(t);

            finish();
            Toast.makeText(this, "Tarefa Adicionada com sucessso!", Toast.LENGTH_SHORT).show();
        });

        this.btn_back.setOnClickListener(view -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}
