package azdev.cgpacalculator;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import azdev.cgpacalculator.fragment.About;
import azdev.cgpacalculator.fragment.CGPA;
import azdev.cgpacalculator.helper.BottomBarAdapter;

public class MainActivity extends AppCompatActivity {

    private AHBottomNavigationViewPager viewPager;
    private AHBottomNavigation bottomNavigation;
    private BottomBarAdapter adapter;

    private ActionBar actionBar;
    private TextView title1;
    private RelativeLayout.LayoutParams layoutparams;

    private CGPA fragment1 = new CGPA();
    private About fragment2 = new About();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPager();
        setupBottomNavigation();


    }

    private void setupBottomNavigation(){

        bottomNavigation = findViewById(R.id.navigation);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Home", R.drawable.ic_001_technology_4, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("About", R.drawable.p1_2, R.color.color_tab_3);
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);


        bottomNavigation.setTranslucentNavigationEnabled(false);
        bottomNavigation.setBehaviorTranslationEnabled(true);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (!wasSelected){

                    viewPager.setCurrentItem(position);
                }
                if(position == 0){

//                    actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM );
//                    actionBar.setCustomView(R.layout.custom_logo);
                }
                if(position == 1){

//                    ActionBarTitleGravity("Undi");


                }
                if(position == 2){

//                    ActionBarTitleGravity("Info");
                }
                return true;
            }
        });
    }

    private void setupViewPager(){

        viewPager = findViewById(R.id.content_fragment);
        viewPager.setPagingEnabled(false);
        adapter = new BottomBarAdapter(getSupportFragmentManager());
        adapter.addFragments(fragment1);
        adapter.addFragments(fragment2);
        viewPager.setAdapter(adapter);
    }

    private void ActionBarTitleGravity(String title) {
        // TODO Auto-generated method stub


        title1 = new TextView(this);

        layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        title1.setLayoutParams(layoutparams);
        title1.setText(title);
        title1.setTextColor(Color.BLACK);
        title1.setGravity(Gravity.CENTER);
        title1.setTextSize(20);
        title1.setTypeface(Typeface.DEFAULT_BOLD);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(title1);

    }
}
