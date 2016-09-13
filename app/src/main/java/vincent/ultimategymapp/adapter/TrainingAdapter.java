package vincent.ultimategymapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vincent.ultimategymapp.R;
import vincent.ultimategymapp.model.Training;

/**
 * Created by Vincent on 2016-09-06.
 */
public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.Holder> {

    private final Context context;

    private ArrayList<Training> trainings;

    public ArrayList<Training> getItemsTraining() {
        return trainings;
    }

    public void setItemsTraining(ArrayList<Training> itemsTraining) {
        this.trainings = itemsTraining;
        notifyDataSetChanged();
    }

    public TrainingAdapter(Context context) {
        this.context = context;
    }

    // Ajout d'un item a la fin de la liste
    public void add(Training training) {
        trainings.add(training);
        notifyItemInserted(trainings.size() - 1);
    }

    // Ajout d'un item a une position précise
    public void addAtPosition(Training training, int position) {
        trainings.add(position, training);
        notifyItemInserted(position);
    }

    // Méthode appelé par le layout manager du recycle view
    // Elle créé le holder que on utilise
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_training, parent, false));
    }

    // Called by the RecyclerView to show data at a specific position
    @Override
    public void onBindViewHolder(TrainingAdapter.Holder holder, int position) {
        if (getItemCount() != 0) {
            holder.name.setText(trainings.get(position).getNom());
        }
    }

    // Retourne le nombre d'item dans la structure de données
    @Override
    public int getItemCount() {
        if (trainings == null)
            return 0;
        else
            return trainings.size();
    }

    @Override
    public void onViewRecycled(Holder holder) {
        holder.trainings.setOnClickListener(null);
        super.onViewRecycled(holder);
    }

    public void setSelected(int position, boolean value) {
        trainings.get(position).selected = value;
        notifyItemChanged(position);
    }


    // Prototype utilisé pour chaque item de la liste
    public class Holder extends RecyclerView.ViewHolder {

        CardView trainings;
        TextView name;

        // Construction de notre prototype. Va être appellé par onCreateViewHolder.
        public Holder(View itemView) {
            super(itemView);

            trainings = (CardView) itemView.findViewById(R.id.card);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
