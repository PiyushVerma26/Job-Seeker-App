package hello.tech.jobseeker.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.jobseeker.Adapters.CompanyAdapter;
import hello.tech.jobseeker.Adapters.HiringAdapter;
import hello.tech.jobseeker.Modals.CompanyModal;
import hello.tech.jobseeker.Modals.HiringModal;
import hello.tech.jobseeker.R;
import hello.tech.jobseeker.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<HiringModal> hiringList;
    HiringAdapter hiringAdapter;
    ArrayList<CompanyModal> companyList;
    CompanyAdapter companyAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

//        hiring section

        hiringList = new ArrayList<>();
        hiringAdapter = new HiringAdapter(hiringList, getContext());
        binding.hiringRecycle.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(RecyclerView.HORIZONTAL);
        binding.hiringRecycle.setLayoutManager(linearLayout);
        binding.hiringRecycle.setAdapter(hiringAdapter);

        hiringList.add(new HiringModal("Dell", R.drawable.job, "Piyush Verma", "19k", "2022"));
        hiringList.add(new HiringModal("ONGC", R.drawable.company, "Harsh Anand", "19k", "2022"));
        hiringList.add(new HiringModal("Lenevo", R.drawable.job, "Dev Raj", "19k", "2022"));
        hiringList.add(new HiringModal("Vivo", R.drawable.company, "Ankit", "19k", "2022"));
        hiringList.add(new HiringModal("Oppo", R.drawable.job, "Ishan Kishan", "19k", "2022"));
        hiringList.add(new HiringModal("LG", R.drawable.company, "Dinesh Kartik", "19k", "2022"));
        hiringList.add(new HiringModal("Samsung", R.drawable.job, "Virat Kholi", "19k", "2022"));
        hiringList.add(new HiringModal("Nokia", R.drawable.company, "Rohit Sharma", "19k", "2022"));
        hiringList.add(new HiringModal("Redmi", R.drawable.job, "Rishab Pant", "19k", "2022"));


//        Company Section

        companyList = new ArrayList<>();
        companyAdapter = new CompanyAdapter(companyList, getContext());
        binding.completeRecycle.setHasFixedSize(true);
        LinearLayoutManager CompleteLinearLayout = new LinearLayoutManager(getContext());
        CompleteLinearLayout.setOrientation(RecyclerView.HORIZONTAL);
        binding.completeRecycle.setLayoutManager(CompleteLinearLayout);
        binding.completeRecycle.setAdapter(companyAdapter);

companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Exposys Dat Labs",R.drawable.job,"Internship","Normal"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));
companyList.add(new CompanyModal("Hello Tech",R.drawable.company,"Jobs","MNC"));



binding.linkedin.setOnClickListener(v -> {
    String linkLin = "https://www.linkedin.com/in/piyushverma26/";
    String pack = "com.linkedin.android";
    Callopen(linkLin, pack, linkLin);
});

binding.gitHub.setOnClickListener(v -> {
    String gitLink = "https://github.com/PiyushVerma26";
    String pack = "com.github.android";
    Callopen(gitLink, pack, gitLink);
});
        return binding.getRoot();
    }
    private void Callopen(String link, String pack, String web) {

        try {
            Uri uri = Uri.parse(link);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(pack);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException) {
            Uri uri = Uri.parse(web);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(pack);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
}