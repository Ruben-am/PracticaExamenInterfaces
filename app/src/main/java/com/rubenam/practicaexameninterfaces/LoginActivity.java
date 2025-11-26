package com.rubenam.practicaexameninterfaces;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.rubenam.practicaexameninterfaces.databinding.ActivityLoginBinding;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoginSweet.setOnClickListener(view -> {
            String usuario = binding.etLoginUser.getText().toString().trim();
            String contrasenna = binding.etLoginPassword.getText().toString().trim();

            if (usuario.isEmpty() || contrasenna.isEmpty()) {
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Error")
                        .setContentText("Introduce los datos para logearte")
                        .show();
            } else {
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Hola " + usuario)
                        .setContentText("Logeado correctamente")
                        .setConfirmText("Continuar")
                        .setConfirmClickListener(sweetAlertDialog -> {
                            sweetAlertDialog.dismissWithAnimation();

                            Intent intent = new Intent(this, SingUpActivity.class);
                            startActivity(intent);
                        })
                        .show();
            }
        });
    }
}