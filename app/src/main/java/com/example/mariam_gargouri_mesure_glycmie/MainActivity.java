package com.example.mariam_gargouri_mesure_glycmie;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private EditText editTextGlycemie;
    private SeekBar sbAge;
    private RadioButton rbtOui,rbtNon;
    private Button btnConsulter;
    private TextView text,resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                Log.i("Information", "onProgressChanged "+progress);
                text.setText("Votre âge : "+ progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculer(v);
            }
        });
    }
    public void calculer (View view)
    {
        Log.i("Information", "button cliqué");
        int Age = sbAge.getProgress();
        float valeurM = Float.valueOf(editTextGlycemie.getText().toString());
        boolean radiobutt = rbtOui.isChecked();
        if (radiobutt) {
            if (Age >= 13) {
                if (valeurM  < 5.0)
                    resultTextView.setText("Niveau de glycémie est trop bas");
                else if (valeurM  >= 5.0 && valeurM <= 7.2)
                    resultTextView.setText("Niveau de glycémie est normale");
                else
                    resultTextView.setText("Niveau de glycémie est trop élevé");
            } else
            if (Age >= 6 && Age <= 12)
            {
                if (valeurM  < 5.0)
                    resultTextView.setText("Niveau de glycémie est trop bas");
                else if (valeurM  >= 5.0 && valeurM  <= 10.0)
                    resultTextView.setText("Niveau de glycémie est normale");
                else
                    resultTextView.setText("Niveau de glycémie est trop élevé");
            }
            else
            if (Age < 6)
            {
                if (valeurM  < 5.5)
                    resultTextView.setText("Niveau de glycémie est trop bas");
                else if (valeurM  >= 5.5 && valeurM  <= 10.0)
                    resultTextView.setText("Niveau de glycémie est normale");
                else
                    resultTextView.setText("Niveau de glycémie est trop élevé");
            }
        } else
        {
            if (valeurM  > 10.5)
                resultTextView.setText("Niveau de glycémie est trop élevé");
            else
                resultTextView.setText("Niveau de glycémie est normale");
        }
    }


    private void init()
    {
        editTextGlycemie = findViewById(R.id.editTextGlycemie);
        sbAge = findViewById(R.id.sbAge);
        rbtOui = findViewById(R.id.rbtOui);
        rbtNon = findViewById(R.id.rbtNon);
        btnConsulter= findViewById(R.id.btnConsulter);
        text = findViewById(R.id.ageb);
        resultTextView = findViewById(R.id.resultTextView);

    }


}