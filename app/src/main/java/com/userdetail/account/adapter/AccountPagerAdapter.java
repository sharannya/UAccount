package com.userdetail.account.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.userdetail.account.utils.AppConstant;
import com.userdetail.account.view.AccountFragment;

/**
 * Pager Adapter to display account related data
 */
public class AccountPagerAdapter extends FragmentPagerAdapter {
    private final String[] PAGE_TITLES = new String[]{
            "Accounts",
            "Active Accounts"
    };

    public AccountPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        AccountFragment accountFragment = new AccountFragment();
        Bundle arguments = null;
        switch (position) {
            case AppConstant.ALL_ACCOUNTS:
                arguments = new Bundle();
                arguments.putInt(AppConstant.INDEX, AppConstant.ALL_ACCOUNTS);
                accountFragment.setArguments(arguments);
                return accountFragment;

            case AppConstant.ACTIVE_ACCOUNTS:
                arguments = new Bundle();
                arguments.putInt(AppConstant.INDEX, AppConstant.ACTIVE_ACCOUNTS);
                accountFragment.setArguments(arguments);
                return accountFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }

}
