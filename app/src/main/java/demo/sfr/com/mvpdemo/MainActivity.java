package demo.sfr.com.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ILoginView {
    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////
    private EditText etName, etEmail;
    private Button btnSubmit;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        submit();
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        presenter = new LoginPresenter(this);
    }

    private void submit(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.getInstance().showProgressDialog(MainActivity.this);
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                presenter.validateAsync(name, email);
            }
        });
    }

    @Override
    public void showLoginSuccess() {
        DialogUtil.getInstance().dismissProgressDialog();
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailure() {
        DialogUtil.getInstance().dismissProgressDialog();
        Toast.makeText(this, "Login failure", Toast.LENGTH_SHORT).show();
    }
}
