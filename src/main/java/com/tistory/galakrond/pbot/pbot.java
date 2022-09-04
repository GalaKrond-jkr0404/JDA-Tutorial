package com.tistory.galakrond.pbot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.stream.StreamSupport;

public class pbot {

    private final ShardManager shardManager;

    public pbot() throws LoginException { // 잠재적으로 LoginExecption을 발생시킬 수 있다.
        String token = "MTAxNTE1MTc3Nzk3ODUxOTYxMw.GFZS2l.fPBSQyqZTTRuTGmMbqMha3nthBV1WxDkfqjQGY";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Galakrond"));
        shardManager = builder.build();

    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args){
        try {
            pbot bot = new pbot();
        }
        catch (LoginException e){
            System.out.println("Error occured In Login session. did you check the token?"); /
        }
    }

}
