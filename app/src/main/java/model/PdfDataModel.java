package model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PDF_DATA")
public class PdfDataModel {

    public PdfDataModel() {
    }

    public PdfDataModel(String id, String name, String address, String hometown, String selfDescription) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hometown = hometown;
        this.selfDescription = selfDescription;
    }

    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "hometown")
    public String hometown;

    @ColumnInfo(name = "self_description")
    public String selfDescription;
}
