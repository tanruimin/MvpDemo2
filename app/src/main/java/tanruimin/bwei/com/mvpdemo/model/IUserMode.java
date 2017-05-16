package tanruimin.bwei.com.mvpdemo.model;

import tanruimin.bwei.com.mvpdemo.bean.User;

/**
 * data:2017/5/16
 * name:tanruimin tanruimin
 * function:
 */

public interface IUserMode {
    /**
     * 登录
     *
     * @param user
     * @return 约定返回"true"为登录成功，其他为登录失败的错误信息
     */
    String login(User user);
}
