package com.example.gif.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gif.R;
import com.example.gif.adapter.ExploreAdapter;
import com.example.gif.model.explore.ExploreItem;
import com.example.gif.view.viewmodel.ExploreViewModel;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {

    private ExploreAdapter exploreAdapter;
    private RecyclerView rvExplore;
    private ExploreViewModel exploreViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment #exploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exploreAdapter = new ExploreAdapter(getContext());
        exploreAdapter.notifyDataSetChanged();

        rvExplore = view.findViewById(R.id.fragmentexplore_rv);
        rvExplore.setLayoutManager(new GridLayoutManager(getContext(),3));

        exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        exploreViewModel.setExplore();
        exploreViewModel.getExploreResult().observe(this,getExplore);

        rvExplore.setAdapter(exploreAdapter);
    }

    private androidx.lifecycle.Observer<ArrayList<ExploreItem>> getExplore = new Observer<ArrayList<ExploreItem>>() {
        @Override
        public void onChanged(ArrayList<ExploreItem> trendingResultsItems) {
            if (trendingResultsItems !=null){
                exploreAdapter.setData(trendingResultsItems);
            }
        }
    };
}
