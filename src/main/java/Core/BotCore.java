package Core;

import Services.SendMessageService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static Constant.VarConstant.*;

public class BotCore extends TelegramLongPollingBot {

    SendMessageService sendMessageService = new SendMessageService();

    @Override
    public String getBotUsername() {
        return "botname";
    }

    @Override
    public String getBotToken() {
        return "bottoken";
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
                case QUESTION:
                    System.out.println("It's a question"); // they both are working
                    break;
                case ANSWER:
                    System.out.println("It's an answer");
                    break;
            }
        }
    }
}
