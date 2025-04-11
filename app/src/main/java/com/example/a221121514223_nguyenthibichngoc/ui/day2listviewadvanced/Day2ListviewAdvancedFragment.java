package com.example.a221121514223_nguyenthibichngoc.ui.day2listviewadvanced;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a221121514223_nguyenthibichngoc.R;
import com.example.a221121514223_nguyenthibichngoc.adapter.ContactAdapter;
import com.example.a221121514223_nguyenthibichngoc.model.ContactModel;
import com.example.a221121514223_nguyenthibichngoc.model.ContactModel_1;
import com.example.a221121514223_nguyenthibichngoc.network.IOnChildItemClick;

import java.util.ArrayList;
import java.util.List;

public class Day2ListviewAdvancedFragment extends Fragment implements IOnChildItemClick {

    private Day2ListviewAdvancedViewModel mViewModel;
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private TextView tvName;
    private ImageView ivUser;

    public static Day2ListviewAdvancedFragment newInstance() {
        return new Day2ListviewAdvancedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day2_listview_advanced, container, false);

        initView(view); // Truyền view vào
        initData();

        mAdapter = new ContactAdapter(getContext(), listContact);
        mAdapter.registerChildItemClick(new IOnChildItemClick() {
            @Override
            public void onItemChildClick(int position) {
                ContactModel model = listContact.get(position);
                tvName.setText(model.getName());
                ivUser.setImageResource(model.getImage());
            }
        });

        lvContact.setAdapter(mAdapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel model = listContact.get(position);
                Toast.makeText(getContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void initView (View view) {
        lvContact = view.findViewById(R.id.lvContact);
        tvName = view.findViewById(R.id.tvName);
        ivUser = view.findViewById(R.id.ivUser);
    }

    private void initData() {
        listContact.add(new ContactModel("Nguyễn Thị Bích Ngọc", "0975825267", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Trần Thị Lan Anh", "0912345678", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Lê Hoàng Nam", "0908765432", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Phan Minh Tâm", "0987654321", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Đỗ Thanh Tùng", "0923456789", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Hoàng Thị Thu Trang", "0934567890", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Vũ Minh Đức", "0945678901", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Bùi Thị Kim Oanh", "0956789012", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Ngô Thị Mai Lan", "0967890123", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Lê Minh Tường", "0978901234", R.drawable.nguyen_thi_bich_ngoc));
        listContact.add(new ContactModel("Phạm Quang Hieu", "0989012345", R.drawable.nguyen_thi_bich_ngoc));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel model = listContact.get(position);
        tvName.setText(model.getName());
        ivUser.setImageResource(model.getImage());

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Day2ListviewAdvancedViewModel.class);
        // TODO: Use the ViewModel
    }

}