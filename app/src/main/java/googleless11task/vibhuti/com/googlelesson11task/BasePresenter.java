package googleless11task.vibhuti.com.googlelesson11task;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Base Presenter interface to be extended by all presenters of the app
 */
public interface BasePresenter {

    void start(@Nullable Bundle extras);

    void destroy();

}
