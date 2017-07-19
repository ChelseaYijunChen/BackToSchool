package com.example.rjt.backtoschool.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.controllers.DataParser;
import com.example.rjt.backtoschool.models.pojo.BusResponse;
import com.example.rjt.backtoschool.models.pojo.UpdatedBusLocationItem;
import com.example.rjt.backtoschool.rest.ApiClient;
import com.example.rjt.backtoschool.rest.ApiInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yijunchen on 7/16/17.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap mMap;
    private final static String ROUTE_ID = "101";
    List<UpdatedBusLocationItem> locationList = new ArrayList<>();
    Double lat = null;
    Double longi = null;
    private final String TAG = MapFragment.class.getSimpleName();

    public static MapFragment newInstance() {
        MapFragment mapFragment = new MapFragment();
        return mapFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiInterface.getBusLocation(ROUTE_ID);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d(TAG, response.code() + "");
                BusResponse busResponse = (BusResponse) response.body();
                busResponse.setUpdatedBusLocation(busResponse.getUpdatedBusLocation());
                locationList = busResponse.getUpdatedBusLocation();
                Log.d(TAG, locationList.get(0).toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng school = new LatLng(12.416514, 77.504332);

        for (int i = 0; i < locationList.size(); i++) {
            lat = Double.parseDouble(locationList.get(0).getUpdatedLattitude());
            longi = Double.parseDouble(locationList.get(0).getUpdatedLongtitude());
            Log.d(TAG, "lat " + lat + "long" + longi);
            Marker marker_car = mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car_48))
                    .title("24 Km/h")
                    .position(new LatLng(lat,longi)));
        }

        Marker marker_school = mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_school_48))
                .position(school));

//
//        String encodedString = overviewPolylines.getString("points");
//        List<LatLng> list = decodePoly(encodedString);
//        Polyline line = mMap.addPolyline(new PolylineOptions()
//                .add(school, bus)
//                .width(10)
//                .color(Color.parseColor("#05b1fb"))
//                .geodesic(true));

        //marker_car.setTag(0);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.000, 40.000)));
        mMap.setOnMarkerClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(12.716514, 77.404332), 9));

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
