package org.techtown.android4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentLogin extends Fragment implements View.OnClickListener{
//1) implement View.OnClickListener를 사용 - 좀더 보기 편하다. 클릭관련 다 모여있어서
//2) imageButton.setOnClickListener를 사용해서 그 자리에서 사용하냐 - 코드가 난잡해질 수 있음. 버튼이 여러개일 경우

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_login, container, false);
        Button b = rootView.findViewById(R.id.join_button);
        b.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;

        switch(b.getId()) {
            //id에 따라서 다른 구현을 한다.
            case R.id.join_button:
                //버튼 클릭시 아래 구현이 실행된다.
                System.out.println("InputRecord clicked");
                getActivity().startActivity(new Intent(getActivity(),FragmentJoin.class));
                break;
        }

    }
}








//public class FragmentLogin extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_login, container, false);
//
//        return rootView;
//    }
//
//}
