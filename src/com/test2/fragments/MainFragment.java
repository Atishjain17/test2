package com.test2.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.test2.R;
import com.test2.fragments.CFragment.CFragmentListener;

public class MainFragment extends Fragment {
	private Button cbtn,javabtn,sqlbtn,htmlbtn;
	
	public interface BtnFragmentListener {
		void nextClickedcbtn();
		void nextClickedjavabtn();
		void nextClickedhtmlbtn();
		void nextClickedsqlbtn();
	}
	
	private BtnFragmentListener listener;
	
	@Override
	public void onAttach(Activity activity) {

		super.onAttach(activity);
		try {
			listener = (BtnFragmentListener) activity;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_main, container, false);
		
		cbtn = (Button) v.findViewById(R.id.button1);
		javabtn = (Button) v.findViewById(R.id.button2);
		sqlbtn = (Button) v.findViewById(R.id.button3);
		htmlbtn = (Button) v.findViewById(R.id.button4);
		cbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.nextClickedcbtn();	
			}
		});
		
		javabtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.nextClickedjavabtn();	
			}
		});
		
		htmlbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.nextClickedhtmlbtn();	
			}
		});
		
		sqlbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(listener != null)
					listener.nextClickedsqlbtn();	
			}
		});
		
		return v;
	}
	
	

}
