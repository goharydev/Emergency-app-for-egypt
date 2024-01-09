package com.redButton;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import java.util.regex.*;
import org.json.*;

public class EmerencyActivity extends AppCompatActivity {
	
	private ScrollView vscroll3;
	private LinearLayout linear1;
	private ImageView imageview3;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private EditText edittext4;
	private EditText edittext5;
	private EditText edittext6;
	private EditText edittext7;
	private LinearLayout linear2;
	private Button save;
	private LinearLayout call;
	private ImageView imageview2;
	
	private SharedPreferences phones;
	private Intent calls = new Intent();
	private AlertDialog.Builder sd;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.emerency);
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
		vscroll3 = findViewById(R.id.vscroll3);
		linear1 = findViewById(R.id.linear1);
		imageview3 = findViewById(R.id.imageview3);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		edittext4 = findViewById(R.id.edittext4);
		edittext5 = findViewById(R.id.edittext5);
		edittext6 = findViewById(R.id.edittext6);
		edittext7 = findViewById(R.id.edittext7);
		linear2 = findViewById(R.id.linear2);
		save = findViewById(R.id.save);
		call = findViewById(R.id.call);
		imageview2 = findViewById(R.id.imageview2);
		phones = getSharedPreferences("phones", Activity.MODE_PRIVATE);
		sd = new AlertDialog.Builder(this);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sd.setTitle("هل تود تحديث البيانات ؟");
				sd.setMessage("سيتم استبدال البيانات السابقة بالبيانات الجديدة ولا يوجد امكانية لأسترجاعها !");
				sd.setPositiveButton("تحديث", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						phones.edit().putString("1", edittext1.getText().toString()).commit();
						phones.edit().putString("2", edittext2.getText().toString()).commit();
						phones.edit().putString("3", edittext3.getText().toString()).commit();
						phones.edit().putString("4", edittext4.getText().toString()).commit();
						phones.edit().putString("5", edittext5.getText().toString()).commit();
						phones.edit().putString("6", edittext6.getText().toString()).commit();
						phones.edit().putString("7", edittext7.getText().toString()).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "تم التحديث");
						finish();
					}
				});
				sd.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				sd.create().show();
			}
		});
		
		call.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				calls.setAction(Intent.ACTION_CALL);
				calls.setData(Uri.parse("tel:".concat(edittext1.getText().toString())));
				startActivity(calls);
			}
		});
	}
	
	private void initializeLogic() {
		edittext1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		edittext2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		edittext3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		edittext4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		edittext5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		edittext6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		edittext7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFF7F8F8));
		save.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, 0xFFFF0017, 0xFFFF0017));
		call.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, 0xFFFF0017, 0xFFFF0017));
		edittext1.setText(phones.getString("1", ""));
		edittext2.setText(phones.getString("2", ""));
		edittext3.setText(phones.getString("3", ""));
		edittext4.setText(phones.getString("4", ""));
		edittext5.setText(phones.getString("5", ""));
		edittext6.setText(phones.getString("6", ""));
		edittext7.setText(phones.getString("7", ""));
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