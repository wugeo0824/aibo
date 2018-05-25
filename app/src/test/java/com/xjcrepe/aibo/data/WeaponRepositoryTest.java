package com.xjcrepe.aibo.data;

import com.xjcrepe.aibo.base.RxSchedulers;
import com.xjcrepe.aibo.model.Weapon;
import com.xjcrepe.aibo.network.MHWService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeaponRepositoryTest {

    @Mock
    private WeaponDao weaponDao;

    @Mock
    private MHWService mhwService;

    @Mock
    private RxSchedulers rxSchedulers;

    private WeaponRepository subject;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        subject = new WeaponRepository(weaponDao, mhwService, rxSchedulers);

        Single<List<Weapon>> errorSingle = Single.error(new Throwable("should not reach here"));
        when(mhwService.getWeapons()).thenReturn(errorSingle);

        when(rxSchedulers.getIo()).thenReturn(Schedulers.io());
    }

    @Test
    public void loadWeapons_whenLocalStorageIsEmpty_shouldLoadFromNetwork() {

    }

    @Test
    public void loadWeapons_whenLocalStorageHasData_shouldLoadFromLocal() {
//        List<Weapon> weapons = new ArrayList<>();
//        weapons.add(mock(Weapon.class));
//        weapons.add(mock(Weapon.class));
//        when(weaponDao.getAll()).thenReturn(Single.just(weapons));
//        TestObserver<List<Weapon>> testObserver = subject.loadWeapons(1).test();
//
////        subject.loadWeapons(1).subscribe(testObserver);
//        testObserver.awaitTerminalEvent();
//
//        testObserver.assertNoErrors();
//        testObserver.assertValue(weapons);
    }
}
