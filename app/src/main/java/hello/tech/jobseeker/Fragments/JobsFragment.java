package hello.tech.jobseeker.Fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hello.tech.jobseeker.Adapters.JobAdapter;
import hello.tech.jobseeker.Modals.JobModal;
import hello.tech.jobseeker.databinding.FragmentJobsBinding;

public class JobsFragment extends Fragment {
    FragmentJobsBinding binding;
    DatabaseReference reference;
    ArrayList<JobModal> list;
    JobAdapter adapter;
    ProgressDialog pd;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJobsBinding.inflate(getLayoutInflater());
        pd = new ProgressDialog(getContext());
        pd.setTitle("Fetching data");
        pd.setMessage("Loading Please Wait");
        pd.show();

        list = new ArrayList<>();
        adapter = new JobAdapter(list, getContext());
        reference = FirebaseDatabase.getInstance().getReference();
        binding.jobRecycle.setHasFixedSize(true);
        binding.jobRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.jobRecycle.setAdapter(adapter);

        reference.child("Jobs").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                pd.dismiss();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    JobModal modal = dataSnapshot.getValue(JobModal.class);
                    assert modal != null;
                    list.add(modal);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                pd.dismiss();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return binding.getRoot();
    }
}