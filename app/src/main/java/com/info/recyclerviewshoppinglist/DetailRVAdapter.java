package com.info.recyclerviewshoppinglist;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.info.recyclerviewcalismasi.R;

import java.util.List;



public class DetailRVAdapter extends RecyclerView.Adapter<DetailRVAdapter.CardViewHolderDesignObjects> {

    private Context mContext;
    private List<Movies> movieOutList;

    public DetailRVAdapter(Context mContext, List<Movies> moveOutList) {
        this.mContext = mContext;
        this.movieOutList = moveOutList;
    }

    public class CardViewHolderDesignObjects extends RecyclerView.ViewHolder {
        public TextView textViewMovTitle;
        public TextView textViewMovPrice;
        public Button buttonaddShoppingCart;
        public ImageView imageViewMovPicture;
        public ImageView imageViewPoPicture;
        public CardView lineCardView;

        public CardViewHolderDesignObjects(View view) {
            super(view);
            textViewMovTitle = (TextView) view.findViewById(R.id.textViewMovTitle);
            textViewMovPrice = (TextView) view.findViewById(R.id.textViewMovPrice);
            imageViewMovPicture = (ImageView) view.findViewById(R.id.imageViewMovPicture);
            imageViewPoPicture = (ImageView) view.findViewById(R.id.imageViewPoPicture);
            buttonaddShoppingCart= (Button) view.findViewById(R.id.buttonaddShoppingCart);
            lineCardView = (CardView) view.findViewById(R.id.satirCardViewFilm);
        }
    }

    @Override
    public CardViewHolderDesignObjects onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_movie_design, parent, false);

        return new CardViewHolderDesignObjects(itemView);
    }


    @Override
    public void onBindViewHolder(final CardViewHolderDesignObjects holder, final int position) {
        final Movies film = movieOutList.get(position);
        holder.textViewMovTitle.setText(film.getMovName().toString());

        holder.textViewMovPrice.setText(String.valueOf(film.getPrice()));

        holder.lineCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Your selected movie : "+ film.getMovName().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.buttonaddShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,film.getMovName().toString()+ " Added to Cart. ",Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageViewMovPicture.setImageResource(mContext.getResources().getIdentifier(movieOutList.get(position).getPicture()
                ,"drawable", mContext.getPackageName()));

        holder.imageViewPoPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(mContext, holder.imageViewPoPicture);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_card, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_sale:
                                Toast.makeText(mContext,"Your selected movie : "+ film.getMovName().toString()+" Will Go Discount",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_detail:
                                Toast.makeText(mContext,"Your selected movie: "+ film.getMovName().toString()+"Detail shown ",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                        }
                        return false;
                    }
                });
            }
        });

    }


    @Override
    public int getItemCount() {
        return movieOutList.size();
    }

}

