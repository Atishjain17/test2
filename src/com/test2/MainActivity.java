package com.test2;

import com.test2.fragments.CFragment;
import com.test2.fragments.CFragment.CFragmentListener;
import com.test2.fragments.CQuizFragment;
import com.test2.fragments.HTMLCFragment;
import com.test2.fragments.HTMLCFragment.HTMLCFragmentListener;
import com.test2.fragments.HTMLQuizFragment;
import com.test2.fragments.JavaFragment;
import com.test2.fragments.JavaQuizFragment;
import com.test2.fragments.MainFragment;
import com.test2.fragments.JavaFragment.JavaFragmentListener;
import com.test2.fragments.MainFragment.BtnFragmentListener;
import com.test2.fragments.SQLFragment;
import com.test2.fragments.SQLFragment.SQLFragmentListener;
import com.test2.fragments.SQLQuizFragment;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks, JavaFragmentListener, CFragmentListener, SQLFragmentListener, HTMLCFragmentListener, BtnFragmentListener {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}
	public FragmentManager fragmentManager = getFragmentManager();
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		
		
		/*try {
			fragmentManager.popBackStackImmediate();
		} catch(Exception e) {}*/
		
		switch(position) {
		case 0: {
			fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			fragmentManager
			.beginTransaction()
			.replace(R.id.container,
					new MainFragment()).commit();
			break;
		}
		case 1: {
			fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			fragmentManager
			.beginTransaction()
			.addToBackStack(null)
			.replace(R.id.container,
					new JavaFragment()).commit();
			break;
		}
		case 2: {
			
			fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			fragmentManager
			.beginTransaction()
			.addToBackStack(null)
			.replace(R.id.container,
					new CFragment()).commit();
			break;
		}
		case 3: {
			fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			fragmentManager
			.beginTransaction()
			.addToBackStack(null)
			.replace(R.id.container,
					new SQLFragment()).commit();
			break;
		}
		case 4: {
			
			fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			fragmentManager
			.beginTransaction()
			.addToBackStack(null)
			.replace(R.id.container,
					new HTMLCFragment()).commit();
			break;
		}
		}	
	}

	public void onSectionAttached(int number) {

	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			//getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void nextClicked() {
		getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new JavaQuizFragment()).commit();
	}

	@Override
	public void nextClickedc() {
		getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new CQuizFragment()).commit();
	}
	
	@Override
	public void nextClickedh() {
		getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new HTMLQuizFragment()).commit();
	}
	
	@Override
	public void nextClickedsql() {
		getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new SQLQuizFragment()).commit();
	}
	public void nextClickedcbtn() {
		fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		fragmentManager
		.beginTransaction()
		.addToBackStack(null)
		.replace(R.id.container,
				new CFragment()).commit();
	}
	
	@Override
	public void nextClickedjavabtn() {
		fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		fragmentManager
		.beginTransaction()
		.addToBackStack(null)
		.replace(R.id.container,
				new JavaFragment()).commit();
	}
	
	@Override
	public void nextClickedhtmlbtn() {
		fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		fragmentManager
		.beginTransaction()
		.addToBackStack(null)
		.replace(R.id.container,
				new HTMLCFragment()).commit();
	}
	
	@Override
	public void nextClickedsqlbtn() {
		fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		fragmentManager
		.beginTransaction()
		.addToBackStack(null)
		.replace(R.id.container,
				new SQLFragment()).commit();
	}

}
