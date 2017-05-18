package br.com.alchemy;

import android.content.Context;

import br.com.alchemy.util.Preferences;

public class Application extends android.app.Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Preferences.init(this);
    }
}
