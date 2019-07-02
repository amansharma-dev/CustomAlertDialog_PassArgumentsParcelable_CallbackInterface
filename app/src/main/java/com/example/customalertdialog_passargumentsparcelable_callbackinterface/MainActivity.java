package com.example.customalertdialog_passargumentsparcelable_callbackinterface;

import android.app.Person;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.customalertdialog_passargumentsparcelable_callbackinterface.model.UserDetails;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floating_action_button);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog(){

        UserDetails userDetails = new UserDetails("Asahd","Khaled",2);

        CustomDialogFragment customDialogFragment = CustomDialogFragment.newInstance(userDetails);
        customDialogFragment.setCancelable(false);
        customDialogFragment.show(getSupportFragmentManager(),"CUSTOM_ALERT_DIALOG");
    }
}
