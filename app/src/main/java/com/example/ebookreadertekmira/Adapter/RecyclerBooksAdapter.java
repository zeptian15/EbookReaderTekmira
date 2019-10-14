package com.example.ebookreadertekmira.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ebookreadertekmira.DetailBooks;
import com.example.ebookreadertekmira.Model.Book;
import com.example.ebookreadertekmira.R;

import java.util.ArrayList;

public class RecyclerBooksAdapter extends RecyclerView.Adapter<RecyclerBooksAdapter.RecyclerViewHolder> {
    private ArrayList<Book> listBook;

    public RecyclerBooksAdapter (ArrayList<Book> list){
        this.listBook = list;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_books_layout, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Book book = listBook.get(position);

        Glide.with(holder.itemView.getContext())
                .load("http://10.0.9.194:8000/images/" + book.getGambar())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvJudul.setText(book.getJudul());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                // Masuk Halaman Detail PDF
                Intent DetailBook = new Intent(holder.itemView.getContext(), DetailBooks.class);
                DetailBook.putExtra("File", book.getFile());
                DetailBook.putExtra("Judul", book.getJudul());
                context.startActivity(DetailBook);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    // Membuat Contructor
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul;
        ImageView imgPhoto;
        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            // Cari berdasarkan Id
            tvJudul = itemView.findViewById(R.id.tv_judul_buku);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);

        }
    }
}
