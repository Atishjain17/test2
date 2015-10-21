package com.test2.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.test2.R;

public class JavaFragment extends Fragment {

	private Button quizButton;
	
	private WebView mWebView;
	
	public interface JavaFragmentListener {
		void nextClicked();
	}
	
	private JavaFragmentListener listener;
	
	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		try {
			listener = (JavaFragmentListener) activity;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.java_fragment, container, false);

		mWebView = (WebView) v.findViewById (R.id.java_fragment_webview);
		
		mWebView.loadUrl("file:///android_asset/java.html");
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		quizButton = (Button) v.findViewById(R.id.java_quiz_btn);

		quizButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.nextClicked();
				
			}
		});


		return v;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}


}
