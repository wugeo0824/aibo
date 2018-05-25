package com.xjcrepe.aibo.data;

import com.xjcrepe.aibo.base.RxSchedulers;
import com.xjcrepe.aibo.model.Weapon;
import com.xjcrepe.aibo.network.MHWService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

@Singleton
public class WeaponRepository {

    private final static int ITEMS_PER_PAGE = 20;

    private final WeaponDao weaponDao;

    private final MHWService mhwService;

    private final RxSchedulers rxSchedulers;

    @Inject
    public WeaponRepository(WeaponDao weaponDao, MHWService mhwService, RxSchedulers rxSchedulers) {
        this.weaponDao = weaponDao;
        this.mhwService = mhwService;
        this.rxSchedulers = rxSchedulers;
    }

    public Single<List<Weapon>> loadWeapons(int page) {
//        int offset = (page - 1) * ITEMS_PER_PAGE;

        final Single<List<Weapon>> remoteSingle = mhwService.getWeapons()
                .subscribeOn(rxSchedulers.getIo())
                .doOnSuccess(new Consumer<List<Weapon>>() {
                    @Override
                    public void accept(List<Weapon> weapons) throws Exception {
                        weaponDao.insertAll(weapons);
                    }
                });

        return weaponDao.getAll()
                .subscribeOn(rxSchedulers.getIo())
                .flatMap(new Function<List<Weapon>, SingleSource<List<Weapon>>>() {
                    @Override
                    public SingleSource<List<Weapon>> apply(List<Weapon> weapons) throws Exception {
                        if (weapons == null || weapons.isEmpty()){
                            return remoteSingle;
                        }

                        return Single.just(weapons);
                    }
                })
                .map(new Function<List<Weapon>, List<Weapon>>() {
                    @Override
                    public List<Weapon> apply(List<Weapon> weapons) throws Exception {
                        if (weapons != null && weapons.size() > 19){
                            return weapons.subList(0,19);
                        }

                        return weapons;
                    }
                });
    }
}
