package com.xjcrepe.aibo.base;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulers {

    private final Scheduler io;
    private final Scheduler ui;
    private final Scheduler computation;

    public RxSchedulers() {
        io = Schedulers.io();
        ui = AndroidSchedulers.mainThread();
        computation = Schedulers.computation();
    }

    public Scheduler getIo() {
        return io;
    }

    public Scheduler getUi() {
        return ui;
    }

    public Scheduler getComputation() {
        return computation;
    }
}
