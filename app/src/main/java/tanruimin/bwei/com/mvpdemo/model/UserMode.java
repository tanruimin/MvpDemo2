package tanruimin.bwei.com.mvpdemo.model;

import tanruimin.bwei.com.mvpdemo.bean.User;

/**
 * data:2017/5/16
 * name:tanruimin tanruimin
 * function:
 */

public class UserMode implements IUserMode {
    @Override
    public String login(User user) {
        boolean networkError = false; //网络是否异常

        try {
            Thread.sleep(3000);//模拟网络连接
            if (networkError) {
                return "网络异常";
            } else if ("tanruimin".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
                return "true";
            } else {
                return "账号或密码错误";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}