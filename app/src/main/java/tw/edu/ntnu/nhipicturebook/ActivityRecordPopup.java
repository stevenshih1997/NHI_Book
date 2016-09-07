package tw.edu.ntnu.nhipicturebook;

import android.os.Bundle;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

public class ActivityRecordPopup extends DashboardActivity {


    private ImageButton record_button;
    private boolean isRecording = false;
    private ProgressBar record_volumn;
    private boolean isMediaPlay = false;

    private MyRecoder myRecoder;



    private String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordpopup);
        processViews();


        Intent intent = getIntent();
        fileName = intent.getStringExtra("fileName");
    }


    public void onSubmit(View view) {
        if (isRecording) {

            myRecoder.stop();
        }


        if (view.getId() == R.id.record_ok) {
            if(isMediaPlay) {
                myRecoder.stop();

            }
            Intent result = getIntent();
            setResult(DashboardActivity.RESULT_OK, result);
        }
//Clicking cancel without recording causes crash

        finish();
    }

    private void processViews() {
        record_button = (ImageButton) findViewById(R.id.record_button);
        record_volumn = (ProgressBar) findViewById(R.id.record_volumn);

         setProgressBarIndeterminateVisibility(false);
    }

    public void clickRecord(View view) {

        isRecording = !isRecording;


        if (isRecording) {
             isMediaPlay=true;

            record_button.setImageResource(R.drawable.ic_action_name);

            myRecoder = new MyRecoder(fileName);

            myRecoder.start();

            //new MicLevelTask().execute();
        }

        else {

            record_button.setImageResource(R.drawable.record_sound_icon);

            record_volumn.setProgress(0);

            myRecoder.stop();
        }
    }


   /* private class MicLevelTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... args) {

            while (isRecording) {
                publishProgress();

                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    Log.d("RecordActivity", e.toString());
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            record_volumn.setProgress((int) myRecoder.getAmplitudeEMA());
        }

    }
*/

    private class MyRecoder {

        private static final double EMA_FILTER = 0.6;
        private MediaRecorder recorder = null;
        private double mEMA = 0.0;
        private String output;


        MyRecoder(String output) {
            this.output = output;
        }


        public void start() {
            if (recorder == null) {

                recorder = new MediaRecorder();

                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);


                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                recorder.setOutputFile(output);

                try {

                    recorder.prepare();
                }
                catch (IOException e) {
                    Log.d("RecordActivity", e.toString());
                }



                recorder.start();
                mEMA = 0.0;
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        }


        public void stop() {
            if (recorder != null) {

                recorder.stop();

                recorder.release();
                recorder = null;
            }
        }

        public double getAmplitude() {
            if (recorder != null)
                return (recorder.getMaxAmplitude() / 2700.0);
            else
                return 0;
        }


        public double getAmplitudeEMA() {
            double amp = getAmplitude();
            mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA;
            return mEMA;
        }

    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            record_volumn.setProgress((int) myRecoder.getAmplitudeEMA());

            handler.sendMessageDelayed(Message.obtain(), 300);
        }

    };
}


