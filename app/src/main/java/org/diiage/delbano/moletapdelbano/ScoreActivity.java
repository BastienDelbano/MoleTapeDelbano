package org.diiage.delbano.moletapdelbano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        //on recup les info de la session
        Session session = getIntent().getExtras().getParcelable(MainActivity.SESSION);

        ListView lstScores = findViewById(R.id.scores);
        ScoresAdapter sa = new ScoresAdapter(this, session.getScores());
        lstScores.setAdapter(sa);
    }
}
