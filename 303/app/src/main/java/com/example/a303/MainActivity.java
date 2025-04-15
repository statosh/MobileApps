package com.example.a303;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription;
    private Button buttonAddTask;
    private ListView listViewTasks;
    private Spinner spinnerColor;
    private DatabaseHelper dbHelper;
    private List<Task> taskList;
    private ArrayAdapter<String> adapter;
    private List<String> displayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        listViewTasks = findViewById(R.id.listViewTasks);
        spinnerColor = findViewById(R.id.spinnerColor);

        dbHelper = new DatabaseHelper(this);
        taskList = new ArrayList<>();
        displayList = new ArrayList<>();
        loadTasks();

        buttonAddTask.setOnClickListener(v -> addOrUpdateTask(null));

        listViewTasks.setOnItemClickListener((parent, view, position, id) -> editTask(position));

        listViewTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            deleteTask(position);
            return true;
        });
    }

    private void loadTasks() {
        taskList.clear();
        displayList.clear();
        List<Task> tasksFromDB = dbHelper.getAllTasks();
        for (Task task : tasksFromDB) {
            taskList.add(task);
            displayList.add(task.getTitle() + ": " + task.getDescription());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                String color = taskList.get(position).getColor();
                if (color != null) {
                    switch (color) {
                        case "Red":
                            textView.setTextColor(Color.RED);
                            break;
                        case "Green":
                            textView.setTextColor(Color.GREEN);
                            break;
                        case "Blue":
                            textView.setTextColor(Color.BLUE);
                            break;
                        case "Yellow":
                            textView.setTextColor(Color.YELLOW);
                            break;
                        default:
                            textView.setTextColor(Color.BLACK);
                    }
                }
                return view;
            }
        };
        listViewTasks.setAdapter(adapter);
    }

    private void addOrUpdateTask(Task taskToUpdate) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String color = spinnerColor.getSelectedItem().toString();

        if (!title.isEmpty() && !description.isEmpty()) {
            if (taskToUpdate == null) {
                Task task = new Task(title, description, color);
                dbHelper.addTask(task);
                taskList.add(task);
                displayList.add(title + ": " + description);
            } else {
                taskToUpdate.setTitle(title);
                taskToUpdate.setDescription(description);
                taskToUpdate.setColor(color);
                dbHelper.updateTask(taskToUpdate);
                int index = taskList.indexOf(taskToUpdate);
                displayList.set(index, title + ": " + description);
            }
            adapter.notifyDataSetChanged();
            clearInputs();
            Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter title and description", Toast.LENGTH_SHORT).show();
        }
    }

    private void editTask(int position) {
        Task task = taskList.get(position);
        editTextTitle.setText(task.getTitle());
        editTextDescription.setText(task.getDescription());
        spinnerColor.setSelection(getColorIndex(task.getColor()));
        buttonAddTask.setOnClickListener(v -> addOrUpdateTask(task));
    }

    private void deleteTask(int position) {
        Task task = taskList.get(position);
        dbHelper.deleteTask(task);
        taskList.remove(position);
        displayList.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show();
    }

    private int getColorIndex(String color) {
        String[] colors = getResources().getStringArray(R.array.color_options);
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color)) {
                return i;
            }
        }
        return 0;
    }

    private void clearInputs() {
        editTextTitle.setText("");
        editTextDescription.setText("");
        spinnerColor.setSelection(0);
        buttonAddTask.setOnClickListener(v -> addOrUpdateTask(null));
    }
}