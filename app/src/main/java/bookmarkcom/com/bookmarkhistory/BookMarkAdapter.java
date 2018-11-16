package bookmarkcom.com.bookmarkhistory;

/*
 *  ****************************************************************************
 *  * Created by : Md. Moniruzzaman Monir on 11/16/2018 at 12:07 PM.
 *  * Email : moniruzzaman@w3engineers.com
 *  *
 *  * Purpose:
 *  *
 *  * Last edited by : Md. Moniruzzaman Monir on 11/16/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.MyViewHolder>{
    private ArrayList<BookmarkModel> arrayList;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public BookMarkAdapter( ArrayList<BookmarkModel> myDataset) {
        arrayList = myDataset;
    }

    @NonNull
    @Override
    public BookMarkAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitle.setText(arrayList.get(position).getBookmarkTitle());
        holder.mUrl.setText(arrayList.get(position).getBookmarkUrl());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitle, mUrl;
        public MyViewHolder(View v) {
            super(v);
            mTitle = v.findViewById(R.id.bookmar_title);
            mUrl = v.findViewById(R.id.bookmark_url);
        }
    }
}
