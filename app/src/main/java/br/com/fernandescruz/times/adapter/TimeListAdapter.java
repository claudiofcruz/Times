package br.com.fernandescruz.times.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.fernandescruz.times.R;
import br.com.fernandescruz.times.listener.OnClickListener;
import br.com.fernandescruz.times.model.Time;

/**
 * Created by claudiocruz on 19/11/16.
 */

public class TimeListAdapter extends
        RecyclerView.Adapter<TimeListAdapter.TimesViewHolder>{

    private Context context;
    private List<Time> times;
    private OnClickListener clickListener;
    private TimesViewHolder mHolder;

    public TimeListAdapter(Context context, List<Time> times, OnClickListener clickListener)
    {
        this.context = context;
        this.times = times;
        this.clickListener = clickListener;
    }

    @Override
    public TimesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context)
                .inflate(R.layout.time_row, parent, false);

        mHolder = new TimesViewHolder(v);

        return new TimesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimesViewHolder holder, final int position) {

        mHolder.tvNome.setText(times.get(position).getNome());
        Picasso.with(context).
                load(times.get(position).getEscudo())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivEscudo);

        if(clickListener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    clickListener.onClick(mHolder.itemView, position);
                }
            });
        }

    }

    //classe interna utilizada somente pelo este adapter
    public static class TimesViewHolder extends RecyclerView.ViewHolder{

        TextView tvNome;
        ImageView ivEscudo;


        public TimesViewHolder(View itemView) {
            super(itemView);

            //Efetua o bind com a view dos objetos do layout time_rowxml
            tvNome      = (TextView) itemView.findViewById(R.id.tvNome);
            ivEscudo = (ImageView) itemView.findViewById(R.id.ivEscudo);
        }
    }


    public Time getItem(int position){
        return times.get(position);
    }

    @Override
    public int getItemCount() {
        return times.size();
    }
}
