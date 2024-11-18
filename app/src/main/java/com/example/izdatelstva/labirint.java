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

public class labirint extends AppCompatActivity {

    private ListView listView_lab;
    private Button add_lab, del_lab;
    private ArrayList<String> bookList3;
    private ArrayAdapter<String> adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labirint);

        listView_lab = findViewById(R.id.listView_lab);
        add_lab = findViewById(R.id.add_lab);
        del_lab = findViewById(R.id.del_lab);

        bookList3 = new ArrayList<>();
        adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, bookList3);
        listView_lab.setAdapter(adapter3);

        add_lab.setOnClickListener(v -> showAddBookDialog());

        del_lab.setOnClickListener(v -> showDeleteBookDialog());
    }

    private void showAddBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите название книги");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String bookName = input.getText().toString();
            if (!bookName.isEmpty()) {
                bookList3.add(bookName);
                adapter3.notifyDataSetChanged();
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
            if (bookList3.contains(bookName)) {
                bookList3.remove(bookName);
                adapter3.notifyDataSetChanged();
            } else {
                Toast.makeText(labirint.this, "Книга не найдена", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}