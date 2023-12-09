package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.league.R;

import java.util.List;

import ItemData.LeagueItem;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<LeagueItem> leagues;

    public Adapter(Context context, List<LeagueItem> leagues) {
        this.leagues = leagues;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_rv, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int i) {
        LeagueItem league = leagues.get(i);
        holder.tvLeagueName.setText(league.getStrLeague());

        // Jika ada lebih dari satu klub, Anda mungkin ingin menampilkan informasi klub pertama
        if (league.getClubs() != null && !league.getClubs().isEmpty()) {
            LeagueItem.ClubItem club = league.getClubs().get(0);
            holder.tvLeagueType.setText(club.getStrTeam());
            holder.tvLeagueCountry.setText(club.getStrCountry());
        } else {
            holder.tvLeagueType.setText("ada"); // Atau sesuaikan dengan teks default jika tidak ada klub
            holder.tvLeagueCountry.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeagueName, tvLeagueType, tvLeagueCountry;

        MyViewHolder(View view) {
            super(view);
            tvLeagueName = itemView.findViewById(R.id.tvLeagueName);
            tvLeagueType = itemView.findViewById(R.id.tvLeagueType);
            tvLeagueCountry = itemView.findViewById(R.id.tvLeagueCountry);
        }
    }
}
