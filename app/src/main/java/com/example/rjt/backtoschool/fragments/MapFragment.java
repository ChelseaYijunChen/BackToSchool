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

import java.util.ArrayList;
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
    List<UpdatedBusLocationItem> locationList = new ArrayList<>();
    String lat = null;
    String loni = null;
    private final String TAG = MapFragment.class.getSimpleName();
    //private static final String TAG = .getSimpleName();

    public static MapFragment newInstance() {
        MapFragment mapFragment = new MapFragment();
        return mapFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiInterface.getBusLocation(ROUTE_ID);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d(TAG,response.code()+"");
                BusResponse busResponse = (BusResponse) response.body();
                locationList = busResponse.getUpdatedBusLocation();
                Log.d(TAG,locationList.get(0).toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                call.cancel();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_map, container, false);
        context = getContext();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for(int i =0; i< locationList.size();i++){
            double lat = Double.parseDouble(locationList.get(i).getUpdatedLattitude());
            double longi = Double.parseDouble(locationList.get(i).getUpdatedLongtitude());
            Marker marker_car = mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car_48))
                    .title("24 Km/h")
                    .position(new LatLng(lat, longi)));
        }

//        Marker marker_car = mMap.addMarker(new MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_car_48))
//                .title("24 Km/h")
//                .position(new LatLng(41.838874, -87.857666)));

        Marker marker_school = mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_school_48))
                .position(new LatLng(12.416514, 77.504332)));

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
