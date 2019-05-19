package com.example.gamelist;

import com.example.gamelist.mock.MockNetworkModule;
import com.example.gamelist.test.CreateTest;
import com.example.gamelist.test.GetGameTest;
import com.example.gamelist.test.MainTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends GameListApplicationComponent {
    void inject(MainTest mainTest);

    void inject(CreateTest createTest);

    void inject(GetGameTest getGameTest);
}

