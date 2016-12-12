package br.com.fernandescruz.times.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.fernandescruz.times.fragments.TimesFragment;

/**
 * Created by claudiocruz on 19/11/16.
 */

public class TabAdapter extends FragmentStatePagerAdapter{

    public static final int TOTAL_TABS = 1;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new TimesFragment();
        return f;
    }

    @Override
    public int getCount() {

        return TOTAL_TABS;
    }
}
