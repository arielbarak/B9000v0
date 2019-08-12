package com.example.b9000v0.Profile;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v0.Schema.Post;
import com.example.b9000v0.R;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


public class ProfileFragment extends Fragment {

    private Vector<Post> postsList = new Vector<>();
    private Vector<String> followingList = new Vector<>();
    private Vector<String> followersList = new Vector<>();

    private ImageViewAdapter adapter;
    private RecyclerView recycler_view;


    //Profile vars
    private TextView profile_username, profile_bio;
    private ImageView profile_image;
    private Button edit_profile_btn;

    private RecyclerView.LayoutManager layoutManager;

    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_username = view.findViewById(R.id.profile_username);
        profile_bio = view.findViewById(R.id.profile_bio);
        profile_image = view.findViewById(R.id.profile_image);
        edit_profile_btn = view.findViewById(R.id.profile_edit_profile_btn);

        for(int i=0; i<6; i++)
        {
            followingList.add(i + "");
            followersList.add("" + (i+20));
        }

        profile_username.setText("edgybob");
        profile_bio.setText("why is this do funny");

        recycler_view = view.findViewById(R.id.home_recycler_view);
        recycler_view.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getActivity(), 3);
        layoutManager.isAutoMeasureEnabled();
        recycler_view.setLayoutManager(layoutManager);

        //TODO remove
        for (int i=0; i<10; i++)
        {
            Post post = new Post();
            post.setCaption("Caption number " + i);
            List<String> commentIds = new LinkedList<String>();
            commentIds.add("1");
            commentIds.add("2");
            commentIds.add("2");
            post.setComments_list(commentIds);
            List<String> likes = new LinkedList<String>();
            likes.add("11");
            likes.add("22");
            likes.add("23");
            post.setLiked_by_user_list(likes);
            post.setCreator_user_id("123123123");
            postsList.add(post);
        }

        adapter = new ImageViewAdapter(postsList);
        recycler_view.setAdapter(adapter);

        return view;
    }



}
