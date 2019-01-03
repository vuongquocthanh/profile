package android.vuongquocthanh.profile.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.vuongquocthanh.profile.R;
import android.vuongquocthanh.profile.ui.fragment.FragmentCalendar;
import android.vuongquocthanh.profile.ui.fragment.FragmentHome;
import android.vuongquocthanh.profile.ui.fragment.FragmentMessage;
import android.vuongquocthanh.profile.ui.fragment.FragmentMore;
import android.vuongquocthanh.profile.ui.fragment.FragmentNotification;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout framelayout;
    private BottomNavigationView bnvMain;

    FragmentHome fragmentHome;
    FragmentCalendar fragmentCalendar;
    FragmentMessage fragmentMessage;
    FragmentMore fragmentMore;
    FragmentNotification fragmentNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        showFragment(fragmentHome);
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        showFragment(fragmentHome);
                        return true;
                    case R.id.calendar:
                        showFragment(fragmentCalendar);
                        return true;
                    case R.id.message:
                        showFragment(fragmentMessage);
                        return true;
                    case R.id.notification:
                        showFragment(fragmentNotification);
                        return true;
                    case R.id.more:
                        showFragment(fragmentMore);
                        return true;
                }
                return false;
            }
        });
    }

    private void initViews(){
        framelayout = findViewById(R.id.framelayout);
        bnvMain = findViewById(R.id.bnvMain);
        fragmentHome = new FragmentHome();
        fragmentCalendar = new FragmentCalendar();
        fragmentMessage = new FragmentMessage();
        fragmentMore = new FragmentMore();
        fragmentNotification = new FragmentNotification();
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        ft.commit();
    }
}
