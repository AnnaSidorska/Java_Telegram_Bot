import Services.SendMessageService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static constant.VarConstant.START;

public class YBot extends TelegramLongPollingBot {
    SendMessageService sendMessageService = new SendMessageService();
    @Override
    public String getBotUsername() {
        return "BOTNAME";
    }

    @Override
    public String getBotToken() {
        return "BOTTOKEN";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case START:
                    try {
                        execute(sendMessageService.greetingOperation(update));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
