package br.ufpe.cin.residencia.todoapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tarefas")
public class Tarefa {

    private static int ultimoId = 0;
    @PrimaryKey @NonNull
    private int id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private Date dataCriacao;
    private Date dataConclusao;

    // Construtor
    public Tarefa(String titulo, String descricao, boolean concluida) {
        this.id = obterProximoId();
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.dataCriacao = new Date();
    }

    private static int obterProximoId() {
        return ++ultimoId;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Date getDataConclusao() {
        return dataConclusao;
    }
    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
