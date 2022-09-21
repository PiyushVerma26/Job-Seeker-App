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

import hello.tech.jobseeker.Modals.CompanyModal;
import hello.tech.jobseeker.R;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.viewHolder> {

    ArrayList<CompanyModal> list;
    Context context;

    public CompanyAdapter(ArrayList<CompanyModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.company, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CompanyModal modal = list.get(position);
        holder.image.setImageResource(modal.getImage());
        holder.companyType.setText(modal.getCompanyType());
        holder.openingType.setText(modal.getOpeningType());
        holder.CompanyName.setText(modal.getCompanyName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView CompanyName, openingType, companyType;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.CompanyImage);
            CompanyName = itemView.findViewById(R.id.CompanyName);
            openingType = itemView.findViewById(R.id.type);
            companyType = itemView.findViewById(R.id.openings);
        }
    }
}
