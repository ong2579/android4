package org.techtown.android4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentCommunity extends Fragment implements View.OnClickListener{
//1) implement View.OnClickListener를 사용 - 좀더 보기 편하다. 클릭관련 다 모여있어서
//2) imageButton.setOnClickListener를 사용해서 그 자리에서 사용하냐 - 코드가 난잡해질 수 있음. 버튼이 여러개일 경우

    private TextView textView_title;
    private TextView textView_content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_community, container, false);
        Button b = rootView.findViewById(R.id.button22);
        b.setOnClickListener(this);

        return rootView;

        Intent intent = Intent.getIntent();

        textView_title = (TextView)findViewById(R.id.title);
        textView_content
                (TextView)findViewById(R.id.content);

        textView_title.setText(intent.getStringExtra("title"));
        ArrayList<String> content intent.getStringArrayListExtra("content");

        textView_content.setText("");

        for(int i=0, i < content.size(); i++)
        {

            textView_content.setText(textView_content.getText() content.get(i));
        }

    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;

        switch(b.getId()) {
            //id에 따라서 다른 구현을 한다.
            case R.id.button22:
                //버튼 클릭시 아래 구현이 실행된다.
                System.out.println("InputRecord clicked");
                getActivity().startActivity(new Intent(getActivity(),FragmentCommunityRegister.class));
                break;
        }

    }
}
