package com.ddona.day4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Placeholder plView;
    private ConstraintLayout clRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plView = findViewById(R.id.pl_view);
        clRoot = findViewById(R.id.cl_root);
    }

    public void swapView(View view) {
        TransitionManager.beginDelayedTransition(clRoot);
        plView.setContentId(view.getId());
    }
}
