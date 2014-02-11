package com.gss.abcdoverair;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class utils {
	private final String TAG = "com.gss.abcoverair";
	private Context mContext;
	private SharedPreferences mSharedPreferences;
	private WakeLock mWakeLock;
	///////////////////////////////////////////////////////////////////////////////////////////////
	// Utils Instance
	//////////////////////////////////////////////////////////////////////////////////////////////
	static  public utils mUtils = new utils();
	/*! 
	 *  \brief ��ȡ�������й�����Ψһ��ʵ��
	 */
	static utils GetInstance()
	{
		return mUtils;
	}
	
	void Init(Context context)
	{
		mContext = context;
		mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// LOG ����
	//////////////////////////////////////////////////////////////////////////////////////////////
	void Logx(String s)
	{
		Log.i(TAG, s);
	}
	
    void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
    
	///////////////////////////////////////////////////////////////////////////////////////////////
	// ���ô洢 ����
	//////////////////////////////////////////////////////////////////////////////////////////////
	SharedPreferences GetDefaultSharedPreferences()
	{
		return mSharedPreferences;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// SD��
	//////////////////////////////////////////////////////////////////////////////////////////////
	public String getSDPath(){ 
	       File sdDir = null; 
	       boolean sdCardExist = Environment.getExternalStorageState()   
	                           .equals(Environment.MEDIA_MOUNTED);   //�ж�sd���Ƿ���� 
	       if   (sdCardExist)   
	       {                               
	         sdDir = Environment.getExternalStorageDirectory();//��ȡ��Ŀ¼ 
	      }   
	       return sdDir.toString(); 
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// ��Ļ��
	//////////////////////////////////////////////////////////////////////////////////////////////
	public void acquireWakeLock() {
		if (mWakeLock == null) {
			PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
			mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, this
					.getClass().getCanonicalName());
			mWakeLock.acquire();
		}
	}

	public void releaseWakeLock() {
		if (mWakeLock != null && mWakeLock.isHeld()) {
			mWakeLock.release();
			mWakeLock = null;
		}
	}
}
