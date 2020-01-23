package com.example.myapplicationfragments;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new MessageFragment.DemoPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));

        final TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Comments");
        tabLayout.getTabAt(1).setText("Friends");

//        Button buttonSports= view.findViewById(R.id.btn_sports);
//        buttonSports.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.newsFragment);
//                tabLayout.getTabAt(1).setText(category[0]);
//            }
//        });
    }

    static class DemoPagerAdapter extends FragmentPagerAdapter {

        public DemoPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new MessageCommentFragment();
            else return new MessageFriendFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

    }

}
