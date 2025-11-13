package tema5.listaseries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.SerieViewHolder> {

    private Context context;
    private List<Series> listaSeries;

    public SerieAdapter(Context context, List<Series> listaSeries) {
        this.context = context;
        this.listaSeries = listaSeries;
    }

    @NonNull
    @Override
    public SerieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_serie, parent, false);
        return new SerieViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieViewHolder holder, int position) {
        Series serie = listaSeries.get(position);
        holder.bindSerie(serie);
    }

    @Override
    public int getItemCount() {
        return (listaSeries != null) ? listaSeries.size() : 0;
    }

    public static class SerieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgSerie;
        private TextView txtTitulo;
        private TextView txtGenero;
        private Context context;

        public SerieViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            imgSerie = itemView.findViewById(R.id.imgSerie);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtGenero = itemView.findViewById(R.id.txtGenero);
        }

        public void bindSerie(Series serie) {
            txtTitulo.setText(serie.getTitulo());
            txtGenero.setText(serie.getGenero());
            imgSerie.setImageResource(serie.getImagen());
        }
    }
}
