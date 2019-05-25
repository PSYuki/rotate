package com.example.user.rotate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FrontBackSwitchActivity extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_back);
    }

    @Override
    public void onClick(View v) {
        switchFrontBackView(false);  // 表から裏にひっくり返す場合
//		switchFrontBackView(true);   // 裏から表にひっくり返す場合
    }

    private void switchFrontBackView(boolean isReverse) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        View frontView = (ImageView)findViewById(R.id.imageViewFront);
        View backView = (ImageView)findViewById(R.id.imageViewBack);

        if(frontView == null || backView == null) return;

        FrontBackSwitchAnimator animator =
                new FrontBackSwitchAnimator(frontView, backView, backView.getWidth() /2 , backView.getHeight() / 2);
        if(isReverse) animator.reverse();
        relativeLayout.startAnimation(animator);
    }
}