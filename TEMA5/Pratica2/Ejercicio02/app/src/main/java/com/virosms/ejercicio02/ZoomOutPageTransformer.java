package com.virosms.ejercicio02;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

/**
 * ZoomOutPageTransformer es una implementación de ViewPager2.PageTransformer que proporciona una animación de transformación de página de zoom.
 * @author charles
 * @version 1.0
 * @since 2024-02-05
 * @see ViewPager2.PageTransformer
 * @see ViewPager2
 * @see View
 */
public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    /**
     * Aplica una transformación a la página especificada.
     * @param view La página a la que se aplica la transformación.
     * @param position Posición de la página relativa al centro de la pantalla. 0 es el centro. Los valores negativos indican páginas a la izquierda, y los valores positivos indican páginas a la derecha.
     */
    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // Esta página está muy a la izquierda de la pantalla.
            view.setAlpha(0f);

        } else if (position <= 1) { // [-1,1]
            // Modifica la transición de deslizamiento predeterminada para reducir también la página
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Reduce el tamaño de la página (entre MIN_SCALE y 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Desvanece la página en relación con su tamaño.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // Esta página está muy a la derecha de la pantalla.
            view.setAlpha(0f);
        }
    }
}