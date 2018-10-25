package com.example.muhammadhaikal.layoutapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muhammadhaikal.layoutapp.R;
import com.example.muhammadhaikal.layoutapp.adapter.MemberListAdapter;
import com.example.muhammadhaikal.layoutapp.model.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by docotel on 3/7/16.
 */
public class MemberFragment extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;

    protected Context context;

    public static MemberFragment newInstance(){
        return new MemberFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listMember);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();
        Member member;

        int thumb[] = {R.drawable.asuma, R.drawable.berdua, R.drawable.boruto,
                R.drawable.deidara, R.drawable.hidan, R.drawable.hinatakerudungan,
                R.drawable.itachi, R.drawable.kakasi, R.drawable.kakuzu,
                R.drawable.kawaki, R.drawable.kurama, R.drawable.madara,
                R.drawable.minato, R.drawable.mitsuki, R.drawable.naruto,
                R.drawable.obito, R.drawable.pain, R.drawable.sarada,
                R.drawable.sasori, R.drawable.sasuke};

        String name[] = {"asuma", "berdua", "boruto", "deidara",
                "hidan", "hidan", "hinatakerudungan", "itachi",
                "kakasi", "kakuzu", "kawaki", "kurama",
                "madara", "minato", "mitsuki", "naruto",
                "obito", "pain", "sarada", "sasori","sasuke"};

        String team = "Team campuran";

        for(int i=0; i < thumb.length; i++){
            member = new Member();

            member.setId(i+1);
            member.setName(name[i]);
            member.setTeam(team);
            member.setThumb(thumb[i]);

            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
