package ItemData;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LeagueItem {

    @SerializedName("name")
    private String strLeague;

    @SerializedName("clubs")
    private List<ClubItem> clubs;

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public List<ClubItem> getClubs() {
        return clubs;
    }

    public void setClubs(List<ClubItem> clubs) {
        this.clubs = clubs;
    }

    public static class ClubItem {

        @SerializedName("name")
        private String strTeam;

        @SerializedName("code")
        private String strTeamShort;

        @SerializedName("country")
        private String strCountry;

        public String getStrTeam() {
            return strTeam;
        }

        public void setStrTeam(String strTeam) {
            this.strTeam = strTeam;
        }

        public String getStrTeamShort() {
            return strTeamShort;
        }

        public void setStrTeamShort(String strTeamShort) {
            this.strTeamShort = strTeamShort;
        }

        public String getStrCountry() {
            return strCountry;
        }

        public void setStrCountry(String strCountry) {
            this.strCountry = strCountry;
        }
    }
}

