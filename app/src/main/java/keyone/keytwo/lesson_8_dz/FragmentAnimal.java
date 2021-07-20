package keyone.keytwo.lesson_8_dz;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import keyone.keytwo.lesson_8_dz.ui.AnimalsNetworkAdapter;
import keyone.keytwo.lesson_8_dz.ui.Data.CardsSource;
import keyone.keytwo.lesson_8_dz.ui.Data.CardsSourceImpl;


public class FragmentAnimal extends Fragment {

    public static FragmentAnimal newInstance() {
        return new FragmentAnimal();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
//        String[] data = getResources().getStringArray(R.array.titles);
        // Получим источник данных для списка
        CardsSource data = new CardsSourceImpl(getResources()).init();
        initRecyclerView(recyclerView, data);
        return view;
    }

    private void initRecyclerView(RecyclerView recyclerView, CardsSource data) {

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер
        final AnimalsNetworkAdapter adapter = new AnimalsNetworkAdapter(data);
        recyclerView.setAdapter(adapter);
    }
// Установим слушателя
       adapter.SetOnItemClickListener(new AnimalsNetworkAdapter.OnItemClickListener()

    {
        @Override
        public void onItemClick; (View) view; int position = 0; {
        Toast.makeText(getContext(), String.format("Позиция - %d", position),
                Toast.LENGTH_SHORT).show();
    }
    }

}



