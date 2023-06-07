package com.example.hhsprime;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.hhsprime.adapters.ShowAdapter;
import com.example.hhsprime.models.Show;
import java.util.ArrayList;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;
    private List<Show> shows = new ArrayList<>();
    private ShowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        RecyclerView recyclerView = findViewById(R.id.overview_list_rv_id);
        adapter = new ShowAdapter(shows);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        shows.addAll(Show.getAll(this));
        adapter.notifyDataSetChanged();

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    shows.clear();
                    shows.addAll(Show.getAll(this));
                    adapter.notifyDataSetChanged();
                    System.out.println(result.getData().getStringExtra("MESSAGE"));
                });

        findViewById(R.id.overview_show_btn_id).setOnClickListener(view -> {
            Intent intent = new Intent(this, AddShowActivity.class);
            launcher.launch(intent);
        });

        findViewById(R.id.overview_character_btn_id).setOnClickListener(view -> {
            Intent intent = new Intent(this, AddCharacterActivity.class);
            launcher.launch(intent);
        });
    }
}
