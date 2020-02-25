package com.example.timeline;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<News> newsList;
    Context c;


    public NewsListAdapter(List<News> newsList, Context c) {
        this.newsList = newsList;
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
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {
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


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void itemClick(View view, int position) {

                Intent intent = new Intent(c,NewsOnClickActivity.class);
                intent.putExtra("news", news);
                c.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }



    //newsHolder class
    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ItemClickListener listener;

        TextView tvName;
        TextView tvDate;
        TextView tvText;
        TextView tvCommentsCount;
        TextView tvLikesCount;
        TextView tvRepostCount;
        TextView tvViewsCount;
        ImageView tvImage;

        //ImageView like;
        boolean clicked = false;

        NewsViewHolder(@NonNull View itemView){
            super(itemView);

            tvName = itemView.findViewById(R.id.autor);
            tvDate = itemView.findViewById(R.id.date);
            tvText = itemView.findViewById(R.id.vText);
            tvCommentsCount = itemView.findViewById(R.id.comment_text);
            tvLikesCount = itemView.findViewById(R.id.like_text);
            tvRepostCount = itemView.findViewById(R.id.shre_text);
            tvViewsCount = itemView.findViewById(R.id.view_text);
            tvImage = itemView.findViewById(R.id.imageView3);

            ImageView like = itemView.findViewById(R.id.like_btn);


            like.setOnClickListener(viewOnClick);
            tvLikesCount.setOnClickListener(viewOnClick);

            itemView.setOnClickListener(this);

        }

        View.OnClickListener viewOnClick = new View.OnClickListener(){
            public void onClick(View v){

                ImageView like = itemView.findViewById(R.id.like_btn);
                if(!clicked) {
                    like.setImageResource(R.drawable.blueheart);
                    int s = Integer.parseInt(tvLikesCount.getText().toString()) + 1;
                    tvLikesCount.setText(String.valueOf(s));
                    tvLikesCount.setTextColor(Color.parseColor("#3B6FA1"));
                    Toast toast = Toast.makeText(c, "Добавлено в избранное", Toast.LENGTH_SHORT);
                    toast.show();
                    clicked = true;
                }else{
                    like.setImageResource(R.drawable.heart);
                    int s = Integer.parseInt(tvLikesCount.getText().toString()) - 1;
                    tvLikesCount.setText(String.valueOf(s));
                    tvLikesCount.setTextColor(Color.parseColor("#A6A9B0"));
                    clicked = false;

                }
            }
        };


        @Override
        public void onClick(View view) {

            this.listener.itemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic){
            this.listener=ic;
        }
    }
}

