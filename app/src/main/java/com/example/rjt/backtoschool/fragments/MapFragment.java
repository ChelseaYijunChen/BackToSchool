package com.example.rjt.backtoschool.fragments;

import android.content.Context;
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
import com.example.rjt.backtoschool.models.BusTracking;
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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yijunchen on 7/16/17.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback, GoogleMap.OnMarkerClickListener{
    private GoogleMap mMap;
    Context context;
    private final static String ROUTE_ID = "101";
    //private static final String TAG = .getSimpleName();

    public static MapFragment newInstance() {
        MapFragment mapFragment = new MapFragment();
        return mapFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_map, container, false);
        context = getContext();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiInterface.getBusLocation(ROUTE_ID);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("TAG",response.code()+"");
                BusTracking busTracking = (BusTracking) response.body();
                List locationList = busTracking.updatedBusLocation;
                Log.d("TAG",locationList.get(0).toString());
                for (Object bus : locationList){
                    Toast.makeText(getActivity(), bus.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
            }
        });
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Responseresponse response) {
//                Log.d("TAG",response.code()+"");
//                BusTracking busTracking = response.body();
//                BusTracking.BusInfo[] locationList = busTracking.updatedBusLocation;
//                Log.d("TAG",locationList.get(0).toString());
//
//                for (int i = 0; i<locationList.size();i++) {
//                    BusTracking.BusInfo v = (BusTracking.BusInfo) locationList.get(0);
//                    Toast.makeText(getActivity(),locationList.get(i).toString(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Log.e("TAG", t.toString());
//            }
//        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Marker marker_car = mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car_48))
                .title("24 Km/h")
                .position(new LatLng(41.838874, -87.857666)));

        Marker marker_school = mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_school_48))
                .position(new LatLng(41.438874, -87.657666)));

        //marker_car.setTag(0);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.000, 40.000)));
        mMap.setOnMarkerClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(41.638874, -87.757666), 9));

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
