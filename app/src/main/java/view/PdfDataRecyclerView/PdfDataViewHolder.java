package view.PdfDataRecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intisharfa.wifibillmanager.R;

import model.PdfDataModel;

public class PdfDataViewHolder extends RecyclerView.ViewHolder {

    TextView nameTv,addressTv,hometownTv,descTv;

    public PdfDataViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.nameTv);
        addressTv = itemView.findViewById(R.id.addressTv);
        hometownTv = itemView.findViewById(R.id.hometownTv);
        descTv = itemView.findViewById(R.id.descTv);
    }

    public void bindData(PdfDataModel data){
        nameTv.setText(data.name);
        addressTv.setText(data.address);
        hometownTv.setText(data.hometown);
        descTv.setText(data.selfDescription);
    }
}
