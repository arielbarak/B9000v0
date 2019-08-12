package com.example.b9000v0.Comments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.b9000v0.R;
import com.example.b9000v0.Schema.Comment;

import java.util.GregorianCalendar;
import java.util.Vector;

public class CommentsFragment extends Fragment {

    private RecyclerView recycler_view;
    private LinearLayoutManager layout_manager;
    private CommentsListAdapter adapter;
    private Vector<Comment> comments = new Vector<>(); //TODO remove

    public CommentsFragment() {

    }

    Comment comment = new Comment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        recycler_view = view.findViewById(R.id.notifications_recycler_view);
        recycler_view.setHasFixedSize(true);

        layout_manager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(layout_manager);

        //TODO remove
        // -------------------------------------
        Comment c1 = new Comment();
        c1.setActionTime(new GregorianCalendar(2017, 6, 21, 8, 23, 45).getTime());
        c1.setContent("comment1");
        c1.setUserId("1");

        // -------------------------------------
        Comment c2 = new Comment();
        c2.setActionTime(new GregorianCalendar(2019, 8, 6, 20, 36, 00).getTime());
        c2.setContent("comment2");
        c2.setUserId("2");

        // -------------------------------------
        Comment c3 = new Comment();
        c3.setActionTime(new GregorianCalendar(2019, 8, 0, 0, 0, 0).getTime());
        c3.setContent("comment3");
        c3.setUserId("3");

        adapter = new CommentsListAdapter(comments);
        recycler_view.setAdapter(adapter);


        return view;
    }

}
