package com.percival.beth.apptest.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by beth_ on 26/03/2018.
 */

public class AddViewsToAnotherView {

    public static void addImageViewsToLinearLayout(String[] imageUrls, LinearLayout parentView, Context context) {
        for (int i = 0; i < imageUrls.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            Picasso.get().load(imageUrls[i]).into(imageView);
            parentView.addView(imageView);
        }
    }

    public static void addTextViewsToLinearLayout(String[] textList, LinearLayout parentView, Context context) {
        for (int i = 0; i < textList.length; i++) {
            TextView textView = new TextView(context);
            textView.setText(textList[i]);
            parentView.addView(textView);
        }
    }
}
