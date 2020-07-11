package com.example.smartnotify;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Progress_signup {
    private CardView card;
    private ConstraintLayout layout;
    private ProgressBar progress;
    private TextView text;
Animation fade_in;

    Progress_signup(Context ct, View view){

        fade_in= AnimationUtils.loadAnimation(ct,R.anim.fade_in);
        card=view.findViewById(R.id.card);
        layout=view.findViewById(R.id.layout);
        progress=view.findViewById(R.id.progress);
        text = view.findViewById(R.id.text);
    }
    void buttonActivated(){
        progress.setAnimation(fade_in);
        progress.setVisibility(View.VISIBLE);
        text.setAnimation(fade_in);
        text.setText("please wait...");


    }
    void buttonFinished(){
        layout.setBackgroundColor(card.getResources().getColor(R.color.green));
        progress.setVisibility(View.GONE);
        text.setText("Done!");

    }
}
