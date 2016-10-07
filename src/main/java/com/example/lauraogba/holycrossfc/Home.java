package com.example.lauraogba.holycrossfc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView splash = (TextView) findViewById(R.id.splash_top);
        ImageView splash_image = (ImageView)
                findViewById(R.id.splash_image);
        TextView version = (TextView) findViewById(R.id.version);

        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        Animation spinin = AnimationUtils.loadAnimation(this,
                R.anim.custom_anim);
        fade2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {

                Intent intent = new Intent(new Intent(Home.this,
                        Register.class));
                startActivity(intent);
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });

        splash.startAnimation(fade1);
        splash_image.startAnimation(spinin);
        version.startAnimation(fade2);


        //  setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onPause() {
        super.onPause();

        TextView splash = (TextView) findViewById(R.id.splash_top);
        ImageView splash_image = (ImageView)
                findViewById(R.id.splash_image);
        TextView version = (TextView) findViewById(R.id.version);

        splash.clearAnimation();
        splash_image.clearAnimation();
        version.clearAnimation();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
