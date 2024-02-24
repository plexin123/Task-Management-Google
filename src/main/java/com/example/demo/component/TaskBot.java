//package com.example.demo.component;
//
//import org.apache.http.client.ResponseHandler;
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.telegram.abilitybots.api.bot.AbilityBot;
//import org.telegram.abilitybots.api.db.DBContext;
//import org.telegram.abilitybots.api.sender.SilentSender;
//import org.telegram.telegrambots.Constants;
//
//@Component
//public class TaskBot extends AbilityBot {
//    private final ResponseHandler responseHandler;
//    @Autowired
//    public TaskBot(Environment env, ResponseHandler responseHandler){
//        super(env.getProperties().getProperty("6629034459:AAGdtYIS_EAG02-WzyIwBu8VfRSZmDExAKg"),"taskremindergobot" );
//        this.responseHandler = responseHandler;
//    }
//    @Override
//    public long creatorId(){
//        return 1L;
//    }
//    public class ResponseHandler {
//        private final SilentSender sender;
//        private final Map<Long, UserState> chatStates;
//
//        public ResponseHandler(SilentSender sender, DBContext db) {
//            this.sender = sender;
//            chatStates = db.getMap(Constants.CHAT_STATES);
//        }
//
//    }
//}
