package tanruimin.bwei.com.mvpdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import tanruimin.bwei.com.mvpdemo.bean.User;
import tanruimin.bwei.com.mvpdemo.presenter.UserPresenter;
import tanruimin.bwei.com.mvpdemo.view.IUserView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IUserView {
    private UserPresenter userPresenter;
    private EditText etUserName;
    private EditText etPassword;
    private ProgressDialog loginProgreess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText) findViewById(R.id.edit);
        etPassword = (EditText) findViewById(R.id.edit2);
        findViewById(R.id.du).setOnClickListener(this);
        userPresenter = new UserPresenter(this);
    }

    @Override
    public void onLoginSuccess() {
        loginProgreess.dismiss();
        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed(String error) {
        loginProgreess.dismiss();
        Toast.makeText(getApplicationContext(), "登录失败:" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        loginProgreess = ProgressDialog.show(this, "登录", "正在登录...");
        userPresenter.login(new User(username, password));
    }
}
