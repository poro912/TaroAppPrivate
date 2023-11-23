package TaroSystem;

import android.util.Log;

public class TaroDebug {
	public void test(){
		Log.e("test","hello");
		Log.w("test","hello");
		Log.i("test","hello");
		Log.d("test","hello");
		Log.v("test","hello");
/*
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		for (StackTraceElement stackTraceElement : stackTraceElements) {
			Log.d("TaroDebug", "Code Location: " + stackTraceElement.getClassName() +
					" - " + stackTraceElement.getMethodName() +
					" - Line: " + stackTraceElement.getLineNumber());
		}
		*/
	}
}
