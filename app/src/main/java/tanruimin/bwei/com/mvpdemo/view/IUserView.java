package tanruimin.bwei.com.mvpdemo.view;

/**
 * data:2017/5/16
 * name:tanruimin tanruimin
 * function:
 */

public interface IUserView {
    /**
     * 登录成功
     */
    void onLoginSuccess();

    /**
     * 登录失败
     *
     * @param error
     */
    void onLoginFailed(String error);
}
