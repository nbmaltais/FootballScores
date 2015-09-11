package barqsoft.footballscores;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;

import barqsoft.footballscores.api.ApiFetchService;

/**
 * Created by yehya khaled on 2/27/2015.
 */
public class MainFragment extends Fragment
{
    public static final int NUM_PAGES = 5;
    private static final String KEY_DATE = "DATE";
    public ViewPager mViewPager;
    private TabLayout mTabs;
    private MyPageAdapter mPagerAdapter;
    private ScoreListFragment[] mViewFragments = new ScoreListFragment[5];
    private String mCurrentDate;


    void fetchScoreIfNeeded()
    {
        String date = Utils.getCurrentDate();
        if(!date.equals(mCurrentDate))
        {
            mCurrentDate = Utils.getCurrentDate();

            ApiFetchService.fetchScores(getActivity());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null)
        {
            mCurrentDate = savedInstanceState.getString(KEY_DATE);
        }
        fetchScoreIfNeeded();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_DATE,mCurrentDate);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        // If the day changed since the last time, refetch fixtures and change fragment dates
        String date = Utils.getCurrentDate();
        if(!date.equals(mCurrentDate))
        {
            mCurrentDate = Utils.getCurrentDate();
            ApiFetchService.fetchScores(getActivity());

            for (int i = 0;i < NUM_PAGES;i++)
            {
                Date fragmentdate = new Date(System.currentTimeMillis()+((i-2)*86400000));
                SimpleDateFormat mformat = new SimpleDateFormat("yyyy-MM-dd");
                mViewFragments[i].setFragmentDate(mformat.format(fragmentdate));
            }
            mPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mTabs = (TabLayout) rootView.findViewById(R.id.tabs);
        mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPagerAdapter = new MyPageAdapter(getChildFragmentManager());
        for (int i = 0;i < NUM_PAGES;i++)
        {
            Date fragmentdate = new Date(System.currentTimeMillis()+((i-2)*86400000));
            SimpleDateFormat mformat = new SimpleDateFormat("yyyy-MM-dd");
            mViewFragments[i] = ScoreListFragment.newInstance(mformat.format(fragmentdate));
        }
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(MainActivity.current_fragment);

        mTabs.setupWithViewPager(mViewPager);

        return rootView;
    }


    private class MyPageAdapter extends FragmentStatePagerAdapter
    {
        @Override
        public int getItemPosition(Object object)
        {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int i)
        {
            return mViewFragments[i];
        }

        @Override
        public int getCount()
        {
            return NUM_PAGES;
        }

        public MyPageAdapter(FragmentManager fm)
        {
            super(fm);
        }
        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position)
        {
            return getDayName(getActivity(),System.currentTimeMillis()+((position-2)*86400000));
        }

        public String getDayName(Context context, long dateInMillis) {
            // If the date is today, return the localized version of "Today" instead of the actual
            // day name.

            Time t = new Time();
            t.setToNow();
            int julianDay = Time.getJulianDay(dateInMillis, t.gmtoff);
            int currentJulianDay = Time.getJulianDay(System.currentTimeMillis(), t.gmtoff);
            if (julianDay == currentJulianDay) {
                return context.getString(R.string.today);
            } else if ( julianDay == currentJulianDay +1 ) {
                return context.getString(R.string.tomorrow);
            }
             else if ( julianDay == currentJulianDay -1)
            {
                return context.getString(R.string.yesterday);
            }
            else
            {
                Time time = new Time();
                time.setToNow();
                // Otherwise, the format is just the day of the week (e.g "Wednesday".
                SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
                return dayFormat.format(dateInMillis);
            }
        }
    }
}
