package edu;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {



    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage ( ) && update.getMessage ( ).hasText ( )) {
            String message_text = update.getMessage ( ).getText ( );
            long chat_id = update.getMessage ( ).getChatId ( );
            SendMessage message;

            if (message_text.equals ("/start") || message_text.equals ("/")) {
                message = new SendMessage ( )
                        .setChatId (chat_id)
                        .setText (message_text);

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup ( );
                List<KeyboardRow> keyboardRows = new ArrayList<> ( );
                KeyboardRow keyboardButtons = new KeyboardRow ( );
                keyboardButtons.add ("About us");
                keyboardButtons.add ("Courses Schedule");
                keyboardRows.add (keyboardButtons);
                keyboardButtons = new KeyboardRow ( );
                keyboardButtons.add ("Course Navigator");
                keyboardButtons.add ("Schedule for Students");
                keyboardRows.add (keyboardButtons);
                replyKeyboardMarkup.setKeyboard (keyboardRows);
                message.setReplyMarkup (replyKeyboardMarkup);
                send (message);
            } else if (message_text.equals ("About us")) {
                message = new SendMessage ( )
                        .setChatId (chat_id)
                        .setText ("About Us\n\n" + "https://career.softserveinc.com/en-us/technology");
                send (message);
            } else if (message_text.equals ("Courses Schedule")) {
                message = new SendMessage ( )
                        .setChatId (chat_id)
                        .setText ("Courses Schedule\n\n" + "https://career.softserveinc.com/en-us/schedule");
                send (message);
            } else if (message_text.equals ("Course Navigator")) {
                message = new SendMessage ( )
                        .setChatId (chat_id)
                        .setText ("Course Navigator\n\n" + "https://career.softserveinc.com/en-us/course-navigator");
                send (message);
            } else if (message_text.equals ("Schedule for Students")) {
                message = new SendMessage ( )
                        .setChatId (chat_id)
                        .setText ("Schedule for Students\n\n" + "https://softserve.academy/pluginfile.php/50888/mod_resource/content/272/lviv/index.htm");
                send (message);
            }
        }
    }

    private void send(SendMessage message) {
        try {
            execute (message);
        } catch (TelegramApiException e) {
            e.printStackTrace ( );
        }
    }

    @Override
    public String getBotUsername() {
        return "VjqBot";
    }

    @Override
    public String getBotToken() {
        return "496494170:AAFJ1weAlaEns4TK7L19tgp9C6E_Cca7JoM";
    }
}
