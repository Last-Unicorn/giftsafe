package org.giftsafe.givesafe.donator.activities;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.giftsafe.givesafe.R;

import java.io.IOException;
import java.io.InputStream;

public class DonationRequestActivity extends ActionBarActivity {
  ImageView profileImageView;
  TextView profileDescriptionTxt;
  TextView homelessNameTxt;
  Button give1DolarBtn;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_donation_request);
    profileImageView = (ImageView) findViewById(R.id.profileImageView);
    profileDescriptionTxt = (TextView) findViewById(R.id.profileDescriptionTxt);
    homelessNameTxt = (TextView) findViewById(R.id.homelessNameTxt);
    give1DolarBtn = (Button) findViewById(R.id.give1DolarBtn);
    Bitmap image = getBitmapFromAsset("homeless2.jpg");
    profileImageView.setImageBitmap(image);
    profileDescriptionTxt.setMovementMethod(new ScrollingMovementMethod());
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_donation_request, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private Bitmap getBitmapFromAsset(String strName)
  {
    AssetManager assetManager = getAssets();
    InputStream istr = null;
    try {
      istr = assetManager.open(strName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    Bitmap bitmap = BitmapFactory.decodeStream(istr);
    return bitmap;
  }
}
