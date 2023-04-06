package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    Button button_center;
    Button button_top_left;
    Button button_top_right;
    Button button_bottom_left;
    Button button_bottom_right;
    Button button_navigate;
    EditText edit_text;

    Integer no_clicks = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        button_center = (Button) findViewById(R.id.center);
        button_top_left = (Button) findViewById(R.id.top_left);
        button_top_right = (Button) findViewById(R.id.top_right);
        button_bottom_right = (Button) findViewById(R.id.bottom_right);
        button_bottom_left = (Button) findViewById(R.id.bottom_left);
        button_navigate = (Button) findViewById(R.id.button_navigate);
        edit_text = (EditText) findViewById(R.id.edittext);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("ClICKS")) {
                no_clicks = savedInstanceState.getInt("ClICKS");
                Toast.makeText(this, "clicks: " + no_clicks, Toast.LENGTH_SHORT).show();
            }
        } else {
            no_clicks = 0;
        }



        button_center.setOnClickListener(view -> {
            if(!edit_text.getText().toString().isEmpty())
                edit_text.setText(edit_text.getText().toString() + ",");
            no_clicks++;
            edit_text.setText(edit_text.getText().toString() + "Center");
        });
        button_top_left.setOnClickListener(view -> {
            if(!edit_text.getText().toString().isEmpty())
                edit_text.setText(edit_text.getText().toString() + ",");
            no_clicks++;
            edit_text.setText(edit_text.getText().toString() + "Top Left");
        });
        button_top_right.setOnClickListener(view -> {
            if(!edit_text.getText().toString().isEmpty())
                edit_text.setText(edit_text.getText().toString() + ",");
            no_clicks++;
            edit_text.setText(edit_text.getText().toString() + "Top Right");
        });
        button_bottom_left.setOnClickListener(view -> {
            if(!edit_text.getText().toString().isEmpty())
                edit_text.setText(edit_text.getText().toString() + ",");
            no_clicks++;
            edit_text.setText(edit_text.getText().toString() + "Bottom Left");
        });
        button_bottom_right.setOnClickListener(view -> {
            if(!edit_text.getText().toString().isEmpty())
                edit_text.setText(edit_text.getText().toString() + ",");
            no_clicks++;
            edit_text.setText(edit_text.getText().toString() + "Bottom Right");
        });
        button_navigate.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SeconadryActivity.class);
            intent.putExtra("TEXT", edit_text.getText().toString());
            startActivityForResult(intent, 1);
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("ClICKS", no_clicks);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            no_clicks = 0;
            edit_text.setText("");
        }
    }
}