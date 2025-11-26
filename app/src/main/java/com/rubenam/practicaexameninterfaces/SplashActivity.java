package com.rubenam.practicaexameninterfaces;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.rubenam.practicaexameninterfaces.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ImageView backImage = findViewById(R.id.iv_splash_backimage); sin binding

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.rotation);
        binding.ivSplashLogo.startAnimation(myAnim);

        Glide.with(this)
                .load("https://i.pinimg.com/736x/5a/1b/11/5a1b116edc2c526aa67132b35a826390.jpg")
                .centerCrop()
                .into(binding.ivSplashBackimage);

        openMain();
    }

    private void openMain() {
        Handler handler = new Handler(android.os.Looper.getMainLooper());
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                }, 5000
        );
    }
}