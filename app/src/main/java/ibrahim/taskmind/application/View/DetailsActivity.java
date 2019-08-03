package ibrahim.taskmind.application.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import ibrahim.taskmind.Library.Main.MindValley;
import ibrahim.taskmind.R;
import ibrahim.taskmind.application.Model.DataResponse;
import ibrahim.taskmind.application.ViewModel.DetailsViewModel;

public class DetailsActivity extends AppCompatActivity {

    ImageView cover_image , user_image ;

    TextView txt_date , txt_like , txt_username , txt_nickname ,txt_contact, txt_category , txt_size;

    String id="";

    DetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getId();
        initView();

        initViewModel();
        getCashedData();
    } // function of onCreate

    private void initView()
    {
        cover_image = findViewById(R.id.details_image);
        user_image = findViewById(R.id.details_user_image);

        txt_date = findViewById(R.id.details_date);
        txt_like = findViewById(R.id.details_likes);
        txt_username = findViewById(R.id.details_user_name);
        txt_nickname = findViewById(R.id.details_user_nick_name);
        txt_contact = findViewById(R.id.details_user_contact);
        txt_category = findViewById(R.id.details_category);
        txt_size = findViewById(R.id.details_size);
    } // function of initView


    private void getId()
    {
        if(getIntent() != null)
        {
            id = getIntent().getStringExtra("id");
        }
    } // function of getId

    private void initViewModel()
    {
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
    } // function of initViewModel

    private void getCashedData()
    {
         viewModel.getData(id).observe(this, new Observer<DataResponse>() {
             @Override
             public void onChanged(DataResponse dataResponse) {

                 setData(dataResponse);
             }
         });
    } // fnction of getCashedData


    private void setData(DataResponse data)
    {
        new MindValley.LoadImage()
                .with(this)
                .from(data.getUrls().getRegular())
                .into(cover_image)
                .create();


        new MindValley.LoadImage()
                .with(this)
                .from(data.getUser().getProfile_image().getMedium())
                .into(user_image)
                .create();


        txt_date.setText(data.getCreated_at());
        txt_like.setText(data.getLikes()+"");

        txt_username.setText(data.getUser().getName());
        txt_nickname.setText(data.getUser().getUsername());
//        txt_contact.setText(data.getUser().getLinks().getSelf());

        txt_category.setText(getString(R.string.category)+" "
                +data.getCategories().get(0).getTitle());

        txt_size.setText(getString(R.string.size)+" "+data.getHeight()+" X "+data.getWidth());


    } // function of setData
} // class of DetailsActivity
