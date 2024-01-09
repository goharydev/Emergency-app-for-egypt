package com.redButton;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SplashLoginActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout splash;
	private LinearLayout login;
	private ImageView imageview1;
	private TextView textview3;
	private ImageView imageview2;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private Button button1;
	private TextView createaccount_textview;
	private Button button2;
	private TextView login_textview;
	private EditText username;
	private EditText password;
	
	private FirebaseAuth users;
	private OnCompleteListener<AuthResult> _users_create_user_listener;
	private OnCompleteListener<AuthResult> _users_sign_in_listener;
	private OnCompleteListener<Void> _users_reset_password_listener;
	private OnCompleteListener<Void> users_updateEmailListener;
	private OnCompleteListener<Void> users_updatePasswordListener;
	private OnCompleteListener<Void> users_emailVerificationSentListener;
	private OnCompleteListener<Void> users_deleteUserListener;
	private OnCompleteListener<Void> users_updateProfileListener;
	private OnCompleteListener<AuthResult> users_phoneAuthListener;
	private OnCompleteListener<AuthResult> users_googleSignInListener;
	
	private Intent check = new Intent();
	private TimerTask splash_timer;
	private AlertDialog.Builder c;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash_login);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		splash = findViewById(R.id.splash);
		login = findViewById(R.id.login);
		imageview1 = findViewById(R.id.imageview1);
		textview3 = findViewById(R.id.textview3);
		imageview2 = findViewById(R.id.imageview2);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		button1 = findViewById(R.id.button1);
		createaccount_textview = findViewById(R.id.createaccount_textview);
		button2 = findViewById(R.id.button2);
		login_textview = findViewById(R.id.login_textview);
		username = findViewById(R.id.username);
		password = findViewById(R.id.password);
		users = FirebaseAuth.getInstance();
		c = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "جميع البيانات مطلوبة !");
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
				else {
					users.signInWithEmailAndPassword(username.getText().toString().concat("_@env.com"), password.getText().toString()).addOnCompleteListener(SplashLoginActivity.this, _users_sign_in_listener);
					check.setClass(getApplicationContext(), CheckActivity.class);
					startActivity(check);
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
			}
		});
		
		createaccount_textview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				createaccount_textview.setVisibility(View.GONE);
				login_textview.setVisibility(View.VISIBLE);
				button2.setVisibility(View.VISIBLE);
				button1.setVisibility(View.GONE);
				SketchwareUtil.hideKeyboard(getApplicationContext());
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "جميع البيانات مطلوبة لأنشاء حساب !");
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
				else {
					users.createUserWithEmailAndPassword(username.getText().toString().concat("_@env.com"), password.getText().toString()).addOnCompleteListener(SplashLoginActivity.this, _users_create_user_listener);
					createaccount_textview.setVisibility(View.VISIBLE);
					login_textview.setVisibility(View.GONE);
					button2.setVisibility(View.GONE);
					button1.setVisibility(View.VISIBLE);
					SketchwareUtil.showMessage(getApplicationContext(), "Account Created ! login now");
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
			}
		});
		
		login_textview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				createaccount_textview.setVisibility(View.VISIBLE);
				login_textview.setVisibility(View.GONE);
				button2.setVisibility(View.GONE);
				button1.setVisibility(View.VISIBLE);
				SketchwareUtil.hideKeyboard(getApplicationContext());
			}
		});
		
		password.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (password.getText().toString().length() < 8) {
					((EditText)password).setError("Password must be (8) letters or more.");
					button1.setEnabled(false);
					button2.setEnabled(false);
				}
				else {
					button1.setEnabled(true);
					button2.setEnabled(true);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		users_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		users_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		users_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		users_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		users_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		users_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		users_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_users_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_users_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_users_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			splash_timer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							finish();
						}
					});
				}
			};
			_timer.schedule(splash_timer, (int)(1000));
		}
		else {
			splash_timer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							splash.setVisibility(View.GONE);
						}
					});
				}
			};
			_timer.schedule(splash_timer, (int)(1000));
		}
		button2.setVisibility(View.GONE);
		login_textview.setVisibility(View.GONE);
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFFFFFFFF, 0xFFFF0017));
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFFFFFFFF, 0xFFFF0017));
		linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)25, (int)3, 0xFFFF0017, 0xFFF1F1F1));
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)25, (int)3, 0xFFFF0017, 0xFFF1F1F1));
		createaccount_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		login_textview.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
	}
	
	@Override
	public void onBackPressed() {
		c.setTitle("هل تريد الخروج");
		c.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		c.setNegativeButton("لا", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		c.create().show();
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