package com.ramotion.foldingcell.examples.simple;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ramotion.foldingcell.FoldingCell;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get our folding cell
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);

        // attach click listener to fold btn
        final Button toggleBtn = (Button) findViewById(R.id.toggle_btn);
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        // attach click listener to toast btn
        final Button toggleInstantlyBtn = (Button) findViewById(R.id.toggle_instant_btn);
        toggleInstantlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(true);
            }
        });

    }
}
