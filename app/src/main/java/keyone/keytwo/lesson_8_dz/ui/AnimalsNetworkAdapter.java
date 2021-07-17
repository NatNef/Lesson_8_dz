package keyone.keytwo.lesson_8_dz.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import keyone.keytwo.lesson_8_dz.R;

public class AnimalsNetworkAdapter extends RecyclerView.Adapter<AnimalsNetworkAdapter.ViewHolder> {

    private String[] animals;

    // Передаём в конструктор источник данных
    // В нашем случае это массив, но может быть и запрос к БД
    public AnimalsNetworkAdapter(String[] animals) {
        this.animals = animals;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @Override
    public AnimalsNetworkAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Создаём новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        // Здесь можно установить всякие параметры
        return new ViewHolder(v);
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // Получить элемент из источника данных (БД, интернет...)
        // Вынести на экран, используя ViewHolder
        viewHolder.getTextView().setText(animals[i]);
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return animals.length;
    }

    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на один пункт списка
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}


