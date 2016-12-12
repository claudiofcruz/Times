package br.com.fernandescruz.times.api;

import java.util.List;

import br.com.fernandescruz.times.model.Time;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by claudiocruz on 19/11/16.
 */

public interface TimeAPI {
    @GET("v2/57c49ba10f00007111b50c00")
    Call<List<Time>> findby();
}
