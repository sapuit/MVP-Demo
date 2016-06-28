package vn.soapp.mvpdemo.view;

/**
 *  là một lớp giao diện cho phép phương thức
 *  hiển thị có thể đuợc thực thi hay hoán đổi dễ dàng
 *  trên nhiều Activity khác nhau..
 */
public interface LoginView {
    public void showProgress();

    public void hideProgress();

    public void setUsernameError();

    public void setPasswordError();

    public void navigateToHome();
}
