package vn.soapp.mvpdemo.presenter;

/**
 * Giúp thực thi nhiều logic trên activity
 * hay hoán đổi các logic này cho nhau thông qua việc khởi tạo một lớp Implement khác.
 */
public interface LoginPresenter {
    public void validateCredentials(String username, String password);
}
