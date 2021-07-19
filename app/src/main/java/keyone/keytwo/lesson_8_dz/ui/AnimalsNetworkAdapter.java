package keyone.keytwo.lesson_8_dz.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Data;

import keyone.keytwo.lesson_8_dz.Data.CardData;
import keyone.keytwo.lesson_8_dz.Data.CardsSource;

import keyone.keytwo.lesson_8_dz.R;

public class AnimalsNetworkAdapter extends RecyclerView.Adapter<AnimalsNetworkAdapter.ViewHolder> {


    private final static String TAG = "AnimalsNetworkAdapter";
    private String[] dataSource;
    private OnItemClickListener itemClickListener;  // Слушатель будет устанавливаться извне

    private String[] animals;

    // Передаём в конструктор источник данных
    // В нашем случае это массив, но может быть и запрос к БД
//    public AnimalsNetworkAdapter(String[] animals) {
//        this.animals = animals;
//    }
    public AnimalsNetworkAdapter(String[] dataSource)
    {this.dataSource = dataSource;
    }


    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @Override
    public AnimalsNetworkAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Создаём новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        Log.d(TAG, "onCreateViewHolder");
        // Здесь можно установить всякие параметры
        return new ViewHolder(v);
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // Получить элемент из источника данных (БД, интернет...)
        // Вынести на экран, используя ViewHolder
      //  viewHolder.getTextView().setText(animals[i]);
        viewHolder.setData(dataSource.getCardData(i));
        Log.d(TAG, "onBindViewHolder");

    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
      //  return animals.length;
        return dataSource.size();
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
            return null;
        }

        // Сеттер слушателя нажатий
        public void SetOnItemClickListener(OnItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }
        // Интерфейс для обработки нажатий, как в ListView
        public interface OnItemClickListener {
            void onItemClick(View view , int position);
        }

    }
    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // один пункт списка
    public class ViewHolder extends RecyclerView.ViewHolder {

      //  private TextView textView;
        private TextView title;
        private TextView description;
        private AppCompatImageView image;
        private CheckBox like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
         //   textView = (TextView) itemView;
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);
            like = itemView.findViewById(R.id.like);

            // Обработчик нажатий на картинке
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }

        public void setData(CardData cardData){
            title.setText(cardData.getTitle());
            description.setText(cardData.getDescription());
            like.setChecked(cardData.isLike());
            image.setImageResource(cardData.getPicture());
        }

//        public TextView getTextView() {
//            return textView;
//        }
    }
}




