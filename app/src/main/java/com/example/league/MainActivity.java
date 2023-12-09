package com.example.league;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter;
import ApiClient.ApiClient;
import ItemData.LeagueItem;
import ApiClient.SoccerAPI;
import Leagueku.LeagueResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static SoccerAPI apiClient = ApiClient.getClient().create(SoccerAPI.class);
    private List<LeagueItem> leaguesItems = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvLeague);
        getLeagues(leaguesItems);
        adapter = new Adapter(this, leaguesItems);
        initRv();

    }

    public void getLeagues(final List<LeagueItem> leagues) {
        Call<LeagueResponse> leagueResponseCall = apiClient.getAllLeague();
        leagueResponseCall.enqueue(new Callback<LeagueResponse>() {
            @Override
            public void onResponse(Call<LeagueResponse> call, Response<LeagueResponse> response) {
                if (response.isSuccessful()) {
                    LeagueResponse leagueResponse = response.body();
                    if (leagueResponse != null && leagueResponse.getLeagues() != null && !leagueResponse.getLeagues().isEmpty()) {
                        leagues.addAll(leagueResponse.getLeagues());
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.d("NetworkCall", "Empty Data");
                    }
                } else {
                    // Handle response failure
                    Log.d("NetworkCall", "Response not successful");
                }
            }


            @Override
            public void onFailure(Call<LeagueResponse> call, Throwable t) {
                Log.d("NetworkCall", "Failed Fetch getLeague()/Failure");
            }
        });
            }


    public void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}