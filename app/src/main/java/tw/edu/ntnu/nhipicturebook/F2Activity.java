/*
 * Copyright (C) 2011 Wglxy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tw.edu.ntnu.nhipicturebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is the activity for feature 2 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class F2Activity extends DashboardActivity 
{
    private String fileName;
    Intent intent;


protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_f2);

    intent = getIntent();
}

    public void onClickMedia (View v)
    {
        fileName = intent.getStringExtra("fileName");
        Intent recordIntent = new Intent();
        int id = v.getId ();
        switch (id) {
            case R.id.btn_playback :
                recordIntent.setClass(F2Activity.this,Story1Playback.class);
                recordIntent.putExtra("fileName", fileName);
                startActivity (recordIntent);
                break;
            case R.id.btn_record :

                recordIntent.setClass(F2Activity.this,F2ActivityRecordStory1.class);
                recordIntent.putExtra("fileName", fileName);
                startActivity (recordIntent);
                break;
            case R.id.btn_playback2 :
                recordIntent.setClass(F2Activity.this,Story2Playback.class);
                recordIntent.putExtra("fileName", fileName);
                startActivity (recordIntent);
                break;
            case R.id.btn_record2 :

                recordIntent.setClass(F2Activity.this,F2ActivityRecordStory2.class);
                recordIntent.putExtra("fileName", fileName);
                startActivity (recordIntent);
                break;
            case R.id.btn_playback3 :
                recordIntent.setClass(F2Activity.this,Story3Playback.class);
                recordIntent.putExtra("fileName", fileName);
                startActivity (recordIntent);
                break;
            case R.id.btn_record3 :

                recordIntent.setClass(F2Activity.this,F2ActivityRecordStory3.class);
                recordIntent.putExtra("fileName", fileName);
                startActivity (recordIntent);                break;



            default:
                break;
        }
    }
} // end class
