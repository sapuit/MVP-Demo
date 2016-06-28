package vn.soapp.mvpdemo.model;

/**
 * Created by sapui on 6/28/2016.
 */
public interface LoginInteractor {
    public void login(String username, String password, OnLoginFinishedListener listener);
}
