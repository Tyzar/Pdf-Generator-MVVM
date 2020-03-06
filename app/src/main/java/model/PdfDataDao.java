package model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PdfDataDao {
     @Query("SELECT * FROM PDF_DATA")
     LiveData<List<PdfDataModel>> selectAll();
     @Insert
     void insert(PdfDataModel data);
     @Update
     void update(PdfDataModel data);
     @Query("DELETE FROM PDF_DATA WHERE id=:dataId")
     void delete(String dataId);
}
