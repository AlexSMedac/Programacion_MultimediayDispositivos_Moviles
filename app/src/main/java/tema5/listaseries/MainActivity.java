package tema5.listaseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSeries;
    private SerieAdapter serieAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected <Serie> void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewSeries = findViewById(R.id.recyclerSeries);

        ArrayList<Serie> listaSeries = new ArrayList<>();
        listaSeries.add(new Serie("Breaking Bad", "Drama / Crimen", R.drawable.breaking_bad));
        listaSeries.add(new Serie("Stranger Things", "Ciencia Ficción / Terror", R.drawable.stranger_things));
        listaSeries.add(new Serie("The Office", "Comedia", R.drawable.the_office));

        serieAdapter = new SerieAdapter(this, listaSeries);

        recyclerViewSeries.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewSeries.setLayoutManager(layoutManager);

        recyclerViewSeries.setAdapter(serieAdapter);
    }
}
