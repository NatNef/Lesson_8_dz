package keyone.keytwo.lesson_8_dz.ui.Data;



    public interface CardsSource {
        CardData getCardData(int position);
        int size();
        void deleteCardData(int position);
        void updateCardData(int position, CardData cardData);
        void addCardData(CardData cardData);
        void clearCardData();

    }
