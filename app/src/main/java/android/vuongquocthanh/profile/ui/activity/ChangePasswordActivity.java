package android.vuongquocthanh.profile.ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.vuongquocthanh.profile.R;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {
    private Toolbar toolbarHome;
    private TextView tvHuy;
    private TextView titleProfile;
    private TextView tvSave;
    private EditText edCurrentPass;
    private EditText edNewPass;
    private EditText edReNewPass;
    private TextView tvDialogcancel;
    private TextView tvDialogHuy;
    View viewDialog;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initViews();
        tvHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangePasswordActivity.this, "SAVED!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(){
        toolbarHome = findViewById(R.id.toolbarHome);
        tvHuy = findViewById(R.id.tvHuy);
        titleProfile = findViewById(R.id.titleProfile);
        tvSave = findViewById(R.id.tvSave);
        edCurrentPass = findViewById(R.id.edCurrentPass);
        edNewPass = findViewById(R.id.edNewPass);
        edReNewPass = findViewById(R.id.edReNewPass);
    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        viewDialog = inflater.inflate(R.layout.dialog_cancel_change_pass, null);
        initViewDialog();
        builder.setView(viewDialog);
        dialog = builder.create();
        Window window  = dialog.getWindow();
        WindowManager.LayoutParams wlp  = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        tvDialogcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvDialogHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangePasswordActivity.this, "Huy", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void initViewDialog() {
        tvDialogcancel = viewDialog.findViewById(R.id.tvDialogcancel);
        tvDialogHuy = viewDialog.findViewById(R.id.tvDialogHuy);

    }
}
