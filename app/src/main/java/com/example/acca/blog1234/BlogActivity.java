package com.example.acca.blog1234;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BlogActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        BlogQuery.ArticlesAsyncTask task = new BlogQuery.ArticlesAsyncTask();
        task.execute();



        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.ic_launcher_foreground);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_launcher_foreground);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_launcher_foreground);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_launcher_foreground);








        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        menu = bottomNavigationView.getMenu();
        menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.icon_blog:

                        break;

                    case R.id.icon_home:
                        Intent intent1 = new Intent(BlogActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.icon_materials:
                        Intent intent2 = new Intent(BlogActivity.this, MaterialsActivity.class);
                        startActivity(intent2);
                        break;


                }


                return false;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MarketingFragment());
        adapter.addFragment(new SoftSkillsFragment());
        adapter.addFragment(new DesignFragment());
        adapter.addFragment(new WebFragment());
        viewPager.setAdapter(adapter);
    }
}
