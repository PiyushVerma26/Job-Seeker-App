package hello.tech.jobseeker;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import hello.tech.jobseeker.Modals.JobModal;
import hello.tech.jobseeker.databinding.ActivityEmployersCreateBinding;

public class EmployersCreate extends AppCompatActivity {
ActivityEmployersCreateBinding binding;
ProgressDialog pd;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEmployersCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pd=new ProgressDialog(this);
        pd.setMessage("Loading Please Wait");
       reference= FirebaseDatabase.getInstance().getReference();
//       For Internship
        binding.btnIntern.setOnClickListener(v -> {
            pd.show();
            String companyName,location,type,stream,salary;
            String inputType="Internship";
            companyName=binding.companyName.getText().toString().trim();
            location=binding.location.getText().toString().trim();
            type=binding.type.getText().toString().trim();
            stream=binding.Stream.getText().toString().trim();
            salary=binding.salary.getText().toString().trim();
            if (TextUtils.isEmpty(companyName)||TextUtils.isEmpty(location)||TextUtils.isEmpty(type)||TextUtils.isEmpty(stream)||TextUtils.isEmpty(salary))
            {
                pd.dismiss();
                Toast.makeText(EmployersCreate.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                UpdatingDataBase(companyName,type,location,stream,salary,inputType);
                binding.salary.setText("");
                binding.type.setText("");
                binding.Stream.setText("");
                binding.location.setText("");
                binding.companyName.setText("");
            }
        });

//       for jobs

        binding.btnSubmit.setOnClickListener(v -> {
            pd.show();
            String inputType="Jobs";
            String companyName,location,type,stream,salary;
            companyName=binding.companyName.getText().toString().trim();
            location=binding.location.getText().toString().trim();
            type=binding.type.getText().toString().trim();
            stream=binding.Stream.getText().toString().trim();
            salary=binding.salary.getText().toString().trim();

            if (TextUtils.isEmpty(companyName)||TextUtils.isEmpty(location)||TextUtils.isEmpty(type)||TextUtils.isEmpty(stream)||TextUtils.isEmpty(salary))
            {
                pd.dismiss();
                Toast.makeText(EmployersCreate.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                UpdatingDataBase(companyName,type,location,stream,salary,inputType);
                binding.salary.setText("");
                binding.type.setText("");
                binding.Stream.setText("");
                binding.location.setText("");
                binding.companyName.setText("");
            }
        });
    }

    private void UpdatingDataBase(String companyName, String type, String location, String stream, String salary,String inputType) {
        SimpleDateFormat format=new SimpleDateFormat("dd MMM yyyy,hh mm ss", Locale.getDefault());
        String Date= format.format(new Date());

        JobModal modal= new JobModal(stream,companyName,salary,type,location);

        reference.child(inputType).child(Date).setValue(modal).addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                pd.dismiss();
                Toast.makeText(EmployersCreate.this, "Job List Updated", Toast.LENGTH_SHORT).show();
            }
            else
            {pd.dismiss();
                Toast.makeText(EmployersCreate.this, "Network Error", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            pd.dismiss();
            Toast.makeText(EmployersCreate.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        });

    }
}