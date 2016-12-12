package br.com.fernandescruz.times;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import br.com.fernandescruz.times.model.Time;

public class DetalheActivity extends AppCompatActivity {

    ImageView ivEscudo;
    TextView tvAnoFundacao;
    TextView tvEstado;
    CollapsingToolbarLayout toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tvAnoFundacao = (TextView)findViewById(R.id.tvAnoFundacao);
        ivEscudo = (ImageView)findViewById(R.id.ivEscudo);
        tvEstado = (TextView)findViewById(R.id.tvEstado);

        toolBar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);

        if(getIntent() != null){
            Time time = getIntent().getParcelableExtra("time");

            toolBar.setTitle(time.getNome());
            tvEstado.setText(time.getEstado());
            tvAnoFundacao.setText(time.getAnoFundacao());

            Picasso.with(this).
                    load(time.getEscudo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivEscudo);

            Toast.makeText(this,
                    time.getNome(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
