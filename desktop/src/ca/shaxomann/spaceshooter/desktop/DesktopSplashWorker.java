package ca.shaxomann.spaceshooter.desktop;

import java.awt.SplashScreen;

import ca.shaxomann.spaceshooter.SplashWorker;

public class DesktopSplashWorker implements SplashWorker {

    @Override
    public void closeSplashScreen() {
        SplashScreen splashScreen = SplashScreen.getSplashScreen();

        if(splashScreen != null ){
            splashScreen.close();
        }
    }
}
