package com.example.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.festafimdeano.R;
import com.example.festafimdeano.constant.FimDeAnoConstant;
import com.example.festafimdeano.data.SecurityPreferences;
import com.example.festafimdeano.view.DetailsActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private SecurityPreferences mSecurityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirmed = findViewById(R.id.button_confirmed);
        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.buttonConfirmed.setOnClickListener(this);

        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.dias));
        this.mViewHolder.textDaysLeft.setText(daysLeft);

        this.verifyPresence();
    }

    private void verifyPresence() {
        String presence = this.mSecurityPreferences.getStoreString(FimDeAnoConstant.PRESENCE_KEY);
        if (presence.equals("")){
            this.mViewHolder.buttonConfirmed.setText(getString(R.string.nao_confirmado));
        }else if (presence.equals(FimDeAnoConstant.CONFIRMATION_YES)){
            this.mViewHolder.buttonConfirmed.setText(getString(R.string.sim));
        }else {
            this.mViewHolder.buttonConfirmed.setText(getString(R.string.nao));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirmed){
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    private int getDaysLeft(){
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay = Calendar.getInstance();
        int dayMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return dayMax - today;

    }

    private static class ViewHolder{
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirmed;
    }
}