package com.example.hhsprime.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hhsprime.R;
import com.example.hhsprime.models.Show;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder>{
    private List<Show> data;
    public ShowAdapter(List<Show> data) {
        this.data = data;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder object.
     * It inflates the item layout and creates a new ViewHolder.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the item layout.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_row, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * It binds the data to the views in the ViewHolder.
     *
     * @param holder   The ViewHolder that should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Show show = data.get(position);
        holder.showNameTf.setText(show.getName());
        String characterName = show.getMainCharacter() != null ?
                show.getMainCharacter().getName() :
                null;
        holder.characterNameTf.setText(characterName);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * ViewHolder class that represents each item in the RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView showNameTf;
        private TextView characterNameTf;

        /**
         * Constructor for the ViewHolder.
         *
         * @param itemView The item view for the ViewHolder.
         */
        public ViewHolder(View itemView) {
            super(itemView);
            showNameTf = itemView.findViewById(R.id.showRow_showName_tf);
            characterNameTf = itemView.findViewById(R.id.showRow_showCharacter_tf);
        }

    }
}

