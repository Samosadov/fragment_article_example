package ru.synergy.fragmentarticleexample.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import ru.synergy.fragmentarticleexample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRatingBar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRatingBar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RatingBar ratingBar;

    public FragmentRatingBar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRatingBar.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRatingBar newInstance(String param1, String param2) {
        FragmentRatingBar fragment = new FragmentRatingBar();
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
        final View rootView = inflater.inflate(R.layout.fragment_rating_bar, container, false);

        ratingBar = (RatingBar) rootView.findViewById(R.id.rating_bar);
        addListenerOnButton(ratingBar);

        return rootView;
    }

    private void addListenerOnButton(RatingBar ratingBar) {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getActivity(), "Наш фанатик " + rating, Toast.LENGTH_LONG).show();

            }
        });
    }
}