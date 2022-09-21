package hello.tech.jobseeker.Fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
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
import hello.tech.jobseeker.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {
    FragmentSearchBinding binding;
    ArrayList<JobModal> list;
    JobAdapter adapter;
    ProgressDialog pd;
    DatabaseReference reference;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(getLayoutInflater());
        list = new ArrayList<>();

        pd = new ProgressDialog(getContext());
        pd.setMessage("Loading Please Wait");
        pd.show();
        reference = FirebaseDatabase.getInstance().getReference().child("Jobs");
        adapter = new JobAdapter(list, getContext());
        binding.searchRecycle.setHasFixedSize(true);
        binding.searchRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.searchRecycle.setAdapter(adapter);
        binding.search.clearFocus();
        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true ;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        reference.addValueEventListener(new ValueEventListener() {
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

    private void filterList(String newText) {
        ArrayList<JobModal> filterList = new ArrayList<>();
        for (JobModal modal : list) {
            if (modal.getLocation().toLowerCase().contains(newText.toLowerCase())) ;
            filterList.add(modal);
        }
        if (filterList.isEmpty()) {
            Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filteredList(filterList);
        }

    }
}