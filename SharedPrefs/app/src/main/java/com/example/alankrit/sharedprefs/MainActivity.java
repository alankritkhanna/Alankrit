package com.example.alankrit.sharedprefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;
    public static final String INPUT="inputText";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText) findViewById(R.id.editText);
        textView= (TextView) findViewById(R.id.textView);
        button= (Button) findViewById(R.id.button);

        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);

        String retrievedValue=sharedPreferences.getString(INPUT,null);
        textView.setText(retrievedValue);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=editText.getText().toString();
                editor.putString(INPUT,inputText);
                editor.apply();
                textView.setText(inputText);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSettings:
                Toast.makeText(getBaseContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAdd:
                Toast.makeText(getBaseContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuDelete:
                Toast.makeText(getBaseContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
