package com.example.daniel.paceplace;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.paceplace.R;

import java.util.ArrayList;
import java.util.List;

public class BookListAdapter extends BaseAdapter implements Filterable {
    //to reference the Activity
    private BookFilter bookFilter;
    private final Context context;
    private List<Book> mBookList;
    private List<Book> mFilteredList;
    private int mSelectedPosition;

    public BookListAdapter(Activity context, List<Book> bookList){

        this.context=context;
        this.mBookList = bookList;
        this.mFilteredList = bookList;

        getFilter();

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.book_finder_list_item, null);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        final Book book = (Book) getItem(position);
        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.mTitleView.setText(book.getTitle());
        viewHolder.mAuthorView.setText(book.getAuthor());

        return convertView;




    }

    // Sets position of clicked item in listview
    void setSelectedPosition(int position) {
        mSelectedPosition = position;
    }

    //Gets position of clicked item in listview
    int getSelectedPosition() {
        return mSelectedPosition;
    }

    @Override
    public int getCount() {
        return mFilteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFilteredList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Filter getFilter() {
        if (bookFilter == null) {
            bookFilter = new BookFilter();
        }

        return bookFilter;

    }

    static class ViewHolder {
        TextView mAuthorView;
        TextView mTitleView;

        ViewHolder(View item) {
            //Add All views for an item in the view holder
            mTitleView = item.findViewById(R.id.titleTextView);
            mAuthorView = item.findViewById(R.id.authorTextView);


        }
    }



    private class BookFilter extends Filter { //Filter to search for books based on title

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                List<Book> tempList = new ArrayList<>();

                // search content in book list
                for (Book book : mBookList) {
                    if (book.getTitle().contains(constraint)) {
                        tempList.add(book);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = mBookList.size();
                filterResults.values = mBookList;
            }

            return filterResults;
        }


         // Notify about filtered list to ui
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredList = (List<Book>) results.values;
            notifyDataSetChanged();
        }
    }
}
