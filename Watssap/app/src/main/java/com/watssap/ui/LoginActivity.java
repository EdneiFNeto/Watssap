package com.watssap.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.watssap.R;
import com.watssap.model.Usuario;
import com.watssap.retrofit.RetrofitInicializador;
import com.watssap.util.PreferencesUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private String TAG = "LoginActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class));
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        EditText email = findViewById(R.id.textEmailLogin);
        EditText senha = findViewById(R.id.textSenhaLogin);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty()) {
                    email.setError("Preencha o campo email");
                    email.requestFocus();
                } else if (senha.getText().toString().isEmpty()) {
                    senha.setError("Preencha o campo Senha");
                    senha.requestFocus();
                } else {
                    Usuario usuario = new Usuario();
                    usuario.setEmail(email.getText().toString());
                    usuario.setSenha(senha.getText().toString());
                    Call<List<Usuario>> call = new RetrofitInicializador().getUser().login(usuario);
                    call.enqueue(new Callback<List<Usuario>>() {
                        @Override
                        public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {

                            List<Usuario> usuarios = response.body();
                            if (usuarios != null) {
                                if (!usuarios.isEmpty()) {
                                    for (Usuario u : usuarios) {
                                        Log.e(TAG, "Usuario usuario " + u);
                                        SharedPreferences sharedPreferences = new PreferencesUtils(LoginActivity.this).getSharedPreferences();
                                        PreferencesUtils.saveUsuarioID(sharedPreferences, u);
                                    }
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<List<Usuario>> call, Throwable t) {

                        }
                    });
                }
            }
        });

        showChat();
    }

    private void showChat(){
        SharedPreferences sharedPreferences = new PreferencesUtils(this).getSharedPreferences();
        long usuarioId = sharedPreferences.getLong(PreferencesUtils.USUARIO_ID, 0);
        if(usuarioId > 0){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}
