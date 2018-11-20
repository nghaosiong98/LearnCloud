package com.academy.tacocat.learncloud;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    TutorialFragment tutorialFragment;
    WhyFragment whyFragment;
    AboutFragment aboutFragment;
    MenuItem prevMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation1:
//                        TutorialFragment tutorialFragment = new TutorialFragment();
//                        FragmentManager manager1 = getSupportFragmentManager();
//                        manager1.beginTransaction().replace(R.id.contentLayout, tutorialFragment, tutorialFragment.getTag()).commit();
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation2:
//                        WhyFragment whyFragment = new WhyFragment();
//                        FragmentManager manager2 = getSupportFragmentManager();
//                        manager2.beginTransaction().replace(R.id.contentLayout, whyFragment, whyFragment.getTag()).commit();
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation3:
//                        AboutFragment aboutFragment = new AboutFragment();
//                        FragmentManager manager3 = getSupportFragmentManager();
//                        manager3.beginTransaction().replace(R.id.contentLayout, aboutFragment, aboutFragment.getTag()).commit();
                        viewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation1);
        }

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TutorialFragment());
        adapter.addFragment(new WhyFragment());
        adapter.addFragment(new AboutFragment());
        viewPager.setAdapter(adapter);
    }

}
