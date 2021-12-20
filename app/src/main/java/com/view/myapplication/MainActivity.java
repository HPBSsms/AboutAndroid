package com.view.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.promeg.pinyinhelper.Pinyin;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<>();

    private List<String> strings;
    private Adapter adapter;

    private String letter;
    private List<Integer> viewTypeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvIndex = findViewById(R.id.rv_index);
        rvIndex.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new Adapter();
        rvIndex.setAdapter(adapter);

        initData();
    }

    private void initData() {
        String[] s = new String[]{"如果", "没人", "吃饭", "食堂", "倒闭", "大头", "小炮", "石头", "亚索", "塞纳", "武器", "螳螂"};
        strings = Arrays.asList(s);

//        list.add("中国");
//        list.add("加拿大");
//        list.add("美国");
//        list.add("A");
//        list.add("more");
//        list.add("啊");
        Comparator cmp = new ChineseCharComp();
        Collections.sort(strings, cmp);
        Iterator iter = strings.iterator();
        while (iter.hasNext()) {
            System.out.println("----" + iter.next());
        }

        adapter.notifyItemRangeInserted(adapter.getItemCount(), strings.size());

    }

    public void bt1(View view) {
        Toast.makeText(this, "ViewPager", Toast.LENGTH_SHORT).show();
    }

    private class Adapter extends RecyclerView.Adapter<MyViewHolder> {
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index, null));
            if (viewType == 1) {
                viewHolder.tvIndex.setVisibility(View.VISIBLE);
                viewHolder.tvText.setVisibility(View.VISIBLE);
            } else if (viewType == 2) {
                viewHolder.tvIndex.setVisibility(View.VISIBLE);
                viewHolder.tvText.setVisibility(View.VISIBLE);
            } else {
                viewHolder.tvIndex.setVisibility(View.GONE);
                viewHolder.tvText.setVisibility(View.VISIBLE);
            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tvIndex.setText(Pinyin.toPinyin(strings.get(position), "").toUpperCase());
            holder.tvText.setText(strings.get(position));
        }

        @Override
        public int getItemCount() {
            return strings.size();
        }

        @Override
        public int getItemViewType(int position) {
            String firstLetter = String.valueOf(Pinyin.toPinyin(strings.get(position), "").toUpperCase().charAt(0));
            if (viewTypeList.size() >= position + 1) {
                return viewTypeList.get(position);
            }
            if (position == 0) {
                letter = firstLetter;
                viewTypeList.add(1);
                return 1;
            } else if (!letter.equals(firstLetter)) {
                letter = firstLetter;
                viewTypeList.add(2);
                return 2;
            } else {
                viewTypeList.add(3);
                return 3;
            }
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvIndex;
        private final TextView tvText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIndex = itemView.findViewById(R.id.tv_index);
            tvText = itemView.findViewById(R.id.tv_text);
        }

    }

    @SuppressWarnings("unchecked")
    public class ChineseCharComp implements Comparator {
        public int compare(Object o1, Object o2) {
            Collator myCollator = Collator.getInstance(java.util.Locale.CHINA);
            if (myCollator.compare(o1, o2) < 0)
                return -1;
            else if (myCollator.compare(o1, o2) > 0)
                return 1;
            else
                return 0;
        }

    }
}