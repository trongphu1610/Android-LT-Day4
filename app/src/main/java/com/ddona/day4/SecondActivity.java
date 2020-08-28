package com.ddona.day4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;

public class SecondActivity extends AppCompatActivity {
    private ConstraintLayout clRoot;
    private ConstraintSet setOld = new ConstraintSet();
    private ConstraintSet setNew = new ConstraintSet();
    private boolean isAlt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        clRoot = findViewById(R.id.layout);

        setOld.clone(clRoot);
        setNew.clone(this, R.layout.activity_three);
    }

    public void swapView(View view) {
        Transition changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new OvershootInterpolator());
        TransitionManager.beginDelayedTransition(clRoot, changeBounds);
        if(!isAlt) {
            setNew.applyTo(clRoot);
            isAlt = true;
        } else {
            setOld.applyTo(clRoot);
            isAlt = false;
        }
    }
}
