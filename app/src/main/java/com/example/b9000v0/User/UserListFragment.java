package com.example.b9000v0.User;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v0.Schema.User;
import com.example.b9000v0.R;

import java.util.Vector;

public class UserListFragment extends Fragment {


    private RecyclerView recycler_view;
    private LinearLayoutManager layout_manager;
    private UserListAdapter adapter;
    private Vector<User> searched_users = new Vector<>(); //TODO remove

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recycler_view = view.findViewById(R.id.user_recycler_view);
        recycler_view.setHasFixedSize(true);

        layout_manager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(layout_manager);

        //TODO remove
        User u1 = new User();
        u1.setUsername("Ariel");
        // -------------------------------------
        User u2 = new User();
        u2.setUsername("Bob");
        // -------------------------------------
        User u3 = new User();
        u3.setUsername("Max");

        searched_users.add(u1);
        searched_users.add(u2);
        searched_users.add(u3);


        adapter = new UserListAdapter(searched_users);
        recycler_view.setAdapter(adapter);

        return view;
    }



}
