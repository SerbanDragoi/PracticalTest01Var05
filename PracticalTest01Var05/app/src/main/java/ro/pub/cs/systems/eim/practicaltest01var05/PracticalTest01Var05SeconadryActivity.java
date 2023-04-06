package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var05SeconadryActivity extends AppCompatActivity {

    EditText edit_text;
    Button verify;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_seconadry);

        edit_text = (EditText) findViewById(R.id.edittext);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("TEXT")) {
            String text = intent.getStringExtra("TEXT");
            edit_text.setText(String.valueOf(text));
        }

        verify = (Button) findViewById(R.id.verify);
        cancel = (Button) findViewById(R.id.cancel);

        verify.setOnClickListener(view -> {
            setResult(RESULT_OK);
            finish();
        });

        cancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}