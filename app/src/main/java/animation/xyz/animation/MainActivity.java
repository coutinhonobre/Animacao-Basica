package animation.xyz.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template_animation);

        final List<ImageView> imagens = new ArrayList<>();

        b=(Button)findViewById(R.id.button);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);

        imagens.add((ImageView) findViewById(R.id.imageView1));
        imagens.add((ImageView) findViewById(R.id.imageView2));
        imagens.add((ImageView) findViewById(R.id.imageView3));
        imagens.add((ImageView) findViewById(R.id.imageView4));
        imagens.add((ImageView) findViewById(R.id.imageView5));

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                for (int x = 0; x < imagens.size(); x++){
                    if (i >= x){
                        imagens.get(x).setVisibility(View.VISIBLE);
                        imagens.get(x).startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.lefttoright));
                    }else {
                        imagens.get(x).setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView1.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.VISIBLE);
                imageView1.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.lefttoright));
                imageView2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.sample_anim));
                imageView3.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.righttoleft));
                imageView4.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.lefttoright));
                imageView5.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.sample_anim));

            }
        });


    }
}
