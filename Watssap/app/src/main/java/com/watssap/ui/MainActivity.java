package com.watssap.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.watssap.R;
import com.watssap.adapter.ContectAdapter;
import com.watssap.adapter.MyPagerAdapter;
import com.watssap.model.Contact;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Contact c = new Contact();
        c.setId(2);
        c.setName("Jose");
        ArrayList<Contact> contacts = new ArrayList();
        contacts.add(c);

        ContectAdapter adapter = new ContectAdapter(this, contacts);
        RecyclerView recycleview = findViewById(R.id.recycleViewContacts);
        recycleview.setAdapter(adapter);


        ViewPager viewPager = findViewById(R.id.viewPager);
        FragmentManager fm = getSupportFragmentManager();
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(fm, this);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        for(int i=0;i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTableView(i));
        }
    }
}
