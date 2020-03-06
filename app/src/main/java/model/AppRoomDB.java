package model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {PdfDataModel.class},
        version = 1,
        exportSchema = false
)
public abstract class AppRoomDB extends RoomDatabase {
    public abstract PdfDataDao pdfDataDao();
    private static volatile AppRoomDB instance;
    private static final int numThread = 4;
    public static final ExecutorService writeExecutor = Executors.newFixedThreadPool(numThread);

    public static AppRoomDB getDb(final Context context){
        if(instance == null){
            synchronized (AppRoomDB.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),AppRoomDB.class
                            ,"APP_ROOM_DB").build();
                }
            }
        }
        return instance;
    }

}
