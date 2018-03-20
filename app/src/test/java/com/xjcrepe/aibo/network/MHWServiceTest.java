package com.xjcrepe.aibo.network;

import com.xjcrepe.aibo.model.Weapon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class MHWServiceTest {

    private MHWService subject;

    private MockWebServer mockWebServer;

    @Before
    public void setUp() {
        mockWebServer = new MockWebServer();
        subject = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MHWService.class);
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void getWeapons() throws IOException, InterruptedException {
        enqueueResponse("WeaponsResponse.json");
        TestObserver<List<Weapon>> testObserver = new TestObserver<>();

        Single<List<Weapon>> allWeaponsSingle = subject.getWeapons();
        allWeaponsSingle.subscribe(testObserver);

        RecordedRequest request = mockWebServer.takeRequest();
        assertThat(request.getPath(), is("/weapons"));

        List<Weapon> allWeapons = testObserver.values().get(0);

        assertEquals(allWeapons.size(), 1149);
        assertEquals(allWeapons.get(0).getName(), "Buster Sword 1");
    }

    private void enqueueResponse(String fileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        mockResponse.setBody(source.readString(StandardCharsets.UTF_8));
        mockWebServer.enqueue(mockResponse);
    }

}
