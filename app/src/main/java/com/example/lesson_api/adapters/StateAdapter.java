package com.example.lesson_api.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson_api.R;
import com.example.lesson_api.models.State;
import com.bumptech.glide.Glide;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {

    private Context context;
    private List<State> stateList;

    public StateAdapter(Context context, List<State> stateList) {
        this.context = context;
        this.stateList = stateList;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_state, parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {
        State state = stateList.get(position);

        holder.textName.setText(state.getName());
        holder.textNativeName.setText(state.getNativeName());


        Glide.with(context)
                .load(state.getFlag())
                .into(holder.imageFlag);
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class StateViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFlag;
        TextView textName;
        TextView textNativeName;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFlag = itemView.findViewById(R.id.image_flag);
            textName = itemView.findViewById(R.id.text_name);
            textNativeName = itemView.findViewById(R.id.text_native_name);
        }
    }
}