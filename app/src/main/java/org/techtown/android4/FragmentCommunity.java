package org.techtown.android4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class FragmentCommunity extends ListFragment {
//1) implement View.OnClickListener를 사용 - 좀더 보기 편하다. 클릭관련 다 모여있어서
//2) imageButton.setOnClickListener를 사용해서 그 자리에서 사용하냐 - 코드가 난잡해질 수 있음. 버튼이 여러개일 경우

    private TextView textView_title;
    private TextView textView_content;
    // 사이즈를 지정하지 않고 무한대로 넣을수 있다.
    ArrayList<String> values = new ArrayList<String>();
    ArrayAdapter<String> listViewAdapter;

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                listViewAdapter =
                String result = bundle.getString("title");
                values.add(result);
                System.out.print(result);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_fragment_community_list, container, false);
        Button b = rootView.findViewById(R.id.reg_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                if(mainActivity != null)
                    mainActivity.FragmentChange(4);
            }
        });



        ListView listView = (ListView) rootView.findViewById(android.R.id.list);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);

        listView.setAdapter(listViewAdapter);

        // adapter
        // 문자열의 list <--> 안드로이드의 listView
        return rootView;
    }
}
