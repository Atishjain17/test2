package com.test2.fragments;

import com.test2.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class HTMLCFragment extends Fragment {

	private Button quizButton;
	private WebView mWebView;
	
	public interface HTMLCFragmentListener {
		void nextClickedh();
	}
	
	private HTMLCFragmentListener listener;
	
	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		try {
			listener = (HTMLCFragmentListener) activity;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.html_fragment, container, false);
		mWebView = (WebView) v.findViewById (R.id.html_fragment_webview);
		
		mWebView.loadUrl("file:///android_asset/html.html");
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);

		quizButton = (Button) v.findViewById(R.id.html_quiz_btn);

		quizButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.nextClickedh();
				
			}
		});


		return v;
	}



}
