package comp208.budiakov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private ImageView[] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViews = new ImageView[12];
        imageViews[0] = findViewById(R.id.imageView1);
        imageViews[1] = findViewById(R.id.imageView2);
        imageViews[2] = findViewById(R.id.imageView3);
        imageViews[3] = findViewById(R.id.imageView4);
        imageViews[4] = findViewById(R.id.imageView5);
        imageViews[5] = findViewById(R.id.imageView6);
        imageViews[6] = findViewById(R.id.imageView7);
        imageViews[7] = findViewById(R.id.imageView8);
        imageViews[8] = findViewById(R.id.imageView9);
        imageViews[9] = findViewById(R.id.imageView10);
        imageViews[10] = findViewById(R.id.imageView11);
        imageViews[11] = findViewById(R.id.imageView12);

        game = new Game(imageViews);
        for (int i = 0; i < 12; i++) {
            final int index = i;
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    game.onCardClicked(game.getCards()[index]);
                    if (game.isFinished())
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                showScoreScreen(game.start, game.attempts, game.score);
                            }
                        }, 1000);
                }

            });
        }
    }

    private void showScoreScreen(long start, int attempts, int score) {
        Intent intent = new Intent(this, ScoreActivity.class);
        long time = (System.currentTimeMillis() - start) / 1000;
        int finalScore = score - ( Math.round(time) * attempts );
        if(finalScore <= 50) finalScore = 50;
        if(attempts == 6) finalScore = score;

        intent.putExtra("score", finalScore);
        intent.putExtra("time", time);
        intent.putExtra("attempts", attempts);

        startActivity(intent);
    }
}