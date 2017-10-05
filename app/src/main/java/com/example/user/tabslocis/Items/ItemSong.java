package com.example.user.tabslocis.Items;

/**
 * Created by User on 17.05.2017.
 */

public class ItemSong {
    public int id;
    public String authorName;
    public String songName;
    public String durability;

    public ItemSong(int id,String authorName, String songName, String durability){
        this.id = id;
        this.authorName = authorName;
        this.songName = songName;
        this.durability = durability;
    }
}
