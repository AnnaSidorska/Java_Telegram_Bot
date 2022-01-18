package Services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;


import static Constant.VarConstant.ANSWER;
import static Constant.VarConstant.QUESTION;
import static java.util.Arrays.asList;

public class SendMessageService {
    private final String greetingMessage = "Привет, странник!";
    private final String whyMessage = "Вот твой ответ:";
    private final ButtonsService buttonsService = new ButtonsService();

    public SendMessage greetingOperation(Update update) {
        SendMessage mes = simpleMessage(update, greetingMessage);
        ReplyKeyboardMarkup keyboardMarkup =
                buttonsService.setButtons(buttonsService.createButtons(asList(QUESTION, ANSWER)));
        mes.setReplyMarkup(keyboardMarkup);
        return mes;
    }

    public SendMessage whyOperation(Update update) {
        SendMessage mes = simpleMessage(update, whyMessage);

        return mes;
    }

    private SendMessage simpleMessage(Update update, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(message);
        return sendMessage;
    }
}
