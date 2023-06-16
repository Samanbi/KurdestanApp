package tekma.app.kurdistan.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tekma.app.kurdistan.R;
import tekma.app.kurdistan.models.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Activity activity;
    private List<Product> dataList;

    public ProductAdapter(Activity activity, List<Product> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product products = dataList.get(position);

        ImageView image = holder.image;
        TextView name = holder.name;
        TextView price = holder.price;
        TextView date = holder.date;
        TextView dateAge = holder.dateAge;

//        image.setImageDrawable(activity.getResources().getDrawable(products.getImage(),null));
        name.setText(products.getName());
        price.setText(products.getPrice() + " تومان ");
        date.setText(products.getDate());
        dateAge.setText(products.getDateAge());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView price;
        public TextView date;
        public TextView dateAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_title);
            price = itemView.findViewById(R.id.product_price);
            date = itemView.findViewById(R.id.product_date);
            dateAge = itemView.findViewById(R.id.product_date_age);
        }
    }
}
