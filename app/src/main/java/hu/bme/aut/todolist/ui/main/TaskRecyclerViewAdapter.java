package hu.bme.aut.todolist.ui.main;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.todolist.R;
import hu.bme.aut.todolist.TodoListApplication;
import hu.bme.aut.todolist.model.Task;
import hu.bme.aut.todolist.ui.details.DetailsActivity;

import static hu.bme.aut.todolist.ui.details.DetailsActivity.KEY_TASK_ID;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> {
    public static final String TAG = TaskRecyclerViewAdapter.class.getSimpleName();

    private final List<Task> mTasks;
    @Inject
    MainPresenter mainPresenter;

    public TaskRecyclerViewAdapter(List<Task> items) {
        mTasks = items;
        TodoListApplication.injector.inject(this);
    }

    public void addTasks(List<Task> tasks) {
        mTasks.addAll(tasks);
        notifyDataSetChanged();
    }

    public void remove(String taskId) {
        for(Task task : mTasks) {
            if( task.getId() == taskId) {
                mTasks.remove(task);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void add(Task task) {
        mTasks.remove(task);
        mTasks.add(task);
        notifyDataSetChanged();
    }

    public void clear() {
        mTasks.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mTasks.get(position);
        holder.mNameTextView.setText(mTasks.get(position).getName());
        holder.mDoneCheckBox.setChecked(mTasks.get(position).isDueComplete());
        holder.mDeleteButton.setVisibility(mTasks.get(position).isDueComplete() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameTextView;
        public final CheckBox mDoneCheckBox;
        public final Button mDeleteButton;
        public Task mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameTextView = view.findViewById(R.id.name_text_view);
            mDoneCheckBox = view.findViewById(R.id.done_checkbox);
            mDoneCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(mItem != null) {
                        mItem.setDueComplete(isChecked);
                        mainPresenter.updateTask(mItem);
                    }
                }
            });
            mDeleteButton = view.findViewById(R.id.delete_button);
            mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mItem != null) {
                        mainPresenter.deleteTask(mItem);
                    }
                }
            });
            mNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mItem != null) {
                        Intent intent = new Intent(mView.getContext(), DetailsActivity.class);
                        intent.putExtra(KEY_TASK_ID, mItem.getId());
                        mView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}
