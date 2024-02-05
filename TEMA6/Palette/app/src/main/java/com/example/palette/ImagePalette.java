package com.example.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import java.util.Objects;

public class ImagePalette extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Slide());
        getWindow().setSharedElementEnterTransition(new ChangeImageTransform());
        setContentView(R.layout.activity_image_palette);

        // Obtén la imagen seleccionada del Intent
        int selectedImage = getIntent().getIntExtra("image_resource", 0);

        // Configura la imagen en el ImageView
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(selectedImage);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), selectedImage);
        Palette.from(bitmap).generate(palette -> {
            if(palette != null) {
                int defaultColor = 0xFFFFFF;
                int vibrantColor = palette.getVibrantColor(defaultColor);
                int vibrantDarkColor = palette.getDarkVibrantColor(defaultColor);
                int vibrantLightColor = palette.getLightVibrantColor(defaultColor);
                int mutedColor = palette.getMutedColor(defaultColor);
                int mutedDarkColor = palette.getDarkMutedColor(defaultColor);
                int mutedLightColor = palette.getLightMutedColor(defaultColor);

                Toolbar toolbar = findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                toolbar.setBackgroundColor(vibrantColor);
                Objects.requireNonNull(getSupportActionBar()).setTitle("Palette");

                Window window = getWindow();
                window.setStatusBarColor(vibrantDarkColor);

                TextView textView = findViewById(R.id.imageView2);
                textView.setBackgroundColor(mutedColor);

                TextView textView2 = findViewById(R.id.imageView3);
                textView2.setBackgroundColor(vibrantLightColor);

                TextView textView3 = findViewById(R.id.imageView4);
                textView3.setBackgroundColor(mutedDarkColor);

                TextView textView4 = findViewById(R.id.imageView5);
                textView4.setBackgroundColor(mutedLightColor);
            }

        });
    }

}
