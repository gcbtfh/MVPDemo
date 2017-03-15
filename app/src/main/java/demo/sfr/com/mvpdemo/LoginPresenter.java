package demo.sfr.com.mvpdemo;

/**
 * Created by Tong Hung on 15-Mar-17.
 */

public class LoginPresenter implements OnLoginListener {
    private ILoginView loginView;
    private ModelLogin modelLogin;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.modelLogin = new ModelLogin();
    }

    public void validate(String name, String email){
        if(modelLogin.isLogicValidate(name, email)){
            loginView.showLoginSuccess();
        }else {
            loginView.showLoginFailure();
        }
    }

    public void validateAsync(String name, String email){
        modelLogin.logicValidate(this, name, email);
    }

    @Override
    public void OnError() {
        loginView.showLoginFailure();
    }

    @Override
    public void OnSuccess() {
        loginView.showLoginSuccess();
    }
}
