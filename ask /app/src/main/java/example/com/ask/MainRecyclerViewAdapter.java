package example.com.ask;


import android.content.Context;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.squareup.picasso.Picasso;


import java.util.List;


public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE1 = 1;
    private final int TYPE2 = 2;
    private final int TYPE3 = 3;
    private List<Object> data;
    private Context context;
    LayoutInflater inflater;

    public MainRecyclerViewAdapter(List<Object> data, Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof Template1Data) {

            return TYPE1;
        } else if (data.get(position) instanceof Template2Data) {

            return TYPE2;
        } else if (data.get(position) instanceof Template3Data) {

            return TYPE3;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE1:
                View v1 = inflater.inflate(R.layout.temp_three, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case TYPE2:
                View v2 = inflater.inflate(R.layout.tem_two, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
            case TYPE3:
                View v3 = inflater.inflate(R.layout.temp_three, viewGroup, false);
                viewHolder = new ViewHolder3(v3);
                break;
            default:
                viewHolder = null;
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case TYPE1:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            case TYPE2:

                ViewHolder2 vh2 = (ViewHolder2) viewHolder;
                configureViewHolder2(vh2, position);
                break;
            case TYPE3:
                ViewHolder3 vh3 = (ViewHolder3) viewHolder;
                configureViewHolder3(vh3, position);
                break;

        }

    }

    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        Template1Data temp = (Template1Data) data.get(position);
        List<Item> dataForPagerAdapter = temp.getTemplate1Items();
        vh1.template3MainLabel.setText(temp.getLabel());
        ViewGroup.LayoutParams layoutParams = vh1.template3ViewPager.getLayoutParams();
        layoutParams.height = 500;
        vh1.template3ViewPager.setLayoutParams(layoutParams);
        vh1.template3ViewPager.setAdapter(new ViewPagerAdapterType3(dataForPagerAdapter, context));
        //Template1Data temp = (Template1Data) data.get(position);
        //Picasso.with(context).load(temp.getImageUrl()).resize(MainActivity.screenWidth - 20, MainActivity.screenSize / 3).into(vh1.imageView);

    }

    private void configureViewHolder2(ViewHolder2 vh2, int position) {

        Template2Data temp = (Template2Data) data.get(position);
        List<Item> dataForInnerRecycler = temp.getTemplate2Items();
        vh2.templateTwoMainLabel.setText(temp.getLabel());
        vh2.template2Recycler.setAdapter(new RecyclerAdapterType2(dataForInnerRecycler, context));
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        vh2.template2Recycler.setLayoutManager(layoutManager);
    }

    private void configureViewHolder3(ViewHolder3 vh3, int position) {

        Template3Data temp = (Template3Data) data.get(position);
        List<Item> dataForPagerAdapter = temp.getTemplate3Items();
        vh3.template3MainLabel.setText(temp.getLabel());
        ViewGroup.LayoutParams layoutParams = vh3.template3ViewPager.getLayoutParams();
        layoutParams.height = 500;
        vh3.template3ViewPager.setLayoutParams(layoutParams);
        vh3.template3ViewPager.setAdapter(new ViewPagerAdapterType3(dataForPagerAdapter, context));

        vh3.titleIndicator.setViewPager(vh3.template3ViewPager);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }
}
