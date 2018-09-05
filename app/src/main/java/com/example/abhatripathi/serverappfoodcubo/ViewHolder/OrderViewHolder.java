package com.example.abhatripathi.serverappfoodcubo.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abhatripathi.serverappfoodcubo.R;

public class OrderViewHolder extends RecyclerView.ViewHolder  {
    public TextView txtOrderId, txtOrderStatus, txtOrderphone, txtOrderAddress,txtOrderDate;
    public Button btnEdit,btnRemove,btnDetails,btnDirections;



    public OrderViewHolder(View itemView){
        super(itemView);

        txtOrderAddress = itemView.findViewById(R.id.order_address);
        txtOrderId = itemView.findViewById(R.id.order_id);
        txtOrderStatus = itemView.findViewById(R.id.order_status);
        txtOrderphone = itemView.findViewById(R.id.order_address);
        txtOrderDate = itemView.findViewById(R.id.order_date);


        btnEdit=(Button)itemView.findViewById(R.id.btnEdit);
        btnRemove=(Button)itemView.findViewById(R.id.btnRemove);
        btnDetails=(Button)itemView.findViewById(R.id.btnDetails);
        btnDirections=(Button)itemView.findViewById(R.id.btnDirections);

    }

}
