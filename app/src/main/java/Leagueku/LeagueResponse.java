package Leagueku;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ItemData.LeagueItem;



public class LeagueResponse {

        @SerializedName("leagues")
        private List<LeagueItem> leagues;

        public List<LeagueItem> getLeagues() {
            return leagues;
        }

        public void setLeagues(List<LeagueItem> leagues) {
            this.leagues = leagues;
        }

    }
