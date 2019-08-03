package ibrahim.taskmind.application.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import ibrahim.taskmind.Library.Main.MindValley;
import ibrahim.taskmind.R;
import ibrahim.taskmind.application.Model.DataResponse;
import ibrahim.taskmind.application.View.DetailsActivity;

public class DataAapter extends PagedListAdapter<DataResponse,DataAapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView photographer_name , date ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_image);
            photographer_name = itemView.findViewById(R.id.item_photographer);
            date = itemView.findViewById(R.id.item_date);

        }
    }

    private Context context;

    protected DataAapter(@NonNull DiffUtil.ItemCallback<DataResponse> diffCallback) {
        super(diffCallback);
    }
    public DataAapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    private static DiffUtil.ItemCallback<DataResponse> DIFF_CALLBACK
            = new DiffUtil.ItemCallback<DataResponse>() {
        @Override
        public boolean areItemsTheSame(@NonNull DataResponse listBean, @NonNull DataResponse t1) {
            return listBean.getId() == t1.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataResponse listBean, @NonNull DataResponse t1) {
            return listBean.equals(t1);
        }
    };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final  DataResponse object = getItem(position);

        new MindValley.LoadImage()
                      .with(context)
                      .from(object.getUrls().getRaw())
                      .into(holder.image)
                      .create();

        holder.photographer_name.setText(object.getUser().getName());
        holder.date.setText(object.getCreated_at());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new MindValley.CasheJson()
                        .request(object.getId())
                        .json(object)
                        .cahse();

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id",object.getId());
                context.startActivity(intent);
            }
        });

    }




}
