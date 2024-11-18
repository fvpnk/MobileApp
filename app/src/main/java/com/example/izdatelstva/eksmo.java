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

public class eksmo extends AppCompatActivity {

    private ListView listView_eksmo;
    private Button add_eksmo, del_eksmo;
    private ArrayList<String> bookList2;
    private ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eksmo);

        listView_eksmo = findViewById(R.id.listView_eksmo);
        add_eksmo = findViewById(R.id.add_eksmo);
        del_eksmo = findViewById(R.id.del_eksmo);

        bookList2 = new ArrayList<>();
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList2);
        listView_eksmo.setAdapter(adapter2);

        // Слушатель для кнопки "Добавить книгу"
        add_eksmo.setOnClickListener(v -> showAddBookDialog());

        // Слушатель для кнопки "Удалить книгу"
        del_eksmo.setOnClickListener(v -> showDeleteBookDialog());
    }

    // Показать диалог для добавления книги
    private void showAddBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите название книги");

        // Создаём поле ввода
        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String bookName = input.getText().toString();
            if (!bookName.isEmpty()) {
                bookList2.add(bookName);
                adapter2.notifyDataSetChanged();  // Обновляем список
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    // Показать диалог для удаления книги
    private void showDeleteBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите название книги для удаления");

        // Создаём поле ввода
        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Удалить", (dialog, which) -> {
            String bookName = input.getText().toString();
            if (bookList2.contains(bookName)) {
                bookList2.remove(bookName);
                adapter2.notifyDataSetChanged();  // Обновляем список
            } else {
                Toast.makeText(eksmo.this, "Книга не найдена", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}