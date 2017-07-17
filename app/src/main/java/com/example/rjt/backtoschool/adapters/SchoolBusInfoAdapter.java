package com.example.rjt.backtoschool.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.models.StudentBirthday;
import com.example.rjt.backtoschool.models.StudentBirthdayList;
import com.example.rjt.backtoschool.models.Vehicle;
import com.example.rjt.backtoschool.models.VehiclesList;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class SchoolBusInfoAdapter extends RecyclerView.Adapter<SchoolBusViewHolder> {
    @Override
    public SchoolBusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_school_bus_info, parent, false);
        SchoolBusViewHolder holder = new SchoolBusViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SchoolBusViewHolder holder, int position) {
        Vehicle vehicle = VehiclesList.getmInstance().get(position);
        holder.mVehicleID.setText(vehicle.getVehicleID());
        holder.mVehicleCode.setText(vehicle.getVehicleCode());
        holder.mVehicleNO.setText(vehicle.getVehicleNo());
        holder.mVehicleRoute.setText(vehicle.getVehicleRoute());

    }

    @Override
    public int getItemCount() {
        return VehiclesList.getmInstance().size();
    }
}
class SchoolBusViewHolder extends RecyclerView.ViewHolder{
    TextView mVehicleID, mVehicleCode, mVehicleNO, mVehicleRoute;
    public SchoolBusViewHolder(View itemView) {
        super(itemView);
        mVehicleID = (TextView) itemView.findViewById(R.id.vehicleID);
        mVehicleCode = (TextView) itemView.findViewById(R.id.vehicleCode);
        mVehicleNO = (TextView) itemView.findViewById(R.id.vehicleNO);
        mVehicleRoute = (TextView) itemView.findViewById(R.id.vehicleRoute);
    }
}
