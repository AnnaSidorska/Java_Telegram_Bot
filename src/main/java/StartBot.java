import Core.BotCore;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class StartBot {
    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new BotCore());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
