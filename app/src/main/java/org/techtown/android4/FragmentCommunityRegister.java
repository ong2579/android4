package org.techtown.android4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.techtown.android4.databinding.FragmentGalleryBinding;

//public class FragmentCommunityRegister extends AppCompatActivity implements View.OnClickListener {
public class FragmentCommunityRegister extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_fragment_community_register, container, false);
        Button b = rootView.findViewById(R.id.reg_button);
        b.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;

        switch (b.getId()) {
//            id에 따라서 다른 구현을 한다.
            case R.id.reg_button:
//                버튼 클릭시 아래 구현이 실행된다.
                System.out.println("InputRecord clicked");
                getActivity().startActivity(new Intent(getActivity(), FragmentCommunity.class));
                break;
        }

        public void onClickHandler (View v){

            Intent intent = new Intent(this, FragmentCommunity.class);

            intent.putExtra("title", "배달나눔원합니다.");
            intent.putExtra("content", )

            startActivity(intent);
        }
    }
}
//
//
//public class FragmentCommunityRegister extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_community_register);
//    }
//}



//public class FragmentCommunityRegister extends Fragment implements View.OnClickListener{
    //    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_fragment_community_register, container, false);
//        Button b = rootView.findViewById(R.id.reg_button);
//        b.setOnClickListener(this);
//
//        return rootView;
//    }
//
//    @Override
//    public void onClick(View v) {
//        Button b = (Button) v;
//
//        switch(b.getId()) {
//            id에 따라서 다른 구현을 한다.
//            case R.id.reg_button:
//                버튼 클릭시 아래 구현이 실행된다.
//                System.out.println("InputRecord clicked");
//                getActivity().startActivity(new Intent(getActivity(),FragmentCommunity.class));
//                break;
//        }
//
//    }
//}


//    }
//}