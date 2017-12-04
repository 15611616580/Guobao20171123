package guobao.bwie.com.cart;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import guobao.bwie.com.cart.bean.QurryBean;


/**
 * Created by 郭宝 on 2017/11/29.
 */

public class HomeAdapter extends BaseExpandableListAdapter {

    private List<QurryBean.DataBean> list;
    private Context context;
    private CheckBox checkBox2;
    boolean bs = false;

    public HomeAdapter(List<QurryBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return list.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int i, final boolean b, View view, ViewGroup viewGroup) {
        TextView textView1;
        final CheckBox checkBox1;
        view = View.inflate(context, R.layout.item1, null);
        textView1 = view.findViewById(R.id.text1);
        checkBox1 = view.findViewById(R.id.Gcheckbox);
        textView1.setText(list.get(i).getSellerName());
        checkBox1.setChecked(list.get(i).isGcishecked());


//       checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
////                list.get(i).setGcishecked(b);
//                Toast.makeText(context, ""+list.get(i).isGcishecked(), Toast.LENGTH_SHORT).show();
//            }
//        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!bs) {

                    list.get(i).setGcishecked(true);
                    for (int q = 0; q < list.get(i).getList().size(); q++) {
                        list.get(i).getList().get(q).setCischecked(true);
                    }
                    notifyDataSetChanged();
                    bs = true;
                } else {
                    list.get(i).setGcishecked(false);
                    for (int q = 0; q < list.get(i).getList().size(); q++) {
                        list.get(i).getList().get(q).setCischecked(false);
                    }
                    notifyDataSetChanged();
                    bs = false;
                }
            }
        });
        return view;
    }

    public void delete() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isGcishecked()) {
                Log.i("q", "" + i);
                list.remove(i);
                notifyDataSetChanged();
            }

            for (int d = 0; d < list.get(i).getList().size(); d++) {
                if (list.get(i).getList().get(d).isCischecked()) {
                    list.get(i).getList().remove(d);
                    notifyDataSetChanged();

                }
            }
        }
    }


    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        TextView textView2;
        view = View.inflate(context, R.layout.item2, null);
        textView2 = view.findViewById(R.id.text2);
        textView2.setText(list.get(i).getList().get(i1).getTitle());
        checkBox2 = view.findViewById(R.id.Ccheckbox);
        checkBox2.setChecked(list.get(i).getList().get(i1).isCischecked());

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!list.get(i).getList().get(i1).isCischecked()) {
                    list.get(i).getList().get(i1).setCischecked(true);
                } else {
                    list.get(i).getList().get(i1).setCischecked(false);
                }
                /*for (int q=0;q<list.get(i).getList().size();q++){
                    if (list.get(i).getList().get(q).isCischecked()){
                        list.get(i).setGcishecked(true);
                        notifyDataSetChanged();
                    }else {
                        list.get(i).setGcishecked(false);
                        notifyDataSetChanged();
                        return;
                    }
                }*/

            }
        });

//        for(int s=0;s<list.size();s++){
//            if(list.get(s).isGcishecked()){
//
//                notifyDataSetChanged();
//            }else{
//                checkBox2.setChecked(false);
//                notifyDataSetChanged();
//            }
//        }

       /* checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bean.setCischecked(b);
                Toast.makeText(context, ""+bean.isCischecked(), Toast.LENGTH_SHORT).show();
            }
        });*/
       /*delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clist.remove(i).get(i1);
            }
        });*/
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
