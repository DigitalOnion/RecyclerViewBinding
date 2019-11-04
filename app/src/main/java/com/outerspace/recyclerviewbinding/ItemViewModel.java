package com.outerspace.recyclerviewbinding;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {
    private MutableLiveData<String> fullName = new MutableLiveData<>();
    private MutableLiveData<String> title = new MutableLiveData<>();
    private MutableLiveData<String> nickname = new MutableLiveData<>();

    public MutableLiveData<String> getFullName() {
        return fullName;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<String> getNickname() {
        return nickname;
    }
}
