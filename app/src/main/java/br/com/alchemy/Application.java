package br.com.alchemy;

import br.com.alchemy.util.Preferences;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(this);
    }
}
