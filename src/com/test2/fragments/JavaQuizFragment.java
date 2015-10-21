package com.test2.fragments;

import java.util.ArrayList;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test2.R;

public class JavaQuizFragment extends Fragment {

	private ListView lv;
	private Button submit;

	private String[] questions, op1, op2, op3, op4;
	private String options[][] = { op1, op2, op3, op4 };
	private int[] ans;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater
				.inflate(R.layout.java_quiz_fragment, container, false);
		lv = (ListView) v.findViewById(R.id.java_quiz_list);

		submit = (Button) v.findViewById(R.id.java_quiz_submit);

		questions = getActivity().getResources().getStringArray(
				R.array.java_quiz_questions);
		options[0] = getActivity().getResources().getStringArray(
				R.array.java_quiz_option1);
		options[1] = getActivity().getResources().getStringArray(
				R.array.java_quiz_option2);
		options[2] = getActivity().getResources().getStringArray(
				R.array.java_quiz_option3);
		options[3] = getActivity().getResources().getStringArray(
				R.array.java_quiz_option4);

		ans = getActivity().getResources().getIntArray(
				R.array.java_quiz_answer1);
		
		final JavaAdapter adapter = new JavaAdapter();
		lv.setAdapter(adapter);

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ArrayList<RadioGroup> groups = adapter.createdOptions;

				int counter = 0;
				try{
				for (int i = 0; i < 15; i++) {
					RadioGroup radioButtonGroup = groups.get(i);
					int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
					View radioButton = radioButtonGroup.findViewById(radioButtonID);
					int idx = radioButtonGroup.indexOfChild(radioButton);
					
					for(int j = 0; j < radioButtonGroup.getChildCount(); j++) {
						radioButtonGroup.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
					}
					
					if(ans[i] == idx) {
						counter++;
						//radioButton.setBackgroundColor(Color.GREEN);
					}
					else
					{
						//radioButton.setBackgroundColor(Color.RED);
						radioButtonGroup.getChildAt(ans[i]).setBackgroundColor(Color.parseColor("#007328"));
					}
				}
				}
				catch(Exception e){}
				Toast.makeText(getActivity(), "Got "+ counter + "  correct out of "+ questions.length+"!", Toast.LENGTH_LONG).show();

			}
		});

		return v;
	}

	private class JavaAdapter extends BaseAdapter {

		public ArrayList<RadioGroup> createdOptions;

		private LayoutInflater inflater;

		public JavaAdapter() {
			inflater = LayoutInflater.from(getActivity());
			createdOptions = new ArrayList<RadioGroup>();
		}

		@Override
		public int getCount() {
			return questions.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View v = inflater.inflate(R.layout.java_quiz_listitem, parent,
					false);
			TextView question = (TextView) v.findViewById(R.id.java_quiz_ques);
			RadioGroup ops = (RadioGroup) v.findViewById(R.id.options);
			createdOptions.add(ops);

			question.setText(questions[position]);

			for (int i = 0; i < ops.getChildCount(); i++) {
				try{((RadioButton) ops.
						getChildAt(i)).
						setText(
								options[i]
										[position]);
				
				}
				catch(Exception e){}
			}

			return v;
		}

	}

}
