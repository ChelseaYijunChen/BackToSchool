package com.example.rjt.backtoschool.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.models.Driver;
import com.example.rjt.backtoschool.models.DriversList;
import com.example.rjt.backtoschool.models.Vehicle;
import com.example.rjt.backtoschool.models.VehiclesList;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class DriversInfoAdapter extends RecyclerView.Adapter<DriverInfoViewHolder> {
    @Override
    public DriverInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver_info, parent, false);
        DriverInfoViewHolder holder = new DriverInfoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DriverInfoViewHolder holder, int position) {
        Driver driver = DriversList.getmInstance().get(position);
        holder.mDriverID.setText(driver.getDriverID());
        holder.mDriverName.setText(driver.getDriverName());
        holder.mDriverLicenceNO.setText(driver.getDriverLicenceNo());
        holder.mDriverMobile.setText(driver.getDriverMobile());

    }

    @Override
    public int getItemCount() {
        return DriversList.getmInstance().size();
    }
}
class DriverInfoViewHolder extends RecyclerView.ViewHolder{
    TextView mDriverID, mDriverName, mDriverLicenceNO, mDriverMobile;
    public DriverInfoViewHolder(View itemView) {
        super(itemView);
        mDriverID = (TextView) itemView.findViewById(R.id.driverID);
        mDriverName = (TextView) itemView.findViewById(R.id.driverName);
        mDriverLicenceNO = (TextView) itemView.findViewById(R.id.driverLicenceNo);
        mDriverMobile = (TextView) itemView.findViewById(R.id.driverMobile);
    }
}
