package android.vuongquocthanh.profile.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.vuongquocthanh.profile.R;
import android.vuongquocthanh.profile.ui.activity.ChangePasswordActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMore extends Fragment {

    private Toolbar toolbarHome;
    private TextView titleProfile;
    private TextView tvSave;
    private CircleImageView imgAvatar;
    private EditText edMail;
    private EditText edName;
    private LinearLayout lnPassword;
    private TextView tvPassword;
    private EditText edPhone;
    private TextView tvCompany;
    private LinearLayout lnWorld;
    private LinearLayout lnTime;
    private TextView tvChupanh;
    private TextView tvChonanh;
    private TextView tvHuy;

    View viewFragment, viewDialog;
    Dialog dialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragment_more, container, false);
        initViews();
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        lnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(viewFragment.getContext(), ChangePasswordActivity.class));
            }
        });
        return viewFragment;
    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(viewFragment.getContext());
        LayoutInflater inflater = (LayoutInflater) viewFragment.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewDialog = inflater.inflate(R.layout.dialog_set_avatar, null);
        initViewDialog();
        builder.setView(viewDialog);
        dialog = builder.create();
        Window window  = dialog.getWindow();
        WindowManager.LayoutParams wlp  = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        window.setBackgroundDrawableResource(android.R.color.transparent);

        tvChonanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewFragment.getContext(), "Chon Anh", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        tvChupanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewFragment.getContext(), "Chup Anh", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        tvHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewFragment.getContext(), "Huy", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void initViewDialog(){
        tvChupanh = viewDialog.findViewById(R.id.tvChupanh);
        tvChonanh = viewDialog.findViewById(R.id.tvChonanh);
        tvHuy = viewDialog.findViewById(R.id.tvHuy);
    }

    private void initViews(){
        toolbarHome = viewFragment.findViewById(R.id.toolbarHome);
        titleProfile = viewFragment.findViewById(R.id.titleProfile);
        tvSave = viewFragment.findViewById(R.id.tvSave);
        imgAvatar = viewFragment.findViewById(R.id.imgAvatar);
        edMail = viewFragment.findViewById(R.id.edMail);
        edName = viewFragment.findViewById(R.id.edName);
        lnPassword = viewFragment.findViewById(R.id.lnPassword);
        tvPassword = viewFragment.findViewById(R.id.tvPassword);
        edPhone = viewFragment.findViewById(R.id.edPhone);
        tvCompany = viewFragment.findViewById(R.id.tvCompany);
        lnWorld = viewFragment.findViewById(R.id.lnWorld);
        lnTime = viewFragment.findViewById(R.id.lnTime);
    }
}
