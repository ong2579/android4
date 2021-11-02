package org.techtown.android4;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

import org.techtown.android4.R;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener, FragmentCallback{


    FragmentNotice fragment_notice;
    FragmentEvent fragment_event;
    FragmentServiceCenter fragment_service_center;
    FragmentLogin fragment_login;
    FragmentDelivery fragment_delivery;
    FragmentCommunity fragment_community;
    FragmentExchange fragment_exchange;

    DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
//        왼쪽이랑 연결되어 있음. 아랫쪽도 연결해야 함.
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);

        fragment_notice = new FragmentNotice();
        fragment_event = new FragmentEvent();
        fragment_service_center = new FragmentServiceCenter();
        fragment_login = new FragmentLogin();
        fragment_delivery = new FragmentDelivery();
        fragment_community = new FragmentCommunity();
        fragment_exchange = new FragmentExchange();

        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment_notice).commit();


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu1) {
            Toast.makeText(this, "첫번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(0, null);
        } else if (id == R.id.menu2) {
            Toast.makeText(this, "두번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(1, null);
        } else if (id == R.id.menu3) {
            Toast.makeText(this, "세번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(2, null);
        } else if (id == R.id.menu4) {
            Toast.makeText(this, "네번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            onFragmentSelected(3, null);
        } else if (id == R.id.tab1) {
            Toast.makeText(this, "배달 쉐어링", Toast.LENGTH_LONG).show();
            onFragmentSelected(4, null);
//            transaction.replace(R.id.container, fragment_delivery).commitAllowingStateLoss();
        } else if (id == R.id.tab2) {
            Toast.makeText(this, "커뮤니티", Toast.LENGTH_LONG).show();
            onFragmentSelected(5, null);
        } else if (id == R.id.tab3) {
            Toast.makeText(this, "물물교환", Toast.LENGTH_LONG).show();
            onFragmentSelected(6, null);
        }


        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle) {
        Fragment curFragment = null;

        if (position == 0) {
            curFragment = fragment_notice;
            toolbar.setTitle("공지사항");
        } else if (position == 1) {
            curFragment = fragment_event;
            toolbar.setTitle("이벤트");
        } else if (position == 2) {
            curFragment = fragment_service_center;
            toolbar.setTitle("고객센터");
        } else if (position == 3) {
            curFragment = fragment_login;
            toolbar.setTitle("로그인");
        }else if (position == 4) {
            curFragment = fragment_delivery;
            toolbar.setTitle("배달쉐어링");
        } else if (position == 5) {
            curFragment = fragment_community;
            toolbar.setTitle("커뮤니티");
        } else if (position == 6) {
            curFragment = fragment_exchange;
            toolbar.setTitle("물물교환");
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }

}