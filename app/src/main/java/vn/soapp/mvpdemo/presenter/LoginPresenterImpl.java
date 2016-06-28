package vn.soapp.mvpdemo.presenter;


import vn.soapp.mvpdemo.model.LoginInteractor;
import vn.soapp.mvpdemo.model.LoginInteractorImpl;
import vn.soapp.mvpdemo.model.OnLoginFinishedListener;
import vn.soapp.mvpdemo.view.LoginView;

/**
 * Created by sapui on 6/28/2016.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override public void validateCredentials(String username, String password) {
        /*
        *   interface loginView gọi showProgress() (viết đè ở trong main activity ) để hiển thị Progress
        *   loginInteractor gọi login trong lớp LoginInteractorImpl để thực thi hàm logic login
        *   vì loginInteractor khởi tạo đối tượng là LoginInteractorImpl();
        *   khi kiểm tra xong trả về OnLoginFinishedListener kết quả lỗi hay thành công
        *
        * */

        loginView.showProgress();
        loginInteractor.login(username, password, this);
    }

    @Override public void onUsernameError() {

        /*
        *   Nếu lỗi user name thì gọi đến setUsernameError ở hàm main để hiển thị lỗi
        *   và ẩn progress
        *
        * */
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Override public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override public void onSuccess() {
        loginView.navigateToHome();
    }
}
