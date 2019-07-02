package com.example.customalertdialog_passargumentsparcelable_callbackinterface;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.customalertdialog_passargumentsparcelable_callbackinterface.model.UserDetails;

public class CustomDialogFragment extends DialogFragment {

    private Button cancelBtn,sendBtn;
    private EditText et_firstName,et_lastName,et_age;
    public static final String USER_DETAILS = "user_details";
    private FragmentListener fragmentListener;

    interface FragmentListener{
        void UserDetailsFragmentListener(UserDetails userDetails);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentListener = (FragmentListener) context;
    }

    public static CustomDialogFragment newInstance(UserDetails userDetails) {

        Bundle args = new Bundle();
        args.putParcelable(USER_DETAILS,userDetails);
        CustomDialogFragment fragment = new CustomDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.custom_dialog_fragment,container,false);

        cancelBtn = view.findViewById(R.id.cancel_button);
        sendBtn = view.findViewById(R.id.send_button);

        et_firstName = view.findViewById(R.id.firstName);
        et_lastName = view.findViewById(R.id.lastName);
        et_age = view.findViewById(R.id.age);

        UserDetails userDetails = getArguments().getParcelable(USER_DETAILS);
        et_firstName.setText(userDetails.getfName());
        et_lastName.setText(userDetails.getlName());
        et_age.setText(String.valueOf(userDetails.getAge()));

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
                dismiss();
            }
        });
        return view;
    }


    public void sendData(){
        UserDetails userDetails = new UserDetails();
        userDetails.setfName(et_firstName.getText().toString());
        userDetails.setlName(et_lastName.getText().toString());
        userDetails.setAge(Integer.valueOf(et_age.getText().toString()));

        fragmentListener.UserDetailsFragmentListener(userDetails);
    }
}
