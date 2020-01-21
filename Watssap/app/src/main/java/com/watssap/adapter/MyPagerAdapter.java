package com.watssap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.watssap.fragments.ContactsFragments;
import com.watssap.R;
import com.watssap.fragments.ConversaFragment;
import com.watssap.fragments.PerfilFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final Context context;
    String[] tabs = new String[]{"Contatos", "Chats", "Prefil"};

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new ContactsFragments();
            case 1:
                return new ConversaFragment();
            case 2:
                return new PerfilFragment();

            default :
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    public View getTableView(int position) {

        View tab = LayoutInflater.from(context).inflate(R.layout.custom_tabs, null);
        TextView t = tab.findViewById(R.id.txvTabs);
        t.setText(getPageTitle(position));

        return tab;
    }
}
