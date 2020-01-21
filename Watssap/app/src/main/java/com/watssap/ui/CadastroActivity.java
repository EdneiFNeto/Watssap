package com.watssap.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.watssap.R;
import com.watssap.model.Usuario;
import com.watssap.retrofit.RetrofitInicializador;
import com.watssap.retrofit.service.UsuarioService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private String TAG = "CadastroActivityLog";
    private EditText nome, email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = findViewById(R.id.txtNome);
        email = findViewById(R.id.txtEmail);
        senha = findViewById(R.id.txtSenha);
    }

    @Override
    protected void onResume() {
        super.onResume();


        findViewById(R.id.button_cadastrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioService user = new RetrofitInicializador().getUser();
                Usuario usuario = new Usuario();

                usuario.setNome(nome.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                usuario.setData("");
                Call<List<Usuario>> call = user.insert(usuario);

                call.enqueue(new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                        Log.e(TAG, "onReponse " + response.body());
                        if (response.body() != null) {
                            if (!response.body().isEmpty()) {
                                for (Usuario user : response.body()) {
                                }

                                startActivity(new Intent(CadastroActivity.this, ChatActivity.class));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Usuario>> call, Throwable t) {

                        email.setError("Email ja existe");
                        Log.e(TAG, "onFailure  " + t.getMessage());
                    }
                });
            }
        });
    }
}
