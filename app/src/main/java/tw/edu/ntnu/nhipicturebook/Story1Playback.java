package tw.edu.ntnu.nhipicturebook;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.media.MediaPlayer;
import android.os.Environment;
import android.media.AudioManager;
import android.widget.Toast;

import java.io.File;

public class Story1Playback extends DashboardActivity {
    private int page=1;
    FragmentManager fm;
    private MediaPlayer mp;
    Intent intent;
    String audio_path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_playback);

        intent=getIntent();


        FragmentManager fm = getFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.layout_container);
        fragment = storyfragment.newInstance(page);
        replaceFragment(fragment);

        Button buttonNext = (Button) this.findViewById(R.id.btn_next);
        Button buttonBack = (Button) this.findViewById(R.id.btn_back);
        Button buttonPlay = (Button) this.findViewById(R.id.btn_play);
        Button buttonStop= (Button) this.findViewById(R.id.btn_stop);

        buttonNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(view.getId());
            }
        });

        buttonBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(view.getId());
            }
        });
        buttonPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(view.getId());
            }
        });

        buttonStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick(view.getId());
            }
        });

    }


    private void onButtonClick(int id) {
        if (id == R.id.btn_next)
        {
            if (mp != null)
            {
                mp.stop();
            }
            if(page==4) {
                page=1;
                replaceFragment(storyfragment.newInstance(page));
            }
            else {
                replaceFragment(storyfragment.newInstance(++page));
            }
        }
        else  if (id == R.id.btn_back)
        {
            if (mp != null)
            {
                mp.stop();
            }
            if(page!=1)
            replaceFragment(storyfragment.newInstance(--page));
        }
        else if(id == R.id.btn_play)
        {

            audio_path=intent.getStringExtra("fileName");
            audio_path=audio_path+"/Story1/page"+page+".3gp";
            //Toast.makeText(this,audio_path,Toast.LENGTH_SHORT).show();

            if(isFile(audio_path))
                playAudio(audio_path);
            else
                Toast.makeText(this,"File does not exist.",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.btn_stop)
        {
            if (mp != null)
            {
                mp.stop();
            }
        }

    }

    private void replaceFragment(Fragment fragment) {
        this.getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.animator.fade_in,
                        android.R.animator.fade_out)
                .replace(R.id.layout_container, fragment).addToBackStack(null)
                .commit();
    }

    private boolean isSDExist() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }

    private boolean isFile(String recordPath)
    {
        File dirFile = new File(recordPath);
        if(!dirFile.exists())// if file not exist
            return false;
         else
            return true;
    }
    private void playAudio(String path) {

        if(mp == null)
            mp = new MediaPlayer();
        try {
            mp.reset();
            mp.setDataSource(path);
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.prepare();
            mp.start();
            //mp.setLooping(true);
        } catch (Exception e) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

}
