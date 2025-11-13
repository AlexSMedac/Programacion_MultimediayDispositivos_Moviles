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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewSeries = findViewById(R.id.recyclerSeries);

        ArrayList<Series> listaSeries = new ArrayList<>();
        listaSeries.add(new Series("Breaking Bad", "Drama / Crimen", R.drawable.bb));
        listaSeries.add(new Series("Stranger Things", "Ciencia Ficción / Terror", R.drawable.st));
        listaSeries.add(new Series("The Office", "Comedia", R.drawable.to));

        serieAdapter = new SerieAdapter(this, listaSeries);

        recyclerViewSeries.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewSeries.setLayoutManager(layoutManager);

        recyclerViewSeries.setAdapter(serieAdapter);
    }
}
