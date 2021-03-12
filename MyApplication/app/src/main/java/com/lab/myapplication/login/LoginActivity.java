package com.lab.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lab.myapplication.MainActivity;
import com.lab.myapplication.NavActivity;
import com.lab.myapplication.ProductActivity;
import com.lab.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.inputUsername);
        etPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallAPILogin();
            }


        });

    }

    private void clickCallAPILogin() {
        UserLoginRequest userLoginRequest=new UserLoginRequest(etUsername.getText().toString(),etPassword.getText().toString());
        LoginApiService.apiService.callLogin(userLoginRequest).enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {//call api thanh cong
                Toast.makeText(LoginActivity.this,"Call Api success", Toast.LENGTH_SHORT).show();
                UserLoginResponse userLoginResponse=response.body();
                if (userLoginResponse!=null&& userLoginResponse.getMessage().equals("login success")){
                    // login thanh cong
                    Toast.makeText(LoginActivity.this,"login thanh cong",Toast.LENGTH_SHORT).show();
                    String token= userLoginResponse.getData();
                    Toast.makeText(LoginActivity.this,token,Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this, NavActivity.class);
//                    Bundle bundle=new Bundle();
//                    bundle.putSerializable("response",userLoginResponse);
//                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {//call api loi
                Toast.makeText(LoginActivity.this,"Call Api error",Toast.LENGTH_SHORT).show();
            }
        });
    }

}