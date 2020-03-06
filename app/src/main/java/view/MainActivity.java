package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.intisharfa.wifibillmanager.R;

import java.util.ArrayList;
import java.util.List;

import model.PdfDataModel;
import view.PdfDataRecyclerView.PdfDataAdapter;
import viewmodel.PdfGeneratorViewModel;
import viewmodel.AppViewModelFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AddPdfDataView.OnFragmentInteractionListener {

    private PdfGeneratorViewModel pdfGeneratorVM;
    private FloatingActionButton button;
    private PdfDataAdapter pdfDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    Observer<List<PdfDataModel>> listPdfModelObs = new Observer<List<PdfDataModel>>() {
        @Override
        public void onChanged(List<PdfDataModel> liveData) {
            pdfDataAdapter.setDataset(liveData);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        unsubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        subsribeObservable();
    }

    private void initView(){
        button = findViewById(R.id.janx);
        button.setOnClickListener(this);
        RecyclerView pdfDataRecV = findViewById(R.id.pdfDataRecV);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        pdfDataRecV.setLayoutManager(layoutManager);
        pdfDataAdapter = new PdfDataAdapter(new ArrayList<PdfDataModel>());
        pdfDataRecV.setAdapter(pdfDataAdapter);
    }

    private void unsubscribe(){
        if(pdfGeneratorVM != null){
            pdfGeneratorVM.getPdfDatas().removeObservers(this);
        }
    }

    private void subsribeObservable(){

        if(pdfGeneratorVM == null){
            pdfGeneratorVM = ViewModelProviders
                    .of(this,new AppViewModelFactory(getApplication(),""))
                    .get(PdfGeneratorViewModel.class);
        }
        ((LiveData)pdfGeneratorVM.getPdfDatas()).observe(this,listPdfModelObs);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.janx){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            AddPdfDataView addPdfDataView = new AddPdfDataView();
            fragmentTransaction.replace(R.id.mainContent,addPdfDataView);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
