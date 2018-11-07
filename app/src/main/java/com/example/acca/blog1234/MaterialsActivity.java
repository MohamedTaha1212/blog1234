package com.example.acca.blog1234;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MaterialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);


        TextView title = (TextView) findViewById(R.id.activityTitle1);
        title.setText("This is Materials Activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.icon_materials:

                        break;

                    case R.id.icon_home:
                        Intent intent2 = new Intent(MaterialsActivity.this, MainActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.icon_blog:
                        Intent intent1 = new Intent(MaterialsActivity.this, BlogActivity.class);
                        startActivity(intent1);
                        break;


                }


                return false;
            }
        });
    }
}
