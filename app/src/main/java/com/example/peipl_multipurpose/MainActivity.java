package com.example.peipl_multipurpose;

import static android.app.UiModeManager.MODE_NIGHT_NO;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void perc_calc_activity(View v)
    {
        Toast.makeText(this, "Opening...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,percentage_page.class);
        startActivity(intent);
    }
    public void open_project(View v){
       Intent open_github = new Intent(Intent.ACTION_VIEW);
       open_github.setData(Uri.parse("https://github.com/peiplbackup/PEIPL-ALL-BILLS"));
       startActivity(open_github);
    }
    public void open_whatsapp(View v){

        Intent whatsapp_intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        if (whatsapp_intent != null) {
            startActivity(whatsapp_intent);
        }
       else{
            Toast.makeText(this, "Whatsapp is not installed in your phone", Toast.LENGTH_SHORT).show();
       }
    }

}