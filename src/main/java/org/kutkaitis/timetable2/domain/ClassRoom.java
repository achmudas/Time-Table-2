package org.kutkaitis.timetable2.domain;

/**
 *
 * @author achmudas
 */
public class ClassRoom {
    
    private String roomNumber;
    private Boolean specializedRoom;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean isSpecializedRoom() {
        return specializedRoom;
    }

    public void setSpecializedRoom(Boolean specializedRoom) {
        this.specializedRoom = specializedRoom;
    }
    
    

}
