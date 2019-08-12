package com.example.b9000v0.Profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v0.R;
import com.example.b9000v0.Schema.Post;

import java.util.Vector;


public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ImageCellViewHolder> {

    private Vector<Post> postsList; //TODO maybe to delete

    public ImageViewAdapter(Vector<Post> postsList) {
        this.postsList = postsList;
    }//TODO maybe to delete

    @NonNull
    @Override
    public ImageCellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image, parent, false);
        return new ImageCellViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageCellViewHolder holder, int position) {
        Post post = postsList.elementAt(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    static class ImageCellViewHolder extends RecyclerView.ViewHolder {

        ImageView image; // TODO reference to the real picture

        public ImageCellViewHolder(@NonNull View itemView) {

            super(itemView);

            image = itemView.findViewById(R.id.profile_grid_image);
        }

        public void bind(Post post){
            // TODO user the post's image
        }
    }
}
