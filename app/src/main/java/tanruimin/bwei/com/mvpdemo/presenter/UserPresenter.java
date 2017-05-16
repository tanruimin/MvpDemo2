package tanruimin.bwei.com.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import tanruimin.bwei.com.mvpdemo.bean.User;
import tanruimin.bwei.com.mvpdemo.model.UserMode;
import tanruimin.bwei.com.mvpdemo.view.IUserView;

/**
 * data:2017/5/16
 * name:tanruimin tanruimin
 * function:
 */

public class UserPresenter {
    private final IUserView userView;
    private final UserMode userMode;

    public UserPresenter(IUserView userView) {
        this.userView = userView;
        this.userMode = new UserMode();
    }

    /**
     * 登录
     *
     * @param user
     */
    public void login(final User user) {
        new Thread() {
            @Override
            public void run() {
                final String res = userMode.login(user);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if ("true".equals(res)) {
                            userView.onLoginSuccess();
                        } else {
                            userView.onLoginFailed(res);
                        }
                    }
                });
            }
        }.start();
    }
}
