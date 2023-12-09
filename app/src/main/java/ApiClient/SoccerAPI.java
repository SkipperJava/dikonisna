package ApiClient;

import Leagueku.LeagueResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerAPI {
    @GET("2015-16/en.1.clubs.json")
    Call<LeagueResponse> getAllLeague();

}

