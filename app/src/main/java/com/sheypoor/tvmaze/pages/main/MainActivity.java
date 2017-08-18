package com.sheypoor.tvmaze.pages.main;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sheypoor.tvmaze.R;
import com.sheypoor.tvmaze.app.di.DependencyInjector;
import com.sheypoor.tvmaze.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MoviesListFragment fragment=MoviesListFragment.Companion.newInstance();
        ActivityUtils.INSTANCE.replaceFragment(getSupportFragmentManager(),fragment,R.id.listFragmentHolder);
        DependencyInjector.INSTANCE.getMainComponent().inject(this);

        setSupportActionBar(toolbar);

        toolbar.setTitle("Tv Maze");
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));

        new MoviesListFragmentPresenter(fragment);
    }
}
