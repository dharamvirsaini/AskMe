package example.com.ask;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;


public class RecyclerAdapterType2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Item> data ;
    Context context;

    public RecyclerAdapterType2(List<Item> data,Context context) {
        this.data = data;
        this.context = context ;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.type_2_item, parent, false);
        ViewHolderItemType2 viewHolder = new ViewHolderItemType2(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderItemType2 viewHolderItemType2 = (ViewHolderItemType2)holder;
        viewHolderItemType2.textView.setText(data.get(position).getLabel());
        ViewGroup.LayoutParams layoutParamRelativeView= viewHolderItemType2.containerRelativeLayout.getLayoutParams();
        ViewGroup.LayoutParams containerCardParams = viewHolderItemType2.containerCard.getLayoutParams();
        containerCardParams.height = (MainActivity.screenSize/3)*2  ;
        layoutParamRelativeView.height=(MainActivity.screenSize/3)*2;
        viewHolderItemType2.containerCard.setLayoutParams(containerCardParams);
        viewHolderItemType2.containerRelativeLayout.setLayoutParams(layoutParamRelativeView);
        Picasso.with(context).load(data.get(position).getImageUrl()).resize(((MainActivity.screenWidth/ 3 )*2), ((MainActivity.screenSize/ 9 )*4)).into(viewHolderItemType2.imageView);



    }

    @Override
    public int getItemCount() {
       return data.size();
    }
     public class ViewHolderItemType2 extends RecyclerView.ViewHolder{
        ImageView imageView ;
        TextView textView ;
         CardView containerCard;
         LinearLayout containerRelativeLayout;

        public ViewHolderItemType2(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView_template2_item);
            textView =  (TextView)itemView.findViewById(R.id.textView_template2_item);
            containerCard = (CardView)itemView.findViewById(R.id.template_two_item_card_container);
            containerRelativeLayout = (LinearLayout)itemView.findViewById(R.id.template_two_item_card_relative_layout);

        }
    }
}
