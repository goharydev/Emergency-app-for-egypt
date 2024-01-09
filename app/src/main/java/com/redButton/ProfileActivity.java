package com.redButton;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class ProfileActivity extends AppCompatActivity {
	
	private LinearLayout main1;
	private ImageView imageview3;
	private CardView cardview1;
	private ScrollView vscroll1;
	private ImageView imageview2;
	private ImageView imageview1;
	private LinearLayout main2;
	private LinearLayout name_linear;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout blood_box;
	private Button button1;
	private EditText name;
	private EditText phone;
	private EditText bro_phone;
	private EditText hight;
	private LinearLayout fasel;
	private EditText wight;
	private EditText date;
	private EditText address;
	private LinearLayout blood1;
	private LinearLayout blood2;
	private LinearLayout blood3;
	private LinearLayout blood4;
	private LinearLayout blood5;
	private LinearLayout blood6;
	private LinearLayout blood7;
	private LinearLayout blood8;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	
	private SharedPreferences user;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		main1 = findViewById(R.id.main1);
		imageview3 = findViewById(R.id.imageview3);
		cardview1 = findViewById(R.id.cardview1);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview2 = findViewById(R.id.imageview2);
		imageview1 = findViewById(R.id.imageview1);
		main2 = findViewById(R.id.main2);
		name_linear = findViewById(R.id.name_linear);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		blood_box = findViewById(R.id.blood_box);
		button1 = findViewById(R.id.button1);
		name = findViewById(R.id.name);
		phone = findViewById(R.id.phone);
		bro_phone = findViewById(R.id.bro_phone);
		hight = findViewById(R.id.hight);
		fasel = findViewById(R.id.fasel);
		wight = findViewById(R.id.wight);
		date = findViewById(R.id.date);
		address = findViewById(R.id.address);
		blood1 = findViewById(R.id.blood1);
		blood2 = findViewById(R.id.blood2);
		blood3 = findViewById(R.id.blood3);
		blood4 = findViewById(R.id.blood4);
		blood5 = findViewById(R.id.blood5);
		blood6 = findViewById(R.id.blood6);
		blood7 = findViewById(R.id.blood7);
		blood8 = findViewById(R.id.blood8);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		user = getSharedPreferences("user", Activity.MODE_PRIVATE);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				user.edit().putString("name", name.getText().toString()).commit();
				user.edit().putString("phone", phone.getText().toString()).commit();
				user.edit().putString("brophone", bro_phone.getText().toString()).commit();
				user.edit().putString("hight", hight.getText().toString()).commit();
				user.edit().putString("wight", wight.getText().toString()).commit();
				user.edit().putString("date", date.getText().toString()).commit();
				user.edit().putString("address", address.getText().toString()).commit();
			}
		});
		
		blood1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFFFF0017);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "AB\n+").commit();
			}
		});
		
		blood2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFFFF0017);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "AB\n-").commit();
			}
		});
		
		blood3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFFFF0017);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "B\n+").commit();
			}
		});
		
		blood4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFFFF0017);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "B\n-").commit();
			}
		});
		
		blood5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFFFF0017);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "A\n+").commit();
			}
		});
		
		blood6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFFFF0017);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "A\n-").commit();
			}
		});
		
		blood7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFFFF0017);
				blood8.setBackgroundColor(0xFF2196F3);
				user.edit().putString("blood", "AB\n+").commit();
			}
		});
		
		blood8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blood1.setBackgroundColor(0xFF2196F3);
				blood2.setBackgroundColor(0xFF2196F3);
				blood3.setBackgroundColor(0xFF2196F3);
				blood4.setBackgroundColor(0xFF2196F3);
				blood5.setBackgroundColor(0xFF2196F3);
				blood6.setBackgroundColor(0xFF2196F3);
				blood7.setBackgroundColor(0xFF2196F3);
				blood8.setBackgroundColor(0xFFFF0017);
				user.edit().putString("blood", "AB\n+").commit();
			}
		});
	}
	
	private void initializeLogic() {
		cardview1.setCardBackgroundColor(0xFFFF0017);
		blood_box.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFF2196F3, 0xFFFF0017));
		name_linear.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFFF0017, 0xFFFEFEFE));
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, 0xFFFF0017, 0xFFFF0017));
		name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		phone.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		bro_phone.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		hight.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		wight.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		date.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		address.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		if (user.getString("blood", "").equals("AB\n+")) {
			blood1.setBackgroundColor(0xFFFF0017);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("AB\n-")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFFFF0017);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("B\n+")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFFFF0017);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("B\n-")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFFFF0017);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("A\n+")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFFFF0017);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("A\n-")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFFFF0017);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("O\n+")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFFFF0017);
			blood8.setBackgroundColor(0xFF2196F3);
		}
		if (user.getString("blood", "").equals("O\n-")) {
			blood1.setBackgroundColor(0xFF2196F3);
			blood2.setBackgroundColor(0xFF2196F3);
			blood3.setBackgroundColor(0xFF2196F3);
			blood4.setBackgroundColor(0xFF2196F3);
			blood5.setBackgroundColor(0xFF2196F3);
			blood6.setBackgroundColor(0xFF2196F3);
			blood7.setBackgroundColor(0xFF2196F3);
			blood8.setBackgroundColor(0xFFFF0017);
		}
		name.setText(user.getString("name", ""));
		phone.setText(user.getString("phone", ""));
		bro_phone.setText(user.getString("brophone", ""));
		hight.setText(user.getString("hight", ""));
		wight.setText(user.getString("wight", ""));
		date.setText(user.getString("date", ""));
		address.setText(user.getString("address", ""));
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