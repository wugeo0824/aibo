package com.xjcrepe.aibo.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxAwareViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    public void disposeWhenClear(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
