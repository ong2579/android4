package org.techtown.android4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import java.util.ArrayList;

public class FragmentCommunity extends Fragment{
//1) implement View.OnClickListener를 사용 - 좀더 보기 편하다. 클릭관련 다 모여있어서
//2) imageButton.setOnClickListener를 사용해서 그 자리에서 사용하냐 - 코드가 난잡해질 수 있음. 버튼이 여러개일 경우

    private TextView textView_title;
    private TextView textView_content;

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
                String result = bundle.getString("title");
                System.out.print(result);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_community, container, false);
        Button b = rootView.findViewById(R.id.button22);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                if(mainActivity != null)
                    mainActivity.FragmentChange(4);
            }
        });




        return rootView;
    }
}
