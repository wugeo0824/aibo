package com.xjcrepe.aibo.base;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulers {

    private final Scheduler network;
    private final Scheduler ui;
    private final Scheduler computation;

    public RxSchedulers() {
        network = Schedulers.io();
        ui = AndroidSchedulers.mainThread();
        computation = Schedulers.computation();
    }

    public Scheduler getNetwork() {
        return network;
    }

    public Scheduler getUi() {
        return ui;
    }

    public Scheduler getComputation() {
        return computation;
    }
}
