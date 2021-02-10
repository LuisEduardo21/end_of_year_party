package com.example.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.festafimdeano.R;
import com.example.festafimdeano.view.DetailsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirmed = findViewById(R.id.button_confirmed);

        this.mViewHolder.buttonConfirmed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirmed){
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder{
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirmed;
    }
}