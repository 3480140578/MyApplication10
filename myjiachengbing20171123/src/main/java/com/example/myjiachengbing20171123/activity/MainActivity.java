package com.example.myjiachengbing20171123.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.myjiachengbing20171123.R;
import com.example.myjiachengbing20171123.fragment.fragmentfour;
import com.example.myjiachengbing20171123.fragment.fragmentone;
import com.example.myjiachengbing20171123.fragment.fragmentthree;
import com.example.myjiachengbing20171123.fragment.fragmenttwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends FragmentActivity {
    List<Fragment> listfrag;
    @BindView( R.id.vp )
    public ViewPager vp ;

    @BindView( R.id.rg )
    public RadioGroup rg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        initdata();
        myfragmentadapter adapter = new myfragmentadapter(
                getSupportFragmentManager());
        vp.setAdapter(adapter);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);

                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);

                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3);

                        break;

                    default:
                        break;
                }

            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                switch (arg0) {
                    case 0:
                        rg.check(R.id.rb1);
                        break;
                    case 1:
                        rg.check(R.id.rb2);

                        break;
                    case 2:
                        rg.check(R.id.rb3);

                        break;
                    case 3:
                        rg.check(R.id.rb4);

                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }





    private void initdata() {
        listfrag = new ArrayList<Fragment>();
        listfrag.add(new fragmentone());
        listfrag.add(new fragmenttwo());
        listfrag.add(new fragmentthree());
        listfrag.add(new fragmentfour());

    }
    class myfragmentadapter extends FragmentPagerAdapter {


        public myfragmentadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            return listfrag.get(arg0);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return listfrag.size();
        }

    }

}


