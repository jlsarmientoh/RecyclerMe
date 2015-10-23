package com.prodigious.science.fair.recycleme.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodigious.science.fair.recycleme.model.Challenge;

import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by jsarmien on 10/23/15.
 */
public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder> {

    private List<Challenge> challengeList;

    public ChallengeAdapter(List<Challenge> challengeList) {
        this.challengeList = challengeList;
    }

    @Override
    public ChallengeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_challenge, parent, false);

        ChallengeViewHolder viewHolder = new ChallengeViewHolder(v);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ChallengeViewHolder holder, int position) {
        Challenge challenge = this.challengeList.get(position);

        holder.setDescription(challenge.getDescription());
        holder.setImagePath(challenge.getImageUrl());
    }

    @Override
    public int getItemCount() {
        if(this.challengeList == null)
            return 0;

        return this.challengeList.size();
    }

    public static class ChallengeViewHolder extends RecyclerView.ViewHolder{

        private TextView txtChallengeDescription;
        private ImageView imageChallenge;


        public ChallengeViewHolder(View itemView) {
            super(itemView);
            this.txtChallengeDescription = (TextView) itemView.findViewById(R.id.txt_challenge_description);
            this.imageChallenge = (ImageView) itemView.findViewById(R.id.image_challenge);
        }

        public void setDescription(String description){
            this.txtChallengeDescription.setText(description);
        }

        public void setImagePath(String path){
            //TODO add code to load goal's image
        }
    }
}
