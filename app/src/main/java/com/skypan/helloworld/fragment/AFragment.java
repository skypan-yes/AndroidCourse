package com.skypan.helloworld.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skypan.helloworld.R;

/**
 * Created by skypan on 2017/8/30.
 */

public class AFragment extends Fragment {

    private TextView mTvTitle;
    private Button mBtnChange,mBtnReset,mBtnMessage;
    private BFragment bFragment;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity 必须实现 IOnMessageClick接口");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        Log.d("AFragment","----onCreateView----");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnReset = (Button) view.findViewById(R.id.btn_reset);
        mBtnMessage = (Button) view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onClick("你好");
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("我是新文字");
            }
        });
        if(getArguments() != null){
            mTvTitle.setText(getArguments().getString("title"));
        }
    }
}
