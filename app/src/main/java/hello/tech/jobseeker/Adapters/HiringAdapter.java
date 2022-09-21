package hello.tech.jobseeker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.jobseeker.Modals.HiringModal;
import hello.tech.jobseeker.R;

public class HiringAdapter extends RecyclerView.Adapter<HiringAdapter.viewHolder> {

    ArrayList<HiringModal> list;
    Context context;

    public HiringAdapter(ArrayList<HiringModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.hiring, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HiringModal modal = list.get(position);
        holder.image.setImageResource(modal.getImage());
        holder.year.setText(modal.getYear());
        holder.salary.setText(modal.getSalary());
        holder.CompanyName.setText(modal.getName());
        holder.EmployeeName.setText(modal.getEmployeeName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView CompanyName, salary, EmployeeName,year;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hiring_image);
            CompanyName = itemView.findViewById(R.id.company_name);
            EmployeeName = itemView.findViewById(R.id.employee);
            salary = itemView.findViewById(R.id.salary);
            year = itemView.findViewById(R.id.year);
        }
    }
}
