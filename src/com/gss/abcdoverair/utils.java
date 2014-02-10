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
	 *  \brief ��ȡ�������й�����Ψһ��ʵ��
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
	// LOG ����
	//////////////////////////////////////////////////////////////////////////////////////////////
	void Logx(String s)
	{
		Log.i(TAG, s);
	}
	
    void showToast(String msg) {
        Toast.makeText(m_context, msg, Toast.LENGTH_SHORT).show();
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
}
