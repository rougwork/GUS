package com.agyl.recyclergus.models;
/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class SyncContentListViewData {
    private String key;
    private String firstName;
    private String lastName;
    private String picture;
    private int pictureStatusIcon;
    private int pictureTextColor;
    private String note;
    private int noteStatusIcon;
    private String formulaire;

    public SyncContentListViewData(String key,
                                   String firstName,
                                   String lastName,
                                   String picture,
                                   int pictureStatusIcon,
                                   int pictureTextColor,
                                   String note,
                                   int noteStatusIcon,
                                   String form) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.pictureStatusIcon = pictureStatusIcon;
        this.pictureTextColor = pictureTextColor;
        this.note = note;
        this.noteStatusIcon = noteStatusIcon;
        this.formulaire = form;
    }

    public String getKey() {
        return key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNote() {
        return note;
    }

    public int getNoteStatusIcon() {
        return noteStatusIcon;
    }

    public String getPicture() {
        return picture;
    }

    public int getPictureStatusIcon() {
        return pictureStatusIcon;
    }

    public int getPictureTextColor() {
        return pictureTextColor;
    }

    public String getFormulaire() {
        return formulaire;
    }
}
