package dev.abhishekkumar.jokeandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        textView= findViewById(R.id.textView);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("joke"));
    }
}
