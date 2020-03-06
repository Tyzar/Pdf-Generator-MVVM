package repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import model.AppRoomDB;
import model.PdfDataModel;

public class PdfDataRepository implements Repository<PdfDataModel> {

    private AppRoomDB db;
    LiveData<List<PdfDataModel>> allPdfDatas;

    public PdfDataRepository(Application application) {
        db = AppRoomDB.getDb(application);
        allPdfDatas = db.pdfDataDao().selectAll();
    }

    @Override
    public void insert(final PdfDataModel data) {
        AppRoomDB.writeExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            db.pdfDataDao().insert(data);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    @Override
    public void update(PdfDataModel data) {

    }

    @Override
    public void delete(PdfDataModel data) {

    }

    @Override
    public LiveData<List<PdfDataModel>> getAll() {
        return allPdfDatas;
    }
}
