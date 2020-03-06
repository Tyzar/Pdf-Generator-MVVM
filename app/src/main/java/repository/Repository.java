package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public interface Repository<T> {
    void insert(T data);
    void update(T data);
    void delete(T data);
    LiveData<List<T>> getAll();
}
