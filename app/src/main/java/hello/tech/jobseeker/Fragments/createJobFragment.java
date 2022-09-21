package hello.tech.jobseeker.Fragments;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import hello.tech.jobseeker.EmployersCreate;
import hello.tech.jobseeker.databinding.FragmentCreateJobBinding;

public class createJobFragment extends Fragment {
    FragmentCreateJobBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCreateJobBinding.inflate(getLayoutInflater());
binding.btnCode.setOnClickListener(v -> {
    String code=binding.code.getText().toString().trim();
    String matchCode="2022";
    if (TextUtils.isEmpty(code))
    {
        Toast.makeText(getContext(),"Please Enter PassCode",Toast.LENGTH_SHORT).show();
    }
    else if (code.equals(matchCode))
    {
        Toast.makeText(getContext(),"Code Matched",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), EmployersCreate.class));
    }
    else
    {
        binding.code.setText("");
        Toast.makeText(getContext(),"Please Enter Valid PassCode",Toast.LENGTH_SHORT).show();
    }

});
        return binding.getRoot();
    }
}