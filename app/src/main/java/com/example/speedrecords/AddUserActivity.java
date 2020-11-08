package com.example.speedrecords;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.speedrecords.db.AppDatabase;
import com.example.speedrecords.model.User;
import com.example.speedrecords.until.AppExecutors;

import java.util.Locale;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__record);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sumcount=0;
                final EditText et1 = findViewById(R.id.meter1);
                final EditText et2 = findViewById(R.id.second2);
                String numtext = et1.getText().toString();
                String numspeed = et2.getText().toString();
                int sumtext = Integer.parseInt(numtext);
                int sumspeed = Integer.parseInt(numspeed);
                double result=sumspeed/sumtext*3600/1000;
                String str = String.format(Locale.getDefault(), "%.2f", result);
                if(result>80){
                    sumcount++;
                }
                final User user = new User(0,sumtext,sumspeed,result,sumcount);
                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(AddUserActivity.this);
                        db.userDao().addUser(user);
                        finish();
                    }
                });
            }
        });
    }
}
