package com.aarti.onboard_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.List;


public class GetRoutes  extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    SelectRoutesAdapter adapter;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_routes);
        SlidingUpPanelLayout slide_up=findViewById(R.id.sliding_up);
        slide_up.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset)
            {
                //findViewById(R.id.select_message).setAlpha(1-slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
               if (newState==SlidingUpPanelLayout.PanelState.EXPANDED)
               {}
                  // Toast.makeText(GetRoutes.this,"Expanded",Toast.LENGTH_LONG).show();
               else if (newState==SlidingUpPanelLayout.PanelState.COLLAPSED)
               {
                   //Toast.makeText(GetRoutes.this,"Panel Collapsed",Toast.LENGTH_LONG).show();
               }
            }

        });
        startAdapter();
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(GetRoutes.this,Home.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;

        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LatLng Delhi=new LatLng(28.567858, 77.178556);
        googleMap.addMarker(new MarkerOptions().position(Delhi).title("New Delhi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Delhi));

    }


    private void startAdapter()
    {
        RecyclerView pl = (RecyclerView) findViewById(R.id.pl);
        pl.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectRoutesAdapter(GetRoutes.this);
        pl.setAdapter(adapter);

    }

}
