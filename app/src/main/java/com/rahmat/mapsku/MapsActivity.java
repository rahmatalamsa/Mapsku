package com.rahmat.mapsku;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.rahmat.mapsku.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in University and move the camera
        LatLng untad = new LatLng(-0.8347196141691805, 119.89325356849893);
        LatLng uin = new LatLng(-0.8854826848392728, 119.84586178114567);
        LatLng unismuh = new LatLng(-0.8715384637382817, 119.87821421304679);
        LatLng stikes = new LatLng(-0.8422917234028193, 119.88671012856554);
        LatLng poltekkes = new LatLng(-0.7896659373536671, 119.86691336332572);
        LatLng stmik = new LatLng(-0.8870352176072254, 119.86111689480182);
        LatLng alkhairaat = new LatLng(-0.8893713252038618, 119.85186013156122);

        // Custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.ic_marker_black);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.ic_marker_red);
        BitmapDrawable bitmapKus = (BitmapDrawable)getResources().getDrawable(R.drawable.ic_marker_green);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap k = bitmapKus.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi,false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi,false);
        Bitmap markerKus = Bitmap.createScaledBitmap(k, lebar, tinggi,false);

        // Add marker to map
        mMap.addMarker(new MarkerOptions().position(untad).title("Marker in Universitas Tadulako")
                .snippet("Ini adalah kampus kami")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(uin).title("Marker in Universitas Islam Negeri")
                .snippet("Ini adalah kampus uin")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addMarker(new MarkerOptions().position(unismuh).title("Marker in UNISMUH Palu")
                .snippet("Ini adalah kampus unismuh")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKus)));

        mMap.addMarker(new MarkerOptions().position(stikes).title("Marker in STIKes Widya Nusantara Palu")
                .snippet("Ini adalah kampus stikes")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKus)));

        mMap.addMarker(new MarkerOptions().position(poltekkes).title("Marker in Poltekkes Kemenkes Palu")
                .snippet("Ini adalah kampus poltekkes")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKus)));

        mMap.addMarker(new MarkerOptions().position(stmik).title("Marker in STMIK Adhi Guna")
                .snippet("Ini adalah kampus stmik")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKus)));

        mMap.addMarker(new MarkerOptions().position(alkhairaat).title("Marker in Universitas Alkhairaat")
                .snippet("Ini adalah kampus alkhairaat")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKus)));

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                        new LatLng(-0.8347196141691805,119.89325356849893),
                        new LatLng(-0.8447196141691805,119.89335356849893),
                        new LatLng(-0.8547196141691805,119.89345356849893),
                        new LatLng(-0.8647196141691805,119.89355356849893),
                        new LatLng(-0.8754826848392728,119.84366178114567),
                        new LatLng(-0.8854826848402728,119.84376178114567),
                        new LatLng(-0.8854826848392728,119.84586178114567),
                uin
                ).width(10)
                        .color(Color.GREEN)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(untad,11.5f));
    }
}