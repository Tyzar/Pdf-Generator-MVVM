package viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AppViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mParam;

    public AppViewModelFactory(Application application, String param) {
        mApplication = application;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.equals(PdfGeneratorViewModel.class))
            return (T) new PdfGeneratorViewModel(mApplication);
        else if(modelClass.equals(AddPdfDataViewModel.class))
            return (T) new AddPdfDataViewModel(mApplication);
        else
            return null;
    }
}
