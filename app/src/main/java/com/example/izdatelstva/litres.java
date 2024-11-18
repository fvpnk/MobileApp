package com.example.izdatelstva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class litres extends AppCompatActivity {

    private ListView listView_litres;
    private Button add_litres, del_litres;
    private ArrayList<String> bookList1;
    private ArrayAdapter<String> adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.litres);

        listView_litres = findViewById(R.id.listView_litres);
        add_litres = findViewById(R.id.add_litres);
        del_litres = findViewById(R.id.del_litres);

        bookList1 = new ArrayList<>();
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList1);
        listView_litres.setAdapter(adapter1);

        add_litres.setOnClickListener(v -> showAddBookDialog());

        del_litres.setOnClickListener(v -> showDeleteBookDialog());
    }

    private void showAddBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите название книги");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String bookName = input.getText().toString();
            if (!bookName.isEmpty()) {
                bookList1.add(bookName);
                adapter1.notifyDataSetChanged();
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
            if (bookList1.contains(bookName)) {
                bookList1.remove(bookName);
                adapter1.notifyDataSetChanged();
            } else {
                Toast.makeText(litres.this, "Книга не найдена", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}