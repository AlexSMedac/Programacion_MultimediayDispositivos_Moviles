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

    // 🔹 Atributos
    private Context context;
    private List<Serie> listaSeries;

    // 🔹 Constructor: recibe el contexto y la lista de series
    public SerieAdapter(Context context, List<Serie> listaSeries) {
        this.context = context;
        this.listaSeries = listaSeries;
    }

    // ============================================================
    // MÉTODOS OBLIGATORIOS DEL ADAPTADOR
    // ============================================================

    // 1️⃣ onCreateViewHolder(): crea un nuevo ViewHolder con el layout item_serie.xml
    @NonNull
    @Override
    public SerieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_serie, parent, false);
        return new SerieViewHolder(itemView, context);
    }

    // 2️⃣ onBindViewHolder(): enlaza los datos de la lista con las vistas del ViewHolder
    @Override
    public void onBindViewHolder(@NonNull SerieViewHolder holder, int position) {
        Serie serie = listaSeries.get(position);
        holder.bindSerie(serie);
    }

    // 3️⃣ getItemCount(): devuelve el número total de elementos de la lista
    @Override
    public int getItemCount() {
        return this.listaSeries.length;
    }

    // ============================================================
    // CLASE INTERNA VIEWHOLDER
    // ============================================================

    public static class SerieViewHolder extends RecyclerView.ViewHolder {

        // Atributos que representan las vistas del layout
        private ImageView imgSerie;
        private TextView txtTitulo;
        private TextView txtGenero;
        private Context context;

        // Constructor del ViewHolder
        public SerieViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;

            // Asociamos los elementos del XML con las variables
            imgSerie = itemView.findViewById(R.id.imgSerie);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtGenero = itemView.findViewById(R.id.txtGenero);
        }

        // Método que recibe una Serie y actualiza los datos visuales del layout
        public void bindSerie(Serie serie) {
            txtTitulo.setText(serie.getTitulo());
            txtGenero.setText(serie.getGenero());
            imgSerie.setImageResource(serie.getImagen());
        }
    }
}
