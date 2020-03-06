package viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.UUID;

import businesslogic.PdfGenerator;
import model.PdfDataModel;
import repository.PdfDataRepository;

public class PdfGeneratorViewModel extends ViewModel {

    private PdfGenerator pdfGenerator;
    private PdfDataRepository pdfDataRepository;
    LiveData<List<PdfDataModel>> pdfDatas;

    public PdfGeneratorViewModel(Application application) {
        this.pdfGenerator = new PdfGenerator();
        this.pdfDataRepository = new PdfDataRepository(application);
        //init data to be displayed
        pdfDatas = pdfDataRepository.getAll();
    }

    public LiveData<List<PdfDataModel>> getPdfDatas() {
        return pdfDatas;
    }

    public void setPdfDatas(MutableLiveData<List<PdfDataModel>> pdfDatas) {
        this.pdfDatas = pdfDatas;
    }

    public void addNewPdfData(){
        this.pdfDataRepository.insert(new PdfDataModel(
                UUID.randomUUID().toString(),
                "Tika Tika",
                "Jalan Random no.7",
                "Bali",
                "Lorem ipsum dolor sit amet. Loli is justice."
        ));
    }
}
