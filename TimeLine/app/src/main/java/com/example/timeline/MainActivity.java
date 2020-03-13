package com.example.timeline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NewsListAdapter.AddToFavListener, NewsListAdapter.RemoveNewsListener, NewsListAdapter.RemoveFromHomeListener {


    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;


    List<Fragment> fragments;

    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new FavouritesFragment();
    final FragmentManager fm = getSupportFragmentManager();
   // Fragment active = fragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ArrayList<>();
        fragments.add(fragment1);
        fragments.add(fragment2);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(fm, fragments);
        viewPager.setAdapter(pagerAdapter);

        BottomNavigationView bottomNav = findViewById(R.id.bottm_navigaion);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        //fm.beginTransaction().add(R.id.main1, fragment2, "2").hide(fragment2).commit();
        //fm.beginTransaction().add(R.id.main1,fragment1, "1").commit();


    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                  //  Fragment selectedFragment = null;


                    switch (item.getItemId()) {
                        case R.id.home:
                           // fm.beginTransaction().hide(active).show(fragment1).commit();
                            //active = fragment1;
                            viewPager.setCurrentItem(0, false);
                            return true;

                        case R.id.favourites:
                            //fm.beginTransaction().hide(active).show(fragment2).commit();
                            //active = fragment2;
                            viewPager.setCurrentItem(1, false);
                            return true;
                    }


                    return false;

                }
            };

    @Override
    public void sendNews(News news) {
        Toast toast = Toast.makeText(this, "Added to Starred",Toast.LENGTH_SHORT);
        toast.show();

       // Fragment fragment = getSupportFragmentManager().findFragmentByTag("2");
        Fragment fragment = fragments.get(1);
        ((FavouritesFragment)fragment).addNews(news);

    }

    @Override
    public void removeFromFavNews(News news) {

        Fragment fragment = fragments.get(1);

        //Fragment fragment = getSupportFragmentManager().findFragmentByTag("2");
        ((FavouritesFragment)fragment).removeNews(news);

        fragment = fragments.get(0);

        //fragment = getSupportFragmentManager().findFragmentByTag("1");
        ((HomeFragment)fragment).updateLikes(news);

    }

    @Override
    public void removeFromHomeNews(News news) {

        Toast toast = Toast.makeText(this, "Removed from Starred", Toast.LENGTH_SHORT);
        toast.show();

        Fragment fragment = fragments.get(1);
        //Fragment fragment = getSupportFragmentManager().findFragmentByTag("2");
        ((FavouritesFragment)fragment).findRemoveNews(news);
    }
}


