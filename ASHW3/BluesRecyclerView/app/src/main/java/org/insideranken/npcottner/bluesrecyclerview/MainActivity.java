package org.insideranken.npcottner.bluesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BluesRecyclerViewInterface {
    static ArrayList<BluesModel> BluesModel = new ArrayList<>();
    static bluesRecyclerViewAdapter adapter;
        int[] playerImages =
                    {
                        R.drawable.a_ivan_barbashev,
                        R.drawable.b_tyler_bozak,
                        R.drawable.c_logan_brown,
                        R.drawable.d_pavel_buchnevich,
                        R.drawable.e_dakota_joshua,
                        R.drawable.f_klim_kostin,
                        R.drawable.g_jordan_kyrou,
                        R.drawable.h_ryan_o_reily,
                        R.drawable.i_david_perron,
                        R.drawable.j_brandon_saad,
                        R.drawable.k_brayden_schenn,
                        R.drawable.l_oskar_sundqvist,
                        R.drawable.m_vladimir_tarasenko,
                        R.drawable.n_robert_thomas,
                        R.drawable.o_robert_bortuzzo,
                        R.drawable.p_justin_faulk,
                        R.drawable.q_torey_krug,
                        R.drawable.r_niko_mikkola,
                        R.drawable.s_colton_parayko,
                        R.drawable.t_scott_peruvnovich,
                        R.drawable.u_marco_scandella,
                        R.drawable.v_jake_walman,
                        R.drawable.w_jordan_binnington,
                        R.drawable.x_ville_husso
                    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.bluesRecyclerView);
        setBluesModel();

        adapter = new bluesRecyclerViewAdapter(this, BluesModel, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void setBluesModel()
    {
        String[] playerName = getResources().getStringArray(R.array.player_name);
        String[] playerNumber = getResources().getStringArray(R.array.player_number);
        String[] playerPosition = getResources().getStringArray(R.array.player_position);

        for(int lcv = 0; lcv < playerName.length;++lcv)
        {
            BluesModel.add(new BluesModel(playerName[lcv],
                                          playerNumber[lcv],
                                          playerPosition[lcv],
                                          playerImages[lcv]));
        }
    }
    @Override
    public void onItemClick(int position)
    {
        Intent intent = new Intent(this, IndividualPlayer.class);

        intent.putExtra("NAME", BluesModel.get(position).getBluesName());
        intent.putExtra("NUMBER", BluesModel.get(position).getBluesNumber());
        intent.putExtra("POSITION", BluesModel.get(position).getBluesPosition());
        intent.putExtra("IMAGE", BluesModel.get(position).getBluesImage());

        startActivity(intent);
    }
    @Override
    public void onItemLongClick(int position) {
        BluesModel.remove(position);
        adapter.notifyItemRemoved(position);
    }


}