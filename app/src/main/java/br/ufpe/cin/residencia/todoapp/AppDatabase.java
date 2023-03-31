package br.ufpe.cin.residencia.todoapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.room.TypeConverters;
@Database(entities = {Tarefa.class},version = 1)
@TypeConverters(Converters.class)
public abstract  class AppDatabase extends RoomDatabase {

    public static final ExecutorService databaseWriteExecutor =
        Executors.newFixedThreadPool(4);

    // Singleton instance of the database
    private static volatile AppDatabase INSTANCE;

    // DAOs used by the database
    public abstract TarefaDao tarefaDao();

    // Method to get the singleton instance of the database
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "tarefa_database")
                        .build();
                }
            }
        }
        return INSTANCE;
    }


}
