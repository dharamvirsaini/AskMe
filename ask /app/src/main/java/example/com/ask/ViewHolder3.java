package example.com.ask;


import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;


public class ViewHolder3 extends RecyclerView.ViewHolder {
    ViewPager template3ViewPager ;
    CirclePageIndicator titleIndicator;
    TextView template3MainLabel;
    public ViewHolder3(View itemView) {
        super(itemView);
        template3ViewPager = (ViewPager)itemView.findViewById(R.id.template_three_view_pager);
        titleIndicator =(CirclePageIndicator)itemView.findViewById(R.id.titles);
        template3MainLabel = (TextView)itemView.findViewById(R.id.template_three_main_label);
    }
}
