package viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import model.PdfDataModel;
import repository.PdfDataRepository;

public class PdfGeneratorViewModel extends ViewModel {
    private PdfDataRepository pdfDataRepository;
    LiveData<List<PdfDataModel>> pdfDatas;

    public PdfGeneratorViewModel(Application application) {
        this.pdfDataRepository = new PdfDataRepository(application);
        //init data to be displayed
        pdfDatas = pdfDataRepository.getAll();
    }

    public LiveData<List<PdfDataModel>> getPdfDatas() {
        return pdfDatas;
    }
}
