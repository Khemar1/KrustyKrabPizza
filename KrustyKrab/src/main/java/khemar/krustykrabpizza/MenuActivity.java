package khemar.krustykrabpizza;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] imageResId = {
            R.drawable.pizza,
            R.drawable.slice,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();


    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(imageResId[0]);
        tabLayout.getTabAt(1).setIcon(imageResId[1]);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MenuFragment(), getString(R.string.menu));
        adapter.addFrag(new SpecialsFragment(), getString(R.string.specials));

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.wikihow.com/Order-a-Pizza-Over-the-Phone"));
                startActivity(intent);

                return true;
            case 2:
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://kkrab.com/menu"));
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


}

