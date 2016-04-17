package jaenwawe.miniInventory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_FrontPage extends Fragment {

    private static final String ARG_SECTION_NUMBER = "sectionNumber";
    private OnFragmentInteractionListener mListener;


    public Fragment_FrontPage() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Fragment_FrontPage newInstance(int sectionNumber) {
        Fragment_FrontPage fragment = new Fragment_FrontPage();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment__front_page, container, false);

        Button button = (Button) rootView.findViewById(R.id.front_button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mListener.onFragmentInteraction((1));
            }
        });

        Button button2 = (Button) rootView.findViewById(R.id.front_button2);
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //load name of class
                        Intent intent = new Intent(getActivity(), ActivityRecyclerView.class);
                        startActivity(intent);
            }
        });

        Button button3 = (Button) rootView.findViewById(R.id.front_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Activity_MasterDetails.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(int position);
    }
}