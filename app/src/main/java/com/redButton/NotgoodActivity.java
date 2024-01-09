package com.redButton;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class NotgoodActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout linear3;
	private TextView textview3;
	private TextView textview2;
	
	private TimerTask sd;
	private Intent asd = new Intent();
	private AlertDialog.Builder dw;
	private Intent emergency = new Intent();
	private MediaPlayer as;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.notgood);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		textview3 = findViewById(R.id.textview3);
		textview2 = findViewById(R.id.textview2);
		dw = new AlertDialog.Builder(this);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dw.setTitle("تأكيد ايقاف الانزار !");
				dw.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						asd.setClass(getApplicationContext(), MainActivity.class);
						startActivity(asd);
						sd.cancel();
						as.pause();
					}
				});
				dw.create().show();
			}
		});
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFFFFFFFF));
		sd = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						linear1.setBackgroundColor(0xFFF44336);
						sd = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										linear1.setBackgroundColor(0xFF2196F3);
									}
								});
							}
						};
						_timer.schedule(sd, (int)(250));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(sd, (int)(0), (int)(500));
		sd = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview2.setText(String.valueOf((long)(Double.parseDouble(textview2.getText().toString()) - 1)));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(sd, (int)(0), (int)(1000));
		sd = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						emergency.setAction(Intent.ACTION_CALL);
						emergency.setData(Uri.parse("tel:122"));
						startActivity(emergency);
					}
				});
			}
		};
		_timer.schedule(sd, (int)(40000));
		as = MediaPlayer.create(getApplicationContext(), R.raw.beep);
		as.setLooping(true);
		as.start();
	}
	
	@Override
	public void onBackPressed() {
		dw.setTitle("تأكيد ايقاف الانزار !");
		dw.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				asd.setClass(getApplicationContext(), MainActivity.class);
				startActivity(asd);
				sd.cancel();
				as.pause();
			}
		});
		dw.create().show();
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}