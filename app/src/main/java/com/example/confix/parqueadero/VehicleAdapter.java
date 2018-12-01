package com.example.confix.parqueadero;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

//public class VehicleAdapter extends RecyclerView<VehicleAdapter.ViewHolder> {
public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    public VehicleAdapter(Context context, ArrayList<Vehicle> Vehicles) {
        super(context, 0, Vehicles);
    }
}