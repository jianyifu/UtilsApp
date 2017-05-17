package com.fjy.utilsapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConstraintLayoutExample extends AppCompatActivity {
    private RecyclerView recyclerview;
    List<String> names = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout_example);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        for (int i = 0; i < 20; i++) {
            names.add("hahahah----"+i+"----------------------------------------------------------------------------------------------------");
        }
        recyclerview.setAdapter(new MyAdapter(names,this));
    }
    private static class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private List<String> names = new ArrayList<>();
        private LayoutInflater inflater;

        public MyAdapter(List<String> names, Activity activity) {
            this.inflater  = activity.getLayoutInflater();
            this.names = names;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tvName.setText(names.get(position));
            holder.tvOther.setText("tvOther ==="+position);
            holder.textView3.setText("textView3 ==="+position);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_item,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return names.size();
        }

    }
    private static class MyViewHolder  extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvName;
        private TextView tvOther;
        private TextView textView3;
        private Button open;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvOther = (TextView) itemView.findViewById(R.id.tv_other);
            textView3 = (TextView) itemView.findViewById(R.id.textView3);
            open = (Button) itemView.findViewById(R.id.open);
        }
    }
}
