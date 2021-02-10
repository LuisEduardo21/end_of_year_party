package com.example.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.festafimdeano.R;
import com.example.festafimdeano.constant.FimDeAnoConstant;
import com.example.festafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate){
            if (this.mViewHolder.checkParticipate.isChecked()){
                this.mSecurityPreferences.storeString(FimDeAnoConstant.PRESENCE_KEY, FimDeAnoConstant.CONFIRMATION_YES);
            }else {
                this.mSecurityPreferences.storeString(FimDeAnoConstant.PRESENCE_KEY, FimDeAnoConstant.CONFIRMATION_NO);

            }
        }
    }

    private static class ViewHolder{
        CheckBox checkParticipate;
    }
}