package hello.tech.jobseeker.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.jobseeker.Modals.JobModal;
import hello.tech.jobseeker.R;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.viewHolder> {
    ArrayList<JobModal>list;
    Context context;

    public JobAdapter(ArrayList<JobModal> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void filteredList(ArrayList<JobModal> searchList)
    {
        this.list=searchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.jobopening,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        JobModal modal=list.get(position);
        holder.salary.setText(modal.getSalary());
        holder.company.setText(modal.getCompany());
        holder.workType.setText(modal.getWorkType());
        holder.location.setText(modal.getLocation());
        holder.type.setText(modal.getType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView type,company,salary,workType,location ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            type=itemView.findViewById(R.id.stream);
            company=itemView.findViewById(R.id.company);
            workType=itemView.findViewById(R.id.workType);
            salary=itemView.findViewById(R.id.salaryAmount);
            location=itemView.findViewById(R.id.location);
        }
    }
}
