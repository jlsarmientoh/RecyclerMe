package com.prodigious.science.fair.recycleme.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prodigious.science.fair.recycleme.model.Goal;

import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by jsarmien on 10/22/15.
 */
public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {

    private List<Goal> goals;

    public GoalAdapter(List<Goal> goals) {
        this.goals = goals;
    }

    @Override
    public GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_goal, parent, false);

        GoalViewHolder viewHolder = new GoalViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GoalViewHolder holder, int position) {
        //TODO add bind code
        Goal goal = this.goals.get(position);
        holder.setDescription(goal.getDescription());
    }

    @Override
    public int getItemCount() {
        if(goals == null)
            return 0;

        return goals.size();
    }

    public static class GoalViewHolder extends RecyclerView.ViewHolder {

        private TextView txtGoalDescription;
        private ImageView imageGoal;


        public GoalViewHolder(View itemView) {
            super(itemView);
            this.txtGoalDescription = (TextView) itemView.findViewById(R.id.txt_goal_description);
            this.imageGoal = (ImageView) itemView.findViewById(R.id.image_goal);
        }

        public void setDescription(String description){
            this.txtGoalDescription.setText(description);
        }
    }
}
