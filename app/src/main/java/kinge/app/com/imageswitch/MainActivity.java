package kinge.app.com.imageswitch;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import kinge.app.com.ImageSwitch;
public class MainActivity extends AppCompatActivity {
    private String img[]={"http://img1.3lian.com/2015/w7/98/d/22.jpg","http://img.61gequ.com/allimg/2011-4/201142614314278502.jpg","http://pic1.nipic.com/2008-12-25/2008122510134038_2.jpg"};
    private int index;   ImageSwitch imageSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        imageSwitch=(ImageSwitch) findViewById(R.id.image);
        imageSwitch.setLoadNext(new ImageSwitch.LoadNext() {
            @Override
            public View createItem() {
                SimpleDraweeView view=new SimpleDraweeView(MainActivity.this);
                ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                view.setLayoutParams(lp);
                return view;
            }

            @Override
            public void bindData(View view, int position) {
                SimpleDraweeView draweeView;
                draweeView= (SimpleDraweeView) view;
                draweeView.setImageURI(Uri.parse(img[position]));
                System.out.println(" position "+position);
            }

            @Override
            public int getCount() {
                return img.length;
            }
        });
        imageSwitch.start(2000);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}
