package com.example.cours11_viewmodel.view_mdel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.cours11_viewmodel.model.User;
import com.example.cours11_viewmodel.repository.UserRepository;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {
    private UserRepository mRepository;

    // Initialize the repository and the list of users
    public UsersViewModel(Application application) {
        super(application);
        mRepository = new UserRepository(application);
    }

    public LiveData<List<User>> getAllUsers() {
        return mRepository.getAllUsers();
    }

    public void createUser(User user) {
        mRepository.createUser(user);
    }
    public void removeUser(User user) {
        mRepository.removeUser(user);
    }

    public void updateUser(User user) {
        mRepository.updateUser(user);
    }
}
