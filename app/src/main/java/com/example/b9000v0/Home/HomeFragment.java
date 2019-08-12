package com.example.b9000v0.Home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v0.R;
import com.example.b9000v0.Schema.Post;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class HomeFragment extends Fragment {

    private RecyclerView recycler_view;
    private LinearLayoutManager layout_manager;
    private PostListAdapter adapter;
    private Vector<Post> posts = new Vector<>(); //TODO remove

    public HomeFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recycler_view = view.findViewById(R.id.home_recycler_view);
        recycler_view.setHasFixedSize(true);

        layout_manager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(layout_manager);

        //TODO remove
        for (int i=0; i<10; i++)
        {
            Post post = new Post();
            post.setCaption("Caption number " + i);
            List<String> commentIds = new LinkedList<>();
            commentIds.add("1");
            commentIds.add("2");
            commentIds.add("2");
            post.setComments_list(commentIds);
            List<String> likes = new LinkedList<>();
            likes.add("11");
            likes.add("22");
            likes.add("23");
            post.setLiked_by_user_list(likes);
            post.setCreator_user_id("123123123");
            posts.add(post);
        }

        adapter = new PostListAdapter(posts);
        recycler_view.setAdapter(adapter);


        return view;
    }

}
