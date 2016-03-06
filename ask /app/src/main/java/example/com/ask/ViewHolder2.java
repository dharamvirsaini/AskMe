package example.com.ask;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ViewHolder2 extends RecyclerView.ViewHolder {
    RecyclerView template2Recycler;
    TextView templateTwoMainLabel ;
    public ViewHolder2(View itemView) {
        super(itemView);
         template2Recycler = (RecyclerView)itemView.findViewById(R.id.template_two_recycler);
         templateTwoMainLabel = (TextView)itemView.findViewById(R.id.template_two_main_label);
         ViewGroup.LayoutParams layoutParams= template2Recycler.getLayoutParams();
         layoutParams.height = (MainActivity.screenSize*2)/3;
         template2Recycler.setLayoutParams(layoutParams);

    }
}
