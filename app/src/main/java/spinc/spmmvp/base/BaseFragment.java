package spinc.spmmvp.base;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import spinc.spmmvp.R;

/**
 * Created by webwerks on 15/2/17.
 */

abstract public class BaseFragment extends Fragment {
    ProgressBar progressBar;


    Dialog openDialog;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    protected abstract void initView(View rootview);
    protected abstract void setClicklistener();

    private void showAlert(String title,String message,String positiveText,final String negativeText) {

        if(builder==null)
            builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        dialog.dismiss();
                    }
                });
        if(!TextUtils.isEmpty(negativeText)) {
            builder.setNegativeButton(negativeText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // negative button logic
                            dialog.dismiss();
                        }
                    });
        }

        if(dialog==null)
            dialog = builder.create();
        // display dialog
        dialog.show();
    }

    public void showProgressMain(String message){
        if(openDialog == null)
            openDialog = new Dialog(getActivity());

        openDialog.setContentView(R.layout.custom_progress_layout);
        openDialog.setTitle(message);
        AppCompatTextView textViewProgressMessage = (AppCompatTextView) openDialog.findViewById(R.id.textViewProgressMessage);
        textViewProgressMessage.setText(message);
        openDialog.show();
    }
    public void hideProgressMain(){
        if(openDialog != null)
            openDialog.dismiss();
    }

}
