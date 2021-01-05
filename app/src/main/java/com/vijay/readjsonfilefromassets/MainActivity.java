package com.vijay.readjsonfilefromassets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "bezkoder.json");
        Log.i("data", jsonFileString);
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<User>>() {
        }.getType();
        List<User> users = gson.fromJson(jsonFileString, listUserType);
        for (int i = 0; i < users.size(); i++) {
            Log.i("data", "> Item " + i + "\n" + users.get(i));
        }
    }
}