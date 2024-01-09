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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String url = "";
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private CardView cardview1;
	private LinearLayout linear5;
	private CardView driving_asset;
	private LinearLayout linear9;
	private LinearLayout linear6;
	private ImageView imageview16;
	private TextView textview1;
	private LinearLayout linear10;
	private LinearLayout linear14;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private ImageView imageview10;
	private TextView textview2;
	private ImageView imageview11;
	private TextView textview3;
	private ImageView imageview12;
	private TextView textview4;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private ImageView imageview13;
	private TextView textview5;
	private ImageView imageview14;
	private TextView textview6;
	private ImageView imageview15;
	private TextView textview7;
	private LinearLayout linear4;
	private ImageView imageview6;
	private ImageView imageview7;
	private ImageView imageview8;
	private ImageView imageview9;
	
	private Intent start = new Intent();
	private TimerTask check;
	private DatabaseReference secure = _firebase.getReference("secure");
	private ChildEventListener _secure_child_listener;
	private RequestNetwork wifi;
	private RequestNetwork.RequestListener _wifi_request_listener;
	private Intent color_x0 = new Intent();
	private AlertDialog.Builder d;
	private AlertDialog.Builder c;
	private Intent acount = new Intent();
	private Intent home = new Intent();
	private Intent map = new Intent();
	private Intent car = new Intent();
	private AlertDialog.Builder d1;
	private AlertDialog.Builder id1;
	private Intent w = new Intent();
	private Intent q = new Intent();
	private Intent x = new Intent();
	private Intent r = new Intent();
	private Intent G = new Intent();
	private Intent re = new Intent();
	private Intent lock = new Intent();
	private Intent help = new Intent();
	private Intent oiu = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
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
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		cardview1 = findViewById(R.id.cardview1);
		linear5 = findViewById(R.id.linear5);
		driving_asset = findViewById(R.id.driving_asset);
		linear9 = findViewById(R.id.linear9);
		linear6 = findViewById(R.id.linear6);
		imageview16 = findViewById(R.id.imageview16);
		textview1 = findViewById(R.id.textview1);
		linear10 = findViewById(R.id.linear10);
		linear14 = findViewById(R.id.linear14);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		imageview10 = findViewById(R.id.imageview10);
		textview2 = findViewById(R.id.textview2);
		imageview11 = findViewById(R.id.imageview11);
		textview3 = findViewById(R.id.textview3);
		imageview12 = findViewById(R.id.imageview12);
		textview4 = findViewById(R.id.textview4);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		imageview13 = findViewById(R.id.imageview13);
		textview5 = findViewById(R.id.textview5);
		imageview14 = findViewById(R.id.imageview14);
		textview6 = findViewById(R.id.textview6);
		imageview15 = findViewById(R.id.imageview15);
		textview7 = findViewById(R.id.textview7);
		linear4 = findViewById(R.id.linear4);
		imageview6 = findViewById(R.id.imageview6);
		imageview7 = findViewById(R.id.imageview7);
		imageview8 = findViewById(R.id.imageview8);
		imageview9 = findViewById(R.id.imageview9);
		wifi = new RequestNetwork(this);
		d = new AlertDialog.Builder(this);
		c = new AlertDialog.Builder(this);
		d1 = new AlertDialog.Builder(this);
		id1 = new AlertDialog.Builder(this);
		
		driving_asset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("تفعيل وضع تأمين السائق ؟");
				d.setMessage("عند التفعيل يتم رصد اي صدمات قوية للهاتف لأكتشاف الحادث وعند الاكتشاف يقوم بالأتصال برقم الطوارئ\nنعم : للتوجه لوضع تأمين السائق");
				d.setIcon(R.drawable.dsa);
				d.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						car.setClass(getApplicationContext(), AhmActivity.class);
						startActivity(car);
					}
				});
				d.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		linear11.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				w.setAction(Intent.ACTION_CALL);
				w.setData(Uri.parse("tel:180"));
				startActivity(w);
				return true;
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d1.setTitle("تأكيد الاتصال بالاطفاء");
				d1.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						w.setAction(Intent.ACTION_CALL);
						w.setData(Uri.parse("tel:180"));
						startActivity(w);
					}
				});
				d1.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d1.create().show();
			}
		});
		
		linear12.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				q.setAction(Intent.ACTION_CALL);
				q.setData(Uri.parse("tel:123"));
				startActivity(q);
				return true;
			}
		});
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d1.setTitle("تأكيد الاتصال بالاسعاف");
				d1.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						q.setAction(Intent.ACTION_CALL);
						q.setData(Uri.parse("tel:123"));
						startActivity(q);
					}
				});
				d1.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d1.create().show();
			}
		});
		
		linear13.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				x.setAction(Intent.ACTION_CALL);
				x.setData(Uri.parse("tel:122"));
				startActivity(x);
				return true;
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d1.setTitle("تأكيد الاتصال بالشرطة");
				d1.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						x.setAction(Intent.ACTION_CALL);
						x.setData(Uri.parse("tel:122"));
						startActivity(x);
					}
				});
				d1.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d1.create().show();
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				oiu.setClass(getApplicationContext(), SendHelpActivity.class);
				startActivity(oiu);
			}
		});
		
		linear16.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				G.setAction(Intent.ACTION_CALL);
				G.setData(Uri.parse("tel:121"));
				startActivity(G);
				return true;
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d1.setTitle("تأكيد الاتصال بطوارئ الكهرباء");
				d1.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						G.setAction(Intent.ACTION_CALL);
						G.setData(Uri.parse("tel:121"));
						startActivity(G);
					}
				});
				d1.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d1.create().show();
			}
		});
		
		linear17.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				r.setAction(Intent.ACTION_CALL);
				r.setData(Uri.parse("tel:129"));
				startActivity(r);
				return true;
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d1.setTitle("تأكيد الاتصال بطوارئ الغاز");
				d1.setPositiveButton("تأكيد", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						r.setAction(Intent.ACTION_CALL);
						r.setData(Uri.parse("tel:129"));
						startActivity(r);
					}
				});
				d1.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d1.create().show();
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				home.setClass(getApplicationContext(), EmerencyActivity.class);
				startActivity(home);
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				lock.setClass(getApplicationContext(), ThiefActivity.class);
				startActivity(lock);
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				re.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(re);
			}
		});
		
		_secure_child_listener = new ChildEventListener() {
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
		secure.addChildEventListener(_secure_child_listener);
		
		_wifi_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				secure.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
								map1 = new ArrayList<>();
								try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
												HashMap<String, Object> _map = _data.getValue(_ind);
												map1.add(_map);
										}
								}
								catch (Exception _e) {
										_e.printStackTrace();
								}
								if (map1.get((int)0).get("{G}").toString().equals("ok")) {
										
								}
								else {
										color_x0.setClass(getApplicationContext(), Color_0xActivity.class);
										startActivity(color_x0);
								}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
				});
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				d.setTitle("لا يوجد اتصال بالانترنت !");
				d.setIcon(R.drawable.icon);
				d.setPositiveButton("اعد المحاولة", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						start.setClass(getApplicationContext(), MainActivity.class);
						startActivity(start);
					}
				});
				d.setNegativeButton("الخروج", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finishAffinity();
					}
				});
				d.setCancelable(false);
				d.create().show();
			}
		};
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		wifi.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "w", _wifi_request_listener);
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			start.setClass(getApplicationContext(), SplashLoginActivity.class);
			startActivity(start);
			check = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							secure.addListenerForSingleValueEvent(new ValueEventListener() {
									@Override
									public void onDataChange(DataSnapshot _dataSnapshot) {
											map1 = new ArrayList<>();
											try {
													GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
													for (DataSnapshot _data : _dataSnapshot.getChildren()) {
															HashMap<String, Object> _map = _data.getValue(_ind);
															map1.add(_map);
													}
											}
											catch (Exception _e) {
													_e.printStackTrace();
											}
											if (map1.get((int)0).get("{G}").toString().equals("ok")) {
													
											}
											else {
													color_x0.setClass(getApplicationContext(), Color_0xActivity.class);
													startActivity(color_x0);
											}
									}
									@Override
									public void onCancelled(DatabaseError _databaseError) {
									}
							});
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(check, (int)(0), (int)(400));
		}
		else {
			d.setTitle("لا يوجد اتصال بالانترنت !");
			d.setIcon(R.drawable.cardview);
			d.setPositiveButton("اعد المحاولة", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					start.setClass(getApplicationContext(), MainActivity.class);
					startActivity(start);
				}
			});
			d.setNegativeButton("الخروج", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			d.setCancelable(false);
			d.create().show();
		}
		url = "android.resource://" + getPackageName() + "/raw/iskit_gif_2";
		Glide.with(getApplicationContext()).load(Uri.parse(url)).into(imageview16);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hjk.ttf"), 0);
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