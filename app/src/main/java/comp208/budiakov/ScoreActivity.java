package comp208.budiakov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        TextView timeTextView = findViewById(R.id.timeTextView);
        TextView attemptsTextView = findViewById(R.id.attemptsTextView);
        Button playAgainButton = findViewById(R.id.playAgainButton);
        Button quitButton = findViewById(R.id.quitButton);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        int attempts = intent.getIntExtra("attempts", 0);
        long time = intent.getLongExtra("time", 0);

        scoreTextView.setText("Score: " + score);
        timeTextView.setText("Time: " + time + " seconds");
        attemptsTextView.setText("Attempts: " + attempts);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }
}