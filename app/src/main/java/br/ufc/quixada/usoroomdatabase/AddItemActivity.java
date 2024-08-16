package br.ufc.quixada.usoroomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import br.ufc.quixada.usoroomdatabase.database.AppDatabase;
import br.ufc.quixada.usoroomdatabase.models.person;

public class AddItemActivity extends AppCompatActivity {

    private EditText titleEdit, descriptionEdit;
    private Button saveButton, showButton;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        titleEdit = findViewById(R.id.titleEdit);
        descriptionEdit = findViewById(R.id.descriptionEdit);
        saveButton = findViewById(R.id.saveButton);
        showButton = findViewById(R.id.showButton);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "person-database").allowMainThreadQueries().build();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = titleEdit.getText().toString();
                String descricao = descriptionEdit.getText().toString();

                if (!TextUtils.isEmpty(titulo) && !TextUtils.isEmpty(descricao)) {
                    person newperson = new person(titulo, descricao, R.drawable.foto2);
                    db.personDao().insertAll(newperson);

                    titleEdit.setText("");
                    descriptionEdit.setText("");
                }
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
