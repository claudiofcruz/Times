package br.com.fernandescruz.times.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.fernandescruz.times.DetalheActivity;
import br.com.fernandescruz.times.R;
import br.com.fernandescruz.times.adapter.TimeListAdapter;
import br.com.fernandescruz.times.api.TimeAPI;
import br.com.fernandescruz.times.listener.OnClickListener;
import br.com.fernandescruz.times.model.Time;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimesFragment extends Fragment implements Callback<List<Time>>{

    private static String id = "57c49ba10f00007111b50c00";
    private RecyclerView rvTimes;
    private TimeListAdapter adapter;


    public TimesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_times, container, false);
        rvTimes = (RecyclerView) v.findViewById(R.id.rvTimes);
        rvTimes.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Visual de como os itens são adicionados na lista
        rvTimes.setItemAnimator(new DefaultItemAnimator());
        rvTimes.setHasFixedSize(true);

        return v;
    }


    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        loadTimes();
    }

    private void loadTimes() {
        //Chamada ao webservice
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TimeAPI api = retrofit.create(TimeAPI.class);
        Call<List<Time>> call = api.findby();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Time>> call, Response<List<Time>> response) {
        //Alimenta o adapter com o conteudo do webservice
        adapter = new TimeListAdapter(getContext(), response.body(), onClickListener());
        rvTimes.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Time>> call, Throwable t) {
        Toast.makeText(getContext(),
                t.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    private OnClickListener onClickListener () {
        return new OnClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent i = new Intent(getContext(), DetalheActivity.class);
                i.putExtra("time",adapter.getItem(position));
                startActivity(i);
            }
        };

    }

}
