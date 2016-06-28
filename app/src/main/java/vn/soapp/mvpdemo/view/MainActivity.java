package vn.soapp.mvpdemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import vn.soapp.mvpdemo.Main2Activity;
import vn.soapp.mvpdemo.R;
import vn.soapp.mvpdemo.presenter.LoginPresenter;
import vn.soapp.mvpdemo.presenter.LoginPresenterImpl;


/*
*   HIển thị kết quả tới người dùng
*   LoginPresenter : Tiếp nhận và thực thi logic của ứng dụng
*
* */
public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        /*
        *   presenter là một interface khởi tạo new đối tượng LoginPresenterImpl
        *   LoginPresenterImpl có chứa interface LoginView (lớp giao diện để tương tác với view)
        *   và LoginInteractor (Lớp logic xử lý kiểm tra đăng nhập)
        *   */
        presenter = new LoginPresenterImpl(this);
    }


    @Override
    public void onClick(View v) {
        /*
        *   khi click vào đăng nhập
        *   thì hàm validateCredentials sẽ được gọi
        *   để kiểm tra user name và pass
        * */
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, Main2Activity.class));
        finish();
    }
}
