package com.example.adam.score;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.adam.score.model.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class PlayerBoxAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<PlayerModel> playerList;

    public PlayerBoxAdapter(Context context, ArrayList<PlayerModel> playerList){
        this.mContext = context;
        this.playerList = playerList;
    }

    @Override
    public Object getItem(int position) {
        return this.playerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return this.playerList.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final PlayerViewHolder playerViewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.player_box, parent, false);
            playerViewHolder = new PlayerViewHolder(convertView);
            convertView.setTag(playerViewHolder);

        }
        else {
            playerViewHolder = (PlayerViewHolder)convertView.getTag();
        }

        PlayerModel player = this.playerList.get(position);

        playerViewHolder.playerName.setText(player.getPlayerName());
        playerViewHolder.playerId.setText(String.valueOf(player.getPlayerId()));
        playerViewHolder.playerScore.setText(String.valueOf(player.getPlayerScore()));

        playerViewHolder.scorePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer score = Integer.valueOf(playerViewHolder.playerScore.getText().toString()) + 1;
                playerViewHolder.playerScore.setText(String.valueOf(score));
            }
        });

        playerViewHolder.scoreMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer score = Integer.valueOf(playerViewHolder.playerScore.getText().toString()) - 1;
                playerViewHolder.playerScore.setText(String.valueOf(score));
            }
        });

        playerViewHolder.editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((Activity)mContext).getFragmentManager();
                DialogFragment editPlayerName = new EditPlayerName();
                Bundle bundle = new Bundle();
                bundle.putInt("playerId", position);
                editPlayerName.setArguments(bundle);
                editPlayerName.show(fragmentManager, "EditPlayerName");
            }
        });

        return convertView;
    }

    private class PlayerViewHolder {
        TextView playerName;
        TextView playerId;
        TextView playerScore;
        ImageButton scorePlus;
        ImageButton scoreMinus;
        ImageButton editName;

        public PlayerViewHolder(View view) {
            this.playerName = view.findViewById(R.id.player_name);
            this.playerId = view.findViewById(R.id.player_id);
            this.playerScore = view.findViewById(R.id.player_score);
            this.scorePlus = view.findViewById(R.id.score_plus);
            this.scoreMinus = view.findViewById(R.id.score_minus);
            this.editName = view.findViewById(R.id.edit_player_name);
        }
    }

}
