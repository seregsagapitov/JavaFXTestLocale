package sample;


import java.util.Locale;

public class LocaleManager {

    public static final Locale RU_LOCALE = new Locale("ru");
    public static final Locale EN_LOCALE = new Locale("en");

    public static Language currentLanguage;

    public static Language getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(Language currentLanguage) {
        LocaleManager.currentLanguage = currentLanguage;
    }
}
