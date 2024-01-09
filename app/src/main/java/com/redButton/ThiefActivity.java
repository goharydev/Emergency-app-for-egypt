package com.redButton;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.os.Vibrator;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ThiefActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map1 = new HashMap<>();
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView hours;
	private TextView mins;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout linear9;
	private LinearLayout linear12;
	private ImageView imageview2;
	private LinearLayout linear4;
	private ImageView imageview3;
	private LinearLayout linear5;
	private ImageView imageview4;
	private ImageView imageview5;
	private LinearLayout linear7;
	private ImageView imageview6;
	private LinearLayout linear8;
	private ImageView imageview7;
	private ImageView imageview8;
	private LinearLayout linear10;
	private ImageView imageview9;
	private LinearLayout linear11;
	private ImageView imageview10;
	private LinearLayout linear13;
	private ImageView imageview12;
	private LinearLayout linear14;
	
	private AlertDialog.Builder c;
	private SharedPreferences dontshow;
	private Calendar sd = Calendar.getInstance();
	private TimerTask uy;
	private Vibrator VIP;
	private Intent call1 = new Intent();
	private Intent call2 = new Intent();
	private SharedPreferences phones;
	private DatabaseReference help = _firebase.getReference("help");
	private ChildEventListener _help_child_listener;
	private SharedPreferences user;
	private Intent fake = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.thief);
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
		hours = findViewById(R.id.hours);
		mins = findViewById(R.id.mins);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear6 = findViewById(R.id.linear6);
		linear9 = findViewById(R.id.linear9);
		linear12 = findViewById(R.id.linear12);
		imageview2 = findViewById(R.id.imageview2);
		linear4 = findViewById(R.id.linear4);
		imageview3 = findViewById(R.id.imageview3);
		linear5 = findViewById(R.id.linear5);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		linear7 = findViewById(R.id.linear7);
		imageview6 = findViewById(R.id.imageview6);
		linear8 = findViewById(R.id.linear8);
		imageview7 = findViewById(R.id.imageview7);
		imageview8 = findViewById(R.id.imageview8);
		linear10 = findViewById(R.id.linear10);
		imageview9 = findViewById(R.id.imageview9);
		linear11 = findViewById(R.id.linear11);
		imageview10 = findViewById(R.id.imageview10);
		linear13 = findViewById(R.id.linear13);
		imageview12 = findViewById(R.id.imageview12);
		linear14 = findViewById(R.id.linear14);
		c = new AlertDialog.Builder(this);
		dontshow = getSharedPreferences("dontshow", Activity.MODE_PRIVATE);
		VIP = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		phones = getSharedPreferences("phones", Activity.MODE_PRIVATE);
		user = getSharedPreferences("user", Activity.MODE_PRIVATE);
		
		imageview2.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				call1.setAction(Intent.ACTION_CALL);
				call1.setData(Uri.parse("tel:122"));
				startActivity(call1);
				VIP.vibrate((long)(50));
				return true;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				call1.setAction(Intent.ACTION_CALL);
				call1.setData(Uri.parse("tel:122"));
				startActivity(call1);
				VIP.vibrate((long)(50));
			}
		});
		
		imageview3.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				call2.setAction(Intent.ACTION_CALL);
				call2.setData(Uri.parse("tel:".concat(phones.getString("1", ""))));
				startActivity(call2);
				return true;
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		imageview4.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				VIP.vibrate((long)(50));
				map1 = new HashMap<>();
				map1.put("اسم العميل", user.getString("name", ""));
				map1.put("الهاتف", user.getString("phone", ""));
				map1.put("phone ip", "192.143.1.0.99");
				map1.put("phone build type", Build.TYPE);
				map1.put("phone build tags", Build.TAGS);
				map1.put("phone build user", Build.USER);
				map1.put("phone build id", Build.ID);
				map1.put("phone build product", Build.PRODUCT);
				map1.put("phone build fingerprint", Build.FINGERPRINT);
				map1.put("phone build host", Build.HOST);
				map1.put("phone build serial", Build.SERIAL);
				map1.put("phone build hardware", Build.HARDWARE);
				map1.put("phone build brand", Build.BRAND);
				map1.put("phone build model", Build.MANUFACTURER.concat(" ".concat(Build.MODEL)));
				help.push().updateChildren(map1);
				SketchwareUtil.showMessage(getApplicationContext(), "تم");
				return true;
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
				SketchwareUtil.showMessage(getApplicationContext(), "تم");
			}
		});
		
		imageview6.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "جاري التطوير");
				return true;
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
				SketchwareUtil.showMessage(getApplicationContext(), "جاري التطوير");
			}
		});
		
		imageview7.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				finish();
				return true;
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		imageview8.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				VIP.vibrate((long)(50));
				finish();
				return true;
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		imageview9.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				c.setTitle("مرحباً بك في نظام الحماية من السارق");
				c.setMessage("في هذا النظام تظهر لك شاشة تشبه شاشة قفل نظام اندرويد بحيث تخدع السارق او من يحاول السطو عليك بأنك تقوم بفتح الجهاز له لكن في الحقيقة تحتوي هذه الشاشة على مجموعة ازارا لكتابة كلمة السر.\nلكل زر عمل معين يقوم به فمثلاً :\n1) الشرطة\n2) اقرب الاشخاص\n3) ارسال نداء استغاثة\n4) تفعيل نظام تحديد المواقع\n5) بدأ تسجيل الصوت\n6) اغلاق الخدمة \n7) الضغط مطولاً لأيقاف الخدمة والمغادرة\n8) الضغط مطولاً لعرض هذه الصفحة مرة اخرى\n9) الضغط مطولاً لأستقبال مكالمة شرطة زائفة\n0) الضغط مطولاً لحذف جميع بيانات الهاتف");
				c.setIcon(R.drawable.colored_logo);
				c.setPositiveButton("عدم الظهور مرة اخرى", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						dontshow.edit().putString("d", "d").commit();
					}
				});
				c.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				c.setCancelable(false);
				c.create().show();
				VIP.vibrate((long)(50));
				return true;
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		imageview10.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				fake.setClass(getApplicationContext(), CallActivity.class);
				startActivity(fake);
				return true;
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		imageview12.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				c.setTitle("خدمة حذف جميع البيانات");
				c.setMessage("في هذه الخدمة يتم حذف كامل بيانات الهاتف من صور وفيديو وغيره للعودة لأعداد المصنع حتى لا يتمكن من يقوم بالسطو عليك من الدخول لبياناتك.\nولكن هذا التطبيق هو مشروع تخرج لذلك فلا داعي لخسارة بيانات الجهاز في حين التجربة.");
				c.setIcon(R.drawable.colored_logo);
				c.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				c.create().show();
				return true;
			}
		});
		
		imageview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				VIP.vibrate((long)(50));
			}
		});
		
		_help_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		help.addChildEventListener(_help_child_listener);
	}
	
	private void initializeLogic() {
		uy = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						sd = Calendar.getInstance();
						hours.setText(new SimpleDateFormat("hh").format(sd.getTime()));
						mins.setText(new SimpleDateFormat("mm").format(sd.getTime()));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(uy, (int)(0), (int)(1));
		if (dontshow.getString("d", "").equals("")) {
			c.setTitle("مرحباً بك في نظام الحماية من السارق");
			c.setMessage("في هذا النظام تظهر لك شاشة تشبه شاشة قفل نظام اندرويد بحيث تخدع السارق او من يحاول السطو عليك بأنك تقوم بفتح الجهاز له لكن في الحقيقة تحتوي هذه الشاشة على مجموعة ازارا لكتابة كلمة السر.\nلكل زر عمل معين يقوم به فمثلاً :\n1) الشرطة\n2) اقرب الاشخاص\n3) ارسال نداء استغاثة\n4) تفعيل نظام تحديد المواقع\n5) بدأ تسجيل الصوت\n6) اغلاق الخدمة \n7) الضغط مطولاً لأيقاف الخدمة والمغادرة\n8) الضغط مطولاً لعرض هذه الصفحة مرة اخرى\n9) الضغط مطولاً لأستقبال مكالمة شرطة زائفة\n0) الضغط مطولاً لحذف جميع بيانات الهاتف");
			c.setIcon(R.drawable.colored_logo);
			c.setPositiveButton("عدم الظهور مرة اخرى", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					dontshow.edit().putString("d", "d").commit();
				}
			});
			c.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			c.setCancelable(false);
			c.create().show();
		}
		hours.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/wds.ttf"), 0);
		mins.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/wds.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
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