package ibrahim.taskmind.application.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import ibrahim.taskmind.Library.Main.Downloader.DownloadData;
import ibrahim.taskmind.R;
import ibrahim.taskmind.application.Adapter.DataAapter;
import ibrahim.taskmind.application.Model.DataResponse;
import ibrahim.taskmind.application.ViewModel.DataViewModel;


public class MainActivity extends AppCompatActivity {


    ProgressDialog mProgressDialog;



    DataAapter adapter;
    DataViewModel viewModel;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initList();

        initViewModel();
        getData();
    } // function of onCreate

    private void testDownload()
    {
        // instantiate it within the onCreate method
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("A message");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);

// execute this when the downloader must be fired
        final DownloadData downloadTask = new DownloadData(MainActivity.this,mProgressDialog);
        downloadTask.execute("https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg");

        mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                downloadTask.cancel(true); //cancel the task
            }
        });
    } // function of testDownload

    private void initViewModel()
    {
        viewModel = ViewModelProviders.of(this).get(DataViewModel.class);
    } // function of initViewModel
    private void getData()
    {
        viewModel.itemPagedList.observe(this, new Observer<PagedList<DataResponse>>() {
            @Override
            public void onChanged(@Nullable PagedList<DataResponse> listBeans) {

                adapter.submitList(listBeans);
            }
        });
    } // function of getData

    private void initList()
    {
        recyclerView = findViewById(R.id.recycler_view);
        adapter= new DataAapter(this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    } // function of ininList



} // class of MainActivity
