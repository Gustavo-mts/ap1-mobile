package br.ufc.quixada.usoroomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import br.ufc.quixada.usoroomdatabase.models.person;
import br.ufc.quixada.usoroomdatabase.R;

public class personAdapter extends RecyclerView.Adapter<personAdapter.personViewHolder> {

    private List<person> persons;

    public personAdapter(List<person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public personViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person, parent, false);
        return new personViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull personViewHolder holder, int position) {
        person person = persons.get(position);
        holder.titulo.setText(person.nome);
        holder.descricao.setText(person.curso);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void removeperson(int position) {
        persons.remove(position);
        notifyItemRemoved(position);
    }

    public void addperson(person person) {
        persons.add(person);
        notifyItemInserted(persons.size() - 1);
    }

    public person getpersonAt(int position) {
        return persons.get(position);
    }

    public class personViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, descricao;

        public personViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            descricao = itemView.findViewById(R.id.descricao);

        }
    }
}
