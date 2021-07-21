package keyone.keytwo.lesson_8_dz.ui;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import keyone.keytwo.lesson_8_dz.R;
import keyone.keytwo.lesson_8_dz.ui.Data.CardData;
import keyone.keytwo.lesson_8_dz.ui.Data.CardsSource;

public class AnimalsNetworkAdapter extends RecyclerView.Adapter<AnimalsNetworkAdapter.ViewHolder> {


    private final static String TAG = "AnimalsNetworkAdapter";
    private CardsSource dataSource;
    private AdapterView.OnItemClickListener itemClickListener;  // Слушатель будет устанавливаться извне
    private Fragment fragment;
    private int menuPosition;
    private String[] animals;

    // Передаём в конструктор источник данных
    // В нашем случае это массив, но может быть и запрос к БД
//    public AnimalsNetworkAdapter(String[] animals) {
//        this.animals = animals;
//    }
    public AnimalsNetworkAdapter(CardsSource dataSource, Fragment fragment) {
        this.dataSource = dataSource;
        this.fragment = fragment;
    }

    public AnimalsNetworkAdapter(CardsSource data) {

    }


    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NotNull
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
    public void onBindViewHolder(@NonNull AnimalsNetworkAdapter.ViewHolder viewHolder, int i) {
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



    // Сеттер слушателя нажатий
    public void SetOnItemClickListener(OnItemClickListener itemClickListener) {
        // this.itemClickListener = (AdapterView.OnItemClickListener) itemClickListener;
    }

    public void setData(CardData cardData) {
    }

    public int getMenuPosition() {
        return menuPosition;
    }

    // Интерфейс для обработки нажатий, как в ListView
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
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
        

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            //   textView = (TextView) itemView;
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.imageView);
            like = itemView.findViewById(R.id.like);
            registerContextMenu(itemView);

            // Обработчик нажатий на картинке
//            image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (itemClickListener != null) {
//                        itemClickListener.onItemClick(v, getAdapterPosition());
//                    }
//                }
//            });

            // Обработчик нажатий на картинке
            image.setOnLongClickListener(new View.OnLongClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public boolean onLongClick(View v) {
                    menuPosition = getLayoutPosition();
                    itemView.showContextMenu(10, 10);
                    return true;
                }
            });
        }


        private void registerContextMenu(View itemView) {
            if (fragment != null){
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        menuPosition = getLayoutPosition();
                        return false;
                    }
                });
                fragment.registerForContextMenu(itemView);
            }
        }
        

        public void setData(CardData cardData) {
            title.setText(cardData.getTitle());
            description.setText(cardData.getDescription());
            like.setChecked(cardData.isLike());
            image.setImageResource(cardData.getPicture());
        }

    }
}




