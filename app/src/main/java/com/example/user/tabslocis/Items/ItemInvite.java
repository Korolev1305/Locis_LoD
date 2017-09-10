package com.example.user.tabslocis.Items;

/**
 * Created by User on 24.04.2017.
 */

public class ItemInvite {
    public String senderName;
    public String roomName;
    public int invitationId;
    public ItemInvite(String senderName, String  roomName, int invitationId){
        this.senderName = senderName;
        this.roomName = roomName;
        this.invitationId = invitationId;
    }
}
