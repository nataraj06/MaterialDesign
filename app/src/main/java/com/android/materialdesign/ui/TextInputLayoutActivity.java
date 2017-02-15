package com.android.materialdesign.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;

import com.android.materialdesign.R;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout tilUserName;
    private TextInputLayout tilPassword;
    private AppCompatEditText extUserName;
    private AppCompatEditText extPassword;
    private AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilUserName = (TextInputLayout) findViewById(R.id.login_user_name_til);
        tilPassword = (TextInputLayout) findViewById(R.id.login_password_til);

        extUserName = (AppCompatEditText) findViewById(R.id.login_user_name_etxt);
        extPassword = (AppCompatEditText) findViewById(R.id.login_password_etxt);

        extUserName.addTextChangedListener(new LoginTextWatcher(extUserName));
        extUserName.addTextChangedListener(new LoginTextWatcher(extUserName));

        btnLogin = (AppCompatButton) findViewById(R.id.btn_sign);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser();
            }
        });
    }

    private void validateUser() {
        if (!validateName())
            return;
        if (!validatePassword())
            return;

        startActivity(new Intent(TextInputLayoutActivity.this, NavigationViewActivity.class));
    }

    private boolean validateName() {
        if (extUserName.getText().toString().trim().isEmpty()) {
            tilUserName.setError(getString(R.string.login_user_name_error_msg));
            requestFocus(extUserName);
            return false;
        } else {
            tilUserName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validatePassword() {
        if (extPassword.getText().toString().trim().isEmpty()) {
            tilPassword.setError(getString(R.string.login_password_error_msg));
            requestFocus(extPassword);
            return false;
        } else {
            tilPassword.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class LoginTextWatcher implements TextWatcher {

        private View view;

        private LoginTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.login_user_name_til:
                    validateName();
                    break;
                case R.id.login_password_til:
                    validatePassword();
                    break;
            }
        }
    }
}
