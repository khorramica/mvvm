package ir.finto.mvvmproject.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ir.finto.mvvmproject.RoomDB.Information;
import ir.finto.mvvmproject.RoomDB.InformationDB;
import ir.finto.mvvmproject.RoomDB.InformationDao;

public class ViewModelRoomDB extends AndroidViewModel {

    private InformationDao informationDao;
    private InformationDB informationDB;
    private LiveData<List<Information>> allInformation;

    public ViewModelRoomDB(@NonNull Application application) {
        super(application);

        informationDB = InformationDB.GetInstance(application);
        informationDao = InformationDB.informationDao();
        allInformation = informationDao.getAll();
    }

    public LiveData<List<Information>> getAllInformation() {
        return allInformation;
    }

    public class InsertAsyncTask extends AsyncTask<Information,Void,Void>{

        InformationDao informationDao;

        public InsertAsyncTask(InformationDao informationDao) {
            this.informationDao = informationDao;
        }

        @Override
        protected Void doInBackground(Information... information) {
            informationDao.Insert(information[0]);
            return null;
        }
    }

    public void InsertInformation(Information information)
    {
        new InsertAsyncTask(informationDao).execute(information);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
