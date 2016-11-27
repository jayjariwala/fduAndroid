package com.example.jay.tablayoutapp;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.view);

        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(),MainActivity.this));
        TabLayout layout=(TabLayout) findViewById(R.id.sliding_tabs);
        layout.setupWithViewPager(viewPager);

        // set tab title
        String[] tabtitiles=new String[]{"Car Type","Days"};
        for(int i=0;i<layout.getTabCount();i++)
        {
            layout.getTabAt(i).setText(tabtitiles[i]);
        }

    }

    public class TabAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT=2;
        private Context mContext;

        public TabAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext=context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();

            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }



}
