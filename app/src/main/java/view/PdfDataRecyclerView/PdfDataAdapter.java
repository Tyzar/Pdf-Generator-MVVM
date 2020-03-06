package view.PdfDataRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.intisharfa.wifibillmanager.R;
import java.util.List;

import model.PdfDataModel;

public class PdfDataAdapter extends RecyclerView.Adapter<PdfDataViewHolder> {

    private List<PdfDataModel> dataset;

    public PdfDataAdapter(List<PdfDataModel> dataset) {
        this.dataset = dataset;
    }

    public void setDataset(List<PdfDataModel> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PdfDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_data_view_item,parent,false);
        PdfDataViewHolder vh = new PdfDataViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PdfDataViewHolder holder, int position) {
        holder.bindData(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
