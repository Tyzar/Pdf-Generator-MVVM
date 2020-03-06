package viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.UUID;

import model.PdfDataModel;
import repository.PdfDataRepository;

public class AddPdfDataViewModel extends ViewModel {

    public MutableLiveData<String> name,address,hometown,description;
    private PdfDataRepository pdfDataRepository;
    private MutableLiveData<Boolean> requestCloseView;

    public AddPdfDataViewModel(Application application) {
        pdfDataRepository = new PdfDataRepository(application);
        name = new MutableLiveData<>();
        address = new MutableLiveData<>();
        hometown = new MutableLiveData<>();
        description = new MutableLiveData<>();
        requestCloseView = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getRequestCloseView() {
        return requestCloseView;
    }

    public void addNewPdfData(){
        try{
            pdfDataRepository.insert(
                    new PdfDataModel(
                            UUID.randomUUID().toString(),
                            name.getValue(),
                            address.getValue(),
                            hometown.getValue(),
                            description.getValue()
                    )
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        requestCloseView.setValue(true);
    }

}
