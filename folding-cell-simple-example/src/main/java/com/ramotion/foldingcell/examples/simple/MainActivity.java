package com.ramotion.foldingcell.examples.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get our folding cell
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);

        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        // attach click listener to fold btn
        final Button foldBtn = (Button) findViewById(R.id.fold_btn);
        foldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.fold(false);
            }
        });

        // attach click listener to toast btn
        final Button toastBtn = (Button) findViewById(R.id.toast_btn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Victrix superbus cursus est.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
