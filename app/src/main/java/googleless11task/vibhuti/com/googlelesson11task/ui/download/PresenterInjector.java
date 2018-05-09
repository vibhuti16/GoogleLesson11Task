package googleless11task.vibhuti.com.googlelesson11task.ui.download;

/**
 * Encapsulates creation of all Presenters
 */
public class PresenterInjector {

    public static void injectDownloadPresenter(DownloadContract.View homeView){
        new DownloadPresenter(homeView);
    }

}
