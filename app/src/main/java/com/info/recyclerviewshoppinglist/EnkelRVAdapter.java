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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.info.recyclerviewcalismasi.R;

import java.util.List;



public class EnkelRVAdapter extends RecyclerView.Adapter<EnkelRVAdapter.CardViewHoldingDesignObjects> {

    private Context mContext;
    private List<String> countryOutList;

    public EnkelRVAdapter(Context mContext, List<String> countryOutList) {
        this.mContext = mContext;
        this.countryOutList = countryOutList;
    }

    public class CardViewHoldingDesignObjects extends RecyclerView.ViewHolder {
        public TextView lineText;
        public CardView lineCardView;
        public ImageView imageViewPicture;

        public CardViewHoldingDesignObjects(View view) {
            super(view);
            lineText = (TextView) view.findViewById(R.id.lineText);
            lineCardView = (CardView) view.findViewById(R.id.lineCardView);
            imageViewPicture = (ImageView) view.findViewById(R.id.imageViewPicture);

        }
    }

    @Override
    public CardViewHoldingDesignObjects onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_design, parent, false);

        return new CardViewHoldingDesignObjects(itemView);
    }


    @Override
    public void onBindViewHolder(final CardViewHoldingDesignObjects holder, final int position) {
        final String country = countryOutList.get(position);
        holder.lineText.setText(country.toString());

        holder.lineCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Country of choice : "+ country.toString(),Toast.LENGTH_SHORT).show();
            }
        });


        holder.imageViewPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(mContext, holder.imageViewPicture);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_enkelrv_card, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_remove:
                                Toast.makeText(mContext,"Remove : "+ country,Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_update:
                                Toast.makeText(mContext,"Update : "+ country,Toast.LENGTH_SHORT).show();
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
        return countryOutList.size();
    }

}


