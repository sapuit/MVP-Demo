package vn.soapp.mvpdemo.model;

/**
 *  sử dụng như một custom listener cho phép đa dạng hóa
 *  các phương thức hiển thị kết quả tới người dùng
 */
public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
