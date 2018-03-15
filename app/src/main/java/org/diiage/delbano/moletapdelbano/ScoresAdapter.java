package org.diiage.delbano.moletapdelbano;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bastien on 15/03/2018.
 */

public class ScoresAdapter extends BaseAdapter {
    ArrayList<Score> scores;
    Activity activity;

    public ScoresAdapter (Activity activity, ArrayList<Score> scores){
        this.activity = activity;
        this.scores = scores;
    }

    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int i) {
        return scores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        LayoutInflater inflater = this.activity.getLayoutInflater();
        if (view == null){
            view = inflater.inflate(R.layout.item_score, viewGroup, false);

            holder = new ViewHolder();
            holder.tvPointCount = (TextView)view.findViewById(R.id.tvPointCount);
            holder.tvMoleMissed = (TextView)view.findViewById(R.id.tvMoleMissed);
            holder.tvReactionTimeMax = (TextView)view.findViewById(R.id.tvReactionTimeMax);
            holder.tvReactionTimeMin = (TextView)view.findViewById(R.id.tvReactionTimeMin);
            holder.tvReactionTimeAvg = (TextView)view.findViewById(R.id.tvReactionTimeAvg);

            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }

        Score score = (Score)getItem(i);

        holder.tvPointCount.setText(String.valueOf(score.getPointCount()));
        holder.tvMoleMissed.setText(String.valueOf(score.getMoleMissed()));
        holder.tvReactionTimeMax.setText(String.valueOf(score.getReactionTimeMax()));
        holder.tvReactionTimeMin.setText(String.valueOf(score.getReactionTimeMax()));
        holder.tvReactionTimeAvg.setText(String.valueOf(score.getReactionTimeMax()));

        return view;
    }

    private static class ViewHolder {
        public TextView tvPointCount;
        public TextView tvMoleMissed;
        public TextView tvReactionTimeMax;
        public TextView tvReactionTimeMin;
        public TextView tvReactionTimeAvg;

    }
}
