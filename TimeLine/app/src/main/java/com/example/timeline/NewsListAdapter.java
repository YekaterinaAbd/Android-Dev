package com.example.timeline;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<News> newsList;
    private ItemClickListener listener;

    boolean clicked = false;
    Context c;


    public NewsListAdapter(List<News> newsList, @Nullable ItemClickListener listener, Context c) {
        this.newsList = newsList;
        this.listener = listener;
        this.c = c;
    }


    @NonNull
    @Override
    // Create new views (invoked by the layout manager)
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, null, false);


        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);

        return new NewsViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final News news = newsList.get(position);

        holder.tvName.setText(news.getName());
        holder.tvDate.setText(news.getDate());
        holder.tvText.setText(news.getText());

        holder.tvViewsCount.setText(String.valueOf(news.getViewsCount()));
        holder.tvRepostCount.setText(String.valueOf(news.getRepostsCount()));
        holder.tvLikesCount.setText(String.valueOf(news.getLikesCount()));
        holder.tvCommentsCount.setText(String.valueOf(news.getCommentsCount()));

        holder.tvImage.setImageResource(news.getImg());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, news);
                }
            }
        });

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!clicked) {
                    holder.like.setImageResource(R.drawable.blueheart);
                    int s = Integer.parseInt(holder.tvLikesCount.getText().toString()) + 1;
                    holder.tvLikesCount.setText(String.valueOf(s));
                    holder.tvLikesCount.setTextColor(Color.parseColor("#3B6FA1"));
                    Toast toast = Toast.makeText(c, "Добавлено в избранное", Toast.LENGTH_SHORT);
                    toast.show();
                    clicked = true;
                }else{
                    holder.like.setImageResource(R.drawable.heart);
                    int s = Integer.parseInt(holder.tvLikesCount.getText().toString()) - 1;
                    holder.tvLikesCount.setText(String.valueOf(s));
                    holder.tvLikesCount.setTextColor(Color.parseColor("#A6A9B0"));
                    clicked = false;
            }
        }
    });

    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public int getItemViewType(int position) {
        return position;
    }

    //newsHolder class
    public class NewsViewHolder extends RecyclerView.ViewHolder{


       final TextView tvName;
        TextView tvDate;
        TextView tvText;
        TextView tvCommentsCount;
        TextView tvLikesCount;
        TextView tvRepostCount;
        TextView tvViewsCount;
        ImageView tvImage;

       final ImageView like;

        NewsViewHolder(@NonNull View itemView) {

            super(itemView);

            tvName = itemView.findViewById(R.id.autor);
            tvDate = itemView.findViewById(R.id.date);
            tvText = itemView.findViewById(R.id.vText);
            tvCommentsCount = itemView.findViewById(R.id.comment_text);
            tvLikesCount = itemView.findViewById(R.id.like_text);
            tvRepostCount = itemView.findViewById(R.id.shre_text);
            tvViewsCount = itemView.findViewById(R.id.view_text);
            tvImage = itemView.findViewById(R.id.imageView3);

            like = itemView.findViewById(R.id.like_btn);

        }
    }

    interface ItemClickListener {
        void itemClick(int position, News item);
    }

}

