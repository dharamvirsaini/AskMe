package example.com.ask;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ViewPagerAdapterType3 extends PagerAdapter {
    List<Item>items ;
    Context context ;

    public ViewPagerAdapterType3(List<Item> items,Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.type_3_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_template3_item);
        Picasso.with(context).load(items.get(position).getImageUrl()).fit().into(imageView);
        //imageView.setBackgroundResource(R.drawable.loading);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
