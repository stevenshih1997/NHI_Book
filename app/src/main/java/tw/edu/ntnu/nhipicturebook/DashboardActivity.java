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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;


/**
 * This is the base class for activities in the dashboard application.
 * It implements methods that are useful to all top level activities.
 * That includes: (1) stub methods for all the activity lifecycle methods;
 * (2) onClick methods for clicks on home, search, feature 1, feature 2, etc.
 * (3) a method for displaying a message to the screen via the Toast class.
 *
 */

public abstract class DashboardActivity extends Activity
{

/**
 * onCreate - called when the activity is first created.
 *
 * Called when the activity is first created. 
 * This is where you should do all of your normal static set up: create views, bind data to lists, etc. 
 * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
 * 
 * Always followed by onStart().
 *
 */

private File SDCardpath = Environment.getExternalStorageDirectory();
    private String path = SDCardpath.getPath()+ "/Record"+"/Story1";


    protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    //setContentView(R.layout.activity_default);

}

    
/**
 * onDestroy
 * The final call you receive before your activity is destroyed. 
 * This can happen either because the activity is finishing (someone called finish() on it, 
 * or because the system is temporarily destroying this instance of the activity to save space. 
 * You can distinguish between these two scenarios with the isFinishing() method.
 *
 */

protected void onDestroy ()
{
   super.onDestroy ();
}

/**
 * onPause
 * Called when the system is about to start resuming a previous activity. 
 * This is typically used to commit unsaved changes to persistent data, stop animations 
 * and other things that may be consuming CPU, etc. 
 * Implementations of this method must be very quick because the next activity will not be resumed 
 * until this method returns.
 * Followed by either onResume() if the activity returns back to the front, 
 * or onStop() if it becomes invisible to the user.
 *
 */

protected void onPause ()
{
   super.onPause ();
}

/**
 * onRestart
 * Called after your activity has been stopped, prior to it being started again.
 * Always followed by onStart().
 *
 */

protected void onRestart ()
{
   super.onRestart ();
}

/**
 * onResume
 * Called when the activity will start interacting with the user. 
 * At this point your activity is at the top of the activity stack, with user input going to it.
 * Always followed by onPause().
 *
 */

protected void onResume ()
{
   super.onResume ();
}

/**
 * onStart
 * Called when the activity is becoming visible to the user.
 * Followed by onResume() if the activity comes to the foreground, or onStop() if it becomes hidden.
 *
 */

protected void onStart ()
{
   super.onStart ();
}

/**
 * onStop
 * Called when the activity is no longer visible to the user
 * because another activity has been resumed and is covering this one. 
 * This may happen either because a new activity is being started, an existing one 
 * is being brought in front of this one, or this one is being destroyed.
 *
 * Followed by either onRestart() if this activity is coming back to interact with the user, 
 * or onDestroy() if this activity is going away.
 */

protected void onStop ()
{
   super.onStop ();
}

/**
 */
// Click Methods

/**
 * Handle the click on the home button.
 * 
 * @param v View
 * @return void
 */

public void onClickHome (View v)
{
    goHome (this);
}

    /**
     * Handle the click on the About button.
     *
     * @param v View
     * @return void
     */

    public void onClickAbout (View v)
    {
        startActivity (new Intent(getApplicationContext(), AboutActivity.class));
    }


/**
 * Handle the click of a Feature button.
 *
 * @param v View
 * @return void
 */

public void onClickFeature (View v)
{

    int id = v.getId ();
    switch (id) {
      case R.id.home_btn_feature1 :
          String path = SDCardpath.getPath()+ "/Record"+"/Mom";
          Intent recordIntent = new Intent();
          recordIntent.setClass(DashboardActivity.this,F1Activity.class);
          recordIntent.putExtra("fileName", path);
           startActivity (recordIntent);
           break;
      case R.id.home_btn_feature2 :
          String path2 = SDCardpath.getPath()+ "/Record"+"/Dad";
          Intent recordIntent2 = new Intent();
          recordIntent2.setClass(DashboardActivity.this,F2Activity.class);
          recordIntent2.putExtra("fileName", path2);
          startActivity (recordIntent2);
           break;
      case R.id.home_btn_feature3 :
          String path3 = SDCardpath.getPath()+ "/Record"+"/Grandma";
          Intent recordIntent3 = new Intent();
          recordIntent3.setClass(DashboardActivity.this,F3Activity.class);
          recordIntent3.putExtra("fileName", path3);
          startActivity (recordIntent3);           break;
      case R.id.home_btn_feature4 :
          String path4 = SDCardpath.getPath()+ "/Record"+"/Grandpa";
          Intent recordIntent4 = new Intent();
          recordIntent4.setClass(DashboardActivity.this,F4Activity.class);
          recordIntent4.putExtra("fileName", path4);
          startActivity (recordIntent4);           break;


      default: 
    	   break;
    }
}

/**
 */
// More Methods

/**
 * Go back to the home activity.
 * 
 * @param context Context
 * @return void
 */

public void goHome(Context context) 
{
    final Intent intent = new Intent(context, HomeActivity.class);
    intent.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP);
    context.startActivity (intent);
}

/**
 * Use the activity label to set the text in the activity's title text view.
 * The argument gives the name of the view.
 *
 * <p> This method is needed because we have a custom title bar rather than the default Android title bar.
 * See the theme definitons in styles.xml.
 * 
 * @param textViewId int
 * @return void
 */


 // end setTitleText

/**
 * Show a string on the screen via Toast.
 * 
 * @param msg String
 * @return void
 */


 // end toast

/**
 * Send a message to the debug log and display it using Toast.
 */


} // end class
