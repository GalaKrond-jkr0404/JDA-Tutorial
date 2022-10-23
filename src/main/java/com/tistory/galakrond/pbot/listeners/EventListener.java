package com.tistory.galakrond.pbot.listeners;

import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {

        // Technovision reacted to a msg "thumbsup" in #general
        User user = event.getUser();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention(); // Mention == 채널명 #일반 같이
        String jumpLink = event.getJumpUrl(); // 디스코드 메시지 링크

        String message = user.getAsTag() + " reacted to a msg with " + emoji + "in the " + channelMention;
        event.getGuild().getDefaultChannel().asStandardGuildMessageChannel().sendMessage(message).queue();
        // 디스코드는 무조건 queue로 대기를 넣어주어야 한다!
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.contains("ping")){
            event.getChannel().sendMessage("pong").queue();
        }
    }
}
