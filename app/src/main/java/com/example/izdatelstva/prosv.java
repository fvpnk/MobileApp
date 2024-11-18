package com.example.izdatelstva;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class prosv extends AppCompatActivity {

    private ListView listView_prosv;
    private Button add_prosv, del_prosv;
    private ArrayList<String> bookList4;
    private ArrayAdapter<String> adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prosv);

        listView_prosv = findViewById(R.id.listView_prosv);
        add_prosv = findViewById(R.id.add_prosv);
        del_prosv = findViewById(R.id.del_prosv);

        bookList4 = new ArrayList<>();
        adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, bookList4);
        listView_prosv.setAdapter(adapter4);

        add_prosv.setOnClickListener(v -> showAddBookDialog());

        del_prosv.setOnClickListener(v -> showDeleteBookDialog());
    }

    private void showAddBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите название книги");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String bookName = input.getText().toString();
            if (!bookName.isEmpty()) {
                bookList4.add(bookName);
                adapter4.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void showDeleteBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите название книги для удаления");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Удалить", (dialog, which) -> {
            String bookName = input.getText().toString();
            if (bookList4.contains(bookName)) {
                bookList4.remove(bookName);
                adapter4.notifyDataSetChanged();
            } else {
                Toast.makeText(prosv.this, "Книга не найдена", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}