package tw.edu.ntnu.nhipicturebook;

/**
 * Created by stevenshih on 2016-06-22.
 */

import android.content.Intent;
import android.os.Environment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;

import java.io.File;

public class F1ActivityRecordStory1 extends DashboardActivity {

private String fileName;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1recordlist);
        productionUI();

        creatStoryFile();

        intent = getIntent();

    }



    private void productionUI()
    {

        LinearLayout linear = (LinearLayout)findViewById(R.id.linear);

        for (int i=1; i<=13; i++) {
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            params.topMargin=10;

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);

            linear.addView(layout,  params);


            TextView textView = new TextView(this);
            textView.setText(getString(R.string.text_name)+ " " + i + " " + getString(R.string.text_ending));
            setTextViewParams(textView);
            layout.addView(textView);


            Button button = new Button(this);
            button.setText(getString(R.string.button_name));
            button.setId(i);
            setButtonParams(button);
            layout.addView(button);
            button.setOnClickListener(buttonListener);



        }

    }

    OnClickListener buttonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {


            switch(v.getId())
            {

                case 1:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";

                    goToRecord(fileName  );
                    break;

                case 2:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;
                case 3:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;
                case 4:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 5:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 6:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 7:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 8:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 9:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 10:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 11:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 12:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                case 13:
                    fileName = intent.getStringExtra("fileName")+"/Story1";
                    fileName=fileName+"/page"+v.getId()+".3gp";
                    goToRecord(fileName  );
                    break;

                /*default:
                    Toast.makeText(F1ActivityRecordStory1.this, "button other",Toast.LENGTH_LONG).show();
                    break;*/
            }
        }
    };

    private void setButtonParams(Button button)
    {
        int buttonWidth = (int) getResources().getDimension(R.dimen.width_button);
        int buttonHeight = (int) getResources().getDimension(R.dimen.height_button);
        int marginLeft = (int) getResources().getDimension(R.dimen.left_margin_button);
        int marginRight = (int) getResources().getDimension(R.dimen.right_margin_button);
        LinearLayout.LayoutParams buttonParams =
                new LinearLayout.LayoutParams(
                       // LinearLayout.LayoutParams.WRAP_CONTENT,
                       // LinearLayout.LayoutParams.WRAP_CONTENT
                        //380,110);
                          buttonWidth,buttonHeight);
        //180
        //50
        buttonParams.leftMargin=marginLeft;
        buttonParams.rightMargin=marginRight;
        button.setLayoutParams(buttonParams);

    }

    private void setTextViewParams(TextView textView)
    {
        int pageWidth = (int) getResources().getDimension(R.dimen.page_text_width);
        int pageHeight = (int) getResources().getDimension(R.dimen.page_text_height);
        int margin = (int) getResources().getDimension(R.dimen.page_text_margin);
        LinearLayout.LayoutParams textViewParams =
                new LinearLayout.LayoutParams(
                       // LinearLayout.LayoutParams.WRAP_CONTENT,
                        //LinearLayout.LayoutParams.WRAP_CONTENT
                       // 160,100);
                        pageWidth,pageHeight);


        //50,50
        textViewParams.rightMargin=margin;
        textViewParams.leftMargin=margin;
        textView.setLayoutParams(textViewParams);

    }

    private boolean isSDExist() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }



    private void creatStoryFile() {
        if(isSDExist()) {
            File SDCardpath = Environment.getExternalStorageDirectory();
            String recordPath = SDCardpath.getPath()+ "/Record"+"/Mom"+"/Story1";

            File dirFile = new File(recordPath);
            if(!dirFile.exists()){
                dirFile.mkdir();
            }
        }
    }



    private void goToRecord(String path) {
        // 錄音
        Intent recordIntent = new Intent(this, ActivityRecordPopup.class);
        recordIntent.putExtra("fileName", path);
        startActivityForResult(recordIntent, 0);

    }
}
