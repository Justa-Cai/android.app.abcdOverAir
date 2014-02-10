package com.gss.abcdoverair;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class utils {
	private final String TAG = "com.gss.abcoverair";
	private Context m_context;
	private SharedPreferences mSharedPreferences;

	///////////////////////////////////////////////////////////////////////////////////////////////
	// Utils Instance
	//////////////////////////////////////////////////////////////////////////////////////////////
	static  public utils mUtils = new utils();
	/*! 
	 *  \brief 获取程序运行过程中唯一的实例
	 */
	static utils GetInstance()
	{
		return mUtils;
	}
	
	void Init(Context context)
	{
		m_context = context;
		mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// LOG 操作
	//////////////////////////////////////////////////////////////////////////////////////////////
	void Logx(String s)
	{
		Log.i(TAG, s);
	}
	
    void showToast(String msg) {
        Toast.makeText(m_context, msg, Toast.LENGTH_SHORT).show();
    }
    
	///////////////////////////////////////////////////////////////////////////////////////////////
	// 配置存储 操作
	//////////////////////////////////////////////////////////////////////////////////////////////
	SharedPreferences GetDefaultSharedPreferences()
	{
		return mSharedPreferences;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// SD卡
	//////////////////////////////////////////////////////////////////////////////////////////////
	public String getSDPath(){ 
	       File sdDir = null; 
	       boolean sdCardExist = Environment.getExternalStorageState()   
	                           .equals(Environment.MEDIA_MOUNTED);   //判断sd卡是否存在 
	       if   (sdCardExist)   
	       {                               
	         sdDir = Environment.getExternalStorageDirectory();//获取跟目录 
	      }   
	       return sdDir.toString(); 
	}
}
