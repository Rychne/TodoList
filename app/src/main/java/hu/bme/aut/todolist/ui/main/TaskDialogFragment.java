package hu.bme.aut.todolist.ui.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;

public class TaskDialogFragment extends DialogFragment {
    public static final String TAG = TaskDialogFragment.class.getSimpleName();

    @Inject
    MainPresenter mainPresenter;

    private View mView;
    private EditText mInput1;
    private EditText mInput2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TodoListApplication.injector.inject(this);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setTitle(R.string.dialog_title)
                .setView(getDialogView())
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO input validation
                        mainPresenter.createTask(String.valueOf(mInput1.getText()), String.valueOf(mInput2.getText()));
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .create();
    }

    private View getDialogView() {
        mView = LayoutInflater.from(getContext()).inflate(R.layout.create_task, null);
        mInput1 = mView.findViewById(R.id.dialog_input_1);
        mInput2 = mView.findViewById(R.id.dialog_input_2);
        return mView;
    }
}
