package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// NEW: imports for button colors
import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    public static ActivityMainBinding mainBinding;

    private ColorStateList originalCountButtonTint;

//    public TextView displayCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
//        setContentView(R.layout.activity_main);

        originalCountButtonTint =
                mainBinding.buttonCount.getBackgroundTintList();

        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.parseColor("#9E9E9E"))
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        displayCountText = findViewById(R.id.text_display_count);
    }

    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        count++;
        mainBinding.textDisplayCount.setText(String.valueOf(count));
//        displayCountText.setText(String.valueOf(count));

        if (count % 2 != 0) {

            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#4CAF50"))
            );
        } else {

            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#2196F3"))
            );
        }

        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.parseColor("#FF9800"))
        );
    }

    public void show_zero(View view) {
        count = 0;

        mainBinding.textDisplayCount.setText(String.valueOf(count));

        mainBinding.buttonCount.setBackgroundTintList(
                originalCountButtonTint
        );

        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(Color.parseColor("#9E9E9E"))
        );
    }
}